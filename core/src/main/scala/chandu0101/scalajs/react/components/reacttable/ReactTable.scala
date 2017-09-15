package chandu0101.scalajs.react.components.reacttable

import chandu0101.scalajs.react.components._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.components.TriStateCheckbox
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._
import scala.collection.{SortedSet, immutable}

/**
 * Companion object of ReactTable, with tons of little utilities
 */
object ReactTable {

  /**
   * The direction of the sort
   */
  /*
   * Pass this to the ColumnConfig to sort using an ordering
   */
  //  def Sort[T, B](fn: T => B)(implicit ordering: Ordering[B]): (T, T) => Boolean = {
  //    (m1: T, m2: T) =>
  //      ordering.compare(fn(m1), fn(m2)) > 0
  //  }
  //  /*
  //   * Pass this to the ColumnConfig to sort a string ignoring case using an ordering
  //   */
  //  def IgnoreCaseStringSort[T](fn: T => String): (T, T) => Boolean =
  //    (m1: T, m2: T) => fn(m1).compareToIgnoreCase(fn(m2)) > 0

  def DefaultOrdering[T, B](fn: T => B)(implicit ordering: Ordering[B]) = new Ordering[T] {
    def compare(a: T, b: T) = ordering.compare(fn(a), fn(b))
  }

  def ignoreCaseStringOrdering[T](fn: T => String) = new Ordering[T] {
    def compare(a: T, b: T) = fn(a).compareToIgnoreCase(fn(b))
  }

  val DefaultStyle = new ReactTableStyle()

  type CellRenderer[T] = T => VdomNode

  def DefaultCellRenderer[T]: CellRenderer[T] = { model =>
    <.span(model.toString)
  }

  def EmailRenderer[T](fn: T => String): CellRenderer[T] = { t =>
    val str = fn(t)
    <.a(^.whiteSpace.nowrap, ^.href := s"mailto:${str}", str)
  }

  def OptionRenderer[T, B](defaultValue: VdomNode = "", bRenderer: CellRenderer[B])(fn: T => Option[B]): CellRenderer[T] =
    t => fn(t).fold(defaultValue)(bRenderer)

  case class ColumnConfig[T](
    name: String,
    cellRenderer: CellRenderer[T],
    width: Option[String] = None,
    nowrap: Boolean = false
  )(implicit val ordering: Ordering[T])

  def SimpleStringConfig[T](
    name: String,
    stringRetriever: T => String,
    width: Option[String] = None,
    nowrap: Boolean = false): ReactTable.ColumnConfig[T] = {
    val renderer: CellRenderer[T] = if (nowrap) { t =>
      <.span(stringRetriever(t))
    } else { t =>
      stringRetriever(t)
    }
    ColumnConfig(name, renderer, width, nowrap)(ignoreCaseStringOrdering(stringRetriever))
  }
}

/**
 * A relatively simple html/react table with a pager.
 * You should pass in the data as a sequence of items of type T
 * But you should also pass a list of Column Configurations,
 * each of which describes how to get to each column for a given item in the data,
 * how to display it, how to sort it, etc.
 */
case class ReactTable[T](
  // The table data to be displayed
  data: Seq[T],
  // The configuration of the table columns
  configs: Seq[ReactTable.ColumnConfig[T]] = Seq.empty,
  // Whether paging is enabled for the table, if false, all rows will be displayed with no pager
  paging : Boolean = true,
  // The default number of rows per page (only relevant if paging is enabled)
  rowsPerPage: Int = 5,
  // The table style
  style: ReactTableStyle = ReactTable.DefaultStyle,
  // Whether search is enabled in the table
  enableSearch: Boolean = true,
  // Whether rows can be selected in the table
  selectable: Boolean = false,
  // Whether multiple rows can be selected (only relevant if selectable is true)
  multiSelectable : Boolean = true,
  // Whether a select all box shall be displayed (only relevant if selectable and multiSelectable is true)
  allSelectable : Boolean = true,
  // The searchbox style
  searchBoxStyle: ReactSearchBox.Style = ReactSearchBox.DefaultStyle,
  // an initial selection
  initialSelection : Seq[String] = Seq.empty,
  // This is a call back that will be called when an individual row is clicked
  onRowClick: (Int) => Callback = { _ =>
    Callback {}
  },
  // This callback will be called whenever the set of selected rows has changed
  onSelectionChanged: Set[(T, String)] => Callback = { _ : Set[(T, String)] =>
    Callback {}
  },
  // With this function the fields contributing to the search String can be customised
  searchStringRetriever: T => String = { t: T =>
    t.toString
  },
  // The key string retriever should return a unique String for each row of data.
  keyStringRetriever: T => String = { t: T => t.toString() }
) {

  import ReactTable._
  import SortDirection._

  case class TableState(
    filterText: String,
    offset: Int,
    rowsPerPage: Int,
    sortedState: Option[(Int, SortDirection)],
    selectedState: Set[(T, String)]
  )

  class Backend(t: BackendScope[TableProps, TableState]) {

    // handler to react on chenges in the search field
    def onTextChange(props: TableProps)(value: String): Callback = {
      t.modState{state =>

        val filtered = getFilteredData(props, value)
        val newSelected = state.selectedState & filtered.toSet

        if (newSelected.size != state.selectedState.size) {
          onSelectionChanged(newSelected).runNow()
        }

        state.copy(
          filterText = value,
          offset = 0,
          selectedState = newSelected
        )
      }
    }

    // Turn to the previous page of table data
    def onPreviousClick: Callback =
      t.modState(s => s.copy(offset = s.offset - s.rowsPerPage))

    // Turn to the next page of table data
    def onNextClick: Callback =
      t.modState(s => s.copy(offset = s.offset + s.rowsPerPage))

    // get the data filtered using the text in the search field
    def getFilteredData(p: TableProps, filterText: String) : Seq[(T, String)] = if (filterText.isEmpty) {
      p.data
    } else {
      p.data.filter(entry =>
        searchStringRetriever(entry._1).toLowerCase.contains(filterText.toLowerCase)
      )
    }

    // get a single data item using the unique key
    def data(p: TableProps, key: String) : Option[T] = p.data.find(_._2 == key).map(_._1)

    // apply the surrent sort state to the filtered data
    def getFilteredAndSortedData(p: TableProps, s: TableState): Seq[(T, String)] = {

      val rows = getFilteredData(p, s.filterText)

      if (s.sortedState.isEmpty)
        rows
      else {
        val cfg = configs(s.sortedState.head._1)
        val order: Ordering[(T, String)] = cfg.ordering.on(_._1)

        s.sortedState.head._2 match {
          case ASC => rows.sorted(order)
          case DSC => rows.sorted(order.reverse)
        }
      }
    }

    // handle a page size change
    def onPageSizeChange(value: String): Callback =
      t.modState(_.copy(rowsPerPage = value.toInt))

    // apply a new sort to a given column
    val toggleSort = { (index: Int, dir : SortDirection) =>
      t.modState { state => state.copy(sortedState = Some((index, dir)), offset = 0) }
    }

    val toggleSingleSelect = { (data : T, key : String) =>

      t.modState { state =>

        val item = Set((data, key))

        val newSelection = if (multiSelectable) {
          state.selectedState.find(_._2 == key) match {
            case None => state.selectedState ++ item
            case Some(_) => state.selectedState -- item
          }
        } else item

        onSelectionChanged(newSelection).runNow()
        state.copy(selectedState = newSelection)
      }
    }

    def toggleSelectAll(p: TableProps)(selected : Boolean) : Callback =
      t.modState { state =>

        val newSelection : Set[(T, String)] = if (selected) {
          getFilteredData(p, state.filterText).toSet
        } else {
          Set.empty
        }

        onSelectionChanged(newSelection).runNow()
        state.copy(selectedState = newSelection)
      }

    // define how we render the table
    def render(props: TableProps, state: TableState): VdomElement = {

      val rows = getFilteredAndSortedData(props, state)

      // Define how to render the settings bar configuring the rows per page
      val settingsBar = {

        val total = rows.size

        var value = ""
        var options: List[String] = Nil

        if (total > props.rowsPerPage) {
          value = state.rowsPerPage.toString
          options = immutable.Range
            .inclusive(props.rowsPerPage, total, 10 * (total / 100 + 1))
            .:+(total)
            .toList
            .map(_.toString)
        }
        <.div(props.style.settingsBar)(
          <.div(<.strong("Total: " + props.data.size)),
          DefaultSelect(label = "Page Size: ",
            options = options,
            value = value,
            onChange = onPageSizeChange)
        )
      }


      // Define how to render the table header
      val renderHeader: TagMod = {

        val triState = state.selectedState.size match {
          case 0 => TriStateCheckbox.Unchecked
          case n if n < rows.size => TriStateCheckbox.Indeterminate
          case _ => TriStateCheckbox.Checked
        }

        ReactTableHeader[T](
          configs = configs,
          selectable = props.selectable,
          allSelectable = props.selectable && props.multiSelectable && props.allSelectable,
          allSelected =  triState,
          style = style,
          sortedState = state.sortedState,
          onToggleSort = toggleSort,
          onToggleSelectAll = toggleSelectAll(props)
        )()
      }

      // Define how to render the individual rows

      val tableRows = {

        def renderRow(model: T, key: String): TagMod = {
          ReactTableRow(
            configs = configs,
            data = (model, key),
            selectable = props.selectable,
            multiSelectable = props.multiSelectable,
            selected = state.selectedState.map(_._2).contains(key),
            style = props.style,
            onSingleSelect = toggleSingleSelect
          )()
        }

        rows
          .slice(state.offset, state.offset + state.rowsPerPage)
          .map(entry => renderRow(entry._1, entry._2))
          .toTagMod
      }

      <.div(
        props.style.reactTableContainer,
        ReactSearchBox(
          onTextChange = onTextChange(props) _, style = props.searchBoxStyle
        ).when(props.enableSearch),
        settingsBar.when(props.paging),
        <.div(
          props.style.table,
          renderHeader,
          tableRows
        ),
        Pager(
          state.rowsPerPage,
          rows.size,
          state.offset,
          onNextClick,
          onPreviousClick
        ).when(props.paging)
      )
    }
  }

  val component = ScalaComponent
    .builder[TableProps]("ReactTable")
    .initialStateFromProps(props => TableState(
      filterText = "",
      offset = 0,
      rowsPerPage = if (props.paging) props.rowsPerPage else props.data.size,
      sortedState = None,
      selectedState = if (initialSelection.isEmpty) {
        Set.empty
      } else {
        if (props.multiSelectable) {
          props.data.filter(item => initialSelection.contains(item._2)).toSet
        } else {
          props.data.filter(_._2 == initialSelection.head).toSet
        }
      }
    ))
    .renderBackend[Backend]
    .componentWillReceiveProps(e =>
      Callback.when(e.currentProps.data != e.nextProps.data)(
        e.backend.onTextChange(e.nextProps)(e.state.filterText)))
    .build

  case class TableProps(
    data: Seq[(T, String)],
    configs: Seq[ColumnConfig[T]],
    paging: Boolean,
    rowsPerPage: Int,
    style: ReactTableStyle,
    enableSearch: Boolean,
    selectable : Boolean,
    multiSelectable : Boolean,
    allSelectable: Boolean,
    searchBoxStyle: ReactSearchBox.Style,
    onRowClick : Int => Callback,
    searchStringRetriever : T => String,
    keyStringRetriever : T => String
  )

    def apply() = component(TableProps(
      data = data.map( d => (d, keyStringRetriever(d)) ),
      configs = configs,
      paging = paging,
      rowsPerPage = rowsPerPage,
      style = style,
      enableSearch = enableSearch,
      selectable = selectable,
      multiSelectable = multiSelectable,
      allSelectable = allSelectable,
      searchBoxStyle = searchBoxStyle,
      onRowClick = onRowClick,
      searchStringRetriever = searchStringRetriever,
      keyStringRetriever = keyStringRetriever
    ))
}

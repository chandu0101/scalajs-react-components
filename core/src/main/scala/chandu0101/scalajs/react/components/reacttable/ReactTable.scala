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
    sortedState: Map[Int, SortDirection],
    selectedState: Set[(T, String)]
  )

  class Backend(t: BackendScope[TableProps, TableState]) {

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

    def getFilteredData(p: TableProps, filterText: String) : Seq[(T, String)] = if (filterText.isEmpty) {
      p.data
    } else {
      p.data.filter(entry =>
        searchStringRetriever(entry._1).toLowerCase.contains(filterText.toLowerCase)
      )
    }

    def data(p: TableProps, key: String) : Option[T] = p.data.find(_._2 == key).map(_._1)

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

    def changeSelection(p: TableProps, newSelected : Set[(T, String)]) : Callback = {
      t.modState { state =>

        onSelectionChanged(
          newSelected
        ).runNow()

        state.copy(selectedState = newSelected)
      }
    }

    def onPageSizeChange(value: String): Callback =
      t.modState(_.copy(rowsPerPage = value.toInt))

    def render(props: TableProps, state: TableState): VdomElement = {

      def sort(ordering: Ordering[T], columnIndex: Int): Callback = {

        t.modState { state =>
          state.sortedState.get(columnIndex) match {
            case Some(ASC) =>
              state.copy(
                sortedState = Map(columnIndex -> DSC),
                offset = 0
              )
            case _ =>
              state.copy(
                sortedState = Map(columnIndex -> ASC),
                offset = 0
              )
          }
        }
      }

      def singleSelect(p: TableProps, state: TableState, key : String) : Callback = {

        val item = data(p, key).map((_, key)).toSet

        if (props.multiSelectable) {
          state.sortedState.find(_._2 == key) match {
            case None =>
              changeSelection(p, state.selectedState ++ item)
            case Some(d) =>
              changeSelection(p, state.selectedState.filter(_._2 != key))
          }
        } else {
          changeSelection(props, item)
        }
      }

      // Define how to render the settings bar configuring the rows per page
      def settingsBar(total : Int) = {
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
          case n if n < state.selectedState.size => TriStateCheckbox.Indeterminate
          case _ => TriStateCheckbox.Checked
        }

        ReactTableHeader[T](
          configs = configs,
          allSelectable = props.allSelectable,
          allSelected =  triState,
          style = style,
          sortedState = state.sortedState
        )()
      }

      // Define how to render the individual rows

      val rows = getFilteredAndSortedData(props, state)

      val tableRows = {

        def renderRow(model: T, key: String): TagMod = {
          ReactTableRow(
            configs = configs,
            data = model,
            selectable = props.selectable,
            multiSelectable = props.multiSelectable,
            selected = state.selectedState.map(_._2).contains(key),
            style = props.style
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
        settingsBar(rows.size).when(props.paging),
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
      sortedState = Map.empty,
      selectedState = Set.empty
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

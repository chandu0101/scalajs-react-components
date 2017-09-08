package chandu0101.scalajs.react.components.reacttable

import chandu0101.scalajs.react.components._
import japgolly.scalajs.react._
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
  object SortDirection extends Enumeration {
    type SortDirection = Value
    val ASC, DSC = Value
  }
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
    onRowClick: (Int) => Callback = { _ =>
      Callback {}
    },
    onSelectionChanged: Set[(T, Int)] => Callback = { _ : Set[(T, Int)] =>
      Callback {}
    },
    searchStringRetriever: T => String = { t: T =>
      t.toString
    }) {

  import ReactTable._
  import SortDirection._

  case class State(
    filterText: String,
    offset: Int,
    rowsPerPage: Int,
    indexedData: Seq[(T, Int)],
    sortedState: Map[Int, SortDirection],
    selectedState: SortedSet[Int]
  )

  class Backend(t: BackendScope[Props, State]) {

    def onTextChange(props: Props)(value: String): Callback =
      t.modState(_.copy(filterText = value, offset = 0))

    def onPreviousClick: Callback =
      t.modState(s => s.copy(offset = s.offset - s.rowsPerPage))

    def onNextClick: Callback =
      t.modState(s => s.copy(offset = s.offset + s.rowsPerPage))

    def getFilteredAndSortedData(s: State): Seq[(T, Int)] = {

      val rows = if (s.filterText.isEmpty) {
        s.indexedData
      } else {
        s.indexedData.filter(entry =>
          searchStringRetriever(entry._1).toLowerCase.contains(s.filterText.toLowerCase)
        )
      }

      if (s.sortedState.isEmpty)
        rows
      else {
        val cfg = configs(s.sortedState.head._1)
        val order: Ordering[(T, Int)] = cfg.ordering.on(_._1)

        s.sortedState.head._2 match {
          case ASC => rows.sorted(order)
          case DSC => rows.sorted(order.reverse)
        }
      }
    }

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

    def singleSelect(currentState: SortedSet[Int], index: Int) : Callback = {

      if (currentState.contains(index)) {
        changeSelection(currentState - index)
      } else {
        changeSelection(currentState + index)
      }
    }

    def changeSelection(newSelected : SortedSet[Int]) : Callback = {
      t.modState { state =>

        onSelectionChanged(
          newSelected.map(state.indexedData).toSet
        ).runNow()

        state.copy(selectedState = newSelected)
      }
    }

    def onPageSizeChange(value: String): Callback =
      t.modState(_.copy(rowsPerPage = value.toInt))

    def render(props: Props, state: State): VdomElement = {

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
        <.div(props.style.settingsBar)(<.div(<.strong("Total: " + state.indexedData.size)),
          DefaultSelect(label = "Page Size: ",
            options = options,
            value = value,
            onChange = onPageSizeChange))
      }

      // Define how to render the table header
      def renderHeader: TagMod =
        <.tr(
          props.style.tableHeader,
          <.th(
            ^.textAlign := "left",
            <.input(^.`type` := "checkbox").when(props.selectable && props.allSelectable)
          ).when(props.selectable),
          props.configs.zipWithIndex.map {
            case (config, columnIndex) =>
              val cell = getHeaderDiv(config)
              cell(
                ^.textAlign := "left",
                ^.cursor := "pointer",
                ^.onClick --> sort(config.ordering, columnIndex),
                config.name.capitalize,
                props.style
                  .sortIcon(
                    state.sortedState.isDefinedAt(columnIndex) && state.sortedState(columnIndex) == ASC
                  )
                  .when(state.sortedState.isDefinedAt(columnIndex))
              )
          }.toTagMod
        )

      // Define how to render the individual rows
      def renderRow(model: T, index: Int): TagMod =
        <.tr(
          props.style.tableRow,
          <.input(
            ^.`type` := "checkbox",
            ^.checked := state.selectedState.contains(index),
            ^.onChange --> singleSelect(state.selectedState, index)
          ).when(props.selectable),
          props.configs.map(config =>
            <.td(
              ^.whiteSpace.nowrap.when(config.nowrap),
              ^.verticalAlign.middle,
              config.cellRenderer(model)
            )
          ).toTagMod
        )

      val rows = getFilteredAndSortedData(state)

      val tableRows = rows
        .slice(state.offset, state.offset + state.rowsPerPage)
        .map( entry => renderRow(entry._1, entry._2) )
        .toTagMod

      <.div(
        props.style.reactTableContainer,
        ReactSearchBox(onTextChange = onTextChange(props) _, style = props.searchBoxStyle).when(props.enableSearch),
        settingsBar(rows.size).when(props.paging),
        <.div(
          props.style.table,
          <.table(
            ^.width := "100%",
            <.thead(renderHeader()),
            <.tbody(tableRows)
          )
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

  def getHeaderDiv(config: ColumnConfig[T]): TagMod = {
    config.width.fold(<.th())(width => <.th(^.width := width))
  }
  
  val component = ScalaComponent
    .builder[Props]("ReactTable")
    .initialStateFromProps(props => State(
      filterText = "",
      offset = 0,
      rowsPerPage = if (props.paging) props.rowsPerPage else props.data.size,
      indexedData = props.data,
      sortedState = Map.empty,
      selectedState = SortedSet.empty)
    )
    .renderBackend[Backend]
    .componentWillReceiveProps(e =>
      Callback.when(e.currentProps.data != e.nextProps.data)(
        e.backend.onTextChange(e.nextProps)(e.state.filterText)))
    .build

  case class Props(
    data: Seq[(T, Int)],
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
    searchStringRetriever : T => String
  )

    def apply() = component(Props(
      data = data.zipWithIndex,
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
      searchStringRetriever = searchStringRetriever
    ))
}

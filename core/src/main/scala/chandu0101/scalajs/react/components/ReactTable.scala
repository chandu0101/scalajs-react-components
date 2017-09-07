package chandu0101.scalajs.react.components

import japgolly.scalajs.react.vdom.html_<^._

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.BackendScope
import japgolly.scalajs.react.ScalaComponent
import scala.collection.immutable
import scalacss.ProdDefaults._

import scalacss.ScalaCssReact._

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

  class Style extends StyleSheet.Inline {

    import dsl._

    val reactTableContainer = style(display.flex, flexDirection.column)

    val table = style(
      display.flex,
      flexDirection.column,
      boxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)",
      media.maxWidth(740 px)(boxShadow := "none"))

    val tableRow = style(padding :=! "0.8rem",
      &.hover(backgroundColor :=! "rgba(244, 244, 244, 0.77)"),
      media.maxWidth(740 px)(boxShadow := "0 1px 3px grey", margin(5 px)))

    val tableHeader = style(fontWeight.bold, borderBottom :=! "1px solid #e0e0e0", tableRow)

    val settingsBar = style(display.flex, margin :=! "15px 0", justifyContent.spaceBetween)

    val sortIcon = styleF.bool(
      ascending =>
        styleS(
          &.after(fontSize(9 px), marginLeft(5 px),
            if (ascending) {
              content := "'\\25B2'"
            } else {
              content := "'\\25BC'"
            }
          )
        )
    )
  }

  object DefaultStyle extends Style

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

  case class ColumnConfig[T](name: String,
    cellRenderer: CellRenderer[T],
    //sortBy: Option[(T, T) => Boolean] = None,
    width: Option[String] = None,
    nowrap: Boolean = false)(implicit val ordering: Ordering[T])

  def SimpleStringConfig[T](name: String,
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
    configs: List[ReactTable.ColumnConfig[T]] = List(),
    // Whether paging is enabled for the table, if false, all rows will be displayed with no pager
    paging : Boolean = true,
    // The default number of rows per page (only relevant if paging is enabled)
    rowsPerPage: Int = 5,
    // The table style
    style: ReactTable.Style = ReactTable.DefaultStyle,
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
    searchStringRetriever: T => String = { t: T =>
      t.toString
    }) {

  import ReactTable._
  import SortDirection._

  case class State(filterText: String,
    offset: Int,
    rowsPerPage: Int,
    filteredData: Seq[T],
    sortedState: Map[Int, SortDirection])

  class Backend(t: BackendScope[Props, State]) {

    def onTextChange(props: Props)(value: String): Callback =
      t.modState(_.copy(filteredData = getFilteredData(value, props.data), offset = 0))

    def onPreviousClick: Callback =
      t.modState(s => s.copy(offset = s.offset - s.rowsPerPage))

    def onNextClick: Callback =
      t.modState(s => s.copy(offset = s.offset + s.rowsPerPage))

    def getFilteredData(text: String, data: Seq[T]): Seq[T] = {
      if (text.isEmpty) {
        data
      } else {
        data.filter(searchStringRetriever(_).toLowerCase.contains(text.toLowerCase))
      }
    }

    def sort(ordering: Ordering[T], columnIndex: Int): Callback =
      t.modState { state =>
        println(s"Current sort state : ${state.sortedState}")
        val rows = state.filteredData
        state.sortedState.get(columnIndex) match {
          case Some(ASC) =>
            println(s"New sort is (${columnIndex}-$DSC)")
            state.copy(filteredData = rows.sorted(ordering.reverse),
              sortedState = Map(columnIndex -> DSC),
              offset = 0)
          case _ =>
            println(s"New sort is (${columnIndex}-$ASC)")
            state.copy(filteredData = rows.sorted(ordering),
              sortedState = Map(columnIndex -> ASC),
              offset = 0)
        }
      }

    def onPageSizeChange(value: String): Callback =
      t.modState(_.copy(rowsPerPage = value.toInt))

    def render(props: Props, state: State): VdomElement = {
      def settingsBar = {
        var value = ""
        var options: List[String] = Nil
        val total = state.filteredData.length
        if (total > props.rowsPerPage) {
          value = state.rowsPerPage.toString
          options = immutable.Range
            .inclusive(props.rowsPerPage, total, 10 * (total / 100 + 1))
            .:+(total)
            .toList
            .map(_.toString)
        }
        <.div(props.style.settingsBar)(<.div(<.strong("Total: " + state.filteredData.size)),
          DefaultSelect(label = "Page Size: ",
            options = options,
            value = value,
            onChange = onPageSizeChange))
      }

      def renderHeader: TagMod =
        <.tr(
          props.style.tableHeader,
          props.configs.zipWithIndex.map {
            case (config, columnIndex) =>
              val cell = getHeaderDiv(config)
              cell(
                ^.cursor := "pointer",
                ^.onClick --> sort(config.ordering, columnIndex),
                config.name.capitalize,
                props.style
                  .sortIcon(
                    state.sortedState.isDefinedAt(columnIndex) && state.sortedState(columnIndex) == ASC
                  )
                  .when(state.sortedState.isDefinedAt(columnIndex))
              )
          }.toTagMod)

      def renderRow(model: T): TagMod =
        <.tr(
          props.style.tableRow,
          props.configs
            .map(
              config =>
                <.td(^.whiteSpace.nowrap.when(config.nowrap),
                  ^.verticalAlign.middle,
                  config.cellRenderer(model)))
            .toTagMod)

      val rows = state.filteredData
        .slice(state.offset, state.offset + state.rowsPerPage)
        .zipWithIndex
        .map {
          case (row, i) => renderRow(row)
        }
        .toTagMod

      <.div(
        props.style.reactTableContainer,
        ReactSearchBox(onTextChange = onTextChange(props) _, style = props.searchBoxStyle).when(props.enableSearch),
        settingsBar.when(props.paging),
        <.div(
          props.style.table,
          <.table(
            ^.width := "100%",
            <.thead(renderHeader()),
            <.tbody(rows)
          )
        ),
        Pager(
          state.rowsPerPage,
          state.filteredData.length,
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
      if (props.paging) props.rowsPerPage else props.data.size,
      props.data,
      Map())
    )
    .renderBackend[Backend]
    .componentWillReceiveProps(e =>
      Callback.when(e.currentProps.data != e.nextProps.data)(
        e.backend.onTextChange(e.nextProps)(e.state.filterText)))
    .build

  case class Props(
    data: Seq[T],
    configs: List[ColumnConfig[T]],
    paging: Boolean,
    rowsPerPage: Int,
    style: Style,
    enableSearch: Boolean,
    selectable : Boolean,
    multiSelectable : Boolean,
    allSelectable: Boolean,
    searchBoxStyle: ReactSearchBox.Style,
    onRowClick : Int => Callback,
    searchStringRetriever : T => String
  )

    def apply() = component(Props(
      data = data,
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

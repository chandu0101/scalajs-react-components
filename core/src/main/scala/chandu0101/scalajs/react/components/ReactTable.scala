package chandu0101.scalajs.react.components

import japgolly.scalajs.react.vdom.html_<^._

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.BackendScope
import japgolly.scalajs.react.ScalaComponent
import scala.collection.immutable
import scalacss.ProdDefaults._

import scalacss.ScalaCssReact.scalacssStyleaToTagMod

/**
  * Companion object of ReactTable, with tons of little utilities
  */
object ReactTable {

  /**
    * The direction of the sort
    */
  object SortDirection extends Enumeration {
    type SortDirection = Value
    val asc, dsc = Value
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
      media.maxWidth(740 px)(boxShadow := "none")
    )

    val tableRow = style(padding :=! "0.8rem",
                         &.hover(backgroundColor :=! "rgba(244, 244, 244, 0.77)"),
                         media.maxWidth(740 px)(boxShadow := "0 1px 3px grey", margin(5 px)))

    val tableHeader = style(fontWeight.bold, borderBottom :=! "1px solid #e0e0e0", tableRow)

    val settingsBar = style(display.flex, margin :=! "15px 0", justifyContent.spaceBetween)

    val sortIcon = styleF.bool(
      ascending =>
        styleS(
          &.after(fontSize(9 px), marginLeft(5 px), if (ascending) { content := "'\\25B2'" } else {
            content := "'\\25BC'"
          })))

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
  def OptionRenderer[T, B](defaultValue: VdomNode = "", bRenderer: CellRenderer[B])(
      fn: T => Option[B]): CellRenderer[T] =
    t => fn(t).fold(defaultValue)(bRenderer)

  case class ColumnConfig[T](name: String,
                             cellRenderer: CellRenderer[T],
                             //sortBy: Option[(T, T) => Boolean] = None,
                             width: Option[String] = None,
                             nowrap: Boolean = false,
                             rowSeq: Option[T => List[VdomNode]] = None)(implicit val ordering: Ordering[T])

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
  * But you should also pass a list of Column Configurations, each of which describes how to get to each column for a given item in the data, how to display it, how to sort it, etc.
  */
case class ReactTable[T](data: Seq[T],
                         configs: List[ReactTable.ColumnConfig[T]] = List(),
                         rowsPerPage: Int = 5,
                         style: ReactTable.Style = ReactTable.DefaultStyle,
                         enableSearch: Boolean = true,
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
        val rows = state.filteredData
        state.sortedState.get(columnIndex) match {
          case Some(asc) =>
            state.copy(filteredData = rows.sorted(ordering.reverse),
                       sortedState = Map(columnIndex -> dsc),
                       offset = 0)
          case _ =>
            state.copy(filteredData = rows.sorted(ordering),
                       sortedState = Map(columnIndex -> asc),
                       offset = 0)
        }
      }

    def onPageSizeChange(value: String): Callback =
      t.modState(_.copy(rowsPerPage = value.toInt))

    def render(props: Props, state: State): VdomElement = {
      def settingsBar = {
        var value                 = ""
        var options: List[String] = Nil
        val total                 = state.filteredData.length
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
              //              config.sortBy.fold(cell(config.name.capitalize))(sortByFn =>
              cell(
                ^.cursor := "pointer",
                ^.onClick --> sort(config.ordering, columnIndex),
                config.name.capitalize,
                props.style
                  .sortIcon(state.sortedState.isDefinedAt(columnIndex) && state.sortedState(
                    columnIndex) == asc)
                  .when(state.sortedState.isDefinedAt(columnIndex))
              )
            //)
          }.toTagMod
        )

      def renderRow(model: T): TagMod = {
        val existsRowSeq = configs.exists(_.rowSeq.isDefined)
        val rowSpan = configs.flatMap(_.rowSeq.map(_ (model).size).toList)
        val tds = props.configs.map { config =>
          if (config.rowSeq.isEmpty) {
            Seq(
              <.td(^.whiteSpace.nowrap.when(config.nowrap),
                ^.key := config.name,
                ^.verticalAlign.middle,
                (^.rowSpan := rowSpan.max).when(existsRowSeq),
                config.cellRenderer(model)
              )
            ).zipWithIndex
          } else {
            config.rowSeq.get(model).map { node =>
              <.td(^.whiteSpace.nowrap.when(config.nowrap),
                ^.verticalAlign.middle,
                ^.key := config.name,
                node)
            }
          }.zipWithIndex
        }

        val maxIndex = tds.flatMap(_.map(_._2)).max
        val tdSeq = tds.flatten

        val rows = for (i <- 0 to maxIndex) yield {
          <.tr(
            ^.key := i,
            props.style.tableRow,
            tdSeq.filter(_._2 == i).map(_._1).toVdomArray
          )
        }

        rows.toVdomArray
      }

      val rows = state.filteredData
        .slice(state.offset, state.offset + state.rowsPerPage)
        .zipWithIndex
        .map {
          case (row, i) => renderRow(row) //tableRow.withKey(i)((row, props))
        }
        .toTagMod

      <.div(
        props.style.reactTableContainer,
        ReactSearchBox(onTextChange = onTextChange(props) _, style = props.searchBoxStyle)
          .when(props.enableSearch),
        settingsBar,
        <.div(props.style.table, <.table(<.thead(renderHeader()), <.tbody(rows))),
        Pager(state.rowsPerPage,
              state.filteredData.length,
              state.offset,
              onNextClick,
              onPreviousClick)
      )
    }
  }

  def getHeaderDiv(config: ColumnConfig[T]): TagMod = {
    config.width.fold(<.th())(width => <.th(^.width := width))
  }

  def arrowUp: TagMod =
    TagMod(^.width := 0.px,
           ^.height := 0.px,
           ^.borderLeft := "5px solid transparent",
           ^.borderRight := "5px solid transparent",
           ^.borderBottom := "5px solid black")

  def arrowDown: TagMod =
    TagMod(^.width := 0.px,
           ^.height := 0.px,
           ^.borderLeft := "5px solid transparent",
           ^.borderRight := "5px solid transparent",
           ^.borderTop := "5px solid black")

  def emptyClass: TagMod =
    TagMod(^.padding := "1px")

  val component = ScalaComponent
    .builder[Props]("ReactTable")
    .initialStateFromProps(props =>
      State(filterText = "", offset = 0, props.rowsPerPage, props.data, Map()))
    .renderBackend[Backend]
    .componentWillReceiveProps(e =>
      Callback.when(e.currentProps.data != e.nextProps.data)(
        e.backend.onTextChange(e.nextProps)(e.state.filterText)))
    .build

  case class Props(data: Seq[T],
                   configs: List[ColumnConfig[T]],
                   rowsPerPage: Int,
                   style: Style,
                   enableSearch: Boolean,
                   searchBoxStyle: ReactSearchBox.Style)

  def apply() = component(Props(data, configs, rowsPerPage, style, enableSearch, searchBoxStyle))
}

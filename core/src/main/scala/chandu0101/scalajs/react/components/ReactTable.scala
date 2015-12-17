package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.collection.immutable
import scala.scalajs.js.Date
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object ReactTable {

  type ColumnKey = String
  type Model = Map[ColumnKey, Any]
  type CellRenderer = (Model, ColumnKey) ⇒ ReactElement

  case class ColumnConfig(name: String,
    cellRenderer: CellRenderer = defaultCellRenderer,
    sortBy: Option[(Model, Model) ⇒ Boolean] = None,
    width: Option[Double] = None)

  def defaultCellRenderer(model: Model, key: ColumnKey): ReactElement = <.span(model(key).toString)

  object SortDirection extends Enumeration {
    type SortDirection = Value
    val asc, dsc = Value
  }
  import SortDirection._

  class Style extends StyleSheet.Inline {

    import dsl._

    val reactTableContainer = style(display.flex,
      flexDirection.column)

    val table = style(display.flex,
      flexDirection.column,
      boxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)",
      media.maxWidth(740 px)(
        boxShadow := "none"))

    val tableRow = style(display.flex,
      padding :=! "0.8rem",
      &.hover(
        backgroundColor :=! "rgba(244, 244, 244, 0.77)"),
      media.maxWidth(740 px)(
        display.flex,
        flexDirection.column,
        textAlign.center,
        boxShadow := "0 1px 3px grey",
        margin(5 px)),
      unsafeChild("div")(
        flex := "1"))

    val tableHeader = style(fontWeight.bold,
      borderBottom :=! "1px solid #e0e0e0",
      tableRow)

    val settingsBar = style(display.flex,
      margin :=! "15px 0",
      justifyContent.spaceBetween)

    val sortIcon = styleF.bool(ascending ⇒ styleS(
      &.after(
        fontSize(9 px),
        marginLeft(5 px),
        if (ascending) content := "'\\25B2'"
        else content := "'\\25BC'")))

  }

  object DefaultStyle extends Style

  case class State(
    filterText: String,
    offset: Int,
    rowsPerPage: Int,
    filteredModels: Vector[Model],
    sortedState: Map[String, SortDirection])

  class Backend(t: BackendScope[Props, State]) {

    def onTextChange(P: Props)(value: String): Callback =
      t.modState(_.copy(filteredModels = getFilteredModels(value, P.data), offset = 0))

    def onPreviousClick: Callback =
      t.modState(s ⇒ s.copy(offset = s.offset - s.rowsPerPage))

    def onNextClick: Callback =
      t.modState(s ⇒ s.copy(offset = s.offset + s.rowsPerPage))

    def getFilteredModels(text: String, models: Vector[Model]): Vector[Model] =
      if (text.isEmpty) models
      else models.filter(_.values.mkString.toLowerCase.contains(text.toLowerCase))

    def sort(f: (Map[String, Any], Map[String, Any]) ⇒ Boolean, item: String): Callback =
      t.modState { S ⇒
        val rows = S.filteredModels

        S.sortedState.getOrElse(item, asc) match {
          case SortDirection.asc ⇒ S.copy(filteredModels = rows.reverse, sortedState = Map(item -> dsc), offset = 0)
          case SortDirection.dsc ⇒ S.copy(filteredModels = rows.sortWith(f), sortedState = Map(item -> asc), offset = 0)
        }
      }

    def onPageSizeChange(value: String): Callback =
      t.modState(_.copy(rowsPerPage = value.toInt))

    def render(P: Props, S: State) =
      <.div(
        P.style.reactTableContainer,
        P.enableSearch ?= ReactSearchBox(
          onTextChange = onTextChange(P) _,
          style = P.searchBoxStyle),
        settingsBar((P, this, S)),
        tableC((P, S, this)),
        Pager(
          S.rowsPerPage,
          S.filteredModels.length,
          S.offset,
          onNextClick,
          onPreviousClick))
  }

  def getIntSort(key: String) = (m1: Model, m2: Model) ⇒ m1(key).asInstanceOf[Int] < m2(key).asInstanceOf[Int]

  def getDoubleSort(key: String) = (m1: Model, m2: Model) ⇒ m1(key).asInstanceOf[Double] < m2(key).asInstanceOf[Double]

  def getLongSort(key: String) = (m1: Model, m2: Model) ⇒ m1(key).asInstanceOf[Long] < m2(key).asInstanceOf[Long]

  def getStringSort(key: String) = (m1: Model, m2: Model) ⇒ m1(key).toString < m2(key).toString

  def getDateSort(key: String) = (m1: Model, m2: Model) ⇒ m1(key).asInstanceOf[Date].getTime() < m2(key).asInstanceOf[Date].getTime()

  def getCellRenderer(key: String, configs: List[ColumnConfig]) = {
    configs.find(_.name == key).fold(defaultCellRenderer _)(_.cellRenderer)
  }

  def getSortFunction(key: String, config: List[ColumnConfig]) = {
    val group = config.groupBy(_.name).getOrElse(key, Nil)
    if (group.nonEmpty) group.head.sortBy else None
  }

  def getColumnDiv(key: String, configs: List[ColumnConfig]) = {
    configs.find(_.name == key).flatMap(_.width).fold(<.div())(width ⇒ <.div(^.flex := width))
  }

  def arrowUp: TagMod =
    Seq(
      ^.width := 0,
      ^.height := 0,
      ^.borderLeft := "5px solid transparent",
      ^.borderRight := "5px solid transparent",
      ^.borderBottom := "5px solid black")

  def arrowDown: TagMod =
    Seq(
      ^.width := 0,
      ^.height := 0,
      ^.borderLeft := "5px solid transparent",
      ^.borderRight := "5px solid transparent",
      ^.borderTop := "5px solid black")

  def emptyClass: TagMod =
    Seq(^.padding := "1px")

  val tableHeader = ReactComponentB[(Props, Backend, State)]("reactTableHeader")
    .render { $ ⇒
      val (props, b, state) = $.props
      <.div(props.style.tableHeader,
        if (props.config.nonEmpty) {
          props.columns.map { item ⇒
            {
              val cell = getColumnDiv(item, props.config)
              val f = getSortFunction(item, props.config)
              if (f.isDefined) {
                cell(^.cursor := "pointer",
                  ^.onClick --> b.sort(f.get, item), item.capitalize,
                  state.sortedState.isDefinedAt(item) ?= props.style.sortIcon(state.sortedState(item) == asc))
              } else cell(item.capitalize)
            }
          }
        } else props.columns.map(s ⇒ <.div(s.capitalize)))
    }.build

  val tableRow = ReactComponentB[(Model, Props)]("TableRow")
    .render { $ ⇒
      val (row, props) = $.props
      <.div(props.style.tableRow,
        if (props.config.nonEmpty) {
          props.columns.map { item ⇒
            val cell = getColumnDiv(item, props.config)
            val cellRenderer = getCellRenderer(item, props.config)
            cell(cellRenderer(row, item))
          }
        } else props.columns.map { item ⇒ <.div(row(item).toString) })
    }.build

  val tableC = ReactComponentB[(Props, State, Backend)]("table")
    .render { $ ⇒
      val (props, state, b) = $.props
      val rows = state.filteredModels
        .slice(state.offset, state.offset + state.rowsPerPage)
        .zipWithIndex.map {
          case (row, i) ⇒ tableRow.withKey(i)((row, props))
        }
      <.div(props.style.table,
        tableHeader((props, b, state)),
        rows)
    }.build

  val settingsBar = ReactComponentB[(Props, Backend, State)]("settingbar")
    .render { $ ⇒
      val (p, b, s) = $.props
      var value = ""
      var options: List[String] = Nil
      val total = s.filteredModels.length
      if (total > p.rowsPerPage) {
        value = s.rowsPerPage.toString
        options = immutable.Range.inclusive(p.rowsPerPage, total, 10 * (total / 100 + 1)).:+(total).toList.map(_.toString)
      }
      <.div(p.style.settingsBar)(
        <.div(<.strong("Total: " + s.filteredModels.size)),
        DefaultSelect(label = "Page Size: ",
          options = options,
          value = value,
          onChange = b.onPageSizeChange))
    }.build

  val component = ReactComponentB[Props]("ReactTable")
    .initialState_P(p ⇒ State(filterText = "", offset = 0, p.rowsPerPage, p.data, Map()))
    .renderBackend[Backend]
    .build

  case class Props(data: Vector[Model],
    columns: List[String],
    config: List[ColumnConfig],
    rowsPerPage: Int,
    style: Style,
    enableSearch: Boolean,
    searchBoxStyle: ReactSearchBox.Style)

  def apply(data: Vector[Model],
    columns: List[String],
    config: List[ColumnConfig] = List(),
    rowsPerPage: Int = 5,
    style: Style = DefaultStyle,
    enableSearch: Boolean = true,
    searchBoxStyle: ReactSearchBox.Style = ReactSearchBox.DefaultStyle,
    onRowClick: (Int) ⇒ Callback = { a ⇒ Callback {} }) = {
    component(Props(data, columns, config, rowsPerPage, style, enableSearch, searchBoxStyle))
  }
}

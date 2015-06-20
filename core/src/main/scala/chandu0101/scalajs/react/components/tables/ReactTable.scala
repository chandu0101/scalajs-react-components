package chandu0101.scalajs.react.components.tables

import chandu0101.scalajs.react.components.optionselectors.DefaultSelect
import chandu0101.scalajs.react.components.pagers.Pager
import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, _}

import scala.collection.immutable
import scala.scalajs.js.Date
import scalacss.Defaults._
import scalacss.ScalaCssReact._

/**
 * Created by chandrasekharkode .
 */
object ReactTable {

  type Model = Map[String, Any]

  type Config = (String, (Any) => ReactElement, (Model, Model) => Boolean)

  val ASC: String = "asc"
  val DSC: String = "dsc"

  class Style extends StyleSheet.Inline {

    import dsl._

    val reactTableContainer = style(display.flex,
      flexDirection.column)

    val table = style(display.flex,
      flexDirection.column,
      boxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)",
      media.maxWidth(740 px)(
        boxShadow := "none"
       )
      )

    val tableRow = style(display.flex,
      padding :=! "0.8rem",
      &.hover(
        backgroundColor :=! "rgba(0, 0, 0, 0.12)"
      ),
      media.maxWidth(740 px)(
        display.flex,
        flexDirection.column,
        textAlign.center,
        boxShadow := "0 1px 3px grey",
        margin(3 px)
      ),
      unsafeChild("div")(
        flex := "1"
      )
    )

    val tableHeader = style(fontWeight.bold,
      borderBottom :=! "1px solid #e0e0e0",
      tableRow)

    val settingsBar = style(display.flex,
      margin :=! "15px 0",
      justifyContent.spaceBetween
    )

    val sortIcon = boolStyle(ascending => styleS(
      &.after(
        fontSize(9 px),
        marginLeft(5 px),
        if (ascending) content := "'\\25B2'"
        else content := "'\\25BC'"
      )
    ))

    //    val tableCell = intStyle(1 to 1)(i => )

  }

  object DefaultStyle extends Style

  case class State(filterText: String, offset: Int, rowsPerPage: Int, filteredModels: Vector[Model], sortedState: Map[String, String])

  class Backend(t: BackendScope[Props, State]) {


    def onTextChange(value: String) =
      t.modState(_.copy(filteredModels = getFilterdModels(value, t.props.data), offset = 0))

    def onPreviousClick() = {
      t.modState(s => s.copy(offset = s.offset - s.rowsPerPage))
    }

    def onNextClick() = {
      t.modState(s => s.copy(offset = s.offset + s.rowsPerPage))
    }

    def getFilterdModels(text: String, models: Vector[Model]) = {
      if (text.isEmpty) models
      else models.filter(model =>
        model.values.mkString.toLowerCase.contains(text.toLowerCase))
    }

    def sort(f: (Map[String, Any], Map[String, Any]) => Boolean, item: String) = {
      val rows = t.state.filteredModels
      t.state.sortedState.getOrElse(item, "") match {
        case ASC => t.modState(_.copy(filteredModels = rows.reverse, sortedState = Map(item -> DSC), offset = 0))
        case DSC => t.modState(_.copy(filteredModels = rows.sortWith(f), sortedState = Map(item -> ASC), offset = 0))
        case _ => t.modState(_.copy(filteredModels = rows.sortWith(f), sortedState = Map(item -> ASC), offset = 0))

      }
    }

    def sortClass(key: String) = {
      t.state.sortedState.getOrElse(key, "") match {
        //        case ASC => t.props.css.ascendingIcon
        //        case DSC => t.props.css.descendingIcon
        case _ => ""
      }
    }

    def onPageSizeChange(value: String) = t.modState(_.copy(rowsPerPage = value.toInt))

  }

  def getIntSort(key: String) = (m1: Model, m2: Model) => m1(key).asInstanceOf[Int] < m2(key).asInstanceOf[Int]

  def getDoubleSort(key: String) = (m1: Model, m2: Model) => m1(key).asInstanceOf[Double] < m2(key).asInstanceOf[Double]

  def getLongSort(key: String) = (m1: Model, m2: Model) => m1(key).asInstanceOf[Long] < m2(key).asInstanceOf[Long]

  def getStringSort(key: String) = (m1: Model, m2: Model) => m1(key).toString < m2(key).toString

  def getDateSort(key: String) = (m1: Model, m2: Model) => m1(key).asInstanceOf[Date].getTime() < m2(key).asInstanceOf[Date].getTime()


  def getRenderFunction(key: String, config: List[Config]) = {
    val group = config.groupBy(_._1).getOrElse(key, Nil)
    if (group.nonEmpty) group(0)._2 else null
  }

  def getSortFunction(key: String, config: List[Config]) = {
    val group = config.groupBy(_._1).getOrElse(key, Nil)
    if (group.nonEmpty) group(0)._3 else null
  }

  def arrowUp: TagMod = Seq(^.width := 0, ^.height := 0, ^.borderLeft := "5px solid transparent", ^.borderRight := "5px solid transparent", ^.borderBottom := "5px solid black")

  def arrowDown: TagMod = Seq(^.width := 0, ^.height := 0, ^.borderLeft := "5px solid transparent", ^.borderRight := "5px solid transparent", ^.borderTop := "5px solid black")

  def emptyClass: TagMod = Seq(^.padding := "1px")


  val tableHeader = ReactComponentB[(Props, Backend, State)]("reactTableHeader")
    .render(P => {
    val (props, b, state) = P
    <.div(props.style.tableHeader,
      if (props.config.nonEmpty) {
        props.columns.map { item => {
          val f = getSortFunction(item, props.config)
          if (f != null) {
            <.div(^.cursor := "pointer",
              ^.onClick --> b.sort(f, item), item.capitalize,
              state.sortedState.isDefinedAt(item) ?= props.style.sortIcon(state.sortedState(item) == ASC)
            )
          }
          else <.div(item.capitalize)
        }
        }
      }
      else props.columns.map(s => <.div(s.capitalize))
    )
  }).build


  val tableRow = ReactComponentB[(Model, Props)]("TableRow")
    .render(P => {
    val (row, props) = P
    <.div(props.style.tableRow,
      if (props.config.nonEmpty) {
        props.columns.map { item => val f = getRenderFunction(item, props.config); if (f != null) <.div(f(row(item))) else <.div(row(item).toString)}
      }
      else props.columns.map { item => <.div(row(item).toString)}
    )
  }).build


  val tableC = ReactComponentB[(Props, State, Backend)]("table")
    .render(P => {
    val (props, state, b) = P
    val rows = state.filteredModels.slice(state.offset, state.offset + state.rowsPerPage).zipWithIndex.map { case (row, i) => tableRow.withKey(i)((row, props))}
    <.div(props.style.table)(
      tableHeader((props, b, state)),
      rows
    )
  }).build


  val settingsBar = ReactComponentB[(Props, Backend, State)]("settingbar")
    .render(P => {
    val (p, b, s) = P
    var value = ""
    var options: List[String] = Nil
    val total = s.filteredModels.length
    if (total > p.rowsPerPage) {
      value = s.rowsPerPage.toString
      options = immutable.Range.inclusive(p.rowsPerPage, total, 10 * (total / 100 + 1)).:+(total).toList.map(_.toString)
    }
    <.div(p.style.settingsBar)(
      <.div(<.strong("Total : " + s.filteredModels.size)),
      DefaultSelect(label = "Page Size : ",
        options = options,
        value = value,
        onChange = b.onPageSizeChange)
    )
  }).build

  val component = ReactComponentB[Props]("ReactTable")
    .initialStateP(p => State(filterText = "", offset = 0, p.rowsPerPage, p.data, Map()))
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(P.style.reactTableContainer)(
      P.enableSearch ?= ReactSearchBox(onTextChange = B.onTextChange _),
      settingsBar((P, B, S)),
      tableC((P, S, B)),
      Pager(S.rowsPerPage, S.filteredModels.length, S.offset, B.onNextClick, B.onPreviousClick)

    )
  })
    .build


  case class Props(data: Vector[Model], columns: List[String], config: List[Config], rowsPerPage: Int, style: Style,enableSearch : Boolean)

  case class CSS(table: String = "table table-hover", tableResponsive: String = "table-responsive-vertical shadow-z-1", ascendingIcon: String = "ascendingIcon", descendingIcon: String = "descendingIcon", searchBoxForm: String = "form-group", searchBoxControl: String = "form-control")

  def apply(data: Vector[Model], columns: List[String], config: List[Config] = List(), rowsPerPage: Int = 5, style: Style = DefaultStyle,enableSearch : Boolean = true) = {
    component(Props(data, columns, config, rowsPerPage, style,enableSearch))
  }

}

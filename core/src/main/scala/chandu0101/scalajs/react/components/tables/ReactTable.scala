package chandu0101.scalajs.react.components.tables

import chandu0101.scalajs.react.components.optionselectors.DefaultSelect
import chandu0101.scalajs.react.components.pagers.Pager
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, SyntheticEvent, _}
import org.scalajs.dom.html

import scala.collection.immutable
import scala.scalajs.js.Date



/**
 * Created by chandrasekharkode .
 */
object ReactTable {

  type Model = Map[String, Any]

  type Config = (String, (Any) => ReactElement, (Model, Model) => Boolean)

  val ASC: String = "asc"
  val DSC: String = "dsc"


  case class State(filterText: String, offset: Int, rowsPerPage: Int, filteredModels: Vector[Model], sortedState: Map[String, String])

  class Backend(t: BackendScope[Props, State]) {


    def onTextChange(e: SyntheticEvent[html.Input]) =
      t.modState(_.copy(filteredModels = getFilterdModels(e.target.value, t.props.data), offset = 0))

    def onPreviousClick(e: SyntheticEvent[html.Anchor]) = {
      t.modState(s => s.copy(offset = s.offset - s.rowsPerPage))
    }

    def onNextClick(e: SyntheticEvent[html.Anchor]) = {
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
        case ASC => t.props.css.ascendingIcon
        case DSC => t.props.css.descendingIcon
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
    <.thead(
      if (props.config.nonEmpty) {
        props.columns.map { item => {
          val f = getSortFunction(item, props.config)
          if (f != null) <.th(^.cls := b.sortClass(item), ^.cursor := "pointer", ^.onClick --> b.sort(f, item))(item.capitalize)
          else <.th(item.capitalize)
        }
        }
      }
      else props.columns.map(s => <.th(s.capitalize))
    )
  }).build

  val theTr = Ref[html.Element]("theTr")

  val tableRow = ReactComponentB[(Model, List[Config], List[String])]("SeedRow")
    .render(P => {
    val (row, config, columns) = P
    <.tr(
      if (config.nonEmpty) {
        columns.map { item => val f = getRenderFunction(item, config); if (f != null) <.td(f(row(item))) else <.td(row(item).toString)}
      }
      else columns.map { item => <.td(row(item).toString)}
    )
  }).build


  val tableRows = ReactComponentB[(State, Props)]("tableRows")
    .render(P => {
    val (state, props) = P
    val rows = state.filteredModels.slice(state.offset, state.offset + state.rowsPerPage).zipWithIndex.map { case (row, i) => tableRow.withKey(i)((row, props.config, props.columns))}
    <.tbody(
      rows
    )
  }).build

  val tableC = ReactComponentB[(Props, State, Backend)]("table")
    .render(P => {
    val (props, state, b) = P
   <.div(^.cls := props.css.tableResponsive)(
      <.table(^.cls := props.css.table)(
        tableHeader((props, b, state)),
        tableRows((state, props))
      )
    )
  }).build

  val searchBar = ReactComponentB[(Props, (ReactEventI) => Unit)]("searchBar")
    .render(P => {
    val (props, fn) = P
   <.div(^.cls := props.css.searchBoxForm)(
      <.input(^.cls := props.css.searchBoxControl, ^.tpe := "text", ^.placeholder := "Search..", ^.onChange ==> fn)
    )
  }).build

  val settingsBar = ReactComponentB[(Props, Backend, State)]("settingbar")
    .render(P => {
      val (p,b,s) = P
      var value = ""
      var options : List[String] = Nil
      val total = s.filteredModels.length
      if(total > p.rowsPerPage) {
         value = s.rowsPerPage.toString
         options = immutable.Range.inclusive(p.rowsPerPage,total,10*(total/100 + 1)).:+(total).toList.map(_.toString)
      }
     <.div(^.cls := "settings")(
        <.span(^.float := "right")(<.strong("Total : " + s.filteredModels.size)),
        DefaultSelect(label = "Page Size : ", options = options, value = value, onChange = b.onPageSizeChange)
      )
    }).build

  val component = ReactComponentB[Props]("ReactTable")
    .initialStateP(p => State(filterText = "", offset = 0, p.rowsPerPage, p.data, Map()))
    .backend(new Backend(_))
    .render((P, S, B) => {
     <.div(^.cls := "reacttable")(
        searchBar((P, B.onTextChange)),
        settingsBar((P,B,S)),
        tableC((P, S, B)),
        Pager(S.rowsPerPage, S.filteredModels.length, S.offset, B.onNextClick, B.onPreviousClick)

      )
    })
    .build


  case class Props(data: Vector[Model], columns: List[String], config: List[Config], rowsPerPage: Int, css: CSS)

  case class CSS(table: String = "table table-hover", tableResponsive: String = "table-responsive-vertical shadow-z-1", ascendingIcon: String = "ascendingIcon", descendingIcon: String = "descendingIcon", searchBoxForm: String = "form-group", searchBoxControl: String = "form-control")

  def apply(data: Vector[Model], columns: List[String], config: List[Config] = List(), rowsPerPage: Int = 5, css: CSS = CSS()) = {
    component(Props(data, columns, config, rowsPerPage, css))
  }

}

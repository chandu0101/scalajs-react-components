package chandu0101.scalajs.react.components.materialui.datepicker


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.DateTime
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.scalajs.js.Date


/**
 * Created by chandrasekharkode .
 *
 * displayDate: React.PropTypes.object.isRequired,
    onDayTouchTap: React.PropTypes.func,
    selectedDate: React.PropTypes.object.isRequired
 */
object MuiCalenderMonth {


  val component = ReactComponentB[Props]("MuiCalenderMonth")
    .initialState(State(checked = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
   <.div(^.classSet1M(mui_date_picker_calendar_month, P.clsNames))(
      B.getWeekElements
    )
  })
    .build

  def apply(selectedDate: Date, clsNames: CssClassType = Map(), displayDate: Date, ref: js.UndefOr[String] = "", key: js.Any = {}, onDayTouchTap: REventIDateUnit = null) = component.set(key, ref)(Props(selectedDate, clsNames, displayDate, onDayTouchTap))

  case class State(checked: Boolean)

  class Backend(t: BackendScope[Props, State]) {

    def getWeekElements = {
      DateTime.getWeekArray(t.props.displayDate).zipWithIndex.map {
        case (week, i) => <.div(^.cls := mui_date_picker_calendar_month_week, ^.key := i)(getDayElements(week))
      }
    }

    def getDayElements(week: List[Date]) = {
      week.zipWithIndex.map { case (day, i) => {
        val selected = DateTime.isEqualDate(t.props.selectedDate, day)
        MuiDayButton(date = day, onTouchTap = handleDayTouchTap, selected = selected, key = i)
      }
      }
    }

    def handleDayTouchTap(e: ReactEventI, date: Date) = {
      if (t.props.onDayTouchTap != null) t.props.onDayTouchTap(e, date)
    }

  }

  case class Props(selectedDate: Date, clsNames: CssClassType, displayDate: Date, onDayTouchTap: REventIDateUnit)


}

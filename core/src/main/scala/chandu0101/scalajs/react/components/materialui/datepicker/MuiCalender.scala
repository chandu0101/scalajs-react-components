package chandu0101.scalajs.react.components.materialui.datepicker


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.materialui.transiotiongroups.MuiSliderIn
import chandu0101.scalajs.react.components.mixins.WindowListeners
import chandu0101.scalajs.react.components.util.{CommonUtils, DateTime, Events}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.{Event, KeyboardEvent}

import scala.scalajs.js
import scala.scalajs.js.{Date, Function1}


/**
 * Created by chandrasekharkode .
 *
 * initialDate: React.PropTypes.object,
    isActive: React.PropTypes.bool
 */
object MuiCalender {

  val dayList = List("S", "M", "T", "W", "T", "F", "S")
  val component = ReactComponentB[Props]("MuiCalender")
    .initialStateP(p => State(DateTime.getFirstDayOfMonth(p.initialDate), p.initialDate))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val weekCount = DateTime.getWeekArray(S.displayDate).length
    val classes = CommonUtils.cssMap1M(mui_date_picker_calendar, P.clsNames, mui_is_4week -> (weekCount == 4),
      mui_is_5week -> (weekCount == 5),
      mui_is_6week -> (weekCount == 6)
    )
    div(classSetM(classes))(
      MuiDateDisplay(clsNames = Map(mui_date_picker_calendar_date_display -> true), selectedDate = S.selectedDate),
      div(cls := mui_date_picker_calendar_container)(
        MuiCalenderToolbar(displayDate = S.displayDate, onLeftTouchTap = B.handleLeftTouchTap, onRightTouchTap = B.handleRightTouchTap),
        ul(cls := mui_date_picker_calendar_week_title)(
          dayList.map(day => li(cls := mui_date_picker_calendar_week_title_day)(day))
        ),
        MuiSliderIn(direction = S.transitionDirection)(
          MuiCalenderMonth(key = S.displayDate.toDateString(),
            clsNames = Map(MuiSliderIn.childCss -> true),
            displayDate = S.displayDate,
            selectedDate = S.selectedDate,
            onDayTouchTap = B.handleDayTouchTap
          )
        )
      )
    )
  })
    .componentWillReceiveProps((scope, next) => {
    if (next.initialDate != scope.props.initialDate) {
      val d = if (next.initialDate == null) new Date() else next.initialDate
      scope.modState(_.copy(displayDate = DateTime.getFirstDayOfMonth(d), selectedDate = next.initialDate))
    }
  })
    .configure(WindowListeners.mixin)
    .build

  def apply(clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {}, isActive: Boolean = false, initialDate: Date = new Date()) =
    component.set(key, ref)(Props(clsNames, isActive, initialDate))

  case class State(displayDate: Date, selectedDate: Date, transitionDirection: String = "left")

  class Backend(t: BackendScope[Props, State]) extends WindowListeners {

    lazy val handleWindowKeyDown: js.Function1[Event, Unit] = (e: Event) => {
      val keyEvent = e.asInstanceOf[KeyboardEvent]
      keyEvent.keyCode match {
        case KeyCode.up => if (keyEvent.shiftKey) addSelectedMonths(-1) else addSelectedDays(-7)
        case KeyCode.down => if (keyEvent.shiftKey) addSelectedMonths(1) else addSelectedDays(7)
        case KeyCode.right => if (keyEvent.shiftKey) addSelectedMonths(1) else addSelectedDays(1)
        case KeyCode.left => if (keyEvent.shiftKey) addSelectedMonths(-1) else addSelectedDays(-1)
        case _ => ;
      }
    }

    def getSelectedDate = t.state.selectedDate

    def addSelectedDays(days: Int) = setSelectedDate(DateTime.addDays(t.state.selectedDate, days))

    def addSelectedMonths(months: Int) = setSelectedDate(DateTime.addMonths(t.state.selectedDate, months))

    def setSelectedDate(d: Date) = {
      val newDisplayDate = DateTime.getFirstDayOfMonth(d)
      if (newDisplayDate != t.state.displayDate) {
        setDisplayDate(newDisplayDate, d)
      } else {
        t.modState(_.copy(selectedDate = d))
      }
    }

    def handleDayTouchTap(e: ReactEventI, date: Date) = setSelectedDate(date)

    def handleLeftTouchTap(e: ReactEventI) = addDisplatDate(-1)

    def addDisplatDate(m: Int) = {
      val newDisplayDate = DateTime.clone(t.state.displayDate)
      newDisplayDate.setMonth(newDisplayDate.getMonth() + m)
      setDisplayDate(newDisplayDate)
    }

    def setDisplayDate(old: Date, newSelected: Date = null) = {
      val newDisplayDate = DateTime.getFirstDayOfMonth(old)
      val direction = if (newDisplayDate.getTime() > t.state.displayDate.getTime()) "left" else "right"
      val newStateSelectedDate = if (newSelected != null) newSelected else t.state.selectedDate
      if (newDisplayDate != t.state.displayDate) {
        t.modState(_.copy(newDisplayDate, newStateSelectedDate, direction))
      }
    }

    def handleRightTouchTap(e: ReactEventI) = addDisplatDate(1)

    override def listeners: List[(String, Function1[Event, _])] = List(Events.KEYDOWN -> handleWindowKeyDown)
  }

  case class Props(clsNames: CssClassType, isActive: Boolean, initialDate: Date)

}

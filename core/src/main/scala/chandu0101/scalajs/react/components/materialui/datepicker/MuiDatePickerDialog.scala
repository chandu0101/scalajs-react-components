package chandu0101.scalajs.react.components.materialui.datepicker


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.materialui.{MuiDialogWindow, MuiFlatButton}
import chandu0101.scalajs.react.components.mixins.WindowListeners
import chandu0101.scalajs.react.components.util.{CommonUtils, Events}
import japgolly.scalajs.react._
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.{Event, KeyboardEvent}

import scala.scalajs.js
import scala.scalajs.js.{Date, Function1}

import chandu0101.scalajs.react.components.util.MTypes
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scala.scalajs.js
import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._



/**
 * Created by chandrasekharkode .
 *
 * initialDate: React.PropTypes.object,
    onAccept: React.PropTypes.func
 */
object MuiDatePickerDialog {


  val theDialogWindowRef = Ref.to(MuiDialogWindow.component, "theDialogWindowRef")
  val theCalenderRef = Ref.to(MuiCalender.component, "theCalenderRef")
  val component = ReactComponentB[Props]("MuiDatePickerDialog")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMap1M(mui_date_picker_dialog, P.clsNames)
    val actions = List(
      MuiFlatButton(key = 0, label = "Cancel", secondary = true, onTouchTap = B.handleCancelTouchTap, clsNames = Map(mui_dialog_window_action -> true)),
      MuiFlatButton(key = 1, label = "OK", secondary = true, onTouchTap = B.handleOKTouchTap, clsNames = Map(mui_dialog_window_action -> true))
    )
    MuiDialogWindow(ref = theDialogWindowRef, clsNames = classes, contentClassName = mui_date_picker_dialog_window,
      onDismiss = B.handleDialogDismiss _, onShow = B.handleDialogShow _, repositionOnUpdate = false, actions = actions
    )(
        MuiCalender(key = "mcal", ref = theCalenderRef, initialDate = P.initialDate, isActive = S.isCalendarActive)
      )
  })
    .configure(WindowListeners.mixin)
    .build

  def apply(onAccept: DateUnit = null, clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {}, initialDate: Date = null) =
    component.set(key, ref)(Props(onAccept, clsNames, initialDate))

  case class State(isCalendarActive: Boolean = false)

  class Backend(t: BackendScope[Props, State]) extends WindowListeners {

    lazy val handleWindowKeyUp: js.Function1[Event, _] = (e: Event) => {
      val keyEvent = e.asInstanceOf[KeyboardEvent]
      if (theDialogWindowRef(t).get.backend.isOpen) {
        if (keyEvent.keyCode == KeyCode.enter) handleOKTouchTap(e.asInstanceOf[ReactEventI])
      }

    }

    def show() = theDialogWindowRef(t).get.backend.show

    def handleCancelTouchTap(e: ReactEventI) = dismiss

    def handleOKTouchTap(e: ReactEventI) = {
      if (t.props.onAccept != null) t.props.onAccept(theCalenderRef(t).get.backend.getSelectedDate)
      dismiss
    }

    def dismiss() = theDialogWindowRef(t).get.backend.dismiss

    def handleDialogShow() = t.modState(_.copy(isCalendarActive = true))

    def handleDialogDismiss() = t.modState(_.copy(isCalendarActive = false))

    override def listeners: List[(String, Function1[Event, _])] = List(Events.KEYUP -> handleWindowKeyUp)
  }

  case class Props(onAccept: DateUnit, clsNames: CssClassType, initialDate: Date)

}

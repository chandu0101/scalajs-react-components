package chandu0101.scalajs.react.components.materialui.datepicker


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.MuiTextField
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.mixins.WindowListeners
import chandu0101.scalajs.react.components.util.{DateTime, CommonUtils, Events}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.{Date, Function1}


/**
 * Created by chandrasekharkode .
 */
object MuiDatePicker {


  val LANDSCAPE: String = "landscape"
  val INLINE: String = "inline"
  val theInputRef = Ref.to(MuiTextField.component, "theDatePickerTextField")
  val theDialogWindowRef = Ref.to(MuiDatePickerDialog.component, "theDialogWindowRef")
  val component = ReactComponentB[Props]("MuiDatePicker")
    .initialStateP(p => State(p.defaultDate, new Date()))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMap1M(mui_date_picker, P.clsNames,
      mui_is_landscape -> (P.mode == LANDSCAPE),
      mui_is_inline -> (P.mode == INLINE)
    )
    val defaultInputValue = if (P.defaultDate != null) P.formatDate(P.defaultDate) else null
    div(classSetM(classes))(
      MuiTextField(ref = theInputRef, defaultValue = defaultInputValue, onFocus = B.handleInputFocus, name = P.name, onTouchTap = B.handleInputTouchTap, hintText = P.placeholder ,id = s"${P.placeholder}YEAH"),
      MuiDatePickerDialog(ref = theDialogWindowRef, initialDate = S.dialogDate, onAccept = B.handleDialogAccept)
    )
  })
    .build


  case class State(date: Date, dialogDate: Date = new Date())

  class Backend(t: BackendScope[Props, State]) extends WindowListeners {

    lazy val handleWindowKeyUp: js.Function1[Event, Unit] = (e: Event) => {

    }

    def handleDialogAccept(d: Date) = {
      setDate(d)
      if (t.props.onChange != null) t.props.onChange(d)
    }

    def setDate(d: Date) = {
      theInputRef(t).get.backend.setValue(t.props.formatDate(d))
      t.modState(_.copy(date = d))
    }

    def handleInputFocus(e: ReactEventI) = {
      e.target.blur()
      if (t.props.onFocus != null) t.props.onFocus(e)
    }

    def handleInputTouchTap(e: ReactEventI) = {
      val d = if (getDate == null) new Date() else getDate
      t.modState(_.copy(dialogDate = d))
      theDialogWindowRef(t).get.backend.show
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
    }

    def getDate = t.state.date

    override def listeners: List[(String, Function1[Event, _])] = List(Events.KEYUP -> handleWindowKeyUp)
  }

  case class Props(defaultDate: Date, onChange: DateUnit, clsNames: CssClassType, ref: js.UndefOr[String], key: js.Any, onTouchTap: REventIUnit, formatDate: DateString, onFocus: REventIUnit, mode: String, placeholder: String, name: String)

  def apply(defaultDate: Date = null, onChange: DateUnit = null, clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {}, onTouchTap: REventIUnit = null, formatDate: DateString = DateTime.format, onFocus: REventIUnit = null, mode: String = "", placeholder: String = "", name: String = "") =
    component.set(key, ref)(Props(defaultDate, onChange, clsNames, ref, key, onTouchTap, formatDate, onFocus, mode, placeholder, name))

}

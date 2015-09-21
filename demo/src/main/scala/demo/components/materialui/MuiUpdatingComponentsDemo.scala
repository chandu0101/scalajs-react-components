package demo
package components
package materialui

import chandu0101.scalajs.react.components.fascades.LatLng
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react._, vdom.prefix_<^._, ScalazReact._, MonocleReact._
import scala.scalajs.js.{UndefOr, Any, Date}
import japgolly.scalajs.react.extra.ExternalVar
import monocle.macros._
import scala.scalajs.js.Dynamic.global



object MuiUpdatingComponentsDemo {
  
  //@Lenses
  case class DateSpan(start: Date, end: Date, errorMsg: Option[String],
                      pickerMode: MuiDatePickerMode, useAutoOk: Boolean, useYYYYMMDD: Boolean)

  def after(a: Date, b: Date) = a != null && b != null && a.getTime > b.getTime
  def dateFormatterYYYMMDD = (d: Date) => if (d == null) "" else f"${d.getFullYear}-${d.getMonth + 1}%02d-${d.getDate}%02d"
  def dateFormatterToString = (d: Date) => if (d == null) "" else d.toString
  def onlyWeekdays = (d: Date) => (d.getDay() + 1) % 6 != 1

  def modeName(b: Boolean) = if (b) MuiDatePickerMode.LANDSCAPE else MuiDatePickerMode.PORTRAIT
  def autoOkName(b: Boolean) = if (b) "on" else "off"
  def dateFormatName(b: Boolean) = if (b) "YYYY-MM-DD" else "String"

  val code =
    """
      | MuiDatePicker(hintText = "Protrait Dialog"),
      | MuiDatePicker(hintText = "Landscape Dialog",mode = MuiDatePickerMode.LANDSCAPE)
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("MuiUpdatingComponentsDemo")
    .initialState(DateSpan(null, null, None, MuiDatePickerMode.PORTRAIT, false, false))
    .render( $ => {


      def updateStart       = (_: Date, d: Date) => $.modState(s => s.copy(start = d,
                                                end = if (after(d, s.end)) d else s.end))
      def updateEnd         = (_: Date, d: Date) => $.modState(_.copy(end = d))
      def modeSwitch        = (_: ReactEvent, mode: String) => $.modState(_.copy(pickerMode = MuiDatePickerMode.newMode(mode)))
      def autoOkToggle      = (_: ReactEvent, toggled: Boolean) => $.modState(_.copy(useAutoOk = toggled))
      def dateFormatToggle  = (_: ReactEvent, toggled: Boolean) => $.modState(_.copy(useYYYYMMDD = toggled))

      def onSubmit : ReactEventH => Unit = (_:ReactEventH) => global.alert(" Do something Ajax-y with: " + $.state)

      def ??[T](a : T, b: => T) : T = if(a != null) a else b


      val state = $.state

      //val portrait : UndefOr[String] =

      <.div(
        CodeExample(code,"MuiUpdatingComponentsDemo")(
          MuiPaper(zDepth = 3)(
            <.div(^.padding := 3.em,

              // while we can use a toggle for the picker orientation,
              // a radio group is more appropriate, because no mode
              // maps to "off" and the other to "on"
              // We will also change DateSpan's Boolean (is)landscapeMode to a String, pickerMode
              <.label("Picker orientation:",
                MuiRadioButtonGroup(
                  name = "pickerdisplayorientation",
                  defaultSelected = state.pickerMode.value,
                  onChange = modeSwitch)(
                    MuiRadioButton(value = MuiDatePickerMode.PORTRAIT.value, label = MuiDatePickerMode.PORTRAIT.value)(),
                    MuiRadioButton(value = MuiDatePickerMode.LANDSCAPE.value, label = MuiDatePickerMode.LANDSCAPE.value)()
                  )
              ),
              MuiToggle(
                onToggle = autoOkToggle,
                defaultToggled = state.useAutoOk,
                labelPosition = MuiSwitchLabelPosition.RIGHT,
                label="Switch to AutoOk:" + autoOkName(! state.useAutoOk) + " DatePickers"
              )(),

              MuiToggle(
                onToggle = dateFormatToggle,
                defaultToggled = state.useYYYYMMDD,
                labelPosition = MuiSwitchLabelPosition.RIGHT,
                label="Switch to " + dateFormatName(! state.useYYYYMMDD) + " date format DatePickers"
              )(),
               <.h2("Select your travel dates"),
               //<.div(
                 <.label("Depart On:",
               MuiDatePicker(
                 defaultDate = state.start,
                 hintText = "Start Date",
                 onChange = updateStart,
                 minDate = new Date(),
                 mode = state.pickerMode,
                 autoOk = state.useAutoOk,
                 formatDate = if (state.useYYYYMMDD) dateFormatterYYYMMDD else dateFormatterToString
               )()),
              <.label("Return On:",
               MuiDatePicker(
                 defaultDate = state.end,
                 hintText = "End Date",
                 onChange = updateEnd,
                 minDate = ??(state.start, new Date()),
                 mode = state.pickerMode,
                 autoOk = state.useAutoOk,
                 formatDate = if (state.useYYYYMMDD) dateFormatterYYYMMDD else dateFormatterToString
               )()),
                             //shouldDisableDate = onlyWeekdays)(),

               MuiRaisedButton(
                 primary = true,
                 label = "Find Reservations",
                 disabled = state.end == null,
                 onTouchTap = onSubmit
               )(),
              <.p(
                """
                  | While we can use a toggle for the picker orientation,
                  | a radio group is more appropriate, because no mode
                  | maps to "off" and the other to "on".
                  | We will also change DateSpan's Boolean (is)landscapeMode to a String, pickerMode.
                """.stripMargin)
            )
          ),

           <.div(dateFormatterToString(state.start)),
           <.div(if (state.end == null) "Not Set" else state.end.toString),
           <.div(state.errorMsg.map( s => <.span(s))),
           <.button(^.onClick --> {global.alert(" Do something Ajax-y with:" + state)}, "Submit")
        )
      )
  }).buildU
  

  def apply() = component()
}



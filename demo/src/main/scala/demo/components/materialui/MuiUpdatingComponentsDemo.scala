package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.{ReactComponentB, _}
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.scalajs.js.Date
import scala.scalajs.js.Dynamic.global



object MuiUpdatingComponentsDemo {
  
  //@Lenses
  case class DateSpan(start: Date, end: Date, errorMsg: Option[String], useAutoOk: Boolean,
                      pickerMode: MuiDatePickerMode, dateFormatterOffset: Int)

  def ??[T](a : T, b: => T) : T = if (a != null) a else b
  def after(a: Date, b: Date) = a != null && b != null && a.getTime > b.getTime
  def onlyWeekdays = (d: Date) => (d.getDay() + 1) % 6 != 1

  def autoOkName(b: Boolean) = if (b) "on" else "off"

  val dateFormatters = Seq[(String, Date => String)](
    "YYYY-MM-DD"     -> ((d: Date) => if (d == null) "" else f"${d.getFullYear}-${d.getMonth + 1}%02d-${d.getDate}%02d"),
    "toString"       -> ((d: Date) => if (d == null) "" else d.toString),
    "US MM/DD/YYYY"  -> ((d: Date) => if (d == null) "" else f"${d.getMonth + 1}%02d/${d.getDate}%02d/${d.getFullYear}"), // US
    "EUR DD/MM/YYYY" -> ((d: Date) => if (d == null) "" else f"${d.getDate}%02d/${d.getMonth + 1}%02d/${d.getFullYear}") // Eur
  )

  val dateFormattersMenuItems = dateFormatters.zipWithIndex.map {
    case((label, f), i) => MuiDropdownMenuItem(payload = i.toString, text = label + " " + f(new Date()))
  }.toJsArray

  val code =
    """
      | Get code from a macro.
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("MuiUpdatingComponentsDemo")
    .initialState(DateSpan(null, null, None, false, MuiDatePickerMode.PORTRAIT, 0))
    .render( $ => {


      def updateStart       = (_: Date, d: Date) => $.modState(s => s.copy(start = d,
                                                end = if (after(d, s.end)) d else s.end))
      def updateEnd         = (_: Date, d: Date) => $.modState(_.copy(end = d))
      def modeSwitch        = (_: ReactEvent, mode: String) => $.modState(_.copy(pickerMode = MuiDatePickerMode.newMode(mode)))
      def autoOkToggle      = (_: ReactEvent, toggled: Boolean) => $.modState(_.copy(useAutoOk = toggled))
      def dateFormatUpdate  = (_: ReactEvent, index: Int, _: js.Object) => $.modState(_.copy(dateFormatterOffset = index))


      def onSubmit : ReactEventH => Unit = (_:ReactEventH) => global.alert(" Do something Ajax-y with: " + $.state)

      val state = $.state

      //val portrait : UndefOr[String] =

      <.div(
        CodeExample(code,"MuiUpdatingComponentsDemo")(
          MuiPaper(zDepth = 3)(
            <.div(^.padding := 3.em,

              MuiToggle(
                onToggle = autoOkToggle,
                defaultToggled = state.useAutoOk,
                labelPosition = MuiSwitchLabelPosition.RIGHT,
                label="Switch to AutoOk:" + autoOkName(! state.useAutoOk) + " DatePickers"
              )(),

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

              <.label("Date display:",
                MuiDropdownMenu(
                  menuItems = dateFormattersMenuItems,
                  onChange = dateFormatUpdate)()
              ),

              <.h2("Select your travel dates"),

              <.label("Depart On:",
                MuiDatePicker(
                   defaultDate = state.start,
                   hintText = "Date Departing",
                   onChange = updateStart,
                   minDate = new Date(),
                   mode = state.pickerMode,
                   autoOk = state.useAutoOk,
                   formatDate = dateFormatters(state.dateFormatterOffset)._2
                 )()
              ),

              <.label("Return On:",
                 MuiDatePicker(
                   defaultDate = state.end,
                   hintText = "Date Returning",
                   onChange = updateEnd,
                   minDate = ??(state.start, new Date()),
                   mode = state.pickerMode,
                   autoOk = state.useAutoOk,
                   formatDate = dateFormatters(state.dateFormatterOffset)._2
                 )()
              ),

              MuiRaisedButton(
                   primary = true,
                   label = "Find Reservations",
                   disabled = state.end == null,
                   onTouchTap = onSubmit
                 )(),
              <.p("""
                    | Note: date format changes only occur after a date is selected.
                  """.stripMargin
              ),
              <.p("""
                    | While we can use a toggle for the picker orientation,
                    | a radio group is more appropriate, because no mode
                    | maps to "off" and the other to "on".
                    | We will also change DateSpan's Boolean (is)landscapeMode to a String, pickerMode.
                    | There's a small problem when the toggle is under the dropdow:
                    | clicking a dropdown sometimes causing the toggle on click to occur,
                    | and the dropdown onclick is apparently ignored?
                  """.stripMargin
              )
            )
          ),
          <.div(state.errorMsg.map( s => <.span(s)))
        )
      )
  }).buildU
  

  def apply() = component()
}



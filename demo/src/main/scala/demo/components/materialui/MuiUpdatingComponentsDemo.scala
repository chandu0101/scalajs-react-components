package demo
package components
package materialui

import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{ReactComponentB, _}
import org.scalajs.dom
import scala.scalajs.js

//todo: why are there nulls here?
object MuiUpdatingComponentsDemo {
  
  /* This is our state class.
     Note that the state includes not only our domain object, but also all the state we need to manage
     our component. So we'll rename it to just "State".

     Please note that only the date portions of start/endDate are valid, and only the time portions of start/endTime.
   */
  case class State(startDate: js.Date,
                   startTime: js.Date,
                   endDate: js.Date,
                   endTime: js.Date,
                   errorMsg: Option[String],
                   useAutoOk: Boolean,
                   pickerMode: MuiDatePickerMode,
                   dateFormatterOffset: Int)

  val twoHoursInMillis = 2 * 60 * 60 * 1000

  def validStateOrSetError(s: State) = {
    if (s.startDate == null || s.startTime == null || s.endDate == null || s.endTime == null
      || ! after(merge(s.startDate, s.startTime), add(merge(s.endDate, s.endTime), -twoHoursInMillis)))
        s.copy(errorMsg = None)
      else {
        val end = add(merge(s.endDate, s.startTime), twoHoursInMillis)
        s.copy(endDate = end, endTime = end, errorMsg = Some("Adjusted return date and time to be at least two hours after departure"))
    }
  }

  /* This is our backend class.
     It's the equivalent of "this" for React.js, and contains all the functionality to update our state.
     It takes two generic parameters, the type of props (Unit) and the type of state (State).

     We're just going to move all our closures from render to it. Since we used $ for the Component in render,
     we won't have to make any changes.

     We won't copy the "free" functions into this object; render can still use them, as they don't rely on state or backend.

     We will have to prefix the references  to the functions in render which the Backend parameter name "B", however.
     While we're at it, we'll change "state." to 'S.", though we could have just written "val state = S".

     The other thing we need to do is add a call to .backend(new Backend(_)) after the call to .getInitialState.
     This does something quite interesting: getInitialState returns a ReactComponmentB.PS, but .backend
     returns a different type entirely, a ReactComponent.PSB. This is a wonderful use of the Builder Pattern,
     and it means that the render we call will be an entirely different render -- one that, all the name implies, has
     an overload on a function (P, S, B) => some ReactComponent type. Which means render will supply our callback with a
     backend, in fact the same one we passed to .backend!

   */

  class Backend($: BackendScope[Unit, State]) {
    def updateStartDate   = (_: js.Date, d: js.Date) =>
      $.modState(s => validStateOrSetError(s.copy(startDate = d, endDate = if (after(d, s.endDate)) d else s.endDate)))
    def updateStartTime   = (_: js.Date, d: js.Date) => $.modState(s => validStateOrSetError(s.copy(startTime = d)))
    def updateEndDate     = (_: js.Date, d: js.Date) => $.modState(s => validStateOrSetError(s.copy(endDate = d)))
    def updateEndTime     = (_: js.Date, d: js.Date) => $.modState( s => validStateOrSetError(s.copy(endTime = d)))
    def modeSwitch        = (_: ReactEvent, mode: String) => $.modState(_.copy(pickerMode = MuiDatePickerMode.newMode(mode)))
    def autoOkToggle      = (_: ReactEvent, toggled: Boolean) => $.modState(_.copy(useAutoOk = toggled))
    def dateFormatUpdate  = (_: ReactEvent, index: Int, _: js.Object) => $.modState(_.copy(dateFormatterOffset = index))

    def onSubmit: ReactEventH => Callback = _ => Callback(dom.alert("Do something Ajax-y with: " + $.state))

    def render(S: State) = {
      <.div(
        CodeExample(code,"MuiUpdatingComponentsDemo")(
          MuiPaper(zDepth = 3)(
            <.div(^.padding := 3.em,

              MuiToggle(
                onToggle = autoOkToggle,
                defaultToggled = S.useAutoOk,
                labelPosition = MuiSwitchLabelPosition.RIGHT,
                label = s"Date Picker AutoOk is ${autoOkName(S.useAutoOk)}. Switch to AutoOk:${autoOkName(! S.useAutoOk)}."
              )(),

              // while we can use a toggle for the picker orientation,
              // a radio group is more appropriate, because no mode
              // maps to "off" and the other to "on"
              // We will also change DateSpan's Boolean (is)landscapeMode to a String, pickerMode
              <.label("Date Picker orientation:",
                MuiRadioButtonGroup(
                  name = "pickerdisplayorientation",
                  defaultSelected = S.pickerMode.value,
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

              <.div(^.color := "red", S.errorMsg.map( s => <.span(s))),
              <.div(^.color := "red", S.errorMsg.map(
                s => <.span("A bug prevents rendering it, but endTime is actually" + S.endTime.toString))),

              <.div( ^.clear := "both",
                <.h3("Depart"),
                <.label(^.float := "left", "Depart On:",
                  MuiDatePicker(
                     defaultDate = S.startDate,
                     hintText = "Date Departing",
                     onChange = updateStartDate,
                     minDate = new js.Date(),
                     mode = S.pickerMode,
                     autoOk = S.useAutoOk,
                     formatDate = dateFormatters(S.dateFormatterOffset)._2
                   )()
                ),

                <.label(^.float := "right", "Depart At or After:",
                  MuiTimePicker(
                    defaultTime = S.startTime, // there's a bug in MuiTimePicker, null/undefined initialTime causes NPE
                    hintText = "Time Departing",
                    onChange = updateStartTime
                  )()
                )
              ),

              <.div( ^.clear := "both",
                <.h3("Return"),
                <.label(^.float := "left", "Return On:",
                   MuiDatePicker(
                     defaultDate = S.endDate,
                     hintText = "Date Returning",
                     onChange = updateEndDate,
                     minDate = ??(S.startDate, new js.Date()),
                     mode = S.pickerMode,
                     autoOk = S.useAutoOk,
                     formatDate = dateFormatters(S.dateFormatterOffset)._2
                   )()
                ),

                <.label(^.float := "right", "Return At or After:",
                  MuiTimePicker(
                    defaultTime = S.endTime,
                    hintText = "Time Returning",
                    onChange = updateEndTime
                  )()
                )
              ),
              <.div( ^.clear := "both",
                MuiRaisedButton(
                     primary = true,
                     label = "Find Reservations",
                     disabled = S.endDate == null || S.endTime == null,
                     onTouchTap = onSubmit
                   )()
              ),

              <.p("""
                    | Note: date format changes only occur after a date is selected.
                  """.stripMargin
              ),
              <.p("""
                    | If the TimePicker is given a default date of null/undefined, it throws if the format is ampm.
                    | If the format is 24hrs, it doesn't throw, but it shows a time of 0:00.
                    | So there's no way to get a blank time (and thus the hint text) displayed.
                    | This is a bug in the material-ui javascript, not in scala-react-components.
                    |
                    | Also, updates to the defaultTime are not rendered when the state changes and
                    | a subsequent render happens (it is rendered for DatePicker).
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
          )
        )
      )

    }
  }

  // note that b is a by-name parameter, so we effectively get short-circuit evaluation
  def ??[T](a : T, b: => T) : T = if (a != null) a else b
  def after(a: js.Date, b: js.Date) = a != null && b != null && a.getTime > b.getTime
  def add(d: js.Date, millis: Double) = new js.Date(d.getTime() + millis) // getTime returns millis??
  def merge(date: js.Date, time: js.Date) = {
    if (date == null) time
    else if (time == null) date
    else {
      val r = new js.Date(date.getTime())
      r.setHours(time.getHours(), time.getMinutes(), time.getSeconds(), time.getMilliseconds())
      r
    }
  }
  def autoOkName(b: Boolean) = if (b) "on" else "off"

  val dateFormatters = Seq[(String, js.Date => String)](
    "YYYY-MM-DD"     -> ((d: js.Date) => if (d == null) "" else f"${d.getFullYear()}-${d.getMonth + 1}%02d-${d.getDate()}%02d"),
    "toString"       -> ((d: js.Date) => if (d == null) "" else d.toString),
    "US MM/DD/YYYY"  -> ((d: js.Date) => if (d == null) "" else f"${d.getMonth + 1}%02d/${d.getDate()}%02d/${d.getFullYear()}"), // US
    "EUR DD/MM/YYYY" -> ((d: js.Date) => if (d == null) "" else f"${d.getDate()}%02d/${d.getMonth + 1}%02d/${d.getFullYear()}") // Eur
  )

  val dateFormattersMenuItems = dateFormatters.zipWithIndex.map {
    case((label, f), i) => MuiDropdownMenuItem(payload = i.toString, text = label + " " + f(new js.Date()))
  }.toJsArray


  val component = ReactComponentB[Unit]("MuiUpdatingComponentsDemo")
    // TimePicker can't handle null times.
    .initialState(State(null, new js.Date(), null, new js.Date(), None, useAutoOk = false, MuiDatePickerMode.PORTRAIT, 0))
    .renderBackend[Backend]
    .buildU

  def apply() = component()

  val code =
    """""".stripMargin
}



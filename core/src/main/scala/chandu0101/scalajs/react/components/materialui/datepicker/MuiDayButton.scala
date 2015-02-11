package chandu0101.scalajs.react.components.materialui.datepicker


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.MuiEnhancedButton
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.{CommonUtils, DateTime}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js
import scala.scalajs.js.Date


/**
 * Created by chandrasekharkode .
 *
 *
onTouchTap: React.PropTypes.func,
    selected: React.PropTypes.bool
 */
object MuiDayButton {

  val component = ReactComponentB[Props]("MuiDayButton")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMap(mui_date_picker_day_button,
      mui_is_current_date -> DateTime.isEqualDate(P.date, new Date()),
      mui_is_selected -> P.selected)
    if (P.date != null) {
      MuiEnhancedButton(clsNames = classes, onTouchTap = B.handleTouchTap, disabled = false)(
        div(cls := mui_date_picker_day_button_select, key := "daydiv"),
        span(cls := mui_date_picker_day_button_label, key := "dayspan")(P.date.getDate())
      )
    } else {
      span(classSetM(classes))
    }
  })
    .build

  def apply(clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", selected: Boolean = false, key: js.Any = {}, date: Date = null, onTouchTap: REventIDateUnit = null) = component.set(key, ref)(Props(clsNames, ref, selected, key, date, onTouchTap))

  case class State(checked: Boolean)

  class Backend(t: BackendScope[Props, _]) {

    def handleTouchTap(e: ReactEventI) = {
      if (t.props.onTouchTap != null) t.props.onTouchTap(e, t.props.date)
    }

  }

  case class Props(clsNames: CssClassType, ref: js.UndefOr[String], selected: Boolean, key: js.Any, date: Date, onTouchTap: REventIDateUnit)

}

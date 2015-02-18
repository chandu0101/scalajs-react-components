package chandu0101.scalajs.react.components.materialui.datepicker


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.MuiIconButton
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.materialui.svgicons.{MuiNavigationChevronLeft, MuiNavigationChevronRight}
import chandu0101.scalajs.react.components.materialui.transiotiongroups.MuiSliderIn
import chandu0101.scalajs.react.components.util.DateTime
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js
import scala.scalajs.js.Date

/**
 * Created by chandrasekharkode .
 *
 * displayDate: React.PropTypes.object.isRequired,
    onLeftTouchTap: React.PropTypes.func,
    onRightTouchTap: React.PropTypes.func

 */
object MuiCalenderToolbar {

  val component = ReactComponentB[Props]("MuiCalenderToolbar")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    val month = DateTime.getFullMonth(P.displayDate)
    val year = P.displayDate.getFullYear()
    div(cls := mui_date_picker_calendar_toolbar)(
      MuiSliderIn(direction = S.transitionDirection, className = mui_date_picker_calendar_toolbar_title)(
        div(key := s"$month _ $year", cls := MuiSliderIn.childCss)(s"$month $year")
      ),
      MuiIconButton.withChildren(clsNames = Map(mui_date_picker_calendar_toolbar_button_left -> true), onTouchTap = P.onLeftTouchTap)(MuiNavigationChevronLeft()),
      MuiIconButton.withChildren(clsNames = Map(mui_date_picker_calendar_toolbar_button_right -> true), onTouchTap = P.onRightTouchTap)(MuiNavigationChevronRight())
    )
  })
    .componentWillReceiveProps((scope, nextProps) => {
    if (nextProps.displayDate != scope.props.displayDate) {
      val direction = if (nextProps.displayDate.getTime() > scope.props.displayDate.getTime()) "up" else "down"
      scope.modState(_.copy(transitionDirection = direction))
    }
  })
    .build

  case class State(transitionDirection: String = "up")

  class Backend(t: BackendScope[Props, State]) {

  }

  case class Props(clsNames: CssClassType, onLeftTouchTap: REventIUnit, displayDate: Date, onRightTouchTap: REventIUnit)

  def apply(clsNames: CssClassType = Map(), onLeftTouchTap: REventIUnit = null, displayDate: Date, ref: js.UndefOr[String] = "", key: js.Any = {}, onRightTouchTap: REventIUnit = null) =
    component.set(key, ref)(Props(clsNames, onLeftTouchTap, displayDate, onRightTouchTap))

}

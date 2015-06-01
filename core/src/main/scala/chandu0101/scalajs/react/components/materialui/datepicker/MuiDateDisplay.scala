package chandu0101.scalajs.react.components.materialui.datepicker


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.materialui.transiotiongroups.MuiSliderIn
import chandu0101.scalajs.react.components.util.DateTime
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.scalajs.js.Date


/**
 * Created by chandrasekharkode .
 * selectedDate: React.PropTypes.object.isRequired
 */

object MuiDateDisplay {


  val component = ReactComponentB[Props]("MuiDateDisplay")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    val dayOfWeek = DateTime.getDayOfWeek(P.selectedDate)
    val month = DateTime.getShortMonth(P.selectedDate)
    val day = P.selectedDate.getDate()
    val year = P.selectedDate.getFullYear()
   <.div(^.classSet1M(mui_date_picker_date_display, P.clsNames))(
      MuiSliderIn(className = mui_date_picker_date_display_dow, direction = S.transitionDirection)(
       <.div(^.key := dayOfWeek, ^.cls := MuiSliderIn.childCss)(dayOfWeek)
      ),
     <.div(^.cls := mui_date_picker_date_display_date)(

        MuiSliderIn(className = mui_date_picker_date_display_month, direction = S.transitionDirection)(
         <.div(^.key := month, ^.cls := MuiSliderIn.childCss)(month)
        ),
        MuiSliderIn(className = mui_date_picker_date_display_day, direction = S.transitionDirection)(
         <.div(^.key := day, ^.cls := MuiSliderIn.childCss)(day)
        ),
        MuiSliderIn(className = mui_date_picker_date_display_year, direction = S.transitionDirection)(
         <.div(^.key := year, ^.cls := MuiSliderIn.childCss)(year)
        )
      )

    )
  })
    .componentWillReceiveProps((scope, nextProps) => {
    if (nextProps.selectedDate != scope.props.selectedDate) {
      val direction = if (nextProps.selectedDate.getTime() > scope.props.selectedDate.getTime()) "up" else "down"
      scope.modState(_.copy(transitionDirection = direction))
    }
  })
    .build

  def apply(clsNames: CssClassType = Map(), key: js.Any = {}, ref: js.UndefOr[String] = "", selectedDate: Date) =
    component.set(key, ref)(Props(clsNames, selectedDate))

  case class State(transitionDirection: String = "up")

  class Backend(t: BackendScope[Props, State]) {


  }

  case class Props(clsNames: CssClassType, selectedDate: Date)

}

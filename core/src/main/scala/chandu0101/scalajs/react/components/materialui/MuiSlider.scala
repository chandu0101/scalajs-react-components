package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.html




/**
 * Created by chandrasekharkode .
 */
object MuiSlider {

  case class Props(clsNames: CssClassType, value: Double, name: String, step: Int, description: String, onChange: REventIDoubleUnit, min: Int, max: Int, error: String, disabled: Boolean, required: Boolean)

  case class State(value: Double, percent: Double)

  class Backend(t: BackendScope[Props, State]) {

     def onClick(e:ReactEventI) = ???
  }

  //Refs
  val theTrackRef = Ref[html.Div]("theTrack")


  val component = ReactComponentB[Props]("radioButton")
    .initialStateP(p => State(p.value, p.value / p.max))
    .backend(new Backend(_))
    .render((P, S, B) => {
       val classes = cssMapM(P.clsNames,(mui_input,true),(mui_error,!P.error.isEmpty))
       val sliderClasses = cssMapM(P.clsNames,(mui_slider,true),(mui_slider_zero,S.percent == 0),(mui_disabled,P.disabled))
      <.div(^.classSetM(classes))(
         <.span(^.cls := mui_input_highlight),
         <.span(^.cls := mui_input_bar),
         <.span(^.cls := mui_input_description)(P.description),
         <.span(^.cls := mui_input_error)(P.error),
        <.div(^.classSetM(sliderClasses) , ^.onClick ==> B.onClick)(
         <.div( ^.ref := theTrackRef , ^.cls := mui_slider_track) (


          )
         )
       )
    })
    .build

  def apply(clsNames: CssClassType = Map(), value: Double = 0, name: String, step: Int = 0, description: String = "", onChange: REventIDoubleUnit = null, min: Int = 0, max: Int = 1, error: String = "", disabled: Boolean = false, required: Boolean = true) = {
    component(Props(clsNames, value, name, step, description, onChange, min, max, error, disabled, required))
  }


}

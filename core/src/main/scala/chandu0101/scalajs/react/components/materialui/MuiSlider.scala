package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiSlider(
  key:                js.UndefOr[String]                            = js.undefined,
  ref:                js.UndefOr[SliderM => Unit]                   = js.undefined,
  /* The default value of the slider.*/
  defaultValue:       js.UndefOr[Double]                            = js.undefined,
  /* Describe the slider.*/
  description:        js.UndefOr[String]                            = js.undefined,
  /* Disables focus ripple if set to true.*/
  disableFocusRipple: js.UndefOr[Boolean]                           = js.undefined,
  /* If true, the slider will not be interactable.*/
  disabled:           js.UndefOr[Boolean]                           = js.undefined,
  /* An error message for the slider.*/
  error:              js.UndefOr[String]                            = js.undefined,
  /* The maximum value the slider can slide to on
  a scale from 0 to 1 inclusive. Cannot be equal to min.*/
  max:                js.UndefOr[Double]                            = js.undefined,
  /* The minimum value the slider can slide to on a scale
  from 0 to 1 inclusive. Cannot be equal to max.*/
  min:                js.UndefOr[Double]                            = js.undefined,
  /* The name of the slider. Behaves like the name attribute
  of an input element.*/
  name:               js.UndefOr[String]                            = js.undefined,
  /* Callback function that is fired when the focus has left the slider.*/
  onBlur:             js.UndefOr[ReactEventH => Callback]           = js.undefined,
  /* Callback function that is fired when the user changes the slider's value.*/
  onChange:           js.UndefOr[(ReactEventH, Double) => Callback] = js.undefined,
  /* Callback function that is fired when the slider has begun to move.*/
  onDragStart:        js.UndefOr[ReactDragEventH => Callback]       = js.undefined,
  /* Callback function that is fried when the slide has stopped moving.*/
  onDragStop:         js.UndefOr[ReactDragEventH => Callback]       = js.undefined,
  /* Callback fired when the user has focused on the slider.*/
  onFocus:            js.UndefOr[ReactFocusEventH => Callback]      = js.undefined,
  /* Whether or not the slider is required in a form.*/
  required:           js.UndefOr[Boolean]                           = js.undefined,
  /* The granularity the slider can step through values.*/
  step:               js.UndefOr[Double]                            = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:              js.UndefOr[CssProperties]                     = js.undefined,
  /* The value of the slider.*/
  value:              js.UndefOr[Double]                            = js.undefined){

  def apply() = {
    val props = JSMacro[MuiSlider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Slider)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
        


@js.native
class SliderM extends js.Object {
  def alignValue(`val`: js.Any): js.Any = js.native

  def clearValue(): js.Any = js.native

  def dragX(event: js.Any, pos: js.Any): js.Any = js.native

  def getPercent(): js.Any = js.native

  def getTrackLeft(): js.Any = js.native

  def getValue(): js.Any = js.native

  def onDragStart(event: js.Any): js.Any = js.native

  def onDragStop(event: js.Any): js.Any = js.native

  def onDragUpdate(event: js.Any, pos: js.Any): js.Any = js.native

  def percentToValue(percent: js.Any): js.Any = js.native

  def setPercent(percent: js.Any, callback: js.Any): js.Any = js.native

  def setValue(i: js.Any): js.Any = js.native

  def updateWithChangeEvent(event: js.Any, percent: js.Any): js.Any = js.native
}

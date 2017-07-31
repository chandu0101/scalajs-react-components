package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiSlider(
    key: js.UndefOr[String] = js.undefined,
    ref: js.UndefOr[MuiSliderM => Unit] = js.undefined,
    /* The axis on which the slider will slide. */
    axis: js.UndefOr[XX_reverseYY_reverse] = js.undefined,
    /* The default value of the slider. */
    defaultValue: js.UndefOr[Double] = js.undefined,
    /* Describe the slider. */
    @deprecated("Use a sibling node element instead. It will be removed with v0.17.0.")
    description: js.UndefOr[ReactNode] = js.undefined,
    /* Disables focus ripple if set to true. */
    disableFocusRipple: js.UndefOr[Boolean] = js.undefined,
    /* If true, the slider will not be interactable. */
    disabled: js.UndefOr[Boolean] = js.undefined,
    /* An error message for the slider. */
    @deprecated("Use a sibling node element instead. It will be removed with v0.17.0.")
    error: js.UndefOr[ReactNode] = js.undefined,
    /* The maximum value the slider can slide to on
     a scale from 0 to 1 inclusive. Cannot be equal to min. */
    max: js.UndefOr[Double] = js.undefined,
    /* The minimum value the slider can slide to on a scale
     from 0 to 1 inclusive. Cannot be equal to max. */
    min: js.UndefOr[Double] = js.undefined,
    /* The name of the slider. Behaves like the name attribute
     of an input element. */
    name: js.UndefOr[String] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
    /* Callback function that is fired when the slider's value changed.
     @param {object} event KeyDown event targeting the slider.
     @param {number} newValue The new value of the slider. */
    onChange: js.UndefOr[(ReactMouseEvent, Double) => Callback] = js.undefined,
    /* Callback function that is fired when the slider has begun to move.
     @param {object} event MouseDown or TouchStart event targeting the slider. */
    onDragStart: js.UndefOr[ReactDragEvent => Callback] = js.undefined,
    /* Callback function that is fired when the slide has stopped moving.
     @param {object} event MouseEnd or TouchEnd event targeting the slider. */
    onDragStop: js.UndefOr[ReactDragEvent => Callback] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
    /* Whether or not the slider is required in a form. */
    required: js.UndefOr[Boolean] = js.undefined,
    /* Override the inline-styles of the inner slider element. */
    sliderStyle: js.UndefOr[CssProperties] = js.undefined,
    /* The granularity the slider can step through values. */
    step: js.UndefOr[Double] = js.undefined,
    /* Override the inline-styles of the root element. */
    style: js.UndefOr[CssProperties] = js.undefined,
    /* The value of the slider. */
    value: js.UndefOr[Double] = js.undefined) {

  def apply() = {

    val props = JSMacro[MuiSlider](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Mui.Slider)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
@js.native
class MuiSliderM extends js.Object {
  def clearValue(): js.Dynamic = js.native

  def getTrackOffset(): js.Dynamic = js.native

  def getValue(): js.Dynamic = js.native

  def onDragStart(event: js.Any): js.Dynamic = js.native

  def onDragStop(event: js.Any): js.Dynamic = js.native

  def onDragUpdate(event: js.Any, `type`: js.Any): js.Dynamic = js.native

  def setValueFromPosition(event: js.Any, position: js.Any): js.Dynamic =
    js.native
}

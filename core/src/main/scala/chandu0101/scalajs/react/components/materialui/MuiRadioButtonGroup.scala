package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiRadioButtonGroup(
  key:             js.UndefOr[String]                             = js.undefined,
  ref:             js.UndefOr[MuiRadioButtonGroupM => Unit]       = js.undefined,
  /* The CSS class name of the root element.*/
  className:       js.UndefOr[String]                             = js.undefined,
  /* The `value` property (case-sensitive) of the radio button that will be
  selected by default. This takes precedence over the `checked` property
  of the `RadioButton` elements.*/
  defaultSelected: js.UndefOr[String]                             = js.undefined,
  /* Where the label will be placed for all child radio buttons.
  This takes precedence over the `labelPosition` property of the
  `RadioButton` elements.*/
  labelPosition:   js.UndefOr[LeftRight]                          = js.undefined,
  /* The name that will be applied to all child radio buttons.*/
  name:            String,
  /* Callback function that is fired when a radio button has
  been checked.
  radio button.*/
  onChange:        js.UndefOr[(ReactEventI, String) => Callback]  = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:           js.UndefOr[CssProperties]                      = js.undefined,
  /* The `value` of the currently selected radio button.*/
  valueSelected:   js.UndefOr[String]                             = js.undefined,
  /* checked if true
  Used internally by `RadioButtonGroup`.
  (Passed on to RadioButton)*/
  @deprecated("Internal API")
  checked:         js.UndefOr[Boolean]                            = js.undefined,
  /* The icon element to show when the radio button is checked.
  (Passed on to RadioButton)*/
  checkedIcon:     js.UndefOr[ReactElement]                       = js.undefined,
  /* If true, the radio button is disabled.
  (Passed on to RadioButton)*/
  disabled:        js.UndefOr[Boolean]                            = js.undefined,
  /* Override the inline-styles of the icon element.
  (Passed on to RadioButton)*/
  iconStyle:       js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the input element.
  (Passed on to RadioButton)*/
  inputStyle:      js.UndefOr[CssProperties]                      = js.undefined,
  /* Override the inline-styles of the label element.
  (Passed on to RadioButton)*/
  labelStyle:      js.UndefOr[CssProperties]                      = js.undefined,
  /* Callback function fired when the radio button is checked. Note that this
  function will not be called if the radio button is part of a
  radio button group: in this case, use the `onChange` property of
  `RadioButtonGroup`.
  (Passed on to RadioButton)*/
  @deprecated("Internal API")
  onCheck:         js.UndefOr[(ReactEventH, Boolean) => Callback] = js.undefined,
  /* The icon element to show when the radio button is unchecked.
  (Passed on to RadioButton)*/
  uncheckedIcon:   js.UndefOr[ReactElement]                       = js.undefined,
  /* The value of the radio button.
  (Passed on to RadioButton)*/
  value:           js.UndefOr[String]                             = js.undefined){
  /**
   * @param children Should be used to pass `RadioButton` components.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiRadioButtonGroup](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RadioButtonGroup)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiRadioButtonGroupM extends js.Object {
  def clearValue(): Unit = js.native

  def getSelectedValue(): String = js.native

  def hasCheckAttribute(radioButton: js.Any): js.Any = js.native

  def setSelectedValue(newSelectionValue: String): Unit = js.native

  def updateRadioButtons(newSelection: js.Any): js.Any = js.native
}

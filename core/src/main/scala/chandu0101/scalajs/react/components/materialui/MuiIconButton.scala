package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiIconButton(
  key:             js.UndefOr[String]                          = js.undefined,
  ref:             js.UndefOr[String]                          = js.undefined,
  /* The css class name of the root element.*/
  className:       js.UndefOr[String]                          = js.undefined,
  disabled:        js.UndefOr[Boolean]                         = js.undefined,
  /* If you are using a stylesheet for your icons, enter the class name for the icon to be used here.*/
  iconClassName:   js.UndefOr[String]                          = js.undefined,
  /* Overrides the inline-styles of the icon element.*/
  iconStyle:       js.UndefOr[CssProperties]                   = js.undefined,
  /* IconButton.onBlur(e): Callback function for when the component loses focus.*/
  onBlur:          js.UndefOr[ReactEventH => Callback]         = js.undefined,
  /* IconButton.onFocus(e): Callback function for when the component gains focus.*/
  onFocus:         js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  onKeyboardFocus: js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  onMouseEnter:    js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onMouseLeave:    js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:           js.UndefOr[CssProperties]                   = js.undefined,
  /* The tooltip text to show.*/
  tooltip:         js.UndefOr[ReactNode]                       = js.undefined,
  /* default: bottom-center: Allows the tooltip to be viewed with different alignments:
"bottom-center", "top-center", "bottom-right", "top-right", "bottom-left" and "top-left"*/
  tooltipPosition: js.UndefOr[CornersAndCenter]                = js.undefined,
  /* Allows modification of tooltip styles.*/
  tooltipStyles:   js.UndefOr[CssProperties]                   = js.undefined,
  /* default: false: If true, this component will render the touch sized tooltip.*/
  touch:           js.UndefOr[Boolean]                         = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiIconButton](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.IconButton)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

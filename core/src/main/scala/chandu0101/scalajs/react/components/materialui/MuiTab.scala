package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiTab(
  key:        js.UndefOr[String]                       = js.undefined,
  ref:        js.UndefOr[String]                       = js.undefined,
  /* The css class name of the root element.*/
  className:  js.UndefOr[String]                       = js.undefined,
  /* Sets the text value of the tab item to the string specified.*/
  label:      js.UndefOr[ReactNode]                    = js.undefined,
  /* Fired when the active tab changes by touch or tap.
Use this event to specify any functionality when an active tab changes.
For example - we are using this to route to home when the third tab becomes active.
This function will always recieve the active tab as it\'s first argument.*/
  onActive:   js.UndefOr[ReactElement => Callback]     = js.undefined,
  /* This property is overriden by the Tabs component.*/
  onTouchTap: js.UndefOr[ReactTouchEventH => Callback] = js.undefined,
  /* Defines if the current tab is selected or not.
The Tabs component is responsible for setting this property.*/
  selected:   js.UndefOr[Boolean]                      = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:      js.UndefOr[CssProperties]                = js.undefined,
  /* If value prop passed to Tabs component, this value prop is also required.
It assigns a value to the tab so that it can be selected by the Tabs.*/
  value:      js.UndefOr[js.Any]                       = js.undefined,
  /* This property is overriden by the Tabs component.*/
  width:      js.UndefOr[String]                       = js.undefined){

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiTab](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tab)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

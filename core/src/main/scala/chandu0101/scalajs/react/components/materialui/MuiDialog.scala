package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiDialog(
  key:                       js.UndefOr[String]              = js.undefined,
  ref:                       js.UndefOr[String]              = js.undefined,
  /* Action buttons to display below the Dialog content (`children`).
     This property accepts either a React element, or an array of React elements. */
  actions:                   js.UndefOr[VdomNode]           = js.undefined,
  /* The `className` to add to the actions container's root element. */
  actionsContainerClassName: js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the actions container's root element. */
  actionsContainerStyle:     js.UndefOr[CssProperties]       = js.undefined,
  /* If set to true, the height of the `Dialog` will be auto detected. A max height
     will be enforced so that the content does not extend beyond the viewport. */
  autoDetectWindowHeight:    js.UndefOr[Boolean]             = js.undefined,
  /* If set to true, the body content of the `Dialog` will be scrollable. */
  autoScrollBodyContent:     js.UndefOr[Boolean]             = js.undefined,
  /* The `className` to add to the content's root element under the title. */
  bodyClassName:             js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the content's root element under the title. */
  bodyStyle:                 js.UndefOr[CssProperties]       = js.undefined,
  /* The css class name of the root element. */
  className:                 js.UndefOr[String]              = js.undefined,
  /* The `className` to add to the content container. */
  contentClassName:          js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the content container. */
  contentStyle:              js.UndefOr[CssProperties]       = js.undefined,
  /* Force the user to use one of the actions in the `Dialog`.
     Clicking outside the `Dialog` will not trigger the `onRequestClose`. */
  modal:                     js.UndefOr[Boolean]             = js.undefined,
  /* Fired when the `Dialog` is requested to be closed by a click outside the `Dialog` or on the buttons.
     @param {bool} buttonClicked Determines whether a button click triggered this request. */
  onRequestClose:            js.UndefOr[Boolean => Callback] = js.undefined,
  /* Controls whether the Dialog is opened or not. */
  open:                      Boolean,
  /* The `className` to add to the `Overlay` component that is rendered behind the `Dialog`. */
  overlayClassName:          js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the `Overlay` component that is rendered behind the `Dialog`. */
  overlayStyle:              js.UndefOr[CssProperties]       = js.undefined,
  /* Determines whether the `Dialog` should be repositioned when it's contents are updated. */
  repositionOnUpdate:        js.UndefOr[Boolean]             = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                     js.UndefOr[CssProperties]       = js.undefined,
  /* The title to display on the `Dialog`. Could be number, string, element or an array containing these types. */
  title:                     js.UndefOr[VdomNode]           = js.undefined,
  /* The `className` to add to the title's root container element. */
  titleClassName:            js.UndefOr[String]              = js.undefined,
  /* Overrides the inline-styles of the title's root container element. */
  titleStyle:                js.UndefOr[CssProperties]       = js.undefined){

  /**
    * @param children The contents of the `Dialog`.
   */
  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiDialog](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Dialog)
    component(props)(children: _*)
  }
}

package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiPopover(
  key:                    js.UndefOr[String]        = js.undefined,
  ref:                    js.UndefOr[String]        = js.undefined,
  anchorEl:               js.UndefOr[js.Any]        = js.undefined,
  /* This is the point on the anchor where the popover targetOrigin will stick to.
Options:
vertical: [top, middle, bottom]
horizontal: [left, center, right]*/
  anchorOrigin:           js.UndefOr[Origin]        = js.undefined,
  /* default: false: If true, the popover will apply transitions when added it gets added to the DOM.*/
  animated:               js.UndefOr[Boolean]       = js.undefined,
  animation:              js.UndefOr[js.Any]        = js.undefined,
  /* default: true: If true, the popover will hide when the anchor scrolls off the screen*/
  autoCloseWhenOffScreen: js.UndefOr[Boolean]       = js.undefined,
  /* default: true: If true, the popover (potentially) ignores targetOrigin and anchorOrigin to make itself fit on screen,which is useful for mobile devices.*/
  canAutoPosition:        js.UndefOr[Boolean]       = js.undefined,
  /* The css class name of the root element.*/
  className:              js.UndefOr[String]        = js.undefined,
  /* default: no-op: This is a callback that fires when the popover thinks it should close. (e.g. clickAway or offScreen)*/
  onRequestClose:         js.UndefOr[Callback]      = js.undefined,
  /* default: false: Controls the visibility of the popover.*/
  open:                   js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                  js.UndefOr[CssProperties] = js.undefined,
  /* This is the point on the popover which will stick to the anchors origin.Options:vertical: [top, middle, bottom]horizontal: [left, center, right]*/
  targetOrigin:           js.UndefOr[Origin]        = js.undefined,
  /* default: false: If true, the popover will render on top of an invisible layer, which will prevent clicks to the underlying elements, and trigger an onRequestClose(clickAway) event.*/
  useLayerForClickAway:   js.UndefOr[Boolean]       = js.undefined,
  /* default: 1: This number represents the zDepth of the paper shadow.*/
  zDepth:                 js.UndefOr[ZDepth]        = js.undefined){

  def apply(children: js.UndefOr[ReactNode] = js.undefined) = {
    val props = JSMacro[MuiPopover](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Popover)
    f(props, children).asInstanceOf[ReactComponentU_]
  }
}

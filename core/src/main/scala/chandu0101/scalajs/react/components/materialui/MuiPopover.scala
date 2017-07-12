package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiPopover(key: js.UndefOr[String] = js.undefined,
                      ref: js.UndefOr[MuiPopoverM => Unit] = js.undefined,
                      /* This is the DOM element that will be used to set the position of the
     popover. */
                      anchorEl: js.UndefOr[js.Any] = js.undefined,
                      /* This is the point on the anchor where the popover's
     `targetOrigin` will attach to.
     Options:
     vertical: [top, center, bottom]
     horizontal: [left, middle, right]. */
                      anchorOrigin: js.UndefOr[Origin] = js.undefined,
                      /* If true, the popover will apply transitions when
     it is added to the DOM. */
                      animated: js.UndefOr[Boolean] = js.undefined,
                      /* Override the default animation component used. */
                      animation: js.UndefOr[js.Function] = js.undefined,
                      /* If true, the popover will hide when the anchor is scrolled off the screen. */
                      autoCloseWhenOffScreen: js.UndefOr[Boolean] = js.undefined,
                      /* If true, the popover (potentially) ignores `targetOrigin`
     and `anchorOrigin` to make itself fit on screen,
     which is useful for mobile devices. */
                      canAutoPosition: js.UndefOr[Boolean] = js.undefined,
                      /* The CSS class name of the root element. */
                      className: js.UndefOr[String] = js.undefined,
                      /* Callback function fired when the popover is requested to be closed.
     @param {string} reason The reason for the close request. Possibles values
     are 'clickAway' and 'offScreen'. */
                      onRequestClose: js.UndefOr[String => Callback] = js.undefined,
                      /* If true, the popover is visible. */
                      open: js.UndefOr[Boolean] = js.undefined,
                      /* Override the inline-styles of the root element. */
                      style: js.UndefOr[CssProperties] = js.undefined,
                      /* This is the point on the popover which will attach to
     the anchor's origin.
     Options:
     vertical: [top, center, bottom]
     horizontal: [left, middle, right]. */
                      targetOrigin: js.UndefOr[Origin] = js.undefined,
                      /* If true, the popover will render on top of an invisible
     layer, which will prevent clicks to the underlying
     elements, and trigger an `onRequestClose('clickAway')` call. */
                      useLayerForClickAway: js.UndefOr[Boolean] = js.undefined,
                      /* The zDepth of the popover. */
                      zDepth: js.UndefOr[ZDepth] = js.undefined) {

  /**
    * @param children The content of the popover.
    */
  def apply(children: VdomNode*) = {

    val props     = JSMacro[MuiPopover](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Popover)
    component(props)(children: _*)
  }
}
@js.native
class MuiPopoverM extends js.Object {
  def applyAutoPositionIfNeeded(anchor: js.Any,
                                target: js.Any,
                                targetOrigin: js.Any,
                                anchorOrigin: js.Any,
                                targetPosition: js.Any): js.Dynamic = js.native

  def autoCloseWhenOffScreen(anchorPosition: js.Any): js.Dynamic = js.native

  def getAnchorPosition(el: js.Any): js.Dynamic = js.native

  def getOverlapMode(anchor: js.Any, target: js.Any, median: js.Any): js.Dynamic = js.native

  def getPositions(anchor: js.Any, target: js.Any): js.Dynamic = js.native

  def getTargetPosition(targetEl: js.Any): js.Dynamic = js.native

  def requestClose(reason: js.Any): js.Dynamic = js.native
}

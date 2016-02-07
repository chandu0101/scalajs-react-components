package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiLeftNav(
  key:                js.UndefOr[String]                        = js.undefined,
  ref:                js.UndefOr[String]                        = js.undefined,
  /* The css class name of the root element.*/
  className:          js.UndefOr[String]                        = js.undefined,
  /* The css class name of the container element.*/
  containerClassName: js.UndefOr[String]                        = js.undefined,
  /* Override the inline-styles of the container element.*/
  containerStyle:     js.UndefOr[CssProperties]                 = js.undefined,
  /* Indicates whether swiping sideways when the `LeftNav` is closed should open it.*/
  disableSwipeToOpen: js.UndefOr[Boolean]                       = js.undefined,
  /* Indicates that the `LeftNav` should be docked. In this state, the overlay won't
  show and clicking on a menu item will not close the `LeftNav`.*/
  docked:             js.UndefOr[Boolean]                       = js.undefined,
  /* Callback function that is fired when the open state of the `LeftNav` is
  requested to be changed. The provided open argument determines whether
  the `LeftNav` is requested to be opened or closed. Also, the reason
  argument states why the `LeftNav` got closed or opend. It can be either
  `'clickaway'` for overlay clicks, `'escape'` for pressing the
  escape key and `'swipe'` for swiping. For opening the reason is always `'swipe'`.*/
  onRequestChange:    js.UndefOr[(Boolean, String) => Callback] = js.undefined,
  /* Indicates that the `LeftNav` should be opened, closed or uncontrolled.
  Providing a boolean will turn the `LeftNav` into a controlled component.*/
  open:               js.UndefOr[Boolean]                       = js.undefined,
  /* Positions the `LeftNav` to open from the right side.*/
  openRight:          js.UndefOr[Boolean]                       = js.undefined,
  /* The `className` to add to the `Overlay` component that is rendered behind the `LeftNav`.*/
  overlayClassName:   js.UndefOr[String]                        = js.undefined,
  /* Overrides the inline-styles of the `Overlay` component that is rendered behind the `LeftNav`.*/
  overlayStyle:       js.UndefOr[CssProperties]                 = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:              js.UndefOr[CssProperties]                 = js.undefined,
  /* The width of the left most (or right most) area in pixels where the `LeftNav` can be
  swiped open from. Setting this to `null` spans that area to the entire page
  (**CAUTION!** Setting this property to `null` might cause issues with sliders and
  swipeable `Tabs`, use at your own risk).*/
  swipeAreaWidth:     js.UndefOr[Double]                        = js.undefined,
  /* The width of the `LeftNav` in pixels. Defaults to using the values from theme.*/
  width:              js.UndefOr[Double]                        = js.undefined,
  /* This number represents the zDepth of the menu.*/
  zDepth:             js.UndefOr[ZDepth]                        = js.undefined){
  /**
   * @param children The contents of the `LeftNav`
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiLeftNav](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.LeftNav)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

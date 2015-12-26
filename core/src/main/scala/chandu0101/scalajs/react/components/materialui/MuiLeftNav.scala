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
  key:                        js.UndefOr[String]                                 = js.undefined,
  ref:                        js.UndefOr[MuiLeftNavM => Unit]                    = js.undefined,
  /* The css class name of the root element.*/
  className:                  js.UndefOr[String]                                 = js.undefined,
  /* Indicates whether swiping sideways when the `LeftNav` is closed should open it.*/
  disableSwipeToOpen:         js.UndefOr[Boolean]                                = js.undefined,
  /* Indicates that the `LeftNav` should be docked. In this state, the overlay won't
show and clicking on a menu item will not close the `LeftNav`.*/
  docked:                     js.UndefOr[Boolean]                                = js.undefined,
  /* A react component that will be displayed above all the menu items.
Usually, this is used for a logo or a profile image.*/
  @deprecated("Instead, use composability.")
  header:                     js.UndefOr[ReactElement]                           = js.undefined,
  /* Class name for the menuItem.*/
  @deprecated("It will be removed with menuItems.")
  menuItemClassName:          js.UndefOr[String]                                 = js.undefined,
  /* Class name for the link menuItem.*/
  @deprecated("It will be removed with menuItems.")
  menuItemClassNameLink:      js.UndefOr[String]                                 = js.undefined,
  /* Class name for the subheader menuItem.*/
  @deprecated("It will be removed with menuItems.")
  menuItemClassNameSubheader: js.UndefOr[String]                                 = js.undefined,
  /* JSON data representing all menu items to render.*/
  @deprecated("Instead, use composability.")
  menuItems:                  js.UndefOr[js.Array[MuiMenuItemJson]]              = js.undefined,
  /* Fired when a menu item is clicked that is not the
one currently selected. Note that this requires the `injectTapEventPlugin`
component. See the "Get Started" section for more detail.*/
  @deprecated("It will be removed with menuItems.")
  onChange:                   js.UndefOr[(ReactEventH, Int, js.Any) => Callback] = js.undefined,
  /* Fired when the component is opened.*/
  @deprecated("Instead, use onRequestChange.")
  onNavClose:                 js.UndefOr[Callback]                               = js.undefined,
  /* Fired when the component is closed.*/
  @deprecated("Instead, use onRequestChange.")
  onNavOpen:                  js.UndefOr[Callback]                               = js.undefined,
  /* Callback function that is fired when the open state of the `LeftNav` is
requested to be changed. The provided open argument determines whether
the `LeftNav` is requested to be opened or closed. Also, the reason
argument states why the `LeftNav` got closed or opend. It can be either
`'clickaway'` for menuItem and overlay clicks, `'escape'` for pressing the
escape key and 'swipe' for swiping. For opening the reason is always `'swipe'`.*/
  onRequestChange:            js.UndefOr[(Boolean, String) => Callback]          = js.undefined,
  /* Indicates that the `LeftNav` should be opened, closed or uncontrolled.
Providing a boolean will turn the `LeftNav` into a controlled component.*/
  open:                       js.UndefOr[Boolean]                                = js.undefined,
  /* Positions the `LeftNav` to open from the right side.*/
  openRight:                  js.UndefOr[Boolean]                                = js.undefined,
  /* The `className` to add to the `Overlay` component that is rendered behind the `LeftNav`.*/
  overlayClassName:           js.UndefOr[String]                                 = js.undefined,
  /* Overrides the inline-styles of the `Overlay` component that is rendered behind the `LeftNav`.*/
  overlayStyle:               js.UndefOr[CssProperties]                          = js.undefined,
  /* Indicates the particular item in the menuItems array that is currently selected.*/
  @deprecated("It will be removed with menuItems.")
  selectedIndex:              js.UndefOr[Int]                                    = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                      js.UndefOr[CssProperties]                          = js.undefined,
  /* The width of the left most (or right most) area in pixels where the `LeftNav` can be
swiped open from. Setting this to `null` spans that area to the entire page
(**CAUTION!** Setting this property to `null` might cause issues with sliders and
swipeable `Tabs`, use at your own risk).*/
  swipeAreaWidth:             js.UndefOr[Double]                                 = js.undefined,
  /* The width of the `LeftNav` in pixels. Defaults to using the values from theme.*/
  width:                      js.UndefOr[Double]                                 = js.undefined){
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


@js.native
class MuiLeftNavM extends js.Object {
  /* Opens the component. Using this method is deprecated, use the open property and handle onChangeRequest to control the left nav.*/
  @deprecated
  def open(): Unit = js.native

  /* Closes the component, hiding it from view. Using this method is deprecated, use the open property and handle onChangeRequest to control the left nav.*/
  @deprecated
  def close(): Unit = js.native

  /* Toggles between the open and closed states. Using this method is deprecated, use the open property and handle onChangeRequest to control the left nav.*/
  @deprecated
  def toggle(): Unit = js.native
}

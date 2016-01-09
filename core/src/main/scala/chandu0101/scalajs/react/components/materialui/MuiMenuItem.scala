package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiMenuItem(
  key:                         js.UndefOr[String]                          = js.undefined,
  ref:                         js.UndefOr[String]                          = js.undefined,
  /* If true, a left check mark will be rendered.*/
  checked:                     js.UndefOr[Boolean]                         = js.undefined,
  /* Indicates if the menu should render with compact desktop styles.*/
  desktop:                     js.UndefOr[Boolean]                         = js.undefined,
  /* Disables a menu item.*/
  disabled:                    js.UndefOr[Boolean]                         = js.undefined,
  /* Prop passed down to ListItem that tells it what kind of focus it has.*/
  focusState:                  js.UndefOr[NoneFocusedKeyboard_focused]     = js.undefined,
  /* Style overrides for the inner div.*/
  innerDivStyle:               js.UndefOr[CssProperties]                   = js.undefined,
  /* If true, the children will be indented.
Only needed when there is no leftIcon.*/
  insetChildren:               js.UndefOr[Boolean]                         = js.undefined,
  /* This is the SvgIcon or FontIcon to be displayed on the left side.*/
  leftIcon:                    js.UndefOr[ReactElement]                    = js.undefined,
  /* Nested MenuItems for this MenuItem. Used to make nested menus.*/
  menuItems:                   js.UndefOr[ReactNode]                       = js.undefined,
  /* Fired when the element is touchTapped.*/
  onTouchTap:                  js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* This is the SvgIcon or FontIcon to be displayed on the right side.*/
  rightIcon:                   js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the block element that contains the secondary text.
If a string is passed in, a div tag will be rendered.*/
  secondaryText:               js.UndefOr[ReactNode]                       = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                       js.UndefOr[CssProperties]                   = js.undefined,
  /* The value of the menu item.*/
  value:                       js.UndefOr[js.Any]                          = js.undefined,
  /* Generate a nested list indicator icon when
nested list items are detected. Set to false
if you do not want an indicator auto-generated.
Note that an indicator will not be created if a
rightIcon/Button has been specified.
  (Passed on to ListItem)*/
  autoGenerateNestedIndicator: js.UndefOr[Boolean]                         = js.undefined,
  /* Does not allow the element to be focused by the keyboard.
  (Passed on to ListItem)*/
  disableKeyboardFocus:        js.UndefOr[Boolean]                         = js.undefined,
  /* Controls whether or not the child ListItems are initially displayed.
  (Passed on to ListItem)*/
  initiallyOpen:               js.UndefOr[Boolean]                         = js.undefined,
  /* This is the Avatar element to be displayed on the left side.
  (Passed on to ListItem)*/
  leftAvatar:                  js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the Checkbox element to be displayed on the left side.
  (Passed on to ListItem)*/
  leftCheckbox:                js.UndefOr[ReactElement]                    = js.undefined,
  /* An array of ListItems to nest underneath the current ListItem.
  (Passed on to ListItem)*/
  nestedItems:                 js.UndefOr[js.Array[ReactElement]]          = js.undefined,
  /* Controls how deep a ListItem appears.
This property is automatically managed so modify at your own risk.
  (Passed on to ListItem)*/
  nestedLevel:                 js.UndefOr[Int]                             = js.undefined,
  /* Called when the ListItem has keyboard focus.
  (Passed on to ListItem)*/
  onKeyboardFocus:             js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* Called when the mouse is over the ListItem.
  (Passed on to ListItem)*/
  onMouseEnter:                js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Called when the mouse is no longer over the ListItem.
  (Passed on to ListItem)*/
  onMouseLeave:                js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Called when the ListItem toggles its nested ListItems.
  (Passed on to ListItem)*/
  onNestedListToggle:          js.UndefOr[js.Any => Callback]              = js.undefined,
  /* Called when touches start.
  (Passed on to ListItem)*/
  onTouchStart:                js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* This is the block element that contains the primary text.
If a string is passed in, a div tag will be rendered.
  (Passed on to ListItem)*/
  primaryText:                 js.UndefOr[ReactNode]                       = js.undefined,
  /* If provided, tapping on the primary text
of the item toggles the nested list.
  (Passed on to ListItem)*/
  primaryTogglesNestedList:    js.UndefOr[Boolean]                         = js.undefined,
  /* This is the avatar element to be displayed on the right side.
  (Passed on to ListItem)*/
  rightAvatar:                 js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the IconButton to be displayed on the right side.
Hovering over this button will remove the ListItem hover.
Also, clicking on this button will not trigger a
ListItem ripple. The event will be stopped and prevented
from bubbling up to cause a ListItem click.
  (Passed on to ListItem)*/
  rightIconButton:             js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the Toggle element to display on the right side.
  (Passed on to ListItem)*/
  rightToggle:                 js.UndefOr[ReactElement]                    = js.undefined,
  /* Can be 1 or 2. This is the number of secondary
text lines before ellipsis will show.
  (Passed on to ListItem)*/
  secondaryTextLines:          js.UndefOr[_1_2]                            = js.undefined){
  /**
   * @param children Elements passed as children to inner ListItem.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiMenuItem](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.MenuItem)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

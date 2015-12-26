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
  /* default: false: If true, a left check mark will be rendered*/
  checked:                     js.UndefOr[Boolean]                         = js.undefined,
  /* default: false: Indicates if the menu should render with compact desktop styles.*/
  desktop:                     js.UndefOr[Boolean]                         = js.undefined,
  /* default: false: Disables a menu item.*/
  disabled:                    js.UndefOr[Boolean]                         = js.undefined,
  focusState:                  js.UndefOr[NoneFocusedKeyboard_focused]     = js.undefined,
  /* Style overrides for the inner div.*/
  innerDivStyle:               js.UndefOr[CssProperties]                   = js.undefined,
  /* default: false: If true, the children will be indented. Only needed when there is no leftIcon.*/
  insetChildren:               js.UndefOr[Boolean]                         = js.undefined,
  /* This is the SvgIcon or FontIcon to be displayed on the left side.*/
  leftIcon:                    js.UndefOr[ReactElement]                    = js.undefined,
  menuItems:                   js.UndefOr[ReactNode]                       = js.undefined,
  /* function(event, item): Fired when a menu item is touchTapped.*/
  onTouchTap:                  js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* This is the SvgIcon or FontIcon to be displayed on the right side.*/
  rightIcon:                   js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the block element that contains the secondary text. If a string is passed in, a div tag will be rendered.*/
  secondaryText:               js.UndefOr[ReactNode]                       = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                       js.UndefOr[CssProperties]                   = js.undefined,
  /* The value of the menu item.*/
  value:                       js.UndefOr[js.Any]                          = js.undefined,
  /* (Passed on to ListItem)*/
  autoGenerateNestedIndicator: js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to ListItem)*/
  disableKeyboardFocus:        js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to ListItem)*/
  initiallyOpen:               js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to ListItem)*/
  innerStyle:                  js.UndefOr[CssProperties]                   = js.undefined,
  /* (Passed on to ListItem)*/
  leftAvatar:                  js.UndefOr[ReactElement]                    = js.undefined,
  /* (Passed on to ListItem)*/
  leftCheckbox:                js.UndefOr[ReactElement]                    = js.undefined,
  /* (Passed on to ListItem)*/
  nestedItems:                 js.UndefOr[js.Array[ReactElement]]          = js.undefined,
  /* (Passed on to ListItem)*/
  nestedLevel:                 js.UndefOr[Int]                             = js.undefined,
  /* (Passed on to ListItem)*/
  onKeyboardFocus:             js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to ListItem)*/
  onMouseEnter:                js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* (Passed on to ListItem)*/
  onMouseLeave:                js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* (Passed on to ListItem)*/
  onNestedListToggle:          js.UndefOr[js.Any => Callback]              = js.undefined,
  /* (Passed on to ListItem)*/
  onTouchStart:                js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* This is the block element that contains the primary text. If a string is passed in, a div tag will be rendered.
  (Passed on to ListItem)*/
  primaryText:                 js.UndefOr[ReactNode]                       = js.undefined,
  /* (Passed on to ListItem)*/
  primaryTogglesNestedList:    js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to ListItem)*/
  rightAvatar:                 js.UndefOr[ReactElement]                    = js.undefined,
  /* (Passed on to ListItem)*/
  rightIconButton:             js.UndefOr[ReactElement]                    = js.undefined,
  /* (Passed on to ListItem)*/
  rightToggle:                 js.UndefOr[ReactElement]                    = js.undefined,
  /* (Passed on to ListItem)*/
  secondaryTextLines:          js.UndefOr[_1_2]                            = js.undefined){

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

package chandu0101.scalajs.react.components
package materialui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
/**
 * This file is generated - submit issues instead of PR against it
 */
case class MuiListItem(
  key:                         js.UndefOr[String]                          = js.undefined,
  ref:                         js.UndefOr[MuiListItemM => Unit]            = js.undefined,
  /* If true, generate a nested-list-indicator icon when nested list
  items are detected. Note that an indicator will not be created
  if a `rightIcon` or `rightIconButton` has been provided to
  the element.*/
  autoGenerateNestedIndicator: js.UndefOr[Boolean]                         = js.undefined,
  /* If true, the element will not be able to be focused by the keyboard.*/
  disableKeyboardFocus:        js.UndefOr[Boolean]                         = js.undefined,
  /* If true, the element will not be clickable
  and will not display hover effects.
  This is automatically disabled if either `leftCheckbox`
  or `rightToggle` is set.*/
  disabled:                    js.UndefOr[Boolean]                         = js.undefined,
  /* If true, the nested `ListItem`s are initially displayed.*/
  initiallyOpen:               js.UndefOr[Boolean]                         = js.undefined,
  /* Override the inline-styles of the inner div element.*/
  innerDivStyle:               js.UndefOr[CssProperties]                   = js.undefined,
  /* If true, the children will be indented by 72px.
  This is useful if there is no left avatar or left icon.*/
  insetChildren:               js.UndefOr[Boolean]                         = js.undefined,
  /* This is the `Avatar` element to be displayed on the left side.*/
  leftAvatar:                  js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the `Checkbox` element to be displayed on the left side.*/
  leftCheckbox:                js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the `SvgIcon` or `FontIcon` to be displayed on the left side.*/
  leftIcon:                    js.UndefOr[ReactElement]                    = js.undefined,
  /* An array of `ListItem`s to nest underneath the current `ListItem`.*/
  nestedItems:                 js.UndefOr[js.Array[ReactElement]]          = js.undefined,
  /* Controls how deep a `ListItem` appears.
  This property is automatically managed, so modify at your own risk.*/
  nestedLevel:                 js.UndefOr[Int]                             = js.undefined,
  /* Override the inline-styles of the nested items' `NestedList`.*/
  nestedListStyle:             js.UndefOr[CssProperties]                   = js.undefined,
  /* Callback function fired when the `ListItem` is focused or blurred by the keyboard.*/
  onKeyboardFocus:             js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  onMouseEnter:                js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  onMouseLeave:                js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* Callbak function fired when the `ListItem` toggles its nested list.*/
  onNestedListToggle:          js.UndefOr[js.Any => Callback]              = js.undefined,
  onTouchStart:                js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  onTouchTap:                  js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* This is the block element that contains the primary text.
  If a string is passed in, a div tag will be rendered.*/
  primaryText:                 js.UndefOr[ReactNode]                       = js.undefined,
  /* If true, clicking or tapping the primary text of the `ListItem`
  toggles the nested list.*/
  primaryTogglesNestedList:    js.UndefOr[Boolean]                         = js.undefined,
  /* This is the `Avatar` element to be displayed on the right side.*/
  rightAvatar:                 js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the `SvgIcon` or `FontIcon` to be displayed on the right side.*/
  rightIcon:                   js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the `IconButton` to be displayed on the right side.
  Hovering over this button will remove the `ListItem` hover.
  Also, clicking on this button will not trigger a
  ripple on the `ListItem`; the event will be stopped and prevented
  from bubbling up to cause a `ListItem` click.*/
  rightIconButton:             js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the `Toggle` element to display on the right side.*/
  rightToggle:                 js.UndefOr[ReactElement]                    = js.undefined,
  /* This is the block element that contains the secondary text.
  If a string is passed in, a div tag will be rendered.*/
  secondaryText:               js.UndefOr[ReactNode]                       = js.undefined,
  /* Can be 1 or 2. This is the number of secondary
  text lines before ellipsis will show.*/
  secondaryTextLines:          js.UndefOr[_1_2]                            = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:                       js.UndefOr[CssProperties]                   = js.undefined,
  /* (Passed on to EnhancedButton)*/
  centerRipple:                js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  containerElement:            js.UndefOr[String | ReactElement]           = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableFocusRipple:          js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  disableTouchRipple:          js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleColor:            js.UndefOr[MuiColor]                        = js.undefined,
  /* (Passed on to EnhancedButton)*/
  focusRippleOpacity:          js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  href:                        js.UndefOr[String]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  keyboardFocused:             js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  @deprecated("LinkButton is no longer required when the `href` property is provided.\n      It will be removed with v0.16.0.")
  linkButton:                  js.UndefOr[Boolean]                         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onBlur:                      js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onClick:                     js.UndefOr[ReactEventH => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onFocus:                     js.UndefOr[ReactFocusEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyDown:                   js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onKeyUp:                     js.UndefOr[ReactKeyboardEventH => Callback] = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onMouseDown:                 js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onMouseUp:                   js.UndefOr[ReactMouseEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  onTouchEnd:                  js.UndefOr[ReactTouchEventH => Callback]    = js.undefined,
  /* (Passed on to EnhancedButton)*/
  tabIndex:                    js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleColor:            js.UndefOr[MuiColor]                        = js.undefined,
  /* (Passed on to EnhancedButton)*/
  touchRippleOpacity:          js.UndefOr[Double]                          = js.undefined,
  /* (Passed on to EnhancedButton)*/
  `type`:                      js.UndefOr[String]                          = js.undefined){
  /**
   * @param children Children passed into the `ListItem`.
   */
  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiListItem](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListItem)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


@js.native
class MuiListItemM extends js.Object {
  def applyFocusState(focusState: js.Any): js.Any = js.native

  def createDisabledElement(styles: js.Any, contentChildren: js.Any, additionalProps: js.Any): js.Any = js.native

  def createLabelElement(styles: js.Any, contentChildren: js.Any, additionalProps: js.Any): js.Any = js.native

  def createTextElement(styles: js.Any, data: js.Any, key: js.Any): js.Any = js.native

  def pushElement(children: js.Any, element: js.Any, baseStyles: js.Any, additionalProps: js.Any): js.Any = js.native
}

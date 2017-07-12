package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiListItem(
  key:                         js.UndefOr[String]                                 = js.undefined,
  ref:                         js.UndefOr[MuiListItemM => Unit]                   = js.undefined,
  /* If true, generate a nested-list-indicator icon when nested list
     items are detected. Note that an indicator will not be created
     if a `rightIcon` or `rightIconButton` has been provided to
     the element. */
  autoGenerateNestedIndicator: js.UndefOr[Boolean]                                = js.undefined,
  /* If true, the element will not be able to be focused by the keyboard. */
  disableKeyboardFocus:        js.UndefOr[Boolean]                                = js.undefined,
  /* If true, the element will not be clickable
     and will not display hover effects.
     This is automatically disabled if either `leftCheckbox`
     or `rightToggle` is set. */
  disabled:                    js.UndefOr[Boolean]                                = js.undefined,
  /* Override the hover background color. */
  hoverColor:                  js.UndefOr[MuiColor]                               = js.undefined,
  /* If true, the nested `ListItem`s are initially displayed. */
  initiallyOpen:               js.UndefOr[Boolean]                                = js.undefined,
  /* Override the inline-styles of the inner div element. */
  innerDivStyle:               js.UndefOr[CssProperties]                          = js.undefined,
  /* If true, the children will be indented by 72px.
     This is useful if there is no left avatar or left icon. */
  insetChildren:               js.UndefOr[Boolean]                                = js.undefined,
  /* This is the `Avatar` element to be displayed on the left side. */
  leftAvatar:                  js.UndefOr[VdomElement]                           = js.undefined,
  /* This is the `Checkbox` element to be displayed on the left side. */
  leftCheckbox:                js.UndefOr[VdomElement]                           = js.undefined,
  /* This is the `SvgIcon` or `FontIcon` to be displayed on the left side. */
  leftIcon:                    js.UndefOr[VdomElement]                           = js.undefined,
  /* An array of `ListItem`s to nest underneath the current `ListItem`. */
  nestedItems:                 js.UndefOr[js.Array[VdomElement]]                 = js.undefined,
  /* Controls how deep a `ListItem` appears.
     This property is automatically managed, so modify at your own risk. */
  nestedLevel:                 js.UndefOr[Int]                                    = js.undefined,
  /* Override the inline-styles of the nested items' `NestedList`. */
  nestedListStyle:             js.UndefOr[CssProperties]                          = js.undefined,
  /* Callback function fired when the `ListItem` is focused or blurred by the keyboard.
     @param {object} event `focus` or `blur` event targeting the `ListItem`.
     @param {boolean} isKeyboardFocused If true, the `ListItem` is focused. */
  onKeyboardFocus:             js.UndefOr[(ReactFocusEvent, Boolean) => Callback] = js.undefined,
  onMouseEnter:                js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  onMouseLeave:                js.UndefOr[ReactMouseEvent => Callback]            = js.undefined,
  /* Callbak function fired when the `ListItem` toggles its nested list.
     @param {object} listItem The `ListItem`. */
  onNestedListToggle:          js.UndefOr[js.Any => Callback]                     = js.undefined,
  onTouchEnd:                  js.UndefOr[ReactTouchEvent => Callback]            = js.undefined,
  onTouchStart:                js.UndefOr[ReactTouchEvent => Callback]            = js.undefined,
  onTouchTap:                  js.UndefOr[TouchTapEvent => Callback]              = js.undefined,
  /* Control toggle state of nested list. */
  open:                        js.UndefOr[Boolean]                                = js.undefined,
  /* This is the block element that contains the primary text.
     If a string is passed in, a div tag will be rendered. */
  primaryText:                 js.UndefOr[VdomNode]                              = js.undefined,
  /* If true, clicking or tapping the primary text of the `ListItem`
     toggles the nested list. */
  primaryTogglesNestedList:    js.UndefOr[Boolean]                                = js.undefined,
  /* This is the `Avatar` element to be displayed on the right side. */
  rightAvatar:                 js.UndefOr[VdomElement]                           = js.undefined,
  /* This is the `SvgIcon` or `FontIcon` to be displayed on the right side. */
  rightIcon:                   js.UndefOr[VdomElement]                           = js.undefined,
  /* This is the `IconButton` to be displayed on the right side.
     Hovering over this button will remove the `ListItem` hover.
     Also, clicking on this button will not trigger a
     ripple on the `ListItem`; the event will be stopped and prevented
     from bubbling up to cause a `ListItem` click. */
  rightIconButton:             js.UndefOr[VdomElement]                           = js.undefined,
  /* This is the `Toggle` element to display on the right side. */
  rightToggle:                 js.UndefOr[VdomElement]                           = js.undefined,
  /* This is the block element that contains the secondary text.
     If a string is passed in, a div tag will be rendered. */
  secondaryText:               js.UndefOr[VdomNode]                              = js.undefined,
  /* Can be 1 or 2. This is the number of secondary
     text lines before ellipsis will show. */
  secondaryTextLines:          js.UndefOr[_1_2]                                   = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                       js.UndefOr[CssProperties]                          = js.undefined,
  /* (Passed on to EnhancedButton) */
  centerRipple:                js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  containerElement:            js.UndefOr[String | VdomElement]                  = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableFocusRipple:          js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  disableTouchRipple:          js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  focusRippleColor:            js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedButton) */
  focusRippleOpacity:          js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  href:                        js.UndefOr[String]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  keyboardFocused:             js.UndefOr[Boolean]                                = js.undefined,
  /* (Passed on to EnhancedButton) */
  onBlur:                      js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedButton) */
  onClick:                     js.UndefOr[ReactEvent => Callback]                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  onFocus:                     js.UndefOr[ReactFocusEvent => Callback]            = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyDown:                   js.UndefOr[ReactKeyboardEvent => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton) */
  onKeyUp:                     js.UndefOr[ReactKeyboardEvent => Callback]         = js.undefined,
  /* (Passed on to EnhancedButton) */
  tabIndex:                    js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  touchRippleColor:            js.UndefOr[MuiColor]                               = js.undefined,
  /* (Passed on to EnhancedButton) */
  touchRippleOpacity:          js.UndefOr[Double]                                 = js.undefined,
  /* (Passed on to EnhancedButton) */
  `type`:                      js.UndefOr[String]                                 = js.undefined){

  /**
    * @param children Children passed into the `ListItem`.
   */
  def apply(children: VdomNode*) = {
    
    val props = JSMacro[MuiListItem](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.ListItem)
    component(props)(children: _*)
  }
}


@js.native
class MuiListItemM extends js.Object {
  def applyFocusState(focusState: js.Any): js.Dynamic = js.native

  def createDisabledElement(styles: js.Any, contentChildren: js.Any, additionalProps: js.Any): js.Dynamic = js.native

  def createLabelElement(styles: js.Any, contentChildren: js.Any, additionalProps: js.Any): js.Dynamic = js.native

  def createTextElement(styles: js.Any, data: js.Any, key: js.Any): js.Dynamic = js.native

  def pushElement(children: js.Any, element: js.Any, baseStyles: js.Any, additionalProps: js.Any): js.Dynamic = js.native
}

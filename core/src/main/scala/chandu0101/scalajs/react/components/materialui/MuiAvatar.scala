package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiAvatar(
  key:             js.UndefOr[String]        = js.undefined,
  ref:             js.UndefOr[String]        = js.undefined,
  /* The backgroundColor of the avatar. Does not apply to image avatars.*/
  backgroundColor: js.UndefOr[MuiColor]      = js.undefined,
  /* The css class name of the root `div` or `img` element.*/
  className:       js.UndefOr[String]        = js.undefined,
  /* The icon or letter's color.*/
  color:           js.UndefOr[MuiColor]      = js.undefined,
  /* This is the SvgIcon or FontIcon to be used inside the avatar.*/
  icon:            js.UndefOr[ReactElement]  = js.undefined,
  /* This is the size of the avatar in pixels.*/
  size:            js.UndefOr[Int]           = js.undefined,
  /* If passed in, this component will render an img element. Otherwise, a div will be rendered.*/
  src:             js.UndefOr[String]        = js.undefined,
  /* Override the inline-styles of the root element.*/
  style:           js.UndefOr[CssProperties] = js.undefined){
  /**
   * @param children Can be used, for instance, to render a letter inside the avatar.
   */
  def apply(children: js.UndefOr[ReactNode] = js.undefined) = {
    val props = JSMacro[MuiAvatar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Avatar)
    f(props, children).asInstanceOf[ReactComponentU_]
  }
}

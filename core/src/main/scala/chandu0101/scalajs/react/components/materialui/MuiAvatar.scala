
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiAvatar(
	key:             js.UndefOr[String]          = js.undefined,
	ref:             js.UndefOr[String]          = js.undefined,
	/* default: grey400: The backgroundColor of the avatar. Does not apply to image avatars.*/
	backgroundColor: js.UndefOr[MuiColor]        = js.undefined,
	/* default: white: The icon or letter color.*/
	color:           js.UndefOr[MuiColor]        = js.undefined,
	/*  This is the SvgIcon or FontIcon to be used inside the avatar.*/
	icon:            js.UndefOr[ReactElement]    = js.undefined,
	/* default: 40: This is the size of the avatar in pixels*/
	size:            js.UndefOr[Int]             = js.undefined,
	/*  If passed in, this component will render an img element. Otherwise, a div will be rendered.*/
	src:             js.UndefOr[String]          = js.undefined,
	/*  Override the inline-styles of the root element.*/
	style:           js.UndefOr[CssProperties]   = js.undefined)
{

  def apply(character: js.UndefOr[Char] = js.undefined) = {
    val props = JSMacro[MuiAvatar](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Avatar)
    f(props, character.map(_.toString)).asInstanceOf[ReactComponentU_]
  }
}


package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiList(
	key:               js.UndefOr[String]          = js.undefined,
	ref:               js.UndefOr[String]          = js.undefined,
	/* default: false: If true, the subheader will be indented by 72px.*/
	insetSubheader:    js.UndefOr[Boolean]         = js.undefined,
	/* optional, only available if HOC SelectableContainerEnhance is used: Override the choosen inline-styles to indicate a <ListItem> is highlighted. You can set e.g. the background color here like this way: {{backgroundColor: #da4e49}}.*/
	selectedItemStyle: js.UndefOr[CssProperties]   = js.undefined,
	/*  Override the inline-styles of the list's root element.*/
	style:             js.UndefOr[CssProperties]   = js.undefined,
	/*  The subheader string that will be displayed at the top of the list.*/
	subheader:         js.UndefOr[ReactNode]       = js.undefined,
	/*  The style object to override subheader styles.*/
	subheaderStyle:    js.UndefOr[CssProperties]   = js.undefined,
	/* optional, only available if HOC SelectableContainerEnhance is used: Makes List controllable. Highlights the ListItem whose index prop matches this "selectedLink.value". "selectedLink.requestChange" represents a callback function to change that value (e.g. in state).*/
	valueLink:         js.UndefOr[js.Any]          = js.undefined,
	zDepth:            js.UndefOr[MuiZDepth]       = js.undefined)
{

  def apply(children: ReactNode*) = {
    val props = JSMacro[MuiList](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.List)
    f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

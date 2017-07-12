package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiPaper(
  key:               js.UndefOr[String]        = js.undefined,
  ref:               js.UndefOr[String]        = js.undefined,
  /* Set to true to generate a circlular paper container. */
  circle:            js.UndefOr[Boolean]       = js.undefined,
  /* By default, the paper container will have a border radius.
     Set this to false to generate a container with sharp corners. */
  rounded:           js.UndefOr[Boolean]       = js.undefined,
  /* Override the inline-styles of the root element. */
  style:             js.UndefOr[CssProperties] = js.undefined,
  /* Set to false to disable CSS transitions for the paper element. */
  transitionEnabled: js.UndefOr[Boolean]       = js.undefined,
  /* This number represents the zDepth of the paper shadow. */
  zDepth:            js.UndefOr[ZDepth]        = js.undefined){

  /**
    * @param children Children passed into the paper element.
   */
  def apply(children: VdomNode*) = {
    val props = JSMacro[MuiPaper](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Paper)
    component(props)(children: _*)
  }
}

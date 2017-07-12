package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiToolbar(key: js.UndefOr[String] = js.undefined,
                      ref: js.UndefOr[String] = js.undefined,
                      /* The css class name of the root element. */
                      className: js.UndefOr[String] = js.undefined,
                      /* Do not apply `desktopGutter` to the `Toolbar`. */
                      noGutter: js.UndefOr[Boolean] = js.undefined,
                      /* Override the inline-styles of the root element. */
                      style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children Can be a `ToolbarGroup` to render a group of related items.
    */
  def apply(children: VdomNode*) = {

    val props     = JSMacro[MuiToolbar](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Toolbar)
    component(props)(children: _*)
  }
}

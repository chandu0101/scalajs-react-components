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
case class MuiToolbarGroup(key: js.UndefOr[String] = js.undefined,
                           ref: js.UndefOr[String] = js.undefined,
                           /* The css class name of the root element. */
                           className: js.UndefOr[String] = js.undefined,
                           /* Set this to true for if the `ToolbarGroup` is the first child of `Toolbar`
     to prevent setting the left gap. */
                           firstChild: js.UndefOr[Boolean] = js.undefined,
                           /* Set this to true for if the `ToolbarGroup` is the last child of `Toolbar`
     to prevent setting the right gap. */
                           lastChild: js.UndefOr[Boolean] = js.undefined,
                           /* Override the inline-styles of the root element. */
                           style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children Can be any node or number of nodes.
    */
  def apply(children: VdomNode*) = {

    val props     = JSMacro[MuiToolbarGroup](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.ToolbarGroup)
    component(props)(children: _*)
  }
}

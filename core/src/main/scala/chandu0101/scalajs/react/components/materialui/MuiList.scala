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
case class MuiList(key: js.UndefOr[String] = js.undefined,
                   ref: js.UndefOr[String] = js.undefined,
                   /* Override the inline-styles of the root element. */
                   style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children These are usually `ListItem`s that are passed to
    be part of the list.
    */
  def apply(children: VdomNode*) = {

    val props     = JSMacro[MuiList](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.List)
    component(props)(children: _*)
  }
}

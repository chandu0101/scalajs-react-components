package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiCardExpandable(key: js.UndefOr[String] = js.undefined,
                             ref: js.UndefOr[String] = js.undefined,
                             closeIcon: js.UndefOr[VdomNode] = js.undefined,
                             expanded: js.UndefOr[Boolean] = js.undefined,
                             onExpanding: Callback,
                             openIcon: js.UndefOr[VdomNode] = js.undefined,
                             style: js.UndefOr[CssProperties] = js.undefined) {

  def apply() = {

    val props     = JSMacro[MuiCardExpandable](this)
    val component = JsComponent[js.Object, Children.None, Null](Mui.CardExpandable)
    component(props)
  }
}

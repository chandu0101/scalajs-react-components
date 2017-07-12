package chandu0101.scalajs.react.components

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React

import scala.scalajs.js

case class Spinner(key: js.UndefOr[String] = js.undefined,
                   ref: js.UndefOr[String] = js.undefined,
                   className: js.UndefOr[String] = js.undefined) {

  def apply() = {
    val props = JSMacro[Spinner](this)
    val component = JsComponent[js.Object, Children.None, Null](js.Dynamic.global.Spinner)
    component(props)
  }
}

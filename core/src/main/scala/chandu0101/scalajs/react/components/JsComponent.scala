package chandu0101.scalajs.react.components

import japgolly.scalajs.react._

import scala.scalajs.js

@js.native
trait JsComponent[P <: js.Any] extends JsComponentType[P, js.Any, TopNode]

object TODO {
  @deprecated
  type ANY = js.Any
  @deprecated
  type FUNC = Callback
}

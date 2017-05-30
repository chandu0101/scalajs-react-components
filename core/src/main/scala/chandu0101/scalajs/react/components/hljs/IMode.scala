package chandu0101.scalajs.react.components.hljs

import scala.scalajs.js

@js.native
trait IMode extends IModeBase {
  var contains: js.UndefOr[js.Array[IMode]] = js.native
  var keywords: js.UndefOr[Any]             = js.native
}

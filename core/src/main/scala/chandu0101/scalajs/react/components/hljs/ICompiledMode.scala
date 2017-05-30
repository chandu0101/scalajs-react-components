package chandu0101.scalajs.react.components.hljs

import scala.scalajs.js
import scala.scalajs.js.RegExp

@js.native
trait ICompiledMode extends IModeBase {
  var compiled: Boolean                             = js.native
  var contains: js.UndefOr[js.Array[ICompiledMode]] = js.native
  var keywords: js.UndefOr[js.Object]               = js.native
  var terminator_end: js.UndefOr[String]            = js.native
  var terminators: RegExp                           = js.native
}

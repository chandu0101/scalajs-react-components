package chandu0101.scalajs.react

import scala.scalajs.js

package object components
  extends util.CommonStyles
  with util.MTypes {

  private[components] val JSMacro   = _root_.chandu0101.macros.tojs.JSMacro

  /* type alias for `js.undefined` */
  private[components] type U[T] = js.UndefOr[T]
  private[components] val uNone = js.undefined
}
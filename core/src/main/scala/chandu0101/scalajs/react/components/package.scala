package chandu0101.scalajs.react

import japgolly.scalajs.react.{CallbackOption, BackendScope, Callback, CallbackTo, Ref}
import scala.scalajs.js

package object components
  extends util.CommonStyles
  with util.MTypes {

  private[components] val JSMacro = chandu0101.macros.tojs.JSMacro

  /* type alias for `js.undefined` */
  type U[T] = js.UndefOr[T]
  val uNone = js.undefined

  def callbackRef[P, S](ref: Ref, t: => BackendScope[P, S]): CallbackOption[ref.R] =
    CallbackOption.liftOptionLike(ref(t))

  implicit class CallbackToX[T](private val ct: CallbackTo[T]){
    def zip[U](cu: CallbackTo[U]): CallbackTo[(T, U)] = for {
      t <- ct
      u <- cu
    } yield (t, u)
  }
}
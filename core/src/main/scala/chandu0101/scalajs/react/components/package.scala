package chandu0101.scalajs.react

import japgolly.scalajs.react.{BackendScope, Callback, CallbackTo, Ref}
import scala.scalajs.js

package object components
  extends util.CommonStyles
  with util.MTypes {

  private[components] val JSMacro = chandu0101.macros.tojs.JSMacro

  /* type alias for `js.undefined` */
  type U[T] = js.UndefOr[T]
  val uNone = js.undefined

  def withRef[P, S](ref: Ref, t: => BackendScope[P, S])
                   (f: ref.R => Callback): Callback =
    ref(t).fold(Callback.info(s"${ref.name} not found"))(r => f(r))

  implicit class CallbackToX[T](private val ct: CallbackTo[T]){
    def zip[U](cu: CallbackTo[U]): CallbackTo[(T, U)] = for {
      t <- ct
      u <- cu
    } yield (t, u)
  }
}
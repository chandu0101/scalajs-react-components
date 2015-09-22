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

  @inline private[components] implicit final class UCB[R](private val uc: js.UndefOr[CallbackTo[R]]) extends AnyVal {
    @inline def asCbo: CallbackOption[R] =
      CallbackOption.liftOption(uc.toOption.map(_.runNow()))
  }

  @inline private[components] implicit final class UF1CB[T1, R](private val uc: js.UndefOr[T1 => CallbackTo[R]]) extends AnyVal {
    @inline def asCbo(t1: T1): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1).toCBO)
  }

  @inline private[components] implicit final class UF2CB[T1, T2, R](private val uc: js.UndefOr[(T1, T2) => CallbackTo[R]]) extends AnyVal {
    @inline def asCbo(t1: T1, t2: T2): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1, t2).toCBO)
  }

}
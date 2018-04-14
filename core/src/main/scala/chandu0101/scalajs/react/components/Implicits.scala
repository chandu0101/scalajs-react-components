package chandu0101.scalajs.react.components

import japgolly.scalajs.react._

import scala.scalajs.js

// todo: figure out if we should keep these
private[components] object Implicits {

  /* this works here, but not in the general case!
   * (see https://github.com/scala-js/scala-js/pull/2070 )
   */
  implicit final class UCB[R](private val uc: js.UndefOr[CallbackTo[R]]) extends AnyVal {
    @inline def asCbo: CallbackOption[R] =
      CallbackOption.liftOption(uc.toOption.map(_.runNow()))
  }

  implicit final class UF1CB[T1, R](private val uc: js.UndefOr[T1 => CallbackTo[R]])
      extends AnyVal {
    @inline def asCbo(t1: T1): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1).toCBO)
  }

  implicit final class UF2CB[T1, T2, R](private val uc: js.UndefOr[(T1, T2) => CallbackTo[R]])
      extends AnyVal {
    @inline def asCbo(t1: T1, t2: T2): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1, t2).toCBO)
  }

  implicit final class UF3CB[T1, T2, T3, R](
      private val uc: js.UndefOr[(T1, T2, T3) => CallbackTo[R]])
      extends AnyVal {
    @inline def asCbo(t1: T1, t2: T2, t3: T3): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1, t2, t3).toCBO)
  }
}

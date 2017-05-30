package chandu0101.scalajs.react

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomElement

import scala.scalajs.js
import scala.scalajs.js.`|`

package object components {
  type CssProperties = js.Any

  /* this works here, but not in the general case!
   * (see https://github.com/scala-js/scala-js/pull/2070 )
   */
  @deprecated("We need to find a better solution here", "")
  private[components] implicit def UnionEvidence[A, B](ab: A | B)(implicit eva: A => js.Any,
                                                                  evb: B => js.Any): js.Any =
    ab.asInstanceOf[js.Any]

  private[components] implicit def AnyValIsJs(u: AnyVal): js.Any =
    u.asInstanceOf[js.Any]

  private[components] implicit def StringOrElementEvidence(u: String | VdomElement): js.Any =
    //noinspection ComparingUnrelatedTypes
    if (u.isInstanceOf[String]) u.asInstanceOf[js.Any] else u.asInstanceOf[VdomElement].rawElement

  private[components] implicit def VdomElementOrStringOrDoubleEvidence(
      u: VdomElement | String | Double): js.Any =
    //noinspection ComparingUnrelatedTypes
    if (u.isInstanceOf[VdomElement]) u.asInstanceOf[VdomElement].rawElement
    else u.asInstanceOf[js.Any]

  private[components] implicit final class UCB[R](private val uc: js.UndefOr[CallbackTo[R]])
      extends AnyVal {
    @inline def asCbo: CallbackOption[R] =
      CallbackOption.liftOption(uc.toOption.map(_.runNow()))
  }

  private[components] implicit final class UF1CB[T1, R](
      private val uc: js.UndefOr[T1 => CallbackTo[R]])
      extends AnyVal {
    @inline def asCbo(t1: T1): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1).toCBO)
  }

  private[components] implicit final class UF2CB[T1, T2, R](
      private val uc: js.UndefOr[(T1, T2) => CallbackTo[R]])
      extends AnyVal {
    @inline def asCbo(t1: T1, t2: T2): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1, t2).toCBO)
  }
}

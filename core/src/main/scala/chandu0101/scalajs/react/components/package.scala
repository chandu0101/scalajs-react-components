package chandu0101.scalajs.react

import japgolly.scalajs.react._
import org.scalajs.dom.html

import scala.reflect.ClassTag
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.JSName

package object components {
  type CssProperties = js.Any


  type ReactEventB = SyntheticEvent[html.Button]
  type ReactClipboardEventB = SyntheticClipboardEvent[html.Button]
  type ReactCompositionEventB = SyntheticCompositionEvent[html.Button]
  type ReactDragEventB = SyntheticDragEvent[html.Button]
  type ReactFocusEventB = SyntheticFocusEvent[html.Button]
  type ReactMouseEventB = SyntheticMouseEvent[html.Button]

  type ReactEventS = SyntheticEvent[html.Select]
  type ReactClipboardEventS = SyntheticClipboardEvent[html.Select]
  type ReactCompositionEventS = SyntheticCompositionEvent[html.Select]
  type ReactDragEventS = SyntheticDragEvent[html.Select]
  type ReactFocusEventS = SyntheticFocusEvent[html.Select]
  type ReactMouseEventS = SyntheticMouseEvent[html.Select]

  /* this works here, but not in the general case!
   * (see https://github.com/scala-js/scala-js/pull/2070 )
   */
  @deprecated("We need to find a better solution here")
  private[components] implicit def UnionEvidence[A, B](ab: A | B)(implicit eva: A => js.Any, evb: B => js.Any): js.Any =
    ab.asInstanceOf[js.Any]

  private[components] implicit final class UCB[R](private val uc: js.UndefOr[CallbackTo[R]]) extends AnyVal {
    @inline def asCbo: CallbackOption[R] =
      CallbackOption.liftOption(uc.toOption.map(_.runNow()))
  }

  private[components] implicit final class UF1CB[T1, R](private val uc: js.UndefOr[T1 => CallbackTo[R]]) extends AnyVal {
    @inline def asCbo(t1: T1): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1).toCBO)
  }

  private[components] implicit final class UF2CB[T1, T2, R](private val uc: js.UndefOr[(T1, T2) => CallbackTo[R]]) extends AnyVal {
    @inline def asCbo(t1: T1, t2: T2): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1, t2).toCBO)
  }

  private[components] implicit final class UF3CB[T1, T2, T3, R](private val uc: js.UndefOr[(T1, T2, T3) => CallbackTo[R]]) extends AnyVal {
    @inline def asCbo(t1: T1, t2: T2, t3: T3): CallbackOption[R] =
      CallbackOption.liftOptionLike(uc).flatMap(_.apply(t1, t2, t3).toCBO)
  }

  @js.native
  @JSName("React")
  object ReactJS extends js.Object {

    def createElement(ctor: js.Any, props: js.Object, children: ReactNode*): ReactElement = js.native
  }

}
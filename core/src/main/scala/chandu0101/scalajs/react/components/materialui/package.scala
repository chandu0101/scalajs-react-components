package chandu0101.scalajs.react.components

import japgolly.scalajs.react.ReactNode

import scala.reflect.ClassTag
import scala.scalajs.js
import scala.scalajs.js.`|`

package object materialui {
  type CssProperties = js.Any

  implicit def StringToReactNodeU(s: String): js.UndefOr[ReactNode] =
    s: ReactNode

  implicit def UnionEvidence[A: ClassTag, B: ClassTag](ab: A | B)(implicit eva: A => js.Any, evb: B => js.Any): js.Any =
    ab match {
      case a: A => eva(a)
      case b: B => evb(b)
    }
}

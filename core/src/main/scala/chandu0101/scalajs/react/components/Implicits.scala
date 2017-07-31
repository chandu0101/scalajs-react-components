package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.ReactTagOf

import scala.scalajs.js

object Implicits extends Implicits

trait Implicits {
  @inline implicit final def UHelperReactTag[T <: TopNode](
      t: ReactTagOf[T]): js.UndefOr[ReactElement] = t.render

  @inline implicit final def UHelperReactNode[T](t: T)(
      implicit ev: T => ReactNode): js.UndefOr[ReactNode] =
    t.asInstanceOf[js.UndefOr[ReactNode]]
}

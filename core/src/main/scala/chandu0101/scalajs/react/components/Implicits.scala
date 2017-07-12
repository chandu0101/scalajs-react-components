package chandu0101.scalajs.react.components

import japgolly.scalajs.react.vdom._

import scala.scalajs.js

object Implicits extends Implicits

trait Implicits {
  @inline implicit final def UHelperReactTag[T <: TopNode]
    (t: TagOf[T]): js.UndefOr[VdomElement] = t.render

  @inline implicit final def UHelperReactNode[T]
    (t: T)(implicit ev: T => VdomNode): js.UndefOr[VdomNode] =
      ev(t).asInstanceOf[js.UndefOr[VdomNode]]
}

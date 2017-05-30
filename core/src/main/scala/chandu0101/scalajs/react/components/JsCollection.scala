package chandu0101.scalajs.react.components

import scala.scalajs.js

/**
  * This represents the dubious construction
  *  where in javascript one might return
  *  one in three things:
  *
  *  - undefined
  *  - an instance of T
  *  - an array of T
  *
  *  BEWARE: `JsCollection[js.Array[T]]` wont work
  */
@js.native
trait JsCollection[T] extends js.Any

object JsCollection extends JsCollectionLower {
  @inline implicit final def toJsCollectionArray[T <: js.Any](t: js.Array[T]): JsCollection[T] =
    t.asInstanceOf[JsCollection[T]]

  @inline implicit final def toJsCollectionUndefOr[T <: js.Any](
      t: js.UndefOr[T]): JsCollection[T] =
    t.asInstanceOf[JsCollection[T]]

  @inline final implicit class JsCollectionX[T <: js.Any](private val c: JsCollection[T]) {
    @inline def isArray: Boolean =
      js.Array.isArray(c)

    @inline def fold[U](u: => U)(f: T => U)(fs: js.Array[T] => U): U =
      if (c == js.undefined) u
      else if (isArray) fs(c.asInstanceOf[js.Array[T]])
      else f(c.asInstanceOf[T])

    @inline def toJsArray: js.Array[T] =
      fold[js.Array[T]](js.Array())(js.Array(_))(identity)

    @inline def headOption: js.UndefOr[T] =
      fold[js.UndefOr[T]](js.undefined)(identity[T])(a => if (a.nonEmpty) a.head else js.undefined)

    @inline def map[U <: js.Any](f: T => U): JsCollection[U] =
      fold[JsCollection[U]](js.undefined)(f(_))(_ map f)
  }
}

trait JsCollectionLower {
  @inline implicit final def toJsCollectionId[T <: js.Any](t: T): JsCollection[T] =
    t.asInstanceOf[JsCollection[T]]
}

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
  *  BEWARE: `JsCol[js.Array[T]]` wont work
  */
@js.native
trait JsCol[T] extends js.Any

object JsCol extends lower {
  @inline implicit final def toJsColArray[T <: js.Any](t: js.Array[T]): JsCol[T] =
    t.asInstanceOf[JsCol[T]]

  @inline implicit final def toJsColUndefOr[T <: js.Any](t: js.UndefOr[T]): JsCol[T] =
    t.asInstanceOf[JsCol[T]]

  @inline final implicit class JsColX[T <: js.Any](private val c: JsCol[T]){
    @inline def isArray: Boolean =
      js.Array.isArray(c)

    @inline def fold[U](u: => U)(f: T => U)(fs: js.Array[T] => U): U =
      if (c == js.undefined) u
      else if (isArray)      fs(c.asInstanceOf[js.Array[T]])
      else                   f(c.asInstanceOf[T])

    @inline def toJsArray: js.Array[T] =
      fold[js.Array[T]](js.Array())(js.Array(_))(identity)

    @inline def headOption: js.UndefOr[T] =
      fold[js.UndefOr[T]](js.undefined)(identity[T])(a => if (a.nonEmpty) a.head else js.undefined)

    @inline def map[U <: js.Any](f: T => U): JsCol[U] =
      fold[JsCol[U]](js.undefined)(t => f(t))(_ map f)
  }
}

trait lower {
  @inline implicit final def toJsColId[T <: js.Any](t: T): JsCol[T] =
    t.asInstanceOf[JsCol[T]]
}

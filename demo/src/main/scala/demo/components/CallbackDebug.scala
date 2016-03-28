package demo.components

import japgolly.scalajs.react._

import scala.scalajs.js

object CallbackDebug {
  trait Print[T] {
    def print(t: T): String
  }
  trait PrintLower {
    final implicit def PrintAny[T]: Print[T] =
      new Print[T]{
        override def print(t: T): String =
          if (t == js.undefined) "undefined"
          else if (t == null) "null"
          else t.toString
      }
  }

  object Print extends PrintLower {
    def apply[T: Print](t: T): String =
      implicitly[Print[T]].print(t)

    implicit def PrintEvent[E <: ReactEvent]: Print[E] =
      new Print[E] {
        override def print(e: E): String = {
          val d = e.asInstanceOf[js.Dynamic]
          val u = js.undefined.asInstanceOf[js.Dynamic]
          val event =
            if      (d.clipboardData != u) "ReactClipboardEvent"
            else if (d.data != u)          "ReactCompositionEvent"
            else if (d.dataTransfer != u)  "ReactDragEvent"
            else if (d.relatedTarget != u) "ReactFocusEvent"
            else if (d.locale != u)        "ReactKeyboardEvent"
            else if (d.buttons != u)       "ReactMouseEvent"
            else if (d.touches != u)       "ReactTouchEvent"
            else if (d.detail != u)        "ReactUIEvent"
            else if (d.deltaZ != u)        "ReactWheelEvent"
            else                           "ReactEvent"

          val t = e.target.asInstanceOf[js.Dynamic]
          val target =
            if      (t.value     != u) "I"
            else if (t.offsetTop != u) "H"
            else                       ""
          s"$event$target: t.value: ${t.value}, t.offsetTop: ${t.offsetTop}"
        }
      }
  }

  private def base(name: String, params: String*): Callback =
    Callback.info(s"Event handler: $name(${params.mkString(", ")})")

  def f0(name: String): Callback =
    base(name)
  def f1[T1: Print](name: String): js.UndefOr[T1 => Callback] =
    (_1: T1) => base(name, Print(_1))
  def f2[T1: Print, T2: Print](name: String): js.UndefOr[(T1, T2) => Callback] =
    (_1: T1, _2: T2) => base(name, Print(_1), Print(_2))
  def f3[T1: Print, T2: Print, T3: Print](name: String): js.UndefOr[(T1, T2, T3) => Callback] =
    (_1: T1, _2: T2, _3: T3) => base(name, Print(_1), Print(_2), Print(_3))
}

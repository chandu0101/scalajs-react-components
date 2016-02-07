package demo.components

import japgolly.scalajs.react._

import scala.scalajs.js

object DummyEvents {
  def eventType(a: ReactEvent): String = {
    a match {
      case e: ReactEvent =>
        val d = e.asInstanceOf[js.Dynamic]
        val u = js.undefined.asInstanceOf[js.Dynamic]
        val event =
               if (d.clipboardData != u) "ReactClipboardEvent"
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
               if (t.value     != u) "I"
          else if (t.offsetTop != u) "H"
          else                       ""
        s"$event$target: t.value: ${t.value}, t.offsetTop: ${t.offsetTop}"
    }
  }
  def str(a: Any): String =
    if(a == js.undefined || a == null) "undefined" else a.toString

  def f0(name: String): Callback =
    Callback.info(s"Event handler: $name")
  def f1(name: String): ReactEvent => Callback =
    e1 => Callback.info(s"Event handler: $name, ${eventType(e1)}")
  def f1_(name: String): Any => Callback =
    e1 => Callback.info(s"Event handler: $name, ${str(e1)}")
  def f21(name: String): (ReactEvent, Any) => Callback =
    (e1, e2) => Callback.info(s"Event handler: $name, ${eventType(e1)}, ${str(e2)}")
  def f22(name: String): (Any, ReactEvent) => Callback =
    (e1, e2) => Callback.info(s"Event handler: $name, ${str(e1)}, ${eventType(e2)}")
  def f2_(name: String): (Any, Any) => Callback =
    (e1, e2) => Callback.info(s"Event handler: $name, ${str(e1)}, ${str(e2)}")
  def f3(name: String): (ReactEvent, Any, Any) => Callback =
    (e1, e2, e3) => Callback.info(s"Event handler: $name, ${eventType(e1)}, ${str(e2)}, ${str(e3)}")
}

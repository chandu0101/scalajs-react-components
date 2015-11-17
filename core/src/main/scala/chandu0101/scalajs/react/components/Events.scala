package chandu0101.scalajs.react.components

import japgolly.scalajs.react.Callback
import org.scalajs.dom.{Event, EventTarget}

import scala.scalajs.js

object Events {
  def register(element: EventTarget,
               tpe: String,
               _cb: Event => Callback,
               capture: Boolean = false): Callback = {
    val cb: js.Function1[Event, Unit] = (e: Event) => _cb(e).runNow()
    element.addEventListener(tpe, cb, capture)
    Callback(element.removeEventListener(tpe, cb, capture))
  }
}

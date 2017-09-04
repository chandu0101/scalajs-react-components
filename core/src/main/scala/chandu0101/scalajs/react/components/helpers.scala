package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom._

import scala.scalajs.js

object Events {
  def register(
      element: EventTarget,
      tpe: String,
      _cb: Event => Callback,
      capture: Boolean = false
  ): Callback = {
    val cb: js.Function1[Event, Unit] = (e: Event) => _cb(e).runNow()
    element.addEventListener(tpe, cb, capture)
    Callback(element.removeEventListener(tpe, cb, capture))
  }
}

object RCustomStyles extends RCustomStyles

/**
  * Eventually these should be copied to scalajs-react core
  */
trait RCustomStyles {
  val MsFlexAlign          = VdomStyle("MsFlexAlign")
  val MsFlexDirection      = VdomStyle("MsFlexDirection")
  val MsFlexWrap           = VdomStyle("MsFlexWrap")
  val WebkitAlignItems     = VdomStyle("WebkitAlignItems")
  val WebkitBackgroundClip = VdomStyle("WebkitBackgroundClip")
  val WebkitBoxAlign       = VdomStyle("WebkitBoxAlign")
  val WebkitBoxDirection   = VdomStyle("WebkitBoxDirection")
  val WebkitBoxOrient      = VdomStyle("WebkitBoxOrient")
  val WebkitBoxShadow      = VdomStyle("WebkitBoxShadow")
  val WebkitFlexDirection  = VdomStyle("WebkitFlexDirection")
  val WebkitFlexWrap       = VdomStyle("WebkitFlexWrap")
  val WebkitTransform      = VdomStyle("WebkitTransform")
  val mozTransform         = VdomStyle("mozTransform")
  val msTransform          = VdomStyle("msTransform")
}
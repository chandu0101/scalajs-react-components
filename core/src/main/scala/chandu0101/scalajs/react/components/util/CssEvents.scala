package chandu0101.scalajs.react.components
package util

import japgolly.scalajs.react.TopNode
import org.scalajs.dom.Event
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}


object CssEvents {

  def testSupportedProps(props: Map[String, String]) = {
    val el = g.document.createElement("div")
    props.view.filter { case (key, value) =>  !js.isUndefined(el.style.selectDynamic(key)) }.head._2
  }

  def transitionEndEventName = testSupportedProps(Map(
    "transition" -> "transitionend",
    "OTransition" -> "otransitionend",
    "MozTransition" -> "transitionend",
    "WebkitTransition" -> "webkitTransitionEnd"
  ))

  def animationEndEventName = testSupportedProps(Map(
    "animation" -> "animationend",
    "-o-animation" -> "oAnimationEnd",
    "-moz-animation" -> "animationend",
    "-webkit-animation" -> "webkitAnimationEnd"
  ))

  def onTransitionEnd(element: TopNode, callback: Function1[Event, _]) = {
    Events.once(element, transitionEndEventName, callback)
  }

  def onAnimationEnd(element: TopNode, callback: Function1[Event, _]) = {
    Events.once(element, animationEndEventName, callback)
  }

}

package chandu0101.scalajs.react.components
package util

import chandu0101.scalajs.react.components.models.RPoint
import japgolly.scalajs.react.{Callback, TopNode}
import org.scalajs.dom
import org.scalajs.dom._
import scala.scalajs.js

object DomUtil {

  def addClass(element: html.Element, className: String) = {
    if(element.classList.length > 0)
       element.classList.add(className)
    else
      element.className += s" $className"
  }
  def removeClass(element: html.Element, className: String) = {
    if(element.classList.length > 0)
      element.classList.remove(className)
    else
    //new RegExp("(^|\\b)" + className.split(" ").join("|") + "(\\b|$)", "gi"), " "
      element.className = element.className.replace(s"(^|\\b)","")
  }

  case class ClientRect(top: Double,left: Double)

  def offset(element: TopNode) = {
    val rect = element.getBoundingClientRect()
    var scrollTop = 0.0
    var scrollLeft = 0.0
    if(dom.document.body.scrollTop > 0) {
      scrollTop = dom.document.body.scrollTop.toInt
      scrollLeft = dom.document.body.scrollLeft.toInt
    } else if(dom.document.documentElement.scrollTop >0) { // for firefox
      scrollTop = dom.document.documentElement.scrollTop
      scrollLeft = dom.document.documentElement.scrollLeft
    }
    ClientRect(rect.top + scrollTop, rect.left + scrollLeft )
  }

 def forceRedraw(el: html.Element) = Callback {
   val originalDisplay = el.style.display
   el.style.display = "none"
   el.offsetHeight
   el.style.display = originalDisplay
 }

 def isDecedant(parent: TopNode, child: TopNode) = {
   def loop(node: Node): Boolean =  node match  {
     case null => false
     case _ => if(node == parent) true else loop(node.parentNode)
   }
  loop(child.parentNode)
 }

  /**
   *  https://developer.mozilla.org/en-US/docs/Web/API/Element.matches#Browser_compatibility
   * @param element dom element
   * @param selector css selector
   */
 def matchesSelector(element: js.Dynamic)(selector: String): Boolean = {
    val funcName =  Stream("matches",
    "webkitMatchesSelector",
    "mozMatchesSelector",
    "msMatchesSelector",
    "oMatchesSelector").filter(name => !js.isUndefined(element.selectDynamic(name))).head
    element.selectDynamic(funcName).call(element,selector).asInstanceOf[Boolean]
  }

  /**
   *  onTouchStart - / works on most browsers
   *  onmsgesturechange - works on ie10 on ms surface
   * @return whether device is touch enabled or not
   */
  def isTouchDevice = dom.window.hasOwnProperty("ontouchstart") || dom.window.hasOwnProperty("onmsgesturechange")

  def dragEventFor(name: String) = name match {
    case "start" => if (isTouchDevice) "touchstart" else "mousedown"
    case "move" => if (isTouchDevice) "touchmove" else "mousemove"
    case "end" => if (isTouchDevice) "touchend" else "mouseup"
    case _ => ""
  }

  def dragEventFor(e:Event, name: String) = name match {
    case "start" => if (e.`type`.contains("touch")) "touchstart" else "mousedown"
    case "move" => if (e.`type`.contains("touch")) "touchmove" else "mousemove"
    case "end" => if (e.`type`.contains("touch")) "touchend" else "mouseup"
    case _ => ""
  }

  def getControlPosition(e: Event): RPoint =
    if (isTouchDevice || e.`type`.contains("touch")) {
      val position = e.asInstanceOf[TouchEvent].touches(0)
      RPoint(position.clientX, position.clientY)
    } else {
      val position = e.asInstanceOf[MouseEvent]
      RPoint(position.clientX, position.clientY)
    }

  def withoutTransition(el: html.Element, callback: Callback): Callback =
    Callback(el.style.transition = "none") >>
    callback >>
    forceRedraw(el) >>
    Callback(el.style.transition)

  def isLeftClick(e: Event) =  e.`type` == "touchstart" || e.asInstanceOf[MouseEvent].button == 0

}

package chandu0101.scalajs.react.components.materialui.raw

import japgolly.scalajs.react.SyntheticEvent
import org.scalajs.dom

import scala.scalajs.js
@js.native
trait TouchTapEvent[+DOMEventTarget <: dom.Node] extends SyntheticEvent[DOMEventTarget] {
  def altKey: Boolean
  def ctrlKey: Boolean
  def getModifierState(key: String): Boolean
  def metaKey: Boolean
  def shiftKey: Boolean
}

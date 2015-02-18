package chandu0101.scalajs.react.components.mixins

import chandu0101.scalajs.react.components.util.Events
import japgolly.scalajs.react.ReactComponentB
import org.scalajs.dom
import org.scalajs.dom.Event

import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 */
trait WindowListeners {
  def listeners: List[(String,js.Function1[Event,_])]


}

object WindowListeners {
  def mixin[P,S,B] = (c:ReactComponentB[P,S,B]) => {
    c.componentDidMount(scope => {
      val listeners = scope.backend.asInstanceOf[WindowListeners].listeners
      listeners.foreach{ case (name,function) => Events.on(dom.window,name,function) }
    })
      .componentWillUnmount(scope => {
      val listeners = scope.backend.asInstanceOf[WindowListeners].listeners
      listeners.foreach{ case (name,function) => Events.off(dom.window,name,function) }
    })
  }
}

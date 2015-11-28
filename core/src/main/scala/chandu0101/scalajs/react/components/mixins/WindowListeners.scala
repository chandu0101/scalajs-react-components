package chandu0101.scalajs.react.components
package mixins

import chandu0101.scalajs.react.components.util.Events
import japgolly.scalajs.react._
import org.scalajs.dom
import org.scalajs.dom.Event
import scala.collection.mutable

trait WindowListeners {
  def listeners: List[(String, Event => Callback)]
}

object WindowListeners {
  def mixin[P, S, B <: WindowListeners, N <: TopNode] = (c: ReactComponentB[P, S, B, N]) => {
    val unlisteners = mutable.ArrayBuffer.empty[Callback]
    c.componentDidMount(
      $ =>
        Callback(
          $.backend.listeners.foreach {
            case (tpe, cb) => unlisteners += Events.register(dom.window, tpe, cb)
          }
        )
    ).componentWillUnmount( $ => Callback(unlisteners.foreach(_.runNow())))
  }
}

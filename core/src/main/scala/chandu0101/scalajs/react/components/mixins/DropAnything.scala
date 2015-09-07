package chandu0101.scalajs.react.components.mixins

import japgolly.scalajs.react._
import org.scalajs.dom._


trait DropAnything {

  private def _onDrop(ev: Event): Unit = {
    ev.preventDefault()
    val de = ev.asInstanceOf[DragEvent]
    onDrop(de)
  }

  def onDrop(de: DragEvent): Unit = ???

  def onDragEnter(ev: Event): Unit = {
    ev.preventDefault()
  }

  def onDragOver(ev: Event): Unit = {
    ev.preventDefault()
  }
}

object DropAnything {
  def mixin[P, S, B <: DropAnything, N <: TopNode] = (c: ReactComponentB[P, S, B, N]) => {
    c.componentDidMount(scope => {
      val drop = scope.backend.asInstanceOf[DropAnything]
      val node = scope.getDOMNode()
      node.addEventListener("drop", drop._onDrop _, false)
      node.addEventListener("dragenter", drop.onDragEnter _, false)
      node.addEventListener("dragover", drop.onDragOver _, false)
    }).componentWillUnmount { scope =>
      val drop = scope.backend.asInstanceOf[DropAnything]
      val node = scope.getDOMNode()
      node.removeEventListener("drop", drop._onDrop _, false)
      node.removeEventListener("dragenter", drop.onDragEnter _, false)
      node.removeEventListener("dragover", drop.onDragOver _, false)
    }
  }
}

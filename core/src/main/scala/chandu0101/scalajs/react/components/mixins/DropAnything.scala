package chandu0101.scalajs.react.components
package mixins

import japgolly.scalajs.react._
import org.scalajs.dom._

trait DropAnything {

  private def _onDrop(ev: Event): Unit = {
    ev.preventDefault()
    onDrop(ev.asInstanceOf[DragEvent])
  }

  def onDrop(de: DragEvent): Unit

  def onDragEnter(ev: Event): Unit =
    ev.preventDefault()

  def onDragOver(ev: Event): Unit =
    ev.preventDefault()
}

object DropAnything {
  def mixin[P, S, B <: DropAnything, N <: TopNode] = (c: ReactComponentB[P, S, B, N]) => {
    c.componentDidMount(scope =>
      Callback{
        val node = scope.getDOMNode()
        node.addEventListener("drop", scope.backend._onDrop _, useCapture = false)
        node.addEventListener("dragenter", scope.backend.onDragEnter _, useCapture = false)
        node.addEventListener("dragover", scope.backend.onDragOver _, useCapture = false)
      }
    ).componentWillUnmount(scope =>
      Callback{
        val node = scope.getDOMNode()
        node.removeEventListener("drop", scope.backend._onDrop _, useCapture = false)
        node.removeEventListener("dragenter", scope.backend.onDragEnter _, useCapture = false)
        node.removeEventListener("dragover", scope.backend.onDragOver _, useCapture = false)
      }
    )
  }
}

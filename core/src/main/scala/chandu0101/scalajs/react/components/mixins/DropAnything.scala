package chandu0101.scalajs.react.components.mixins

import japgolly.scalajs.react._
import org.scalajs.dom._
import org.scalajs.dom.ext.PimpedNodeList

import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 *
 * To load resources(javascript,stylesheet) on fly
 */
trait DropAnything {

  //var listener: js.Function1[Event, _] = null

  private def _onDrop(ev:Event):Unit = {
    ev.preventDefault()
    val de = ev.asInstanceOf[DragEvent]
    var data = de.dataTransfer.getData("text")
    println(data)
    onDrop(de)
    //ev.appendChild(document.getElementById(data));
  }

  def onDrop(de:DragEvent):Unit = ???

  def onDragEnter(ev:Event):Unit = {
    ev.preventDefault()
    println("Drag ENTER...")
    //ev.appendChild(document.getElementById(data));
  }

  def onDragOver(ev:Event):Unit = {
    ev.preventDefault()
    println("Drag OVER...")
    //ev.appendChild(document.getElementById(data));
  }
}

object DropAnything {
  def mixin[P, S, B <: DropAnything, N <: TopNode] = (c: ReactComponentB[P, S, B, N]) => {
    c.componentDidMount(scope => {
      println("DropAnything componentDidMount")
      val drop = scope.backend.asInstanceOf[DropAnything]
      val node = scope.getDOMNode()

      node.addEventListener("drop", drop._onDrop _, false)
      node.addEventListener("dragenter", drop.onDragEnter _, false)
      node.addEventListener("dragover", drop.onDragOver _, false)

      //org.scalajs.dom.document.addEventListener("dragover", drop.onDragOver _, false)
      println(node.attributes)

    }).componentWillUnmount{scope =>
      val drop = scope.backend.asInstanceOf[DropAnything]
      val node = scope.getDOMNode()
      node.removeEventListener("drop", drop._onDrop _, false )
      node.removeEventListener("dragenter", drop.onDragEnter _, false)
      node.removeEventListener("dragover", drop.onDragOver _, false)
    }
  }
}

package chandu0101.scalajs.react.components
package demo.components.reactdraggable

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object ReactDraggableInfo {

  val component = ReactComponentB[Unit]("ReactDraggableInfo")
    .render(P => {
   <.div(^.cls := "full-width-section")(
     <.h3("React Draggable :"),
      <.p("Port of " , <.a(^.href := "https://github.com/STRML/react-draggable")("react-draggable")),
     <.h3("CSS :"),
      <.p("Get it ", <.a(^.href := "#css")("here"))
    )
  }).buildU


  def apply() = component()

}

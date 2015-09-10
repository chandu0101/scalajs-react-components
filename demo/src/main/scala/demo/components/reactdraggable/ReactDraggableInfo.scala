package demo
package components
package reactdraggable

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

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

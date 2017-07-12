package demo.components

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

object ReactDraggableInfo {

  val component = ScalaComponent.builder[Unit]("ReactDraggableInfo")
    .render(P =>
      InfoTemplate(componentFilePath = "ReactDraggable.scala")(
        <.div(^.cls := "full-width-section")(
          <.h3("React Draggable :"), <.p(
            "Port of ", <.a(^.href := "https://github.com/STRML/react-draggable")(
              "react-draggable"
            )
          )
        )
      )
    ).build

  def apply() = component()

}

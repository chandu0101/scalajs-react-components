package demo.components

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{RElementPosition, ReactDraggable}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.raw.Event

object ReactDraggableDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    def render =
      <.div(
        ^.cls := "react-draggable-demo",
        <.h2(^.cls := "mui-font-style-headline", "Demo"),
        CodeExample(code, "ReactDraggable")(
          ReactDraggable(zIndex = 100,
                         onStop =
                           (e: Event, pos: RElementPosition) => Callback.info(s"stopped at $pos"))(
            <.div(
              <.h2("Drag me"),
              ^.backgroundColor := "#F2706D",
              ^.padding := "20px",
              ^.width := "200px"
            )
          )
        )
      )
  }

  val component = ReactComponentB[Unit]("ReactDraggableDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

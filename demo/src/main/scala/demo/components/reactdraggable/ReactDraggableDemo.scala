package demo
package components
package reactdraggable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.AsyncLoad
import chandu0101.scalajs.react.components.draggables.{RElementPosition, ReactDraggable}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.raw.Event

object ReactDraggableDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($: BackendScope[Unit, Unit]) extends AsyncLoad {

    override val cssResources = Vector("styles/react-draggable.css")

    def render =
     <.div(^.cls := "react-draggable-demo",
       <.h2(^.cls := "mui-font-style-headline", "Demo"),
        CodeExample(code)(
          ReactDraggable(
            zIndex = 100,
            onStop = (e: Event, pos: RElementPosition) => Callback.info(s"stopped at $pos"))(
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
    .configure(AsyncLoad.mixin)
    .buildU

  // EXAMPLE:END

  def apply() = component()
}

package demo
package components
package reactdraggable

import chandu0101.scalajs.react.components.draggables.ReactDraggable
import chandu0101.scalajs.react.components.icons.{IconName, ReactGeomIcon}
import chandu0101.scalajs.react.components.mixins.AsyncLoad
import chandu0101.scalajs.react.components.models.RElementPosition
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.raw.Event

object ReactDraggableDemo {

  val code =
    """
    |ReactDraggable(
    |  zIndex = 100,
    |  onStop = (e: Event, pos: RElementPosition) => Callback.info(s"stopped at $pos"))(
    |  <.div(
    |    <.h2("Drag me"),
    |    ^.backgroundColor := "#F2706D",
    |    ^.padding := "20px",
    |    ^.width := "200px"
    |  )
    |)
    """.stripMargin

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

  def apply() = component()
}

package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiDialogDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(isOpen: Boolean)

  class Backend($: BackendScope[_, State]) {
    val open = $.setState(State(true))
    val close = $.setState(State(false))

    def handleDialogCancel: ReactEventH => Callback =
      e => close >> Callback.info("Cancel Clicked")

    def handleDialogSubmit: ReactEventH => Callback =
      e => close >> Callback.info("Submit Clicked")

    val openDialog: ReactEventH => Callback =
      e => open >> Callback.info("Opened")

    def render(S: State) = {
      val actions: ReactNode = js.Array(
        MuiFlatButton(key = "1", label = "Cancel", secondary = true, onTouchTap = handleDialogCancel)(),
        MuiFlatButton(key = "2", label = "Submit", secondary = true, onTouchTap = handleDialogSubmit)()
      )
      <.div(
        CodeExample(code, "MuiDialog")(
          <.div(
            MuiDialog(
              title = "Dialog With Actions",
              actions = actions,
              open = S.isOpen,
              onRequestClose = DummyEvents.f1_("onRequestClose")
            )(
              "Dialog example with floating buttons"
            ),
            MuiRaisedButton(label = "Dialog", onTouchTap = openDialog)()
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("MuiDialogDemo")
    .initialState(State(isOpen = false))
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()

}

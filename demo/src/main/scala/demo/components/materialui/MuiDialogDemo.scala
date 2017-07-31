package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiDialogDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(isOpen: Boolean)

  class Backend($ : BackendScope[_, State]) {
    val open  = $.setState(State(true))
    val close = $.setState(State(false))

    def handleDialogCancel: TouchTapEvent => Callback =
      e => close >> Callback.info("Cancel Clicked")

    def handleDialogSubmit: TouchTapEvent => Callback =
      e => close >> Callback.info("Submit Clicked")

    val openDialog: TouchTapEvent => Callback =
      e => open >> Callback.info("Opened")

    def render(S: State) = {
      val actions = VdomArray(
        MuiFlatButton(key = "1",
                      label = "Cancel",
                      secondary = true,
                      onTouchTap = handleDialogCancel)(),
        MuiFlatButton(key = "2",
                      label = "Submit",
                      secondary = true,
                      onTouchTap = handleDialogSubmit)()
      )

      <.div(
        CodeExample(code, "MuiDialog")(
          <.div(
            MuiDialog(
              title = js.defined("Dialog With Actions"),
              actions = actions,
              open = S.isOpen,
              onRequestClose = CallbackDebug.f1("onRequestClose")
            )(
              "Dialog example with floating buttons"
            ),
            MuiRaisedButton(label = "Dialog", onTouchTap = openDialog)()
          )
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Unit]("MuiDialogDemo")
    .initialState(State(isOpen = false))
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()

}

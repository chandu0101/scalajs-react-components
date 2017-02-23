package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiDrawerDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(
    selected: js.UndefOr[String],
    isOpen:   Boolean,
    isDocked: Boolean,
    isRight:  Boolean
  )

  case class Choice(id: String, text: String)

  val choices = Seq(
    Choice("1", "First option"),
    Choice("2", "Second option"),
    Choice("3", "Third option"),
    Choice("4", "Fourth option")
  )

  class Backend($: BackendScope[Unit, State]) {
    val toggleOpenCb: Callback =
      $.modState(s => s.copy(isOpen = !s.isOpen))

    val toggleOpen: (ReactMouseEvent, Boolean) => Callback =
      (e, b) => toggleOpenCb

    val toggleDocked: (ReactMouseEvent, Boolean) => Callback =
      (e, b) => $.modState(s => s.copy(isDocked = !s.isDocked))

    val toggleRight: (ReactMouseEvent, Boolean) => Callback =
      (e, b) => $.modState(s => s.copy(isRight = !s.isRight))

    val onRequestChange: (Boolean, String) => Callback =
      (open, reason) =>
        Callback.info(s"onRequestChange: open: $open, reason: $reason") >>
        toggleOpenCb

    val selectItem: String => TouchTapEvent => Callback =
      id => e => $.modState(s => s.copy(selected = id))

    def render(S: State) = {
      <.div(
        CodeExample(code, "MuiDrawer")(
          <.div(
            MuiDrawer(
              onRequestChange = onRequestChange,
              openSecondary   = S.isRight,
              open            = S.isOpen,
              docked          = S.isDocked)(
              /* hack in a cheesy centered avatar */
              MuiAvatar(
                key             = "avatar",
                size            = 112,
                backgroundColor = Mui.Styles.colors.red400,
                style           = js.Dynamic.literal(
                  margin  = "auto",
                  display = "block",
                  padding = "10px"
                ))(":D"),
              choices map (c =>
                MuiMenuItem(
                  key         = c.id,
                  primaryText = c.text,
                  checked     = S.selected == js.defined(c.id),
                  onTouchTap  = selectItem(c.id)
                )()
              )
            ),

            MuiToggle(
              key      = "toggle1",
              toggled  = S.isOpen,
              label    = "Show drawer",
              onToggle = toggleOpen
            )(),
            MuiToggle(
              key      = "toggle2",
              toggled  = S.isDocked,
              label    = "Show docked",
              onToggle = toggleDocked
            )(),
            MuiToggle(
              key      = "toggle3",
              toggled  = S.isRight,
              label    = "Show on right side",
              onToggle = toggleRight
            )()
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("MuiDrawerDemo")
    .initialState(
      State(
        selected = js.undefined,
        isOpen   = false,
        isDocked = false,
        isRight  = false
      )
    )
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

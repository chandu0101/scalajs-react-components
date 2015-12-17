package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiPopoverDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class OriginChoice[T](ts: Seq[T], label: String)(set: T => Callback, fromState: State => T, str: T => String) {
    val action: (ReactEvent, Int, js.Any) => Callback =
      (e, idx, any) => set(ts(idx))

    val items: js.Array[MuiDropDownMenuItem] =
      ts.map(t => MuiDropDownMenuItem(str(t), str(t))).toJsArray

    def menu(S: State) =
      <.div(
        <.label(label, ^.width := "400px"),
        MuiDropDownMenu(
          menuItems = items,
          onChange = action,
          selectedIndex = items.indexWhere(_.payload == str(fromState(S)))
        )()
      )
  }

  case class State(open: Boolean, target: Origin, anchor: Origin)

  case class Backend($: BackendScope[Unit, State]) {

    val ref = Ref[TopNode]("theRef")

    val show: ReactEvent => Callback =
      e => $.modState(_.copy(open = true))

    val hide: Callback =
      $.modState(_.copy(open = false))

    val anchorH = OriginChoice(MuiPopoverHorizontal.values, "Change anchor horizontal")(
      t => $.modState(s => s.copy(anchor = s.anchor.copy(horizontal = t))), _.anchor.horizontal, _.value
    )
    val anchorV = OriginChoice(MuiPopoverVertical.values, "Change anchor vertical")(
      t => $.modState(s => s.copy(anchor = s.anchor.copy(vertical = t))), _.anchor.vertical, _.value
    )
    val targetH = OriginChoice(MuiPopoverHorizontal.values, "Change target horizontal")(
      t => $.modState(s => s.copy(target = s.target.copy(horizontal = t))), _.target.horizontal, _.value
    )
    val targetV = OriginChoice(MuiPopoverVertical.values, "Change target vertical")(
      t => $.modState(s => s.copy(target = s.target.copy(vertical = t))), _.target.vertical, _.value
    )

    val originChoices = Seq(anchorV, anchorH, targetV, targetH)

    def render(S: State) = {
      <.div(
        CodeExample(code, "MuiPopoverDemo")(
          <.div(
            <.div(
              ^.ref := ref,
              MuiRaisedButton(onClick = show, label = "Click on me to show a popover")()
            ),

            originChoices.map(_.menu(S)),

            MuiPopover(
              open = S.open,
              anchorEl = ref($),
              anchorOrigin = S.anchor,
              targetOrigin = S.target,
              onRequestClose = hide
            )(
              <.div(
                ^.padding := "20px",
                <.h2("here is an arbitrary popover"),
                <.p("Hi - here is some content"),
                MuiRaisedButton(primary = true, label = "here is a button")()
              )
            )
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("MuiPopoverDemo")
    .initialState(State(
      open = false,
      target = Origin(MuiPopoverVertical.top, MuiPopoverHorizontal.left),
      anchor = Origin(MuiPopoverVertical.bottom, MuiPopoverHorizontal.left)
    ))
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()
}

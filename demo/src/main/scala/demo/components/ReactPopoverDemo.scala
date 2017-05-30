package demo.components

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.ReactPopOver
import japgolly.scalajs.react.CtorType.PropsAndChildren
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.MutableRef
import japgolly.scalajs.react.vdom.html_<^._

object ReactPopoverDemo {

  object Style {
    val popoverExample =
      TagMod(^.display := "flex", ^.flexDirection := "column", ^.alignItems := "center")
  }
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class Backend(t: BackendScope[Unit, Unit]) {
    type Ref =
      MutableRef[ReactPopOver.Props, ReactPopOver.State, ReactPopOver.Backend, PropsAndChildren]

    val topRef: Ref    = ScalaComponent.mutableRefTo(ReactPopOver.component)
    val rightRef: Ref  = ScalaComponent.mutableRefTo(ReactPopOver.component)
    val leftRef: Ref   = ScalaComponent.mutableRefTo(ReactPopOver.component)
    val bottomRef: Ref = ScalaComponent.mutableRefTo(ReactPopOver.component)

    def toggleCB(ref: Ref): ReactEventFromHtml => Callback =
      e => ref.value.backend.toggle(e.target)

    def render = {
      <.div(
        <.h3("Demo"),
        CodeExample(code, "ReactPopover")(
          <.div(Style.popoverExample)(
            <.div(^.padding := "20px")(
              topRef.component(ReactPopOver.Props(placement = "top", title = "Top Title"))(
                "I am Top Pop Over"),
              LocalDemoButton(name = "Top Button", onButtonClick = toggleCB(topRef))
            ),
            <.div(^.padding := "20px")(
              leftRef.component(ReactPopOver.Props(placement = "left", title = "Left Title"))(
                "I am Left Popover"),
              LocalDemoButton(name = "Left Button", onButtonClick = toggleCB(leftRef))
            ),
            <.div(^.padding := "20px")(
              rightRef.component(ReactPopOver.Props(placement = "right", title = "Right Title"))(
                "I am right Popover"),
              LocalDemoButton(name = "Right Button", onButtonClick = toggleCB(rightRef))
            ),
            <.div(^.padding := "20px")(
              bottomRef.component(
                ReactPopOver.Props(placement = "bottom", title = "Bottom Title"))(
                "I am bottom Popover"),
              LocalDemoButton(name = "Bottom Button", onButtonClick = toggleCB(bottomRef))
            )
          )
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Unit]("ReactPopoverDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

package demo
package components
package reacttagsinput

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{ReactTagsInputM, ReactTagsInput, RefHolder}
import demo.components.materialui.DummyEvents
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object ReactTagsInputDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(tags: js.Array[String] = js.Array("scala", "scalajs"))

  class Backend(t: BackendScope[_, State]) {
    val ref = RefHolder[ReactTagsInputM]

    val onChange: (js.Array[String]) => Callback =
      tags => t.modState(_.copy(tags = tags)) >> Callback.info(s"New state: $tags")

    def render(S: State) =
      <.div(
        CodeExample(code, "Demo")(
          <.div(
            ReactTagsInput(
              value         = S.tags,
              onChange      = onChange,
              onBlur        = DummyEvents.f0("onBlur"),
              onKeyDown     = DummyEvents.f1("onKeyDown"),
              onKeyUp       = DummyEvents.f1("onKeyUp")
            )()
          )
        )
      )

  }

  val component = ReactComponentB[Unit]("ReactTagsInputDemo")
    .initialState(State())
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()
}

package demo
package components
package reacttagsinput

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.RefHolder
import chandu0101.scalajs.react.components.textfields.{ReactTagsInput, ReactTagsInputM}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object ReactTagsInputDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(tags: js.Array[String] = js.Array("scala", "scalajs"))

  class Backend(t: BackendScope[_, State]) {
    val ref = RefHolder[ReactTagsInputM]

    val onChange: (js.Array[String], String) => Callback =
      (tags, tag) =>
        t.modState(_.copy(tags = tags)) >>
          Callback.info(s"Final Tags: $tags, Added/Removed Tag: $tag")

    def render(S: State) = {
      <.div(
        CodeExample(code, "Demo")(
          <.div(
            <.h4("Uncontrolled: "),
            ReactTagsInput(ref = ref.set)()
          ),
          <.div(
            <.h4("Controlled: "),
            ReactTagsInput(value = S.tags, onChange = onChange)()
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("ReactTagsInputDemo")
    .initialState(State())
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()
}

package demo
package components
package reacttagsinput

import chandu0101.scalajs.react.components.textfields.ReactTagsInput
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js.{Array => JArray}

object ReactTagsInputDemo {

  val code =
    """
      | ReactTagsInput(ref = "uncontrolledtags")
      | ReactTagsInput(value = S.tags,onChange = B.onChange _)
      |
    """.stripMargin

  case class State(tags: JArray[String] = JArray("scala", "scalajs"))

  class Backend(t: BackendScope[_, State]) {

    def onChange(tags: JArray[String], tag: String): Callback =
      t.modState(_.copy(tags = tags)) >>
      Callback.info(s"Final Tags: $tags, Added/Removed Tag: $tag")

    def render(S: State) = {
      <.div(
        CodeExample(code, "Demo")(
          <.div(
            <.h4("Uncontrolled: "),
            ReactTagsInput(ref = "uncontrolledtags")()
          ),
          <.div(
            <.h4("Controlled: "),
            ReactTagsInput(value = S.tags, onChange = onChange _)()
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("ReactTagsInputDemo")
    .initialState(State())
    .renderBackend[Backend]
    .buildU

  def apply() = component()

}

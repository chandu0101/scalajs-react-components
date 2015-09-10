package chandu0101.scalajs.react.components
package demo.components.reacttagsinput

import chandu0101.scalajs.react.components.demo.components.CodeExample
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

    def onChange(tags: JArray[String], tag: String) = {
      t.modState(_.copy(tags = tags))
      println(s" Final Tags : ${tags} , Added/Removed Tag : ${tag}")
    }

  }


  val component = ReactComponentB[Unit]("ReactTagsInputDemo")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(
      CodeExample(code, "Demo")(
        <.div(
          <.h4("Uncontrolled : "),
          ReactTagsInput(ref = "uncontrolledtags")()
        ),
        <.div(
          <.h4("Controlled : "),
          ReactTagsInput(value = S.tags, onChange = B.onChange _)()
        )
      )
    )
  }).buildU

  def apply() = component()

}

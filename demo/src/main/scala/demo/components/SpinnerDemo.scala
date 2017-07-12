package demo.components

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.Spinner
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js.{Array => JArray}

object SpinnerDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ScalaComponent.builder[Unit]("SpinnerDemo")
    .render(P =>
      <.div(
        CodeExample(code, "Demo")(
          <.div(^.width := "100px", ^.height := "100px", ^.backgroundColor := "grey",
            Spinner()()
          )
        )
      )
    ).build

  // EXAMPLE:END

  def apply() = component()

}

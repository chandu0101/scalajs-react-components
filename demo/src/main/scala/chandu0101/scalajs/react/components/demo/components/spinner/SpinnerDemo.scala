package chandu0101.scalajs.react.components
package demo.components.spinner

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.spinners.Spinner
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js.{Array => JArray}


object SpinnerDemo {

  val code =
    """
      | <.div( ^.width := "100px", ^.height := "100px" ,^.backgroundColor := "grey",
      |          Spinner()
      |        )
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("SpinnerDemo")
    .render((P) => {
    <.div(
      CodeExample(code, "Demo")(
        <.div( ^.width := "100px", ^.height := "100px" ,^.backgroundColor := "grey",
          Spinner()()
        )
      )
    )
  }).buildU

  def apply() = component()

}

package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiProgressDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  val component = ReactComponentB[Unit]("MuiProgressDemo")
    .render(P => {
      <.div(
        CodeExample(code, "Progress Bars")(
          MuiCircularProgress(mode = DeterminateIndeterminate.determinate, value = 50.0)(),
          MuiCircularProgress(mode = DeterminateIndeterminate.indeterminate, size = 0.5)(),
          MuiCircularProgress(mode = DeterminateIndeterminate.indeterminate)(),
          MuiCircularProgress(mode = DeterminateIndeterminate.indeterminate, size = 2.0)(),
          MuiLinearProgress(mode = DeterminateIndeterminate.indeterminate)()
        )
      )
    })
    .build
  // EXAMPLE:END

  def apply() = component()
}

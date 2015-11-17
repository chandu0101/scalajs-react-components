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
          MuiCircularProgress(mode = MuiCircularProgressMode.DETERMINATE, value = 50)(),
          MuiCircularProgress(mode = MuiCircularProgressMode.INDETERMINATE)(),
          MuiCircularProgress(mode = MuiCircularProgressMode.INDETERMINATE, size = 2)(),
          MuiLinearProgress(mode = MuiLinearProgressMode.INDETERMINATE, size = 2)()
        )
      )
    }).buildU
  // EXAMPLE:END

  def apply() = component()
}

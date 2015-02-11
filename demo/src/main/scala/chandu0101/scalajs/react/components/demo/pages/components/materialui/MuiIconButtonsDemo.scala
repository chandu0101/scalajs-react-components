package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.MuiIconButton
import chandu0101.scalajs.react.components.materialui.svgicons.MuiActionGrade
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object MuiIconButtonsDemo {

  val code =
    """
      |MuiIconButton(icon = "action-grade"),
      |MuiIconButton(icon = "action-grade" , disabled = true)
      |
    """.stripMargin

  val component = ReactComponentB[Unit]("MuiIconButtonsDemo")
    .render(P => {
      div(
       h3("Icon Buttons"),
       CodeExample(code)(
        MuiIconButton.withChildren(tooltip = "Yay")(MuiActionGrade()),
        MuiIconButton.withChildren(disabled = true)(MuiActionGrade())
       )
      )
    }).buildU

  def apply() = component()

}

package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import demo.components.materialui.svgicons.ActionGrade
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline

object MuiButtonsDemo {

  val code = GhPagesMacros.exampleSource

  object Style extends Inline {

    import dsl._

    val container = style(maxWidth(1024 px))

    val content = style(display.flex,
      padding(30.px),
      flexDirection.column,
      alignItems.center)
  }

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiButtonsDemo")
    .render(P =>
      CodeExample(code)(
        <.div(Style.container,
          <.h3("Buttons"),
          MuiTabs()(
            MuiTab(label = "Flat Buttons")(
              <.div(Style.content,
                MuiFlatButton(label = "Default")(),
                MuiFlatButton(label = "Primary", primary = true)(),
                MuiFlatButton(label = "Secondary", secondary = true)(),
                MuiFlatButton(label = "Disabled", disabled = true)()
              )
            ),
            MuiTab(label = "Raised Buttons")(
              <.div(Style.content,
                MuiRaisedButton(label = "Default")(),
                MuiRaisedButton(label = "Primary", primary = true)(),
                MuiRaisedButton(label = "Secondary", secondary = true)(),
                MuiRaisedButton(label = "Disabled", disabled = true)()
              )
            ),
          MuiTab(label = "Floating Action Buttons")(
            <.div(Style.content,
              MuiFloatingActionButton()(ActionGrade()),
              MuiFloatingActionButton(mini = true)(ActionGrade()),
              MuiFloatingActionButton(secondary = true)(ActionGrade()),
              MuiFloatingActionButton(secondary = true, mini = true)(ActionGrade())
            )
          )
        )
      )
    )
  ).buildU

  // EXAMPLE:END

  def apply() = component()

}

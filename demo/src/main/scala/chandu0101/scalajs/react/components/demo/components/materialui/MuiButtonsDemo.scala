package chandu0101.scalajs.react.components.demo.components.materialui

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline

object MuiButtonsDemo {

  val code =
    """
      | MuiAppBar(title = "Title")()
      |
    """.stripMargin

  val flatButtonCode =
    """
      |MuiFlatButton(label = "Default")(),
      |MuiFlatButton(label = "Primary",primary = true)(),
      |MuiFlatButton(label = "Secondary", secondary = true)(),
      |MuiFlatButton(label = "Disabled", disabled = true)()
      |
    """.stripMargin

  val raisedButtonCode =
    """
      |MuiRaisedButton(label = "Default")(),
      |MuiRaisedButton(label = "Primary",primary = true)(),
      |MuiRaisedButton(label = "Secondary", secondary = true)(),
      |MuiRaisedButton(label = "Disabled", disabled = true)()
      |
    """.stripMargin

  val floatingButtonsCOde =
    """
      |MuiFloatingActionButton(iconClassName = "muidocs-icon-action-grade")(),
      |MuiFloatingActionButton(iconClassName = "muidocs-icon-action-grade",mini = true)(),
      |MuiFloatingActionButton(iconClassName = "muidocs-icon-action-grade",secondary = true)(),
      |MuiFloatingActionButton(iconClassName = "muidocs-icon-action-grade",secondary = true,mini = true)()
      |
    """.stripMargin

  object Style extends Inline {

    import dsl._

    val container = style(maxWidth(1024 px))


    val content = style(display.flex,
      padding(30.px),
      flexDirection.column,
      alignItems.center)
  }


  val component = ReactComponentB[Unit]("MuiAppBarDemo")
    .render(P => {
    <.div(Style.container,
      <.h3("Buttons"),
      MuiTabs()(
        MuiTab(label = "Flat Buttons")(
          CodeExample(flatButtonCode)(
            <.div(Style.content,
              MuiFlatButton(label = "Default")(),
              MuiFlatButton(label = "Primary", primary = true)(),
              MuiFlatButton(label = "Secondary", secondary = true)(),
              MuiFlatButton(label = "Disabled", disabled = true)()
            )
          )
        ),
        MuiTab(label = "Raised Buttons")(
          CodeExample(raisedButtonCode)(
            <.div(Style.content,
              MuiRaisedButton(label = "Default")(),
              MuiRaisedButton(label = "Primary", primary = true)(),
              MuiRaisedButton(label = "Secondary", secondary = true)(),
              MuiRaisedButton(label = "Disabled", disabled = true)()
            )
          )
        ),
        MuiTab(label = "Floating Action Buttons")(
          CodeExample(floatingButtonsCOde)(
            <.div(Style.content,
              MuiFloatingActionButton(iconClassName = "muidocs-icon-action-grade")("+"),
              MuiFloatingActionButton(iconClassName = "muidocs-icon-action-grade",mini = true)(),
              MuiFloatingActionButton(iconClassName = "muidocs-icon-action-grade",secondary = true)(),
              MuiFloatingActionButton(iconClassName = "muidocs-icon-action-grade",secondary = true,mini = true)()
            )
          )
        )
      )
    )
  }).buildU


  def apply() = component()


}

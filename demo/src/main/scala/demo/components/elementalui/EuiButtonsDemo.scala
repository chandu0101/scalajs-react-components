package demo
package components
package elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui.{DropdownMenuItem, DropdownMenuItemType, _}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object EuiButtonsDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[_, _]) {
    val renderButtonSizes =
      <.div(
        Button(size = ButtonSize.LG)("Large"),
        Button()("Default"),
        Button(size = ButtonSize.SM)("Small"),
        Button(size = ButtonSize.XS)("Extra Small")
      )

    def renderButtonVariants(list: (ButtonType, String)*) =
      <.div(
        list.map(t => Button(`type` = t._1)(t._2): TagMod): _*
      )

    def render: VdomElement =
      CodeExample(code, "EuiButtons")(
        <.div(
          <.h1("Buttons"),
          <.h2("Sizes"),
          renderButtonSizes,
          <.h2("Fill Buttons"),
          renderButtonVariants(
            (ButtonType.PRIMARY, "Primary"),
            (ButtonType.SUCCESS, "Success"),
            (ButtonType.WARNING, "Warning"),
            (ButtonType.DANGER, "Danger")
          ),
          <.h2("Default Button Alternatives"),
          renderButtonVariants(
            (ButtonType.DEFAULT_PRIMARY, "Primary"),
            (ButtonType.DEFAULT_SUCCESS, "Success"),
            (ButtonType.DEFAULT_WARNING, "Warning"),
            (ButtonType.DEFAULT_DANGER, "Danger")
          ),
          <.h2("Hollow Button Alternatives"),
          renderButtonVariants(
            (ButtonType.HOLLOW_PRIMARY, "Primary"),
            (ButtonType.HOLLOW_SUCCESS, "Success"),
            (ButtonType.HOLLOW_WARNING, "Warning"),
            (ButtonType.HOLLOW_DANGER, "Danger")
          ),
          <.h2("Link Style Buttons"),
          renderButtonVariants(
            (ButtonType.LINK, "Link"),
            (ButtonType.LINK_CANCEL, "Cancel"),
            (ButtonType.LINK_DELETE, "Delete"),
            (ButtonType.LINK_TEXT, "Text")
          ),
          <.h2("Button Groups"),
          ButtonGroup()(
            Button()("Left"),
            Button()("Middle"),
            Button()("Right")
          ),
          <.h2("Dropdown"),
          Dropdown(
            buttonLabel = "Default Trigger",
            items = js.Array(
              DropdownMenuItem(label = "Action"),
              DropdownMenuItem(label = "Another Action"),
              DropdownMenuItem(`type` = DropdownMenuItemType.DIVIDER),
              DropdownMenuItem(label = "Header", `type` = DropdownMenuItemType.HEADER),
              DropdownMenuItem(label = "Action")
            )
          )(),
          <.h3("Custom Trigger"),
          Dropdown(
            items = js.Array(
              DropdownMenuItem(label = "Action"),
              DropdownMenuItem(label = "Another Action"),
              DropdownMenuItem(`type` = DropdownMenuItemType.DIVIDER),
              DropdownMenuItem(label = "Header", `type` = DropdownMenuItemType.HEADER),
              DropdownMenuItem(label = "Action")
            ))(<.h3("I am an H3!!!"))
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("EuiButtonsDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

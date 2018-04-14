package demo
package components
package elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object EuiButtonsDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {
    val renderButtonSizes =
      <.div(
        EuiButton(size = ButtonSize.lg)("Large"),
        EuiButton()("Default"),
        EuiButton(size = ButtonSize.sm)("Small"),
        EuiButton(size = ButtonSize.xs)("Extra Small")
      )

    def renderButtonVariants(list: (ButtonType, String)*) =
      <.div(
        list.map(t => EuiButton(`type` = t._1)(t._2)).toTagMod
      )

    def render =
      CodeExample(code, "EuiButtons")(
        <.div(
          <.h1("Buttons"),
          <.h2("Sizes"),
          renderButtonSizes,
          <.h2("Fill Buttons"),
          renderButtonVariants(
            (ButtonType.primary, "Primary"),
            (ButtonType.success, "Success"),
            (ButtonType.warning, "Warning"),
            (ButtonType.danger, "Danger")
          ),
          <.h2("Default Button Alternatives"),
          renderButtonVariants(
            (ButtonType.default_primary, "Primary"),
            (ButtonType.default_success, "Success"),
            (ButtonType.default_warning, "Warning"),
            (ButtonType.default_danger, "Danger")
          ),
          <.h2("Hollow Button Alternatives"),
          renderButtonVariants(
            (ButtonType.hollow_primary, "Primary"),
            (ButtonType.hollow_success, "Success"),
            (ButtonType.hollow_warning, "Warning"),
            (ButtonType.hollow_danger, "Danger")
          ),
          <.h2("Link Style Buttons"),
          renderButtonVariants(
            (ButtonType.link, "Link"),
            (ButtonType.link_cancel, "Cancel"),
            (ButtonType.link_delete, "Delete"),
            (ButtonType.link_text, "Text")
          ),
          <.h2("Button Groups"),
          EuiButtonGroup()(
            EuiButton()("Left"),
            EuiButton()("Middle"),
            EuiButton()("Right")
          ),
          <.h2("Dropdown"),
          EuiDropdown(
            buttonLabel = "Default Trigger",
            items = js.Array(
              EuiDropdownMenuItem(label = "Action"),
              EuiDropdownMenuItem(label = "Another Action"),
              EuiDropdownMenuItem(`type` = EuiDropdownMenuItemType.DIVIDER),
              EuiDropdownMenuItem(label = "Header", `type` = EuiDropdownMenuItemType.HEADER),
              EuiDropdownMenuItem(label = "Action")
            )
          )(),
          <.h3("Custom Trigger"),
          EuiDropdown(
            items = js.Array(
              EuiDropdownMenuItem(label = "Action"),
              EuiDropdownMenuItem(label = "Another Action"),
              EuiDropdownMenuItem(`type` = EuiDropdownMenuItemType.DIVIDER),
              EuiDropdownMenuItem(label = "Header", `type` = EuiDropdownMenuItemType.HEADER),
              EuiDropdownMenuItem(label = "Action")
            )
          )(<.h3("I am an H3!!!"))
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

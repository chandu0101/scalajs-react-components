package demo
package components
package elementalui

import chandu0101.scalajs.react.components.elementalui._
import demo.components.materialui.svgicons.ActionGrade
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline
import scala.scalajs.js.{ Array ⇒ JArray }
import chandu0101.scalajs.react.components.elementalui.DropdownMenuItem
import chandu0101.scalajs.react.components.elementalui.DropdownMenuItemType

object EuiButtonsDemo {

  val renderButtonSizes = {
    <.div(
      Button(size = ButtonSize.LG)("Large"),
      Button()("Default"),
      Button(size = ButtonSize.SM)("Small"),
      Button(size = ButtonSize.XS)("Extra Small"))
  }
  def renderButtonVariants(list: List[(ButtonType, String)]) = {

    <.div(
      list.map(t ⇒ Button(`type` = t._1)(t._2)))
  }

  val component = ReactComponentB[Unit]("EuiButtonsDemo")
    .render(P ⇒ {
      <.div(
        <.h1("Buttons"),
        <.h2("Sizes"),
        renderButtonSizes,
        <.h2("Fill Buttons"),
        renderButtonVariants(List((ButtonType.PRIMARY, "Primary"), (ButtonType.SUCCESS, "Success"), (ButtonType.WARNING, "Warning"), (ButtonType.DANGER, "Danger"))),
        <.h2("Default Button Alternatives"),
        renderButtonVariants(List((ButtonType.DEFAULT_PRIMARY, "Primary"), (ButtonType.DEFAULT_SUCCESS, "Success"), (ButtonType.DEFAULT_WARNING, "Warning"), (ButtonType.DEFAULT_DANGER, "Danger"))),
        <.h2("Hollow Button Alternatives"),
        renderButtonVariants(List((ButtonType.HOLLOW_PRIMARY, "Primary"), (ButtonType.HOLLOW_SUCCESS, "Success"), (ButtonType.HOLLOW_WARNING, "Warning"), (ButtonType.HOLLOW_DANGER, "Danger"))),
        <.h2("Link Style Buttons"),
        renderButtonVariants(List((ButtonType.LINK, "Link"), (ButtonType.LINK_CANCEL, "Cancel"), (ButtonType.LINK_DELETE, "Delete"), (ButtonType.LINK_TEXT, "Text"))),
        <.h2("Button Groups"),
        ButtonGroup()(Button()("Left"), Button()("Middle"), Button()("Right")),
        <.h2("Dropdown"),
        Dropdown(buttonLabel = "Default Trigger",
          items = JArray(
            DropdownMenuItem(label = "Action"),
            DropdownMenuItem(label = "Another Action"),
            DropdownMenuItem(`type` = DropdownMenuItemType.DIVIDER),
            DropdownMenuItem(label = "Header", `type` = DropdownMenuItemType.HEADER),
            DropdownMenuItem(label = "Action")))(),
        <.h3("Custom Trigger"),
        Dropdown(
          items = JArray(
            DropdownMenuItem(label = "Action"),
            DropdownMenuItem(label = "Another Action"),
            DropdownMenuItem(`type` = DropdownMenuItemType.DIVIDER),
            DropdownMenuItem(label = "Header", `type` = DropdownMenuItemType.HEADER),
            DropdownMenuItem(label = "Action")))(<.h3("I am an H3!!!")))
    }).buildU

  def apply() = component()

}

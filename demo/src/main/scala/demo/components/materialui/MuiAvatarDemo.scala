package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiAvatarDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  import Mui.Styles.colors
  import Mui.SvgIcons

  val component = ScalaComponent
    .builder[Unit]("MuiAvatarDemo")
    .renderStatic(
      <.div(
        CodeExample(code, "MuiAvatar")(
          MuiAvatar(
            key = "1",
            backgroundColor = colors.grey700,
            color = colors.deepPurple200,
            icon = js.defined(SvgIcons.ActionGrade()())
          )(),
          MuiAvatar(key = "2", size = js.defined(120), backgroundColor = colors.lime600)(
            js.defined("Ø")),
          MuiAvatar(key = "3")(js.defined("one")),
          MuiAvatar(key = "4")(js.defined("two")),
          MuiAvatar(key = "5", backgroundColor = colors.red400)(
            js.defined(SvgIcons.ActionFace()()))
        )
      )
    )
    .build

  // EXAMPLE:END

  def apply() = component()
}

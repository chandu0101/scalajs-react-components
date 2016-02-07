package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiAvatarDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  import Mui.Styles.Colors
  import Mui.SvgIcons

  val component = ReactComponentB[Unit]("MuiAvatarDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiAvatar")(
            MuiAvatar(backgroundColor = Colors.grey700, color = Colors.deepPurple200, icon = SvgIcons.ActionGrade()())(),
            MuiAvatar(size = 120, backgroundColor = Colors.lime600)("Ø"),
            MuiAvatar()("one"),
            MuiAvatar()("two"),
            MuiAvatar(backgroundColor = Colors.red400)(SvgIcons.ActionFace()())
        )
      )
    }).buildU

  // EXAMPLE:END

  def apply() = component()
}

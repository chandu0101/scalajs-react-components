package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

object MuiAvatarDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  import Mui.Styles.colors
  import Mui.SvgIcons
  import MuiSvgIcon.SvgIconApply

  val component = ScalaComponent
    .builder[Unit]("MuiAvatarDemo")
    .render(P => {
      val actionGradeIcon: VdomElement = SvgIcons.ActionGrade()()
      val actionFaceIcon: VdomElement  = SvgIcons.ActionFace()()
      <.div(
        CodeExample(code, "MuiAvatar")(
          MuiAvatar(key = "1",
                    backgroundColor = colors.grey700,
                    color = colors.deepPurple200,
                    icon = actionGradeIcon)(),
          MuiAvatar(key = "2", size = 120, backgroundColor = colors.lime600)("Ø": VdomNode),
          MuiAvatar(key = "3")("one": VdomNode),
          MuiAvatar(key = "4")("two": VdomNode),
          MuiAvatar(key = "5", backgroundColor = colors.red400)(actionFaceIcon)
        )
      )
    })
    .build

  // EXAMPLE:END

  def apply() = component()
}

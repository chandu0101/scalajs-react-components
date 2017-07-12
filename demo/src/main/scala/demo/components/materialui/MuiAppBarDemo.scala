package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object MuiAppBarDemo {

  val code = GhPagesMacros.exampleSource
  // EXAMPLE:START

  val component = ScalaComponent
    .builder[Unit]("MuiAppBarDemo")
    .render { _ =>
      <.div(
        CodeExample(code, "MuiAppBar")(
          MuiAppBar(
            title = "Title",
            onLeftIconButtonTouchTap = CallbackDebug.f1("onLeftIconButtonTouchTap"),
            onRightIconButtonTouchTap = CallbackDebug.f1("onRightIconButtonTouchTap"),
            onTitleTouchTap = CallbackDebug.f1("onTitleTouchTap"),
            showMenuIconButton = true
          )()
        )
      )
    }
    .build

  // EXAMPLE:END

  def apply() = component()
}

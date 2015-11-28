package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiAppBarDemo {

  val code = GhPagesMacros.exampleSource
  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiAppBarDemo")
    .render(P =>
      <.div(
        CodeExample(code, "MuiAppBar")(
          MuiAppBar(
            title = "Title",
            onLeftIconButtonTouchTap  = DemoEvents.f1("onLeftIconButtonTouchTap"),
            onRightIconButtonTouchTap = DemoEvents.f1("onRightIconButtonTouchTap"),
            onTitleTouchTap           = DemoEvents.f1("onTitleTouchTap"),
            showMenuIconButton = true
          )()
        )
      )
    ).buildU

  // EXAMPLE:END

  def apply() = component()
}

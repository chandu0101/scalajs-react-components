package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiAppBarDemo {

  val code = GhPagesMacros.exampleSource
  // EXAMPLE:START

  val component = ScalaComponent
    .builder[Unit]("MuiAppBarDemo")
    .render(
      P =>
        <.div(
          CodeExample(code, "MuiAppBar")(
            MuiAppBar(
              title = js.defined("Title"),
              onLeftIconButtonClick = CallbackDebug.f1("onLeftIconButtonClick"),
              onRightIconButtonClick = CallbackDebug.f1("onRightIconButtonClick"),
              onTitleClick = CallbackDebug.f1("onTitleClick"),
              showMenuIconButton = true
            )()
          )
      ))
    .build

  // EXAMPLE:END

  def apply() = component()
}

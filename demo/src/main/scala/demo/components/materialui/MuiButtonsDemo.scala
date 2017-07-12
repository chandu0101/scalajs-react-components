package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ScalaCssReact._

object MuiButtonsDemo {

  val cssSettings = scalacss.devOrProdDefaults
  import cssSettings._

  val code = GhPagesMacros.exampleSource

  object Style extends StyleSheet.Inline {

    import dsl._

    val container = style(maxWidth(1024 px))

    val content = style(display.flex,
      padding(30.px),
      flexDirection.column,
      alignItems.center)
  }

  // EXAMPLE:START
  import Mui.SvgIcons.ActionGrade
  import MuiSvgIcon.SvgIconApply
  val component = ScalaComponent.builder[Unit]("MuiButtonsDemo")
    .render { _ =>
      CodeExample(code, "MuiButtons")(
        <.div(Style.container,
          <.h3("Buttons"),
          MuiTabs()(
            MuiTab(key = "tab1", label = "Flat Buttons")(
              <.div(Style.content,
                MuiFlatButton(key = "flat1", label = "Default",
                  onBlur          = CallbackDebug.f1("onBlur"),
                  onFocus         = CallbackDebug.f1("onFocus"),
                  onKeyboardFocus = CallbackDebug.f2("onKeyboardFocus"),
                  onKeyDown       = CallbackDebug.f1("onKeyDown"),
                  onKeyUp         = CallbackDebug.f1("onKeyUp"),
                  onTouchTap      = CallbackDebug.f1("onTouchTap"),
                  onMouseLeave    = CallbackDebug.f1("onMouseLeave"),
                  onTouchStart    = CallbackDebug.f1("onTouchStart"),
                  onMouseEnter    = CallbackDebug.f1("onMouseEnter"))(),
                MuiFlatButton(key = "flat2", label = "Primary", primary = true)(),
                MuiFlatButton(key = "flat3", label = "Secondary", secondary = true)(),
                MuiFlatButton(key = "flat4", label = "Disabled", disabled = true)()
              )
            ),
            MuiTab(key = "tab2", label = "Raised Buttons")(
              <.div(Style.content,
                MuiRaisedButton(key = "raised1", label = "Default")(),
                MuiRaisedButton(key = "raised2", label = "Primary", primary = true)(),
                MuiRaisedButton(key = "raised3", label = "Secondary", secondary = true)(),
                MuiRaisedButton(key = "raised4", label = "Disabled", disabled = true)()
              )
            ),
          MuiTab(key = "tab3", label = "Floating Action Buttons")(
            <.div(Style.content,
              MuiFloatingActionButton(key = "floating1")(ActionGrade()()),
              MuiFloatingActionButton(key = "floating2", mini = true)(ActionGrade()()),
              MuiFloatingActionButton(key = "floating3", secondary = true)(ActionGrade()()),
              MuiFloatingActionButton(key = "floating4", secondary = true, mini = true)(ActionGrade()())
            )
          ),
          MuiTab(key = "tab4", label = "Icon Buttons")(
            <.div(Style.content,
              MuiIconButton(onTouchTap = CallbackDebug.f1("onTouchTap"))(ActionGrade()())
            )
          )
        )
      )
    )
  }.build

  // EXAMPLE:END

  def apply() = component()
}

package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.Dynamic

object MuiThemeProviderDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(
    baseTheme: MuiRawTheme,
    backgroundColor: js.UndefOr[MuiColor]){

    val theme: MuiTheme =
      Mui.Styles.getMuiTheme(backgroundColor.fold(baseTheme)(
        color ⇒ baseTheme.copy(palette = baseTheme.palette.copy(canvasColor = color)))
      )
  }

  case class Backend($: BackendScope[Unit, State]){

    def pickColor(s: String): MuiColor =
      Mui.Styles.colors.asInstanceOf[Dynamic].selectDynamic(s).asInstanceOf[MuiColor]

    val colors: Seq[(String, MuiColor)] =
      js.Object.keys(Mui.Styles.colors).map {
        key ⇒ key → pickColor(key)
      }

    val onThemeChanged: (ReactEvent, Int, MuiRawTheme) ⇒ Callback =
      (e, idx, theme) ⇒ $.setState(State(theme, js.undefined))

    val onColorChanged: (ReactEvent, Int, MuiColor) ⇒ Callback =
      (e, idx, color) ⇒ $.modState(_.copy(backgroundColor = color))

    def render(S: State): VdomElement = {
      <.div(
        CodeExample(code, "MuiThemeProvider")(
          MuiMuiThemeProvider(muiTheme = S.theme)(
            MuiPaper()(
              <.h3("Pick base theme"),
              MuiDropDownMenu[MuiRawTheme](key = "themeDropdown", value = S.baseTheme, onChange = onThemeChanged)(
                MuiMenuItem[MuiRawTheme](key = "LightRawTheme", primaryText = "LightRawTheme", value = Mui.Styles.LightRawTheme)(),
                MuiMenuItem[MuiRawTheme](key = "DarkRawTheme",  primaryText = "DarkRawTheme",  value = Mui.Styles.DarkRawTheme )()
              ),
              <.h3("Override theme canvas color"),
              MuiDropDownMenu[MuiColor](
                key      = "colorDropdown",
                onChange = onColorChanged,
                value    = S.backgroundColor)(
                colors.map{
                  case (name, color) ⇒
                    MuiMenuItem[MuiColor](key = name, primaryText = name, value = color, style = js.Dynamic.literal(backgroundColor = color))()
                }.toVdomArray
              )
            )
          )
        )
      )
    }
  }

  private val component =
    ScalaComponent.builder[Unit]("MuiThemeProviderDemo")
      .initialState(State(Mui.Styles.LightRawTheme, js.undefined))
      .renderBackend[Backend]
      .build

  // EXAMPLE:END

  def apply(): VdomElement =
    component()
}

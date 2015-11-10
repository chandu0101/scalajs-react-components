package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._

import scala.scalajs.js

@js.native
trait MuiColor extends js.Object

@js.native
trait MuiStyles extends js.Object {
  val AutoPrefix:     js.Dynamic     = js.native
  val Colors:         MuiColors      = js.native
  val Spacing:        js.Dynamic     = js.native
  val ThemeManager:   ThemeManager   = js.native
  val Typography:     js.Dynamic     = js.native
  val Transitions:    js.Dynamic     = js.native
  val DarkRawTheme:   MuiRawTheme    = js.native
  val LightRawTheme:  MuiRawTheme    = js.native
}

@js.native
trait MuiSpacings extends js.Object {
  val iconSize:                      Int = js.native
  val desktopGutter:                 Int = js.native
  val desktopGutterMore:             Int = js.native
  val desktopGutterLess:             Int = js.native
  val desktopGutterMini:             Int = js.native
  val desktopKeylineIncrement:       Int = js.native
  val desktopDropDownMenuItemHeight: Int = js.native
  val desktopDropDownMenuFontSize:   Int = js.native
  val desktopLeftNavMenuItemHeight:  Int = js.native
  val desktopSubheaderHeight:        Int = js.native
  val desktopToolbarHeight:          Int = js.native
}

@js.native
trait MuiPalette extends js.Object {
  val primary1Color:      MuiColor = js.native
  val primary2Color:      MuiColor = js.native
  val primary3Color:      MuiColor = js.native
  val accent1Color:       MuiColor = js.native
  val accent2Color:       MuiColor = js.native
  val accent3Color:       MuiColor = js.native
  val textColor:          MuiColor = js.native
  val alternateTextColor: MuiColor = js.native
  val canvasColor:        MuiColor = js.native
  val borderColor:        MuiColor = js.native
  val disabledColor:      MuiColor = js.native
}

@js.native
trait MuiRawTheme extends js.Object {
  val spacing:    MuiSpacings = js.native
  val fontFamily: String      = js.native
  val palette:    MuiPalette  = js.native
}

@js.native
trait MuiTheme extends js.Object

@js.native
trait ThemeManager extends js.Object {
  def getMuiTheme(r: MuiRawTheme):                                           MuiTheme  = js.native
  def modifyRawThemeSpacing(muiTheme: MuiTheme, newSpacing: Int):            MuiTheme  = js.native
  def modifyRawThemePalette(muiTheme: MuiTheme, newPaletteKeys: js.Dynamic): MuiTheme  = js.native
  def modifyRawThemeFontFamily(muiTheme: MuiTheme, newFontFamily: String):   MuiTheme  = js.native
}

@js.native
trait ThemeDecorator extends js.Object {
  def getMuiTheme(r: MuiRawTheme):                                           MuiTheme  = js.native
  def modifyRawThemeSpacing(muiTheme: MuiTheme, newSpacing: Int):            MuiTheme  = js.native
  def modifyRawThemePalette(muiTheme: MuiTheme, newPaletteKeys: js.Dynamic): MuiTheme  = js.native
  def modifyRawThemeFontFamily(muiTheme: MuiTheme, newFontFamily: String):   MuiTheme  = js.native
}

object ThemeInstaller{
  def installMuiContext[P, S, B, N <: TopNode](rawTheme: MuiRawTheme = Mui.Styles.LightRawTheme): ReactComponentSpec[P, S, B, N] => Callback =
    spec => Callback {
      val theme = Mui.Styles.ThemeManager.getMuiTheme(rawTheme)
      val t = spec.asInstanceOf[js.Dynamic]
      t.updateDynamic("childContextTypes")(js.Dynamic.literal("muiTheme" -> React.asInstanceOf[js.Dynamic].PropTypes.`object`): js.Object)
      t.updateDynamic("getChildContext")(((any: js.Object) => {println(any);js.Dynamic.literal("muiTheme" -> theme)}): js.Function)
    }
}
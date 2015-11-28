package chandu0101.scalajs.react.components

import japgolly.scalajs.react.{Callback, React, ReactComponentSpec, TopNode}
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

package object materialui {

  @js.native @JSName("mui")
  object Mui extends js.Object {

    val AppBar: js.Dynamic = js.native
    val AppCanvas: js.Dynamic = js.native
    val Checkbox: js.Dynamic = js.native
    val CircularProgress: js.Dynamic = js.native
    val ClearFix: js.Dynamic = js.native
    val BeforeAfterWrapper: js.Dynamic = js.native
    val DatePicker: js.Dynamic = js.native
    val Dialog: js.Dynamic = js.native
    val DropDownIcon: js.Dynamic = js.native
    val DropDownMenu: js.Dynamic = js.native
    val EnhancedButton: js.Dynamic = js.native
    val FlatButton: js.Dynamic = js.native
    val FloatingActionButton: js.Dynamic = js.native
    val FontIcon: js.Dynamic = js.native
    val IconButton: js.Dynamic = js.native
    val LeftNav: js.Dynamic = js.native
    val LinearProgress: js.Dynamic = js.native
    val Menu: js.Dynamic = js.native
    val MenuItem: js.Dynamic = js.native
    val Mixins: js.Dynamic = js.native
    val Paper: js.Dynamic = js.native
    val RadioButton: js.Dynamic = js.native
    val RadioButtonGroup: js.Dynamic = js.native
    val RaisedButton: js.Dynamic = js.native
    val Slider: js.Dynamic = js.native
    val SvgIcon: js.Dynamic = js.native
    val Snackbar: js.Dynamic = js.native
    val Tab: js.Dynamic = js.native
    val Tabs: js.Dynamic = js.native
    val Toggle: js.Dynamic = js.native
    val TimePicker: js.Dynamic = js.native
    val TextField: js.Dynamic = js.native
    val Toolbar: js.Dynamic = js.native
    val ToolbarGroup: js.Dynamic = js.native
    val ToolbarSeparator: js.Dynamic = js.native
    val ToolbarTitle: js.Dynamic = js.native
    val Tooltip: js.Dynamic = js.native
    val ListDivider: js.Dynamic = js.native
    val ListItem: js.Dynamic = js.native
    val List: js.Dynamic = js.native
    val Avatar: js.Dynamic = js.native

    val Icons: js.Dynamic = js.native
    val Styles: MuiStyles = js.native
    val Utils: MuiUtil = js.native

  }

  @js.native
  trait MuiUtil extends js.Object {
    val CssEvent: js.Dynamic = js.native
    val Dom: js.Dynamic = js.native
    val Events: js.Dynamic = js.native
    val KeyCode: js.Dynamic = js.native
    val KeyLine: js.Dynamic = js.native
    val ColorManipulator: js.Dynamic = js.native
    val Extend: js.Dynamic = js.native
    val UniqueId: js.Dynamic = js.native
  }

  @js.native
  trait MuiStyles extends js.Object {
    val AutoPrefix: js.Dynamic = js.native
    val Colors: js.Dynamic = js.native
    val Spacing: js.Dynamic = js.native
    val ThemeManager: js.Dynamic = js.native
    val Typography: js.Dynamic = js.native
    val Transitions: js.Dynamic = js.native
  }

  @js.native
  trait ThemeManager extends js.Object {

    def getCurrentTheme(): js.Dynamic = js.native

    def setTheme(newTheme: js.Dynamic): Unit = js.native

    def setPalette(newPalette: js.Dynamic): Unit = js.native

    def setComponentThemes(themes: js.Dynamic): Unit = js.native

    val types :js.Dynamic = js.native
  }

  // I'm getting this error when the val is named ThemeManager:
  // scalajs-react-components\core\src\main\scala\chandu0101\scalajs\react\components\materialui\package.scala:96:
  // ThemeManager is already defined as (compiler-generated) case class companion object ThemeManager
  lazy val themeManager = js.Dynamic.newInstance(Mui.Styles.ThemeManager)().asInstanceOf[ThemeManager]

  def installMuiContext[P, S, B, N <: TopNode]: ReactComponentSpec[P, S, B, N] => Callback =
    spec => Callback {
      val t = spec.asInstanceOf[js.Dynamic]
      t.updateDynamic("childContextTypes")(js.Dynamic.literal("muiTheme" -> React.asInstanceOf[js.Dynamic].PropTypes.`object`): js.Object)
      t.updateDynamic("getChildContext")((() => js.Dynamic.literal("muiTheme" -> themeManager.getCurrentTheme())): js.Function)
    }

}
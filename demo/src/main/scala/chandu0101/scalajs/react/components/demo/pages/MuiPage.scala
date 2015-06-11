package chandu0101.scalajs.react.components.demo.pages
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scalacss.Defaults._
import scalacss.ScalaCssReact._
object MuiPage {

  def installMuiContext[P, S, B, N <: TopNode]: ReactComponentSpec[P, S, B, N] => Unit =
    spec => {
      val t = spec.asInstanceOf[js.Dynamic]
      t.updateDynamic("childContextTypes")(js.Dynamic.literal("muiTheme" -> g.React.PropTypes.`object`): js.Object)
      t.updateDynamic("getChildContext")((() => js.Dynamic.literal("muiTheme" -> g.mui.Styles.ThemeManager().muiThemeManager.getCurrentTheme())): js.Function)
    }

}

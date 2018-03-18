package chandu0101.scalajs.react.components

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-spinner", JSImport.Default)
object SpinnerRequire extends js.Any

@js.native
@JSImport("react-spinner/react-spinner.css", JSImport.Namespace)
object SpinnerCss extends js.Any

case class Spinner(
    key: js.UndefOr[String] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined
) {
  def apply() = {
    val f = JsComponent[js.Object, Children.None, Null](SpinnerRequire)
    f(JSMacro[Spinner](this))
  }
}

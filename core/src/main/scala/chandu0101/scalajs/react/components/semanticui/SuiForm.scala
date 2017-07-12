package chandu0101.scalajs.react.components
package semanticui
import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.JSName

/**
  * This file is generated - submit issues instead of PR against it
  */
case class SuiForm(
    onSubmit: js.UndefOr[(ReactEventFromHtml, js.Dynamic) => Callback] = js.undefined,
    serializer: js.UndefOr[() => Callback] = js.undefined,
    warning: js.UndefOr[Boolean] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    widths: js.UndefOr[SemanticFormWIDTHS | SemanticWIDTHSSTRING | SemanticWIDTHSNUMBER | Double] =
      js.undefined,
    reply: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    success: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    method: js.UndefOr[SemanticFormMETHOD] = js.undefined,
    as: js.UndefOr[String | js.Function] = js.undefined
) {
  def apply(children: VdomNode*) = {
    val props     = JSMacro[SuiForm](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Sui.Form)
    component(props)(children: _*)
  }
}

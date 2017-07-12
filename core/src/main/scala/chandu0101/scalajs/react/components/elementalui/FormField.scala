package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js
import scala.scalajs.js.`|`

case class FormField(
    className: js.UndefOr[String] = js.undefined,
    htmlFor: js.UndefOr[String] = js.undefined,
    id: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[String] = js.undefined,
    offsetAbsentLabel: js.UndefOr[Boolean] = js.undefined,
    width: js.UndefOr[FormFieldWidth] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props = JSMacro[FormField](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.FormField)
    component(props)(children: _*)
  }

}

case class FormFieldWidth private (val value: String) extends AnyVal

object FormFieldWidth {
  val one_half = FormFieldWidth("one-half")
  val two_quarters = FormFieldWidth("two-quarters")
  val three_sixths = FormFieldWidth("three-sixths")
  val one_quarter = FormFieldWidth("one-quarter")
  val three_quarters = FormFieldWidth("three-quarters")
  val one_third = FormFieldWidth("one-third")
  val two_sixths = FormFieldWidth("two-sixths")
  val two_thirds = FormFieldWidth("two-thirds")
  val four_sixths = FormFieldWidth("four-sixths")
  val one_fifth = FormFieldWidth("one-fifth")
  val two_fifths = FormFieldWidth("two-fifths")
  val three_fifths = FormFieldWidth("three-fifths")
  val four_fifths = FormFieldWidth("four-fifths")
  val one_sixth = FormFieldWidth("one-sixth")
}

package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

object MuiSelectFieldDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  class ChoiceId(val value: String)                extends js.Object
  class Choice(val id: ChoiceId, val text: String) extends js.Object

  case class Backend($ : BackendScope[Seq[Choice], Choice]) {
    val onChange: (TouchTapEvent, Int, Choice) => Callback =
      (e, idx, a) => $.setState(a) >> Callback.info(s"selected $a")

    def render(choices: Seq[Choice], selected: Choice): VdomElement =
      CodeExample(code, "MuiSelectField")(
        MuiSelectField[Choice](
          value = selected,
          onBlur = CallbackDebug.f1("onBlur"),
          onFocus = CallbackDebug.f1("onFocus"),
          onChange = onChange
        )(
          choices
            .map(
              c =>
                MuiMenuItem[Choice](key = c.id.value, value = c, primaryText = js.defined(c.text))()
            )
            .toVdomArray
        )
      )
  }

  private val component =
    ScalaComponent
      .builder[Seq[Choice]]("MuiSelectFieldDemo")
      .initialStateFromProps(_.head)
      .renderBackend[Backend]
      .build

  def apply(): Unmounted[Seq[Choice], Choice, Backend] =
    component(
      Seq(
        new Choice(new ChoiceId("1"), "Never"),
        new Choice(new ChoiceId("2"), "Every Night"),
        new Choice(new ChoiceId("3"), "Weeknights"),
        new Choice(new ChoiceId("4"), "Weekends"),
        new Choice(new ChoiceId("5"), "Weekly")
      )
    )

  // EXAMPLE:END
}

package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object MuiSelectFieldDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  case class ChoiceId(value: String)
  case class Choice(id: ChoiceId, text: String)

  case class Backend($ : BackendScope[Seq[Choice], Choice]) {
    val onChange: (TouchTapEvent, Int, Choice) => Callback =
      (e, idx, a) => $.setState(a) >> Callback.info(s"selected $a")

    def render(choices: Seq[Choice], selected: Choice): VdomElement =
      CodeExample(code, "MuiSelectField")(
        MuiSelectField[Choice](value = selected,
                               onBlur = CallbackDebug.f1("onBlur"),
                               onFocus = CallbackDebug.f1("onFocus"),
                               onChange = onChange)(
          choices
            .map(
              c => MuiMenuItem[Choice](key = c.id.value, value = c, primaryText = c.text)()
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

  def apply(): VdomElement =
    component(
      Seq(
        Choice(ChoiceId("1"), "Never"),
        Choice(ChoiceId("2"), "Every Night"),
        Choice(ChoiceId("3"), "Weeknights"),
        Choice(ChoiceId("4"), "Weekends"),
        Choice(ChoiceId("5"), "Weekly")
      )
    )

  // EXAMPLE:END
}

package demo
package components
package reactselect

import chandu0101.macros.tojs.{GhPagesMacros, JSMacro}
import chandu0101.scalajs.react.components.optionselectors.ReactSelect
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object ReactSelectDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(value: String = "", multiValue: String = "")

  class Backend(t: BackendScope[_, State]) {

    def onChange(value: String) =
      t.modState(_.copy(value = value))


    def onMultiChange(value: String) =
      t.modState(_.copy(multiValue = value))

    def render(S: State) = {
      <.div(
        CodeExample(code, "Demo")(
          <.div(
            <.h3("Single Select"),
            ReactSelect(options = options,
              value = S.value,
              onChange = onChange _)()
          ),
          <.div(
            <.h3("Multi Select"),
            ReactSelect(options = options,
              value = S.multiValue,
              multi = true,
              onChange = onMultiChange _)()
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("ReactSelectDemo")
    .initialState(State())
    .renderBackend[Backend]
    .buildU

  case class SampleOption(value: String, label: String) {
    val toJS: js.Object = JSMacro[SampleOption](this)
  }

  object SampleOption {
    def fromJson(obj: js.Dynamic) = SampleOption(value = obj.value.toString, label = obj.label.toString)
  }

  val options = js.Array(
    SampleOption("value1", "label1").toJS,
    SampleOption("value2", "label2").toJS,
    SampleOption("value3", "label3").toJS,
    SampleOption("value4", "label4").toJS,
    SampleOption("value5", "label5").toJS
  )

  // EXAMPLE:END

  def apply() = component()
}

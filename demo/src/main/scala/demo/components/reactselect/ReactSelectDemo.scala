package demo
package components
package reactselect

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.JsCollection
import chandu0101.scalajs.react.components.reactselect._
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.ReactNode
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object ReactSelectDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(
    value:      js.UndefOr[ReactNode] = js.undefined,
    multiValue: js.UndefOr[ReactNode] = js.undefined
  )

  class Backend(t: BackendScope[_, State]) {

    def onChange(value: ReactNode): Callback =
      t.modState(_.copy(value = value)) >>
        Callback.info(s"Chosen $value")

    def onMultiChange(value: ReactNode): Callback =
      t.modState(_.copy(multiValue = value)) >> Callback.info(s"Chosen $value")

    def render(S: State) = {
      val options = js.Array[ValueOption[ReactNode]](
        ValueOption(value = "value1", label = "label1"),
        ValueOption(value = 1, label = "label2"),
        ValueOption(value = "value3", label = "label3"),
        ValueOption(value = "value4", label = "label4"),
        ValueOption(value = "value5", label = "label5")
      )

      <.div(
        CodeExample(code, "Demo")(
          <.div(
            <.h3("Single Select"),
            Select[ReactNode](
              options = options,
              value = S.value.asInstanceOf[JsCollection[ReactNode]],
              onValueClick = (v: ValueOption[ReactNode], e: ReactEvent) => Callback.info(v.toString),
              onChange = onChange _)()
          ),
          <.div(
            <.h3("Multi Select"),
            Select[ReactNode](
              options = options,
              value = S.multiValue.asInstanceOf[JsCollection[ReactNode]],
              multi = true,
              onChange = onMultiChange _)()
          )
        )
      )
    }
  }

  val component = ScalaComponent.builder[Unit]("ReactSelectDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

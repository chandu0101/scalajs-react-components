package demo.components.reactselect

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.JsCollection
import chandu0101.scalajs.react.components.reactselect._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.ReactNode
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object ReactSelectAsyncDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(
      value: JsCollection[ValueOption[MyValue]] = js.undefined
  )

  case class MyValue(value: String, anotherValue: Int)

  class Backend(t: BackendScope[_, State]) {
    val loadValues: (String, js.Function2[Null, AsyncLoaded[MyValue], Unit]) => Callback =
      (search, cb) =>
        Callback(
          cb(
            null,
            AsyncLoaded(
              complete = true,
              ValueOption(MyValue("value", 23), "First value"),
              ValueOption(MyValue("value2", 42), "Second value"),
              ValueOption(MyValue("value3", 101), "Third value")
            )
          )
      )

    val onChangeValue: JsCollection[ValueOption[MyValue]] => Callback =
      chosen =>
        t.modState(_.copy(value = chosen)) >>
          Callback.info(s"Chose ${chosen.toJsArray.map(_.value)}")

    val valueRenderer: ValueOption[MyValue] => ReactNode =
      vo =>
        <.div(
          vo.title.fold(EmptyVdom)(<.h3(_)),
          <.p(vo.label),
          <.small(vo.value.toString)
        ).rawNode

    val optionRenderer: ValueOption[MyValue] => ReactNode =
      vo =>
        <.div("Option: ",
              vo.title.fold(EmptyVdom)(<.h3(_)),
              <.p(vo.label),
              <.small(vo.value.toString)).rawNode

    val onValueClick: (ValueOption[MyValue], ReactEvent) => Callback =
      (vo, e) => Callback.info(s"Clicked on ${vo.value.value}")

    def render(S: State) =
      <.div(
        CodeExample(code, "ReactSelectAsyncDemo")(
          Async(
            loadOptions = loadValues,
            value = S.value,
            multi = true,
            onChange = onChangeValue,
            clearable = true,
            optionRenderer = optionRenderer,
            valueRenderer = valueRenderer,
            onValueClick = onValueClick
          )()
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("ReactSelectAsyncDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

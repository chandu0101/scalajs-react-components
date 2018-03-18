package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.Unmounted
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object DefaultSelect {

  class Backend(t: BackendScope[Props, Unit]) {

    def onChange(P: Props)(e: ReactEventFromInput) =
      P.onChange(e.target.value)

    def render(P: Props) = {
      <.div(
        <.label(<.strong(P.label)),
        <.select(^.paddingLeft := "5px",
                 ^.id := "reactselect",
                 ^.value := P.value,
                 ^.onChange ==> onChange(P))(
          P.options.map(item => <.option(item)).toTagMod
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Props]("DefaultSelect")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(label: String,
                   options: List[String],
                   value: String,
                   onChange: String => Callback)

  def apply(key: js.UndefOr[Key] = js.undefined,
            label: String,
            options: List[String],
            value: String,
            onChange: String => Callback): Unmounted[Props, Unit, Backend] = {
    val props = Props(label, options, value, onChange)
    key.fold(component(props))(key => component.withKey(key)(props))
  }
}

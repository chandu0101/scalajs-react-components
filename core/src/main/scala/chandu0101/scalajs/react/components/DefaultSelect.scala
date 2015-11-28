package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object DefaultSelect {

  class Backend(t: BackendScope[Props, _]) {

    def onChange(P: Props)(e: ReactEventI) =
      P.onChange(e.target.value)

    def render(P: Props) = {
      <.div(
        <.label(<.strong(P.label)),
        <.select(^.paddingLeft := "5px", ^.id := "reactselect", ^.value := P.value, ^.onChange ==> onChange(P))(
          P.options.map(item => <.option(item))
        )
      )
    }
  }

  val component = ReactComponentB[Props]("DefaultSelect")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(label: String, options: List[String], value: String, onChange: String => Callback)

  def apply(ref: js.UndefOr[String] = "", key: js.Any = {}, label: String, options: List[String], value: String, onChange: String => Callback) = component.set(key, ref)(Props(label, options, value, onChange))
}

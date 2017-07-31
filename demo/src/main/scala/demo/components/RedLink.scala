package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object RedLink {
  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props) = {
      <.a(^.href := P.url,
          P.name,
          ^.textDecoration.none,
          ^.color.red,
          ^.margin := "0 5px",
          ^.target := "_blank")
    }
  }

  val component = ReactComponentB[Props]("RedLink")
    .renderBackend[Backend]
    .build

  case class Props(name: String, url: String)

  def apply(name: String, url: String) = component(Props(name, url))
}

package chandu0101.scalajs.react.components
package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object RedLink {

  val component = ReactComponentB[Props]("RedLink")
    .render(P => {
    <.a(^.href := P.url ,
      P.name,
      ^.textDecoration.none ,
      ^.color.red ,
      ^.margin := "0 5px" ,
      ^.target := "_blank")
  }).build

  case class Props(name: String, url: String)

  def apply(name: String, url: String) = component(Props(name, url))
}

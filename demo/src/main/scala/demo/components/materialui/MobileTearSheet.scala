package demo
package components
package materialui

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline

object MobileTearSheet {

  object Style extends Inline {

    import dsl._

    val root = style(
      marginBottom(24 px),
      marginRight(24 px),
      width(360 px)
    )

    val container = style(border :=! "solid 1px #d9d9d9",
      borderBottom :=! "none",
      height :=! "500px",
      overflow.hidden)

    val bottomTear = style(display.block,
      position.relative,
      marginTop :=! "-10px",
      width(360 px))
  }

  case class Backend($: BackendScope[Unit, _]){
    def render(C: PropsChildren) = {
      <.div(Style.root,
        <.div(Style.container,
          C
        ),
        <.img(Style.bottomTear, ^.src := js.Dynamic.global.bottomTearImage.toString)
      )
    }
  }

  val component = ReactComponentB[Unit]("MobileTearSheet")
    .renderBackend[Backend]
    .buildU

  def apply(children: ReactNode*) = component(children)
}

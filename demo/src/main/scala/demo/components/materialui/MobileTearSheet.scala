package demo
package components
package materialui

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._

object MobileTearSheet {

  object Style extends StyleSheet.Inline {

    import dsl._

    val root = style(
      marginBottom(24 px),
      marginRight(24 px),
      width(360 px)
    )

    val container = style(
      border :=! "solid 1px #d9d9d9",
      height :=! "500px",
      overflow.hidden
    )

    val bottomTear = style(
      display.block,
      position.relative,
      marginTop :=! "-10px",
      width(360 px)
    )
  }

  case class Backend($ : BackendScope[Unit, Unit]) {
    def render(C: PropsChildren) = {
      <.div(
        Style.root,
        <.div(
          Style.container,
          C
        ),
        <.img(Style.bottomTear, ^.src := Images.bottomTearImage.toString)
      )
    }
  }

  val component = ScalaComponent
    .builder[Unit]("MobileTearSheet")
    .renderBackendWithChildren[Backend]
    .build

  def apply(children: VdomNode*) = component(children: _*)
}

package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object ReactSearchBox {

  class Style extends StyleSheet.Inline {

    import dsl._

    val searchBox = style(marginBottom(10 px))

    val input = style(
      fontSize(13 px),
      fontWeight._300,
      padding(3 px),
      width(100.%%),
      backgroundColor.transparent,
      borderBottom :=! "1px solid #B2ADAD",
      &.focus(outline.none,
        borderBottom :=! "1.5px solid #03a9f4"
      )
    )
  }

  class Backend(t: BackendScope[Props, _]) {
    def onTextChange(P: Props)(e: ReactEventI) =
      e.preventDefaultCB >> P.onTextChange(e.target.value)

    def render(P: Props) =
      <.div(P.style.searchBox)(
        <.input(P.style.input, ^.placeholder := "Search ..", ^.onKeyUp ==> onTextChange(P))
      )
  }

  object DefaultStyle extends Style

  val component = ReactComponentB[Props]("ReactSearchBox")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(onTextChange: String => Callback, style: Style)

  def apply(onTextChange: String => Callback, style: Style = DefaultStyle, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(onTextChange,style))

}
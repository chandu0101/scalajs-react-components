package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ScalaCssReact._

object ReactSearchBox {

  val cssSettings = scalacss.devOrProdDefaults
  import cssSettings._

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
      &.focus.apply(outline.none,
        borderBottom :=! "1.5px solid #03a9f4"
      )
    )
  }

  class Backend(t: BackendScope[Props, _]) {
    def onTextChange(P: Props)(e: ReactEventFromInput) =
      e.preventDefaultCB >> P.onTextChange(e.target.value)

    def render(P: Props) =
      <.div(P.style.searchBox)(
        <.input(P.style.input, ^.placeholder := "Search ..", ^.onKeyUp ==> onTextChange(P))
      )
  }

  object DefaultStyle extends Style

  val component = ScalaComponent.builder[Props]("ReactSearchBox")
    .stateless
    .renderBackend[Backend]
    .build

  case class Props(onTextChange: String => Callback, style: Style)

  def apply(onTextChange: String => Callback, style: Style = DefaultStyle) = component(Props(onTextChange,style))

}
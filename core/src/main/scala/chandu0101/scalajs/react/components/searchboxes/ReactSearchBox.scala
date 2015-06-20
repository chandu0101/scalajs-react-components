package chandu0101.scalajs.react.components.searchboxes


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scala.scalajs.js
import scala.scalajs.js.undefined
import scala.scalajs.js.UndefOr
import scalacss.Defaults._
import scalacss.ScalaCssReact._


object ReactSearchBox {


  class Style extends StyleSheet.Inline {

    import dsl._

    val searchBox = style(marginBottom(10 px))

    val input = style(border.none,
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
    def onTextChange(e: ReactEventI) = {
      e.preventDefault()
      t.props.onTextChange(e.target.value)
    }

  }

  object DefaultStyle extends Style

  val component = ReactComponentB[Props]("ReactSearchBox")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(P.style.searchBox)(
      <.input(P.style.input, ^.placeholder := "Search ..", ^.onKeyUp ==> B.onTextChange)
    )
  })
    .build

  case class Props(onTextChange: String => Unit, style: Style)


  def apply(onTextChange: String => Unit, style: Style = DefaultStyle, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(onTextChange,style))

}
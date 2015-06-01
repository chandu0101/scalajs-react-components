package chandu0101.scalajs.react.components.searchboxes


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object ReactSearchBox {

  trait Style {
    def searchBox : TagMod =  Seq( ^.position := "relative" ,
      ^.marginBottom := "10px")

    def searchInput : TagMod = Seq( ^.display := "block",
      ^.border := "none",
      ^.fontSize := "13px",
      ^.fontWeight := 300,
      ^.padding := "3px",
      ^.backgroundColor := "transparent",
      ^.boxShadow := "none",
      ^.borderBottom := "1px solid #B2ADAD")

    def searchInputFocus : TagMod = Seq(^.outline := "none" ,
      ^.boxShadow := "none" ,
      ^.borderBottom := "1.5px solid #03a9f4")

  }

  case class State(focused : Boolean = false)

  class Backend(t: BackendScope[Props, State]) {
    def onTextChange(e: ReactEventI) = {
      e.preventDefault()
      t.props.onTextChange(e.target.value)
    }

    def onFocus = t.modState(_.copy(focused = true))

    def onBlur = t.modState(_.copy(focused = false))

  }

  val component = ReactComponentB[Props]("ReactSearchBox")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
     <.div(P.style.searchBox)(
       <.input(P.style.searchInput,S.focused ?= P.style.searchInputFocus , ^.placeholder := "Search ..", ^.onKeyUp ==> B.onTextChange , ^.onFocus --> B.onFocus , ^.onBlur --> B.onBlur)
      )
    })
    .build

  case class Props(onTextChange : StringUnit ,style : Style)


  def apply( onTextChange : StringUnit ,style: Style = new Style{}, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(onTextChange,style))

}

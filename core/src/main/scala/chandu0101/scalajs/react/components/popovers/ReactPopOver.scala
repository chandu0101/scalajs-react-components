package chandu0101.scalajs.react.components
package popovers

import chandu0101.scalajs.react.components.util.DomUtil
import chandu0101.scalajs.react.components.util.DomUtil.ClientRect
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.html
import scala.scalajs.js

object ReactPopOver {

  trait Style {

    def popover: TagMod = Seq(positionAbsolute,
    ^.top := 0,
    ^.left := "-100%",
    ^.zIndex := 1060,
    ^.maxWidth := "500px",
    ^.padding := "1px",
    ^.fontSize := "15px",
    ^.fontWeight := "normal",
    ^.lineHeight := 1.42857143,
    textAlignLeft,
    ^.backgroundColor := "white",
    ^.borderRadius := "6px",
    ^.border := "1px solid #cccccc",
    ^.whiteSpace := "normal").++(backgroundClipPreFixer("padding-box"))
    .++(boxShadowPreFixer("0 5px 10px rgba(0, 0, 0, 0.2)"))

    def popoverTop = Seq(^.marginTop := "-10px")

    def popoverLeft = Seq(^.marginLeft := "-10px")

    def popoverRight = Seq(^.marginLeft := "10px")

    def popoverBottom = Seq(^.marginTop := "10px")

    def popoverTitle = Seq(^.margin := 0, ^.padding := "8px 14px",
     ^.fontSize := "15px",
     ^.backgroundColor := "#f7f7f7",
     ^.borderBottom := "1px solid #ebebeb",
     ^.borderRadius := "5px 5px 0 0")

    def popoverContent = Seq(^.padding := "9px 14px")

    def popoverArrow = Seq(positionAbsolute,
    displayBlock,
    ^.width := 0,
    ^.height := 0,
    ^.border := "solid transparent",
    ^.borderWidth := "11px"
    )
    def popoverArrowAfter = Seq(positionAbsolute,
      displayBlock,
      ^.width := 0,
      ^.height := 0,
      ^.border := "solid transparent",
      ^.borderWidth := "10px"
    )

    def popoverTopArrow = Seq(^.left := "50%",
    ^.marginLeft := "-11px",
    ^.borderBottomWidth := 0,
    ^.borderTopColor := "#999999",
    ^.bottom := "-11px"
    )

    def popoverTopArrowAfter = Seq(
    ^.marginLeft := "-10px",
    ^.borderBottomWidth := 0,
    ^.borderTopColor := "#ffffff",
    ^.bottom := "1px"
    )
     def popoverRightArrow = Seq(^.top := "50%",
    ^.left := "-11px",
    ^.marginTop := "-11px",
    ^.borderLeftWidth := 0,
    ^.borderRightColor := "#999999",
    ^.bottom := "-11px"
    )

    def popoverRightArrowAfter = Seq(
    ^.left := "1px",
    ^.borderLeftWidth := 0,
    ^.borderRightColor := "#ffffff",
    ^.bottom := "-10px"
    )
     def popoverBottomArrow = Seq(^.left := "50%",
    ^.marginLeft := "-11px",
    ^.borderTopWidth := 0,
    ^.borderBottomColor := "#999999",
    ^.top := "-11px"
    )

    def popoverBottomArrowAfter = Seq(^.top := "1px",
    ^.marginLeft := "-10px",
    ^.borderTopWidth := 0,
    ^.borderBottomColor := "#ffffff"
    )
     def popoverLeftArrow = Seq(^.top := "50%",
       ^.right := "-11px",
    ^.marginTop := "-11px",
    ^.borderRightWidth := 0,
    ^.borderLeftColor := "#999999"

    )

    def popoverLeftArrowAfter = Seq(
      ^.right := "1px",
    ^.borderRightWidth := 0,
    ^.borderLeftColor := "#ffffff",
     ^.bottom := "-10px"
    )
  }

  case class State(open: Boolean ,top: Double = 0,left: Double = 0)

  class Backend($: BackendScope[Props, State]) {

    def toggle(node: html.Element): Callback =
      ($.props zip $.state).flatMap {
        case (p, s) => if (s.open) hide else show(getPosition(p)(node))
      }

    private def show(position: ClientRect) =
      $.modState(_.copy(open = true, top = position.top, left = position.left))

    private val hide = $.modState(_.copy(open = false))

    def getPosition(P: Props)(node: html.Element): ClientRect = {
      val offset = DomUtil.offset(node)
      val height = node.offsetHeight
      val width = node.offsetWidth
      val popoverHeight = $.getDOMNode().asInstanceOf[html.Element].offsetHeight
      val popoverWidth = $.getDOMNode().asInstanceOf[html.Element].offsetWidth
      P.placement match {
        case "right" =>
          val top = offset.top + height/2 - popoverHeight/2
          val left = offset.left + width
          ClientRect(top,left)
        case "left" =>
          val top = offset.top + height/2 - popoverHeight/2
          val left = offset.left - popoverWidth
          ClientRect(top,left)
        case "top" =>
          val top = offset.top - popoverHeight
          val left = offset.left + width/2 - popoverWidth/2
          ClientRect(top,left)
        case "bottom" =>
          val top = offset.top + height
          val left = offset.left + width/2 - popoverWidth/2
          ClientRect(top,left)
        case _ => throw new Exception(s"unsupported placement: ${P.placement}")
      }
    }

    def arrowAfter(P: Props): TagMod = {
      if  (P.placement == "top")  <.span(P.style.popoverArrowAfter,P.style.popoverTopArrowAfter," ")
      else if (P.placement == "left")  <.span(P.style.popoverArrowAfter,P.style.popoverLeftArrowAfter," ")
      else if  (P.placement == "right")  <.span(P.style.popoverArrowAfter,P.style.popoverRightArrowAfter," ")
      else if  (P.placement == "bottom") <.span(P.style.popoverArrowAfter,P.style.popoverBottomArrowAfter," ")
      else ""
    }

    def render(P: Props, S: State, C: PropsChildren) = {
     <.div(P.style.popover,
        (P.placement == "top") ?= P.style.popoverTop,
        (P.placement == "left") ?= P.style.popoverLeft,
        (P.placement == "right") ?= P.style.popoverRight,
        (P.placement == "bottom") ?= P.style.popoverBottom,
      ^.top := S.top ,S.open ?= (^.left := S.left))(
       <.div(P.style.popoverArrow,
          (P.placement == "top") ?= P.style.popoverTopArrow,
          (P.placement == "left") ?= P.style.popoverLeftArrow,
          (P.placement == "right") ?= P.style.popoverRightArrow,
          (P.placement == "bottom") ?= P.style.popoverBottomArrow, arrowAfter(P)),
        !P.title.isEmpty ?= <.h3(P.style.popoverTitle)(P.title),
       <.div(P.style.popoverContent)(
          C
        )
      )
    }
  }

  val component = ReactComponentB[Props]("ReactPopover")
    .initialState(State(open = false))
    .renderBackend[Backend]
    .build

  case class Props(title: String,placement: String ,style: Style)

  def apply(title: String = "",
            placement: String = "right",
            ref: U[String] = uNone,
            key: js.Any = {},
            style: Style = new Style {})
           (children: ReactNode*): ReactComponentU[Props, State, Backend, TopNode] =

    component.set(key = key, ref = ref)(
      Props(title, placement, style),
      children
    )
}

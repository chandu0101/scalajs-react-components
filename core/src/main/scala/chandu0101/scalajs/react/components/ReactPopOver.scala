package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import org.scalajs.dom.html

object ReactPopOver {
  import RCustomStyles._

  object DomUtil {
    def offset(element: html.Element) = {
      val rect       = element.getBoundingClientRect()
      var scrollTop  = 0.0
      var scrollLeft = 0.0
      if (dom.document.body.scrollTop > 0) {
        scrollTop = dom.document.body.scrollTop
        scrollLeft = dom.document.body.scrollLeft
      } else if (dom.document.documentElement.scrollTop > 0) { // for firefox
        scrollTop = dom.document.documentElement.scrollTop
        scrollLeft = dom.document.documentElement.scrollLeft
      }
      ClientRect(rect.top + scrollTop, rect.left + scrollLeft)
    }
  }

  trait Style {
    def popover: TagMod = TagMod(
      ^.position := "absolute",
      ^.top := "0",
      ^.left := "-100%",
      ^.zIndex := "1060",
      ^.maxWidth := "500px",
      ^.padding := "1px",
      ^.fontSize := "15px",
      ^.fontWeight := "normal",
      ^.lineHeight := "1.42857143",
      ^.textAlign := "left",
      ^.backgroundColor := "white",
      ^.borderRadius := "6px",
      ^.border := "1px solid #cccccc",
      ^.whiteSpace := "normal",
      backgroundClipPreFixer("padding-box"),
      boxShadowPreFixer("0 5px 10px rgba(0, 0, 0, 0.2)")
    )

    def backgroundClipPreFixer(value: String) =
      TagMod(
        ^.backgroundClip := value,
        WebkitBackgroundClip := value
      )

    def boxShadowPreFixer(value: String) =
      TagMod(
        ^.boxShadow := value,
        WebkitBoxShadow := value
      )

    def popoverTop = TagMod(^.marginTop := "-10px")

    def popoverLeft = TagMod(^.marginLeft := "-10px")

    def popoverRight = TagMod(^.marginLeft := "10px")

    def popoverBottom = TagMod(^.marginTop := "10px")

    def popoverTitle =
      TagMod(^.margin := "0",
             ^.padding := "8px 14px",
             ^.fontSize := "15px",
             ^.backgroundColor := "#f7f7f7",
             ^.borderBottom := "1px solid #ebebeb",
             ^.borderRadius := "5px 5px 0 0")

    def popoverContent = TagMod(^.padding := "9px 14px")

    val displayBlock = ^.display := "block"

    def popoverArrow = TagMod(
      ^.position := "absolute",
      displayBlock,
      ^.width := "0",
      ^.height := "0",
      ^.border := "solid transparent",
      ^.borderWidth := "11px"
    )

    def popoverArrowAfter = TagMod(
      ^.position := "absolute",
      displayBlock,
      ^.width := "0",
      ^.height := "0",
      ^.border := "solid transparent",
      ^.borderWidth := "10px"
    )

    def popoverTopArrow = TagMod(
      ^.left := "50%",
      ^.marginLeft := "-11px",
      ^.borderBottomWidth := "0",
      ^.borderTopColor := "#999999",
      ^.bottom := "-11px"
    )

    def popoverTopArrowAfter = TagMod(
      ^.marginLeft := "-10px",
      ^.borderBottomWidth := "0",
      ^.borderTopColor := "#ffffff",
      ^.bottom := "1px"
    )

    def popoverRightArrow = TagMod(
      ^.top := "50%",
      ^.left := "-11px",
      ^.marginTop := "-11px",
      ^.borderLeftWidth := "0",
      ^.borderRightColor := "#999999",
      ^.bottom := "-11px"
    )

    def popoverRightArrowAfter = TagMod(
      ^.left := "1px",
      ^.borderLeftWidth := "0",
      ^.borderRightColor := "#ffffff",
      ^.bottom := "-10px"
    )

    def popoverBottomArrow = TagMod(
      ^.left := "50%",
      ^.marginLeft := "-11px",
      ^.borderTopWidth := "0",
      ^.borderBottomColor := "#999999",
      ^.top := "-11px"
    )

    def popoverBottomArrowAfter = TagMod(
      ^.top := "1px",
      ^.marginLeft := "-10px",
      ^.borderTopWidth := "0",
      ^.borderBottomColor := "#ffffff"
    )

    def popoverLeftArrow = TagMod(
      ^.top := "50%",
      ^.right := "-11px",
      ^.marginTop := "-11px",
      ^.borderRightWidth := "0",
      ^.borderLeftColor := "#999999"
    )

    def popoverLeftArrowAfter = TagMod(
      ^.right := "1px",
      ^.borderRightWidth := "0",
      ^.borderLeftColor := "#ffffff",
      ^.bottom := "-10px"
    )
  }

  case class State(open: Boolean, top: Double = 0, left: Double = 0)

  class Backend($ : BackendScope[Props, State]) {

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
      val width  = node.offsetWidth

      val popoverHeight = $.getDOMNode.map(_.asElement).map(_.domAsHtml.offsetHeight).runNow()
      val popoverWidth  = $.getDOMNode.map(_.asElement).map(_.domAsHtml.offsetWidth).runNow()
      P.placement match {
        case "right" =>
          val top  = offset.top + height / 2 - popoverHeight / 2
          val left = offset.left + width
          ClientRect(top, left)
        case "left" =>
          val top  = offset.top + height / 2 - popoverHeight / 2
          val left = offset.left - popoverWidth
          ClientRect(top, left)
        case "top" =>
          val top  = offset.top - popoverHeight
          val left = offset.left + width / 2 - popoverWidth / 2
          ClientRect(top, left)
        case "bottom" =>
          val top  = offset.top + height
          val left = offset.left + width / 2 - popoverWidth / 2
          ClientRect(top, left)
        case _ => throw new Exception(s"unsupported placement: ${P.placement}")
      }
    }

    def arrowAfter(P: Props): TagMod = {
      if (P.placement == "top")
        <.span(P.style.popoverArrowAfter, P.style.popoverTopArrowAfter, " ")
      else if (P.placement == "left")
        <.span(P.style.popoverArrowAfter, P.style.popoverLeftArrowAfter, " ")
      else if (P.placement == "right")
        <.span(P.style.popoverArrowAfter, P.style.popoverRightArrowAfter, " ")
      else if (P.placement == "bottom")
        <.span(P.style.popoverArrowAfter, P.style.popoverBottomArrowAfter, " ")
      else ""
    }

    def render(P: Props, S: State, C: PropsChildren) = {
      <.div(
        P.style.popover,
        P.style.popoverTop.when(P.placement == "top"),
        P.style.popoverLeft.when(P.placement == "left"),
        P.style.popoverRight.when(P.placement == "right"),
        P.style.popoverBottom.when(P.placement == "bottom"),
        ^.top := S.top.toString(),
        (^.left := S.left.toString).when(S.open)
      )(
        <.div(
          P.style.popoverArrow,
          P.style.popoverTopArrow.when(P.placement == "top"),
          P.style.popoverLeftArrow.when(P.placement == "left"),
          P.style.popoverRightArrow.when(P.placement == "right"),
          P.style.popoverBottomArrow.when(P.placement == "bottom"),
          arrowAfter(P)
        ),
        (<.h3(P.style.popoverTitle)(P.title)).unless(P.title.isEmpty),
        <.div(P.style.popoverContent)(
          C
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Props]("ReactPopover")
    .initialState(State(open = false))
    .renderBackendWithChildren[Backend]
    .build

  case class Props(title: String = "", placement: String = "", style: Style = new Style {})

  def apply(
      title: String = "",
      placement: String = "right",
      style: Style = new Style {}
  )(children: VdomNode*) =
    component(Props(title, placement, style))(children: _*)
}

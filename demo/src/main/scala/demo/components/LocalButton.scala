package demo.components

import chandu0101.scalajs.react.components._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

object LocalDemoButton {

  trait Style {

    val button = Seq(^.backgroundColor := "#F2706D",
      ^.border := "1px solid transparent",
      ^.boxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)",
      ^.color := "#F5F4F4",
      ^.cursor := "pointer",
      ^.display := "inline-block",
      ^.fontSize := "15px",
      ^.textDecoration := "none",
      ^.padding := "5px 7px",
      WebkitBoxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)")

    val buttonHover: TagMod = Seq(^.backgroundColor := "#DA423E",
      ^.textDecoration := "none")

  }

  case class State(buttonHover: Boolean = false)

  class Backend(t: BackendScope[Props, State]) {

    def onButtonClick(P: Props)(e: ReactEventI): Callback =
      P.onButtonClick.fold(Callback.empty)(_.apply(e)) >> e.preventDefaultCB

    val onMouseEnter_ = t.modState(_.copy(buttonHover = true))

    val onMouseLeave_ = t.modState(_.copy(buttonHover = false))

    def render(P: Props, S: State) = {
      val buttonStyle = styleSet1(P.style.button, P.style.buttonHover -> S.buttonHover)
      if (P.linkButton)<.a(buttonStyle, ^.href := P.href,^.target := "_blank", onMouseEnter --> onMouseEnter_, onMouseLeave --> onMouseLeave_)(P.name)
      else<.a(buttonStyle, ^.onClick ==> onButtonClick(P), onMouseEnter --> onMouseEnter_, onMouseLeave --> onMouseLeave_)(P.name)
    }
  }

  val component = ReactComponentB[Props]("LocalDemoButton")
    .initialState(State())
    .renderBackend[Backend]
    .build

  case class Props(name: String, onButtonClick: js.UndefOr[ReactEventH => Callback], linkButton: Boolean, href: String, style: Style)

  def apply(name: String, onButtonClick: js.UndefOr[ReactEventH => Callback] = js.undefined, linkButton: Boolean = false, href: String = "", style: Style = new Style {}, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(name, onButtonClick, linkButton, href, style))

}

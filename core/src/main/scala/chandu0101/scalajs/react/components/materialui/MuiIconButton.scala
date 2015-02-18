package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import japgolly.scalajs.react._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 *
 * clsNames: React.PropTypes.css,
    key: React.PropTypes.key,
    ref: React.PropTypes.ref,
    className: React.PropTypes.string,
    disabled: React.PropTypes.bool,
    iconClassName: React.PropTypes.string,
    onBlur: React.PropTypes.func,
    onFocus: React.PropTypes.func,
    tooltip: React.PropTypes.string,
    touch: React.PropTypes.bool,
    linkButton: React.PropTypes.bool,
    url: React.PropTypes.string,
    onMouseOver:React.PropTypes.func,
    onMouseOut:React.PropTypes.func,
    onTouchTap:React.PropTypes.func,
 */
object MuiIconButton {



  class Backend(t: BackendScope[Props, State]) {
    def onTouchTap(e: ReactEventI) = {
      if (t.props.onTouchTap != null) t.props.onTouchTap(e)
    }

    def positionTooltip() = {
      val tooltip = theToolTipRef(t).get.getDOMNode()
      val tooltipWidth = tooltip.offsetWidth
      tooltip.style.left = ((tooltipWidth - 48) / 2 * -1).toString.concat("px")
    }

    def handleBlur(e: ReactEventI) = {
      hideTooltip
      if (t.props.onBlur != null) t.props.onBlur(e)
    }

    def hideTooltip() = t.modState(_.copy(tooltipShown = false))

    def handleFocus(e: ReactEventI) = {
      showTooltip
      if (t.props.onFocus != null) t.props.onFocus(e)
    }

    def handleMouseOut(e: ReactEventI) = {
      hideTooltip
      if (t.props.onMouseOut != null) t.props.onMouseOut(e)
    }

    def handleMouseOver(e: ReactEventI) = {
      showTooltip
      if (t.props.onMouseOver != null) t.props.onMouseOver(e)

    }

    def showTooltip() = if (!t.props.disabled) t.modState(_.copy(tooltipShown = true))

  }

  case class State(tooltipShown: Boolean)

  val theToolTipRef = Ref.to(MuiTooltip.component, "theToolTipRef")
  val component = ReactComponentB[Props]("MuiIconButton")
    .initialState(State(tooltipShown = false))
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    MuiEnhancedButton(clsNames = P.clsNames + (mui_icon_button -> true),
      onTouchTap = B.onTouchTap,
      disabled = P.disabled,
      onBlur = B.handleBlur,
      onFocus = B.handleFocus,
      linkButton = P.linkButton,
      url = P.url,
      centerRipple = true,
      onMouseOut = B.handleMouseOut,
      onMouseOver = B.handleMouseOver)(
        if (P.tooltip.nonEmpty) {
          MuiTooltip(ref = theToolTipRef, clsNames = Map(mui_icon_button_tooltip -> true), label = P.tooltip, show = S.tooltipShown, touch = P.touch, key = "icontooltip")
        } else "",
        MuiFontIcon(className = P.iconClassName),
        C
      )
  }
    )
    .componentDidMount(scope => if (scope.props.tooltip.nonEmpty) scope.backend.positionTooltip)
    .build


  def withChildren(iconClassName: String = "", onBlur: REventIUnit = null, touch: Boolean = false, url: String = "", clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {}, onMouseOver: REventIUnit = null, linkButton: Boolean = false, onTouchTap: REventIUnit = null, className: String = "", onMouseOut: REventIUnit = null, onFocus: REventIUnit = null, disabled: Boolean = false, tooltip: String = "")(children: ReactNode*) =
    component.set(key, ref)(Props(iconClassName, onBlur, touch, url, clsNames, ref, key, onMouseOver, linkButton, onTouchTap, className, onMouseOut, onFocus, disabled, tooltip), children)

  def apply(iconClassName: String = "", onBlur: REventIUnit = null, touch: Boolean = false, url: String = "", clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {}, onMouseOver: REventIUnit = null, linkButton: Boolean = false, onTouchTap: REventIUnit = null, className: String = "", onMouseOut: REventIUnit = null, onFocus: REventIUnit = null, disabled: Boolean = false, tooltip: String = "") =
    component.set(key, ref)(Props(iconClassName, onBlur, touch, url, clsNames, ref, key, onMouseOver, linkButton, onTouchTap, className, onMouseOut, onFocus, disabled, tooltip))

  case class Props(iconClassName: String, onBlur: REventIUnit, touch: Boolean, url: String, clsNames: CssClassType, ref: js.UndefOr[String], key: js.Any, onMouseOver: REventIUnit, linkButton: Boolean, onTouchTap: REventIUnit, className: String, onMouseOut: REventIUnit, onFocus: REventIUnit, disabled: Boolean, tooltip: String)

}

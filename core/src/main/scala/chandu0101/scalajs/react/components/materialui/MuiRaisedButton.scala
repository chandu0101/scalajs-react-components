package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js


/**
 * key: PropTypes.string,
   style: PropTypes.js.Any,
   ref: PropTypes.String,
   className: React.PropTypes.string,
   disabled: React.PropTypes.bool,
   hoverColor: React.PropTypes.string,
   label: React.PropTypes.string,
   labelStyle: React.PropTypes.js.Any,
   primary: React.PropTypes.bool,
   linkButton: React.PropTypes.bool,
   href: React.PropTypes.string,
   rippleColor: React.PropTypes.string,
   secondary: React.PropTypes.bool,
    onBlur: React.PropTypes.ReactEventH => Unit,
    onFocus: React.PropTypes.ReactEventH => Unit,
    onMouseOut: React.PropTypes.ReactEventH => Unit,
    onMouseOver: React.PropTypes.ReactEventH => Unit,
    onTouchTap: React.PropTypes.ReactEventH => Unit,
   onMouseDown: React.PropTypes.ReactEventH => Unit,
    onMouseUp: React.PropTypes.ReactEventH => Unit,
    onTouchEnd: React.PropTypes.ReactEventH => Unit,
    onTouchStart: React.PropTypes.ReactEventH => Unit,
 */

case class MuiRaisedButton(onBlur: js.UndefOr[ReactEventH => Unit] = js.undefined,
                           labelStyle: js.UndefOr[js.Any] = js.undefined,
                           onTouchStart: js.UndefOr[ReactEventH => Unit] = js.undefined,
                           rippleColor: js.UndefOr[String] = js.undefined,
                           style: js.UndefOr[js.Any] = js.undefined,
                           label: js.UndefOr[String] = js.undefined,
                           ref: js.UndefOr[String] = js.undefined,
                           secondary: js.UndefOr[Boolean] = js.undefined,
                           onMouseUp: js.UndefOr[ReactEventH => Unit] = js.undefined,
                           onTouchEnd: js.UndefOr[ReactEventH => Unit] = js.undefined,
                           key: js.UndefOr[String] = js.undefined,
                           onMouseOver: js.UndefOr[ReactEventH => Unit] = js.undefined,
                           linkButton: js.UndefOr[Boolean] = js.undefined,
                           onTouchTap: js.UndefOr[ReactEventH => Unit] = js.undefined,
                           className: js.UndefOr[String] = js.undefined,
                           onMouseOut: js.UndefOr[ReactEventH => Unit] = js.undefined,
                           hoverColor: js.UndefOr[String] = js.undefined,
                           onFocus: js.UndefOr[ReactEventH => Unit] = js.undefined,
                           disabled: js.UndefOr[Boolean] = js.undefined,
                           href: js.UndefOr[String] = js.undefined,
                           primary: js.UndefOr[Boolean] = js.undefined,
                           onMouseDown: js.UndefOr[ReactEventH => Unit] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    onBlur.foreach(v => p.updateDynamic("onBlur")(v))
    labelStyle.foreach(v => p.updateDynamic("labelStyle")(v))
    onTouchStart.foreach(v => p.updateDynamic("onTouchStart")(v))
    rippleColor.foreach(v => p.updateDynamic("rippleColor")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    label.foreach(v => p.updateDynamic("label")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    secondary.foreach(v => p.updateDynamic("secondary")(v))
    onMouseUp.foreach(v => p.updateDynamic("onMouseUp")(v))
    onTouchEnd.foreach(v => p.updateDynamic("onTouchEnd")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onMouseOver.foreach(v => p.updateDynamic("onMouseOver")(v))
    linkButton.foreach(v => p.updateDynamic("linkButton")(v))
    onTouchTap.foreach(v => p.updateDynamic("onTouchTap")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    onMouseOut.foreach(v => p.updateDynamic("onMouseOut")(v))
    hoverColor.foreach(v => p.updateDynamic("hoverColor")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    href.foreach(v => p.updateDynamic("href")(v))
    primary.foreach(v => p.updateDynamic("primary")(v))
    onMouseDown.foreach(v => p.updateDynamic("onMouseDown")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.RaisedButton)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

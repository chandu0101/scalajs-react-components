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
    iconClassName: React.PropTypes.string,
    iconStyle: React.PropTypes.js.Any,
    onBlur: React.PropTypes.ReavtEvent => Unit,
    onFocus: React.PropTypes.ReactEvent => Unit,
    tooltip: React.PropTypes.string,
    touch: React.PropTypes.bool,

 */
case class MuiIconButton(iconClassName: js.UndefOr[String] = js.undefined,
                         onBlur: js.UndefOr[ReactEvent => Unit] = js.undefined,
                         touch: js.UndefOr[Boolean] = js.undefined,
                         style: js.UndefOr[js.Any] = js.undefined,
                         iconStyle: js.UndefOr[js.Any] = js.undefined,
                         ref: js.UndefOr[String] = js.undefined,
                         key: js.UndefOr[String] = js.undefined,
                         className: js.UndefOr[String] = js.undefined,
                         onFocus: js.UndefOr[ReactEvent => Unit] = js.undefined,
                         disabled: js.UndefOr[Boolean] = js.undefined,
                         tooltip: js.UndefOr[String] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    iconClassName.foreach(v => p.updateDynamic("iconClassName")(v))
    onBlur.foreach(v => p.updateDynamic("onBlur")(v))
    touch.foreach(v => p.updateDynamic("touch")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    iconStyle.foreach(v => p.updateDynamic("iconStyle")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    tooltip.foreach(v => p.updateDynamic("tooltip")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.IconButton)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

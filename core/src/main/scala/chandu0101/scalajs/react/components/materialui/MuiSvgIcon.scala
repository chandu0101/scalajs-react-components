package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
viewBox: React.PropTypes.string

 */
case class MuiSvgIcon(key: js.UndefOr[String] = js.undefined,
                      style: js.UndefOr[js.Any] = js.undefined,
                      ref: js.UndefOr[String] = js.undefined,
                      viewBox: js.UndefOr[String] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    viewBox.foreach(v => p.updateDynamic("viewBox")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.SvgIcon)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

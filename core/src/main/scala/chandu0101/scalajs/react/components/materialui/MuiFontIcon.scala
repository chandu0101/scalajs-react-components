package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
className: React.PropTypes.string,
    hoverColor: React.PropTypes.string

 */
object MuiFontIcon {

  def apply(style: js.UndefOr[js.Any] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            className: js.UndefOr[String] = js.undefined,
            hoverColor: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    hoverColor.foreach(v => p.updateDynamic("hoverColor")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.FontIcon)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

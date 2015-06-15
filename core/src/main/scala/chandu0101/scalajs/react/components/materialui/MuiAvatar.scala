package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js


object MuiAvatar {

  def apply(backgroundColor: js.UndefOr[String] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            icon: js.UndefOr[ReactElement] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            color: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            src: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    backgroundColor.foreach(v => p.updateDynamic("backgroundColor")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    icon.foreach(v => p.updateDynamic("icon")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    color.foreach(v => p.updateDynamic("color")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    src.foreach(v => p.updateDynamic("src")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Avatar)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

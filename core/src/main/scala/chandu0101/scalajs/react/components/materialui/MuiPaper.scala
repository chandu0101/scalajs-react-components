package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js

/**
key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
circle: React.PropTypes.bool,
rounded: React.PropTypes.bool,
zDepth: React.PropTypes.Int,
transitionEnabled: React.PropTypes.bool
  */
case class MuiPaper(circle: js.UndefOr[Boolean] = js.undefined,
                    style: js.UndefOr[js.Any] = js.undefined,
                    rounded: js.UndefOr[Boolean] = js.undefined,
                    ref: js.UndefOr[String] = js.undefined,
                    transitionEnabled: js.UndefOr[Boolean] = js.undefined,
                    zDepth: js.UndefOr[Int] = js.undefined,
                    key: js.UndefOr[String] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    circle.foreach(v => p.updateDynamic("circle")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    rounded.foreach(v => p.updateDynamic("rounded")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    transitionEnabled.foreach(v => p.updateDynamic("transitionEnabled")(v))
    zDepth.foreach(v => p.updateDynamic("zDepth")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Paper)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

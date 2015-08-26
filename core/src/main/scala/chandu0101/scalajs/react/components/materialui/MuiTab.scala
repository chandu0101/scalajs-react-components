package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * key: PropTypes.string,
   ref: PropTypes.String,
   route: React.PropTypes.string,
   onActive: React.PropTypes.ReactElement => Unit,
   label: React.PropTypes.string

 * @param label
 * @param onActive
 * @param ref
 * @param key
 * @param route
 */

case class MuiTab(style : UndefOr[js.Any] = undefined,
                   label: UndefOr[String] = undefined,
                   onActive: UndefOr[ReactElement => Unit] = undefined,
                   ref: UndefOr[String] = undefined,
                   key: UndefOr[String] = undefined,
                   route: UndefOr[String] = undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    label.foreach(v => p.updateDynamic("label")(v))
    onActive.foreach(v => p.updateDynamic("onActive")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    route.foreach(v => p.updateDynamic("route")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tab)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

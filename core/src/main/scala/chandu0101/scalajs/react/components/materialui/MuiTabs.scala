package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}

/**
 * key: PropTypes.string,
style: PropTypes.js.any,
ref: PropTypes.String,
  initialSelectedIndex: React.PropTypes.number,
    onActive: React.PropTypes.(Int,ReactElement) => Unit,
    tabWidth: React.PropTypes.number

 * @param style
 * @param onChange
 * @param ref
 * @param key
 * @param tabWidth
 * @param initialSelectedIndex
 */


case class MuiTabs(style : UndefOr[js.Any] = undefined,
                   onChange : UndefOr[(Int,ReactElement) => Unit] = undefined,
                   ref : UndefOr[String] = undefined,
                   key : UndefOr[String] = undefined,
                   tabWidth : UndefOr[Int] = undefined,
                   initialSelectedIndex : UndefOr[Int] = undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    style.foreach(v => p.updateDynamic("style")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    tabWidth.foreach(v => p.updateDynamic("tabWidth")(v))
    initialSelectedIndex.foreach(v => p.updateDynamic("initialSelectedIndex")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Tabs)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

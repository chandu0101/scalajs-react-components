package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js


/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
  className: React.PropTypes.string,
 */
case class MuiToolbar(key: js.UndefOr[String] = js.undefined,
                      style: js.UndefOr[js.Any] = js.undefined,
                      ref: js.UndefOr[String] = js.undefined,
                      className: js.UndefOr[String] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Toolbar)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


object MuiToolbarSeparator {

  def apply(key: js.UndefOr[String] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            ref: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarSeparator)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
  text: React.PropTypes.string,

 */
object MuiToolbarTitle {

  def apply(key: js.UndefOr[String] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            text: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    text.foreach(v => p.updateDynamic("text")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarTitle)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
 className: React.PropTypes.string,
    float: React.PropTypes.string

 */


case class MuiToolbarGroup(float : js.UndefOr[String] = js.undefined,
                           style : js.UndefOr[js.Any] = js.undefined,
                           ref : js.UndefOr[String] = js.undefined,
                           key : js.UndefOr[String] = js.undefined,
                           className : js.UndefOr[String] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    float.foreach(v => p.updateDynamic("float")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    p
  }

  def apply(children : ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ToolbarGroup)
    f(toJS,children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


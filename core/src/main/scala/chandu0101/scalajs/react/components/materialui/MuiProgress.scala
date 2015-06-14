package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
 mode: React.PropTypes.MuiProgressMode,
      value: React.PropTypes.number,
      min:  React.PropTypes.number,
      max:  React.PropTypes.number,
      size: React.PropTypes.Double

 */

object MuiCircularProgress {

  def apply(size: js.UndefOr[Double] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            min: js.UndefOr[Int] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            max: js.UndefOr[Int] = js.undefined,
            mode: js.UndefOr[MuiProgressMode] = js.undefined,
            value: js.UndefOr[Int] = js.undefined) = {

    val p = js.Dynamic.literal()
    size.foreach(v => p.updateDynamic("size")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    min.foreach(v => p.updateDynamic("min")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    max.foreach(v => p.updateDynamic("max")(v))
    mode.foreach(v => p.updateDynamic("mode")(v.mode))
    value.foreach(v => p.updateDynamic("value")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.CircularProgress)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


object MuiLinearProgress {

  def apply(size: js.UndefOr[Double] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            min: js.UndefOr[Int] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            max: js.UndefOr[Int] = js.undefined,
            mode: js.UndefOr[MuiProgressMode] = js.undefined,
            value: js.UndefOr[Int] = js.undefined) = {

    val p = js.Dynamic.literal()
    size.foreach(v => p.updateDynamic("size")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    min.foreach(v => p.updateDynamic("min")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    max.foreach(v => p.updateDynamic("max")(v))
    mode.foreach(v => p.updateDynamic("mode")(v.mode))
    value.foreach(v => p.updateDynamic("value")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.LinearProgress)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


class MuiProgressMode private(val mode: String) extends AnyVal


object MuiProgressMode {

  val DETERMINATE = new MuiProgressMode("determinate")

  val INDETERMINATE = new  MuiProgressMode("indeterminate")

  def newMode(mode: String) = new MuiProgressMode(mode)

}
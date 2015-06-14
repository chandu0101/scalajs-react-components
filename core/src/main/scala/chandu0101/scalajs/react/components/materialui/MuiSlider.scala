package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js

/**
 *
key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
required: React.PropTypes.bool,
    disabled: React.PropTypes.bool,
    min: React.PropTypes.Double,
    value: React.PropTypes.Double,
    defaultValue: React.PropTypes.Double,
    max: React.PropTypes.Double,
    step: React.PropTypes.number,
    error: React.PropTypes.string,
    description: React.PropTypes.string,
    name: React.PropTypes.string.isRequired,
    onChange: React.PropTypes.(ReactEventH,Double) => Unit,
    onFocus: React.PropTypes.func,
    onBlur: React.PropTypes.func,
    onDragStart: React.PropTypes.func,
    onDragStop: React.PropTypes.func,

 */



object MuiSlider {

  def apply(onBlur : js.UndefOr[js.Function] = js.undefined ,
            name : String ,
            onDragStart : js.UndefOr[js.Function] = js.undefined ,
            step : js.UndefOr[Int] = js.undefined,
            style : js.UndefOr[js.Any] = js.undefined,
            description : js.UndefOr[String] = js.undefined,
            onChange : js.UndefOr[(ReactEventH,Double) => Unit] = js.undefined,
            min : js.UndefOr[Double] = js.undefined,
            ref : js.UndefOr[String] = js.undefined,
            key : js.UndefOr[String] = js.undefined,
            onDragStop : js.UndefOr[js.Function] = js.undefined ,
            max : js.UndefOr[Double] = js.undefined,
            error : js.UndefOr[String] = js.undefined,
            onFocus : js.UndefOr[js.Function] = js.undefined ,
            disabled : js.UndefOr[Boolean]=js.undefined,
            required : js.UndefOr[Boolean]=js.undefined,
            defaultValue : js.UndefOr[Double] = js.undefined,
            value : js.UndefOr[Double] = js.undefined) = {

    val p = js.Dynamic.literal()
    onBlur.foreach(v => p.updateDynamic("onBlur")(v))
    p.updateDynamic("name")(name)
    onDragStart.foreach(v => p.updateDynamic("onDragStart")(v))
    step.foreach(v => p.updateDynamic("step")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    description.foreach(v => p.updateDynamic("description")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    min.foreach(v => p.updateDynamic("min")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onDragStop.foreach(v => p.updateDynamic("onDragStop")(v))
    max.foreach(v => p.updateDynamic("max")(v))
    error.foreach(v => p.updateDynamic("error")(v))
    onFocus.foreach(v => p.updateDynamic("onFocus")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    required.foreach(v => p.updateDynamic("required")(v))
    defaultValue.foreach(v => p.updateDynamic("defaultValue")(v))
    value.foreach(v => p.updateDynamic("value")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Slider)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

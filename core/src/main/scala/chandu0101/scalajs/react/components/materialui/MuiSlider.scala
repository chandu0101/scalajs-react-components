package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js


case class MuiSlider(onBlur : js.UndefOr[js.Function] = js.undefined ,
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
            value : js.UndefOr[Double] = js.undefined) {

  def apply() = {
    val props = JSMacro[MuiSlider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Slider)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

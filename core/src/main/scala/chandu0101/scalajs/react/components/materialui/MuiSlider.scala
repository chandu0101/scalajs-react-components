package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js

case class MuiSlider(onBlur: U[js.Function] = uNone ,
            name: String ,
            onDragStart: U[js.Function] = uNone ,
            step: U[Int] = uNone,
            style: U[js.Any] = uNone,
            description: U[String] = uNone,
            onChange: U[(ReactEventH,Double) => Unit] = uNone,
            min: U[Double] = uNone,
            ref: U[String] = uNone,
            key: U[String] = uNone,
            onDragStop: U[js.Function] = uNone ,
            max: U[Double] = uNone,
            error: U[String] = uNone,
            onFocus: U[js.Function] = uNone ,
            disabled: U[Boolean]=uNone,
            required: U[Boolean]=uNone,
            defaultValue: U[Double] = uNone,
            value: U[Double] = uNone) {

  def apply() = {
    val props = JSMacro[MuiSlider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Slider)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

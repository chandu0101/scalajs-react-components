package chandu0101.scalajs.react.components
package spinners

import japgolly.scalajs.react._
import scala.scalajs.js

case class Spinner(key: U[String] = uNone,
                   ref: U[String] = uNone,
                   className: U[String] = uNone) {

  def apply() = {
    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    className.foreach(v => p.updateDynamic("className")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.Spinner)
    f(JSMacro[Spinner](this)).asInstanceOf[ReactComponentU_]
  }

}

package chandu0101.scalajs.react.components.spinners

import japgolly.scalajs.react._

import scala.scalajs.js

object Spinner {

  def apply(key: js.UndefOr[String] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            className: js.UndefOr[String] = js.undefined) = {

    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    className.foreach(v => p.updateDynamic("className")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.Spinner)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

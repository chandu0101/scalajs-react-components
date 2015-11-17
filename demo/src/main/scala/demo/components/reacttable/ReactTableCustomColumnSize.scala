package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.tables.ReactTable
import chandu0101.scalajs.react.components.util.JsonUtil
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactTableCustomColumnSize {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($: BackendScope[_, _]) {
    val data: Vector[Map[String, Any]] =
      JsonUtil.jsonArrayToMap(SampleData.personJson)

    val columns: List[String] =
      List("fname", "lname", "email", "country")

    //config is a List of touple4 (String, Option[(Any) => ReactElement], Option[(Model, Model) => Boolean],Option[Double])
    // ._1: colum name you want to config
    // ._2: custom render function (custom cell factory)
    // ._3: Sorting function
    // ._4: column width (flex := width)
    val config = List(("email", None, None, Some(2.0))) // getStringSort is helper function

    def render =
      <.div(
        CodeExample(code, "Custom Column Size")(
          ReactTable(data = data, columns = columns, config = config)
        )
      )
  }

  val component = ReactComponentB[Unit]("ReactTableCustomColumnSize")
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()
}

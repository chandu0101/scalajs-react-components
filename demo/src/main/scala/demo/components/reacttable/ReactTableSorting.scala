package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{JsonUtil, ReactTable}
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactTableSorting {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {
    val data: Vector[Map[String, Any]] =
      JsonUtil.jsonArrayToMap(SampleData.personJson)

    val columns: List[String] =
      List("fname", "lname", "email", "country")

    //config is a List of touple4 (String, Option[(Any) => VdomElement], Option[(Model, Model) => Boolean],Option[Double])
    // ._1: columnname you want to config
    // ._2: custom render function (custom cell factory)
    // ._3: Sorting function
    // ._4: column width (flex := width)
    val config = List(("fname", None, Some(ReactTable.getStringSort("fname")), None)) // getStringSort is helper function

    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Sorting Table"),
        CodeExample(code, "ReactTableSorting")(
          ReactTable(data = data, columns = columns, config = config)
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("ReactTableSorting")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

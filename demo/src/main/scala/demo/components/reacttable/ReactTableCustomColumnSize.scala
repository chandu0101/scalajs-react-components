package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{ ReactTable, JsonUtil }
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

    val config = List(ReactTable.ColumnConfig(name = "email", width = Some(2.0))) // getStringSort is helper function

    def render =
      <.div(
        CodeExample(code, "Custom Column Size")(
          ReactTable(data = data, columns = columns, config = config)))
  }

  val component = ReactComponentB[Unit]("ReactTableCustomColumnSize")
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()
}

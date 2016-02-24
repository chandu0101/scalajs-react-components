package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{ ReactTable, JsonUtil }
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactTableCustomCell {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($: BackendScope[_, _]) {
    val data: Vector[Map[String, Any]] =
      JsonUtil.jsonArrayToMap(SampleData.personJson)
    val columns: List[String] =
      List("fname", "lname", "email", "country")

    val config = List(ReactTable.ColumnConfig(name = "fname", cellRenderer = customRenderer))

    def customRenderer(model: ReactTable.Model, columnId: ReactTable.ColumnKey): ReactElement = {
      val name = model(columnId).toString
      if (name.startsWith("J"))
        <.span(^.backgroundColor := "grey")(name)
      else <.span(name)
    }

    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Custom Cell Factory"),
        CodeExample(code, "ReactTableCustomCell")(
          ReactTable(data = data, columns = columns, config = config)))
  }

  val component = ReactComponentB[Unit]("plain")
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()

}

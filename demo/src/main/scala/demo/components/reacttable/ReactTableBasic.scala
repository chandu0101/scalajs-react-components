package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{JsonUtil, ReactTable}
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactTableBasic {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  val data: Vector[Map[String, Any]] =
    JsonUtil.jsonArrayToMap(SampleData.personJson)

  val columns: List[String] =
    List("fname", "lname", "email", "country")

  case class Backend($ : BackendScope[_, _]) {
    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Basic Table"),
        CodeExample(code, "ReactTableBasic")(
          ReactTable(data = data, columns = columns, rowsPerPage = 6)
        )
      )
  }

  val component = ReactComponentB[Unit]("plain")
    .renderBackend[Backend]
    .build
  // EXAMPLE:END

  def apply() = component()
}

package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{ ReactTable, JsonUtil }
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactTableCustomCellWithButtons {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($: BackendScope[_, _]) {
    val data: Vector[Map[String, Any]] =
      JsonUtil.jsonArrayToMap(SampleData.personJson)
    val columns: List[String] =
      List("fname", "lname", "email", "country", "actions")

    val config = List(ReactTable.ColumnConfig(name = "actions", cellRenderer = actionRenderer))

    def alertMe(name: String) = {
      $.modState(state ⇒ {
        scala.scalajs.js.Dynamic.global.alert(s"${name} was clicked!")
        state
      })
    }

    def actionRenderer(model: ReactTable.Model, columnId: ReactTable.ColumnKey): ReactElement = {
      val name = model("fname").toString
      <.button(^.onClick --> alertMe(name), "Click Me!")
    }

    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Custom Cell Factory"),
        CodeExample(code, "ReactTableCustomCellWithButtons")(
          ReactTable(data = data, columns = columns, config = config)))
  }

  val component = ReactComponentB[Unit]("plain")
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()

}

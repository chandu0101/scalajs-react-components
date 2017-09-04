package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.ReactTable
import demo.util.{Person, SampleData}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactTableCustomColumnSize {
  import ReactTable._

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[_, _]) {

    val configs = List(
      SimpleStringConfig[Person](name = "First Name", _.fname),
      SimpleStringConfig[Person](name = "Last Name", _.lname),
      ColumnConfig[Person](name = "Email",
                           person => <.a(^.href := s"mailto:${person.email}", person.email),
                           width = Some("10%"))(DefaultOrdering(_.email)),
      SimpleStringConfig[Person](name = "Country", _.country)
    )

    def render =
      <.div(
        CodeExample(code, "Custom Column Size")(
          ReactTable(data = SampleData.people, configs = configs, rowsPerPage = 6)()))
  }

  val component = ScalaComponent
    .builder[Unit]("ReactTableCustomColumnSize")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

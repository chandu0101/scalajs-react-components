package demo.components.reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.reacttable.ReactTable
import demo.components.CodeExample
import demo.util.{Person, SampleData}
import japgolly.scalajs.react.{BackendScope, ScalaComponent}
import japgolly.scalajs.react.vdom.html_<^._

object ReactTableSelectable {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($: BackendScope[_, _]) {
    import ReactTable._
    val configs = List(
      ColumnConfig[Person](name = "First Name", _.fname)(DefaultOrdering(_.fname)),
      SimpleStringConfig[Person](name = "Last Name", _.lname),
      ColumnConfig[Person](name = "Email", person => <.a(^.href := s"mailto:${person.email}", person.email))(DefaultOrdering(_.email)),
      SimpleStringConfig[Person](name = "Country", _.country))

    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Table with selections"),
        CodeExample(code, "ReactTableSelectable")(
          ReactTable(
            data = SampleData.people,
            configs = configs,
            rowsPerPage = 6,
            selectable = true,
            multiSelectable = true,
            allSelectable = true
          )()))
  }

  val component = ScalaComponent
    .builder[Unit]("plain")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()

}

package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{ JsonUtil, ReactTable }
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import demo.util.Person

object ReactTableBasic {
  import ReactTable._
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  //  val columns: List[String] =
  //    List("fname", "lname", "email", "country")
  val configs = List(SimpleStringConfig[Person](name = "First Name", _.fname),
    SimpleStringConfig[Person](name = "Last Name", _.lname),
    ColumnConfig[Person](name = "Email", person => <.a(^.href := s"mailto:${person.email}", person.email))(DefaultOrdering(_.email)),
    SimpleStringConfig[Person](name = "Country", _.country))

  case class Backend($: BackendScope[_, _]) {
    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Basic Table"),
        CodeExample(code, "ReactTableBasic")(
          ReactTable(data = SampleData.people,
            configs = configs,
            rowsPerPage = 6)()))
  }

  val component = ScalaComponent
    .builder[Unit]("plain")
    .renderBackend[Backend]
    .build
  // EXAMPLE:END

  def apply() = component()
}

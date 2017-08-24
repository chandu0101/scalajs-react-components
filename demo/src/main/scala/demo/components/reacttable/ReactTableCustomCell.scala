package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{ JsonUtil, ReactTable }
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import demo.util.Person

object ReactTableCustomCell {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($: BackendScope[_, _]) {
    import ReactTable._
    // let say if i want to turn all fnames to grey that starts with J (you can return any VdomElement(buttons,well another ReactTable if you want!)
  val configs = List(ColumnConfig[Person](name = "First Name", customFname),
    SimpleStringConfig[Person](name = "Last Name", _.lname),
    ColumnConfig[Person](name = "Email", person => <.a(^.href := s"mailto:${person.email}", person.email)),
    SimpleStringConfig[Person](name = "Country", _.country))

    def customFname: Person => VdomElement =
      person => {
        if (person.fname.startsWith("J"))
          <.span(^.backgroundColor := "grey")(person.fname)
        else <.span(person.fname)
      }

    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Custom Cell Factory"),
        CodeExample(code, "ReactTableCustomCell")(
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

package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ReactTableInfo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[_, _]) {
    def render =
      InfoTemplate(componentFilePath = "/tables/ReactTable.scala", scalacss = true)(
        <.div(^.cls := "full-width-section")(
          <.h3("React Table :"),
          <.p("Responsive HTML(flexbox) table with the following features"),
          <.ul(^.paddingLeft := "25px")(
            <.li("Search"),
            <.li("Pagination"),
            <.li("Sorting"),
            <.li("Custom Styles"),
            <.li("Custom Custom Column Sizes"),
            <.li("Custom Cell Factory")
          )
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("ReactTableInfo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

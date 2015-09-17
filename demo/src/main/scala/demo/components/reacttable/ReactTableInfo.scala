package demo
package components
package reacttable

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactTableInfo {
  val component = ReactComponentB[Unit]("ReactTableInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "/tables/ReactTable.scala",scalacss = true)(
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
  }).buildU

  def apply() = component()
}

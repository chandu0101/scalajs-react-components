package demo
package components
package reactlistview

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactListViewInfo {

  val component = ReactComponentB[Unit]("ReactListViewInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "listviews/ReactListView.scala")(
     <.h3("React ListView :"),
      <.p("List View Component with search feature")
    )
  }).buildU

  def apply() = component()

}

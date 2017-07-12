package demo.components

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

object ReactListViewInfo {

  val component = ScalaComponent.builder[Unit]("ReactListViewInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "listviews/ReactListView.scala")(
     <.h3("React ListView :"),
      <.p("List View Component with search feature")
    )
  }).build

  def apply() = component()

}

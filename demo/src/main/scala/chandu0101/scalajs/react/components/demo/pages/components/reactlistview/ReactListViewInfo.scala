package chandu0101.scalajs.react.components.demo.pages.components.reactlistview

import chandu0101.scalajs.react.components.demo.pages.util.InfoTemplate
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object ReactListViewInfo {

  val component = ReactComponentB[Unit]("ReactListViewInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "listviews/ReactListView.scala")(
      h3("React ListView :"),
      p("List View Component with search feature")
    )
  }).buildU


  def apply() = component()

}

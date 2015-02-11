package chandu0101.scalajs.react.components.demo.pages.components.reacttreeview

import chandu0101.scalajs.react.components.demo.pages.util.InfoTemplate
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object ReactTreeViewInfo {

  val component = ReactComponentB[Unit]("ReactTreeViewInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "treeviews/ReactTreeView.scala")(
      h3("React TreeView :"),
      p("Tree View Component with search feature")
    )
  }).buildU


  def apply() = component()

}

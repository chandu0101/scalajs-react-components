package demo.components

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactTreeViewInfo {

  val component = ReactComponentB[Unit]("ReactTreeViewInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "treeviews/ReactTreeView.scala")(
        <.h3("React TreeView :"),
        <.p("Tree View Component with search feature")
      )
    })
    .build

  def apply() = component()

}

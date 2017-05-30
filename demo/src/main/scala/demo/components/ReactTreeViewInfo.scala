package demo.components

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

object ReactTreeViewInfo {

  val component = ScalaComponent
    .builder[Unit]("ReactTreeViewInfo")
    .render(P => {
      InfoTemplate(componentFilePath = "treeviews/ReactTreeView.scala")(
        <.h3("React TreeView :"),
        <.p("Tree View Component with search feature")
      )
    })
    .build

  def apply() = component()

}

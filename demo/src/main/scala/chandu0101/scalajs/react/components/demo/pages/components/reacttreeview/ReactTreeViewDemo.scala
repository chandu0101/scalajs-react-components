package chandu0101.scalajs.react.components.demo.pages.components.reacttreeview

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.treeviews.{ReactTreeView, TreeItem}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom


/**
 * Created by chandrasekharkode .
 */
object ReactTreeViewDemo {

  val code =
    """
      | val data = TreeItem("root",
      |    TreeItem("dude1",
      |        TreeItem("dude1c")),
      |    TreeItem("dude2"),
      |    TreeItem("dude3"),
      |    TreeItem("dude4",
      |      TreeItem("dude4c",
      |        TreeItem("dude4cc")))
      |  )
      |ReactTreeView(root = data, openByDefault = true, onItemSelect = B.onItemSelect ,showSearchBox = true),
      |
    """.stripMargin

  object Style {
    def treeViewDemo = Seq(display := "flex")

    def selectedContent = Seq(alignSelf := "center", margin := "0 40px")
  }

  case class State(content: String = "")

  class Backend(t: BackendScope[_, _]) {

    def onItemSelect(item: String, parent: String, depth: Int) = {
      val content =
        s"""Selected Item : $item <br>
                                   |Its Parent  : $parent <br>
                                                           |Its depth :  $depth <br> """.stripMargin
      dom.document.getElementById("treeviewcontent").innerHTML = content
    }

  }

  val component = ReactComponentB[Unit]("ReactTreeViewDemo")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    div(
      h3("Demo"),
      CodeExample(code)(
        div(Style.treeViewDemo)(
          ReactTreeView(root = data, openByDefault = true, onItemSelect = B.onItemSelect, showSearchBox = true),
          strong(id := "treeviewcontent", Style.selectedContent)
        )
      )
    )
  }).buildU

  val data = TreeItem("root",
    TreeItem("dude1",
        TreeItem("dude1c")),
    TreeItem("dude2"),
    TreeItem("dude3"),
    TreeItem("dude4",
      TreeItem("dude4c",
        TreeItem("dude4cc")))
  )

  def apply() = component()

}

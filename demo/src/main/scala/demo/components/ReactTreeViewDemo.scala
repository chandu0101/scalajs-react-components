package demo.components

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.{ReactTreeView, TreeItem}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

object ReactTreeViewDemo {

  object Style {
    def treeViewDemo = Seq(^.display := "flex").toTagMod

    def selectedContent = Seq(^.alignSelf := "center", ^.margin := "0 40px").toTagMod
  }

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val data = TreeItem("root",
    TreeItem("dude1",
      TreeItem("dude1c")),
    TreeItem("dude2"),
    TreeItem("dude3"),
    TreeItem("dude4",
      TreeItem("dude4c",
        TreeItem("dude4cc")))
  )

  case class State(content: String = "")

  class Backend(t: BackendScope[_, _]) {

    def onItemSelect(item: String, parent: String, depth: Int): Callback = {
      val content =
        s"""Selected Item: $item <br>
            |Its Parent : $parent <br>
            |Its depth:  $depth <br>
          """.stripMargin
      Callback(dom.document.getElementById("treeviewcontent").innerHTML = content)
    }

    def render = {
      <.div(
        <.h3("Demo"), CodeExample(code, "ReactTreeView")(
          <.div(Style.treeViewDemo)(
            ReactTreeView(
              root = data,
              openByDefault = true,
              onItemSelect = onItemSelect _,
              showSearchBox = true
            ),
            <.strong(^.id := "treeviewcontent", Style.selectedContent)
          )
        )
      )
    }
  }

  val component = ScalaComponent.builder[Unit]("ReactTreeViewDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()

}

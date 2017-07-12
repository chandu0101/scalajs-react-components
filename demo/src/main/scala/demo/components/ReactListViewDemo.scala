package demo.components

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.ReactListView
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

object ReactListViewDemo {

  object Style {

    def listViewComponent = Seq(^.float := "left", ^.marginBottom := "2em").toTagMod

    def selectedContent = Seq(^.alignSelf := "center", ^.margin := "0 40px").toTagMod

    def listViewDemo = Seq(^.display := "flex").toTagMod
  }

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val data = List("ScalaJS", "JavasScript", "ReactJS", "Html", "Css", "Software", "Browser")

  case class State(content: String = "")

  class Backend(t: BackendScope[_, _]) {

    def onItemSelect(item: String) = Callback {
      val content = s"Selected Item: $item <br>"
      dom.document.getElementById("listviewcontent").innerHTML = content
    }

    def render =
      <.div(
        <.h3("Demo"), CodeExample(code, "ReactListView")(
          <.div(Style.listViewDemo)(
            ReactListView(
              items = data,
              showSearchBox = true,
              onItemSelect = onItemSelect _
            ),
            <.strong(
              ^.id := "listviewcontent",
              Style.selectedContent,
              "Selected Content Here"
            )
          )
        )
      )
  }

  val component = ScalaComponent.builder[Unit]("ReactListViewDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build
  // EXAMPLE:END

  def apply() = component()
}
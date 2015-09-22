package demo
package components
package reactlistview

import chandu0101.scalajs.react.components.listviews.ReactListView
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom

object ReactListViewDemo {

  val code =
    """
      |val data = List("ScalaJS","JavasScript","ReactJS","Html","Css","Software","Browser")
      |
      |ReactListView(items = data, showSearchBox = true ,onItemSelect = B.onItemSelect)
      |
    """.stripMargin

  object Style {

    def listViewComponent = Seq(^.float := "left", ^.marginBottom := "2em")

    def selectedContent = Seq(^.alignSelf := "center", ^.margin := "0 40px")

    def listViewDemo = Seq(^.display := "flex")
  }

  case class State(content: String = "")

  class Backend(t: BackendScope[_, _]) {

    def onItemSelect(item: String) = Callback{
      val content = s"Selected Item: $item <br>"
      dom.document.getElementById("listviewcontent").innerHTML = content
    }

    def render =
      <.div(
        <.h3("Demo"), CodeExample(code)(
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

  val component = ReactComponentB[Unit]("ReactListViewDemo")
    .initialState(State())
    .renderBackend[Backend]
    .buildU

  lazy val data = List("ScalaJS","JavasScript","ReactJS","Html","Css","Software","Browser")

  def apply() = component()
}
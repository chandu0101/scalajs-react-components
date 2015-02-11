package chandu0101.scalajs.react.components.demo.pages.components.reactlistview

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.listviews.ReactListView
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom


/**
 * Created by chandrasekharkode .
 */
object ReactListViewDemo {

  val code =
    """
      |val data = List("ScalaJS","JavasScript","ReactJS","Html","Css","Software","Browser")
      |
      |ReactListView(items = data, showSearchBox = true ,onItemSelect = B.onItemSelect)
      |
    """.stripMargin

  object Style {

    def listViewComponent = Seq(float := "left" , marginBottom := "2em")

    def selectedContent = Seq(alignSelf := "center" , margin := "0 40px")

    def listViewDemo = Seq( display := "flex")
  }

  case class State(content: String = "")

  class Backend(t: BackendScope[_, _]) {

    def onItemSelect(item: String) = {
        val content =
          s"Selected Item : $item <br>"
        dom.document.getElementById("listviewcontent").innerHTML = content
    }

  }

  val component = ReactComponentB[Unit]("ReactListViewDemo")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    div()(
      h3("Demo"),
      CodeExample(code)(
        div(Style.listViewDemo)(
          ReactListView(items = data, showSearchBox = true ,onItemSelect = B.onItemSelect),
          strong(id := "listviewcontent" ,Style.selectedContent)("Selected Content Here")
        )
      )
    )
  }).buildU


  val data = List("ScalaJS","JavasScript","ReactJS","Html","Css","Software","Browser")

  def apply() = component()

}

package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiListDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    def render() =
      <.div(
        CodeExample(code, "SuiList")(
          SuiList()(
            SuiListItem()(
              SuiListIcon(name = SuiIconType("users"))(),
              SuiListContent()("Semantic UI")
            ),
            SuiListItem()(
              SuiListIcon(name = SuiIconType("marker"))(),
              SuiListContent()("New York, NY")
            ),
            SuiListItem()(
              SuiListIcon(name = SuiIconType("mail"))(),
              SuiListContent()(
                <.a(^.href := "mailto:jack@semantic-ui.com")("jack@semantic-ui.com"))
            ),
            SuiListItem()(
              SuiListIcon(name = SuiIconType("linkify"))(),
              SuiListContent()(<.a(^.href := "http://www.semantic-ui.com")("semantic-ui.com"))
            )
          )
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("SuiListDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

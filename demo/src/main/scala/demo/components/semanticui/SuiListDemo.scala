package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object SuiListDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($ : BackendScope[Unit, Unit]) {

    def render() =
      <.div(
        CodeExample(code, "SuiList")(
          SuiList()(
            SuiListItem()(
              SuiListIcon(name = "users")(),
              SuiListContent()("Semantic UI")
            ),
            SuiListItem()(
              SuiListIcon(name = "marker")(),
              SuiListContent()("New York, NY")
            ),
            SuiListItem()(
              SuiListIcon(name = "mail")(),
              SuiListContent()(<.a(^.href := "mailto:jack@semantic-ui.com")("jack@semantic-ui.com"))
            ),
            SuiListItem()(
              SuiListIcon(name = "linkify")(),
              SuiListContent()(<.a(^.href := "http://www.semantic-ui.com")("semantic-ui.com"))
            )
          )
        )
      )
  }

  val component = ReactComponentB[Unit]("SuiListDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

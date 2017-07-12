package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object CodeExample {

  object Style {

    val pageBodyContent = Seq(^.borderRadius := "2px",
                              ^.boxShadow := "0 1px 4px rgba(223, 228, 228, 0.79)",
                              ^.maxWidth := "1024px").toTagMod

    val contentDemo = Seq(^.padding := "30px").toTagMod

    val contentCode = Seq(^.borderTop := "solid 1px #e0e0e0").toTagMod

    val title = Seq(^.paddingBottom := "15px").toTagMod

  }

  case class Backend($ : BackendScope[Props, _]) {
    def render(P: Props, C: PropsChildren) = {
      <.div(
        ^.key := "code-example",
        <.h3(Style.title, P.title).when(P.title.nonEmpty),
        <.div(Style.pageBodyContent)(
          <.div(Style.contentDemo, ^.key := "dan")(
            C
          ),
          <.pre(Style.contentCode, ^.key := "code")(
            CodeHighlight(P.code)
          )
        )
      )
    }
  }

  val component = ScalaComponent
    .builder[Props]("codeexample")
    .renderBackendWithChildren[Backend]
    .build

  case class Props(code: String, title: String)

  def apply(code: String, title: String)(children: VdomNode*) =
    component(Props(code, title))(children: _*)
}

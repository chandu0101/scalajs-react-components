package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object CodeExample {

  object Style {

    val pageBodyContent = TagMod(
      ^.borderRadius := "2px",
      ^.boxShadow := "0 1px 4px rgba(223, 228, 228, 0.79)",
      ^.maxWidth := "1024px"
    )

    val contentDemo = TagMod(^.padding := "30px")

    val contentCode = TagMod(^.borderTop := "solid 1px #e0e0e0")

    val title = TagMod(
      ^.paddingBottom := "15px"
    )

  }
  case class Backend($ : BackendScope[Props, Unit]) {
    def render(P: Props, C: PropsChildren) = {
      <.div(
        (<.h3(P.title, Style.title)).when(P.title.nonEmpty),
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

  def apply(
      code: String,
      title: String
  )(children: VdomNode*) = {
    //    component.set(key, ref)(Props(code, title), children: _*)
    component(Props(code, title))(children: _*)
  }
}

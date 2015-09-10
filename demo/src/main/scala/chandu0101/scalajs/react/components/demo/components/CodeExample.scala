package chandu0101.scalajs.react.components
package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 */
object CodeExample {


  object Style {

    val pageBodyContent = Seq(^.borderRadius := "2px",
      ^.boxShadow := "0 1px 4px rgba(223, 228, 228, 0.79)",
      ^.maxWidth := "1024px")

    val contentDemo = Seq(^.padding := "30px")

    val contentCode = Seq(^.borderTop := "solid 1px #e0e0e0"
    )

    val title = Seq(
    ^.paddingBottom := "15px")


  }

  val component = ReactComponentB[Props]("codeexample")
    .render((P, C) => {
    <.div(
      P.title.nonEmpty ?= <.h3(P.title,Style.title),
      <.div(Style.pageBodyContent)(
        <.div(Style.contentDemo, ^.key := "dan")(
          C
        ),
        <.pre(Style.contentCode, ^.key := "code")(
          CodeHighLighter(P.code)
        )
      )
    )
  })
    .build


  case class Props(code: String,title : String)

  def apply(code: String, title: String = "", ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = component.set(key, ref)(Props(code,title), children)

}

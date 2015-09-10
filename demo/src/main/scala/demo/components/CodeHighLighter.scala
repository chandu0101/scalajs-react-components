package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.ext.PimpedNodeList

object CodeHighLighter {


  val component = ReactComponentB[String]("CodeHighLighter")

    .render(P => {
     <.code(^.padding := "20px", P)
  })
    .configure(installSyntaxHighlighting)
    .build

  def installSyntaxHighlighting[P, S, B, N <: TopNode] =
    (_: ReactComponentB[P, S, B, N])
      .componentDidMount(_ => applySyntaxHighlight())
      .componentDidUpdate((_, _, _) => applySyntaxHighlight())

  def applySyntaxHighlight() = {
    import scala.scalajs.js.Dynamic.{global => g}
    val nodeList = dom.document.querySelectorAll("code").toArray
    nodeList.foreach(n => g.hljs.highlightBlock(n))
  }

  def apply(code: String) = component(code)
}

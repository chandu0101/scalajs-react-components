package demo
package components

import chandu0101.scalajs.react.components.hljs.Hljs
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Generic.toComponentCtor
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import org.scalajs.dom.ext.PimpedNodeList

object CodeHighlight {
  val applySyntaxHighlight = Callback(
    dom.document.querySelectorAll("code").foreach(Hljs.highlightBlock)
  )

  private val component = ScalaComponent
    .builder[String]("CodeHighLighter")
    .render_P(str => <.code(^.`class` := "scala", ^.padding := "20px", str))
    .configure(
      _.componentDidMountConst(applySyntaxHighlight).componentDidUpdateConst(applySyntaxHighlight))
    .build

  def apply(code: String) = component(code)
}

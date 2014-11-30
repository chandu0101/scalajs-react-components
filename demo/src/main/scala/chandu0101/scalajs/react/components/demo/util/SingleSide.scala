package chandu0101.scalajs.react.components.demo.util


import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.ReactVDom.all._
import org.scalajs.dom
import org.scalajs.dom.extensions.PimpedNodeList

/**
 * Created by chandrasekharkode on 12/1/14.
 */
object SingleSide {


  val singleSideComponent = ReactComponentB[(String, Modifier)]("singleSideComponent")
    .render(P => {
    val (scalaCode, component) = P
    div(`class` := "row")(
      div(`class` := "col-md-6")(
        pre(code(scalaCode))
      ),
      div(`class` := "col-md-6")(
        component
      )
    )
  })
    .componentDidMount(_ => {
    applySyntaxHighlight()
  })
    .componentDidUpdate((_, _, _) => {
    applySyntaxHighlight()
  })
    .build

  def component(scalaCode: String, demo: Modifier) = {
    singleSideComponent((scalaCode, demo))
  }


  def applySyntaxHighlight() = {
    import scala.scalajs.js.Dynamic.{global => g}
    val nodeList = dom.document.querySelectorAll("pre code").toArray
    nodeList.foreach(n => g.hljs.highlightBlock(n))
  }
}

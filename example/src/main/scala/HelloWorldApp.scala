package demo

import chandu0101.scalajs.react.components.ReactTapEventPlugin
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import chandu0101.scalajs.react.components.elementalui.EuiButton
import chandu0101.scalajs.react.components.elementalui.ButtonType

object HelloWorldApp extends JSApp {

  override def main(): Unit = {
    // remove waiting page stuff
    if (!js.isUndefined(g.loadingElement)) {
      g.document.body.removeChild(g.loadingElement)
      g.loadingElement = js.undefined
      dom.document.body.className.replace("pg-loading", "")
      dom.document.body.className += " pg-loaded"
    }

    //todo: dev-server complains that we load several times?
    ReactTapEventPlugin(js.undefined)
//    ReactTapEventPlugin

    val component =
      ScalaComponent
        .builder[Unit]("component")
        .renderStatic(
          <.div(^.padding := 100.px, EuiButton(`type` = ButtonType.primary)("Hello World!"))
        )
        .build

    component().renderIntoDOM(dom.document.getElementById("container"))
    ()
  }
}

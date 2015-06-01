package chandu0101.scalajs.react.components.demo

import chandu0101.scalajs.react.components.demo.routes.AppRouter
import japgolly.scalajs.react.React
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global ⇒ g}
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport


/**
 * Created by chandrasekharkode .
 */
object ReactApp extends JSApp {

  @JSExport
  override def main(): Unit = {
    // remove waiting page stuff
    if(!js.isUndefined(g.loadingElement)) {
      g.document.body.removeChild(g.loadingElement)
      g.loadingElement = js.undefined
      dom.document.body.className.replace("pg-loading","")
      dom.document.body.className += " pg-loaded"
    }
    React.render(AppRouter.C(), dom.document.getElementById("container"))
  }
}

package chandu0101.scalajs.react.components
package demo

import chandu0101.scalajs.react.components.demo.css.AppCSS
import chandu0101.scalajs.react.components.demo.routes.AppRouter
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.JSApp


/**
 * Created by chandrasekharkode .
 */
object ReactApp extends JSApp {

  override def main(): Unit = {
    // remove waiting page stuff
    if (!js.isUndefined(g.loadingElement)) {
      g.document.body.removeChild(g.loadingElement)
      g.loadingElement = js.undefined
      dom.document.body.className.replace("pg-loading", "")
      dom.document.body.className += " pg-loaded"
    }
    AppCSS.load
    AppRouter.router().render(dom.document.getElementById("container"))
  }
}

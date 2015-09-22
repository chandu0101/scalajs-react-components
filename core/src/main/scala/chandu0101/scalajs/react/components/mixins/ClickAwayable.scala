package chandu0101.scalajs.react.components
package mixins

import chandu0101.scalajs.react.components.util.DomUtil
import japgolly.scalajs.react.CompScope.DuringCallbackM
import japgolly.scalajs.react._
import org.scalajs.dom
import org.scalajs.dom.{Event, html}
import scala.scalajs.js

trait ClickAwayable {
  def onClickAway: Callback

  var listener: js.Function1[Event, _] = null
}

object ClickAwayable {
  def mixin[P, S, B <: ClickAwayable, N <: TopNode] = (c: ReactComponentB[P, S, B, N]) => {
    def initiateListener(t: DuringCallbackM[P, S, B, N]) = {
      t.backend.listener =
        (e: dom.Event) => {
          val el = t.getDOMNode()
          if (t.isMounted() && el != e.target && !DomUtil.isDecedant(el, e.target.asInstanceOf[html.Element])) {
            t.backend.onClickAway.runNow()
          }
        }
    }
    c.componentDidMount($ =>
      Callback{
        initiateListener($)
        dom.document.addEventListener("click", $.backend.listener)
      }
    ).componentWillUnmount($ =>
      Callback(dom.document.removeEventListener("click", $.backend.listener)))
  }
}

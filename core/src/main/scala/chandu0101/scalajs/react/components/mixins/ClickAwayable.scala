package chandu0101.scalajs.react.components.mixins

import chandu0101.scalajs.react.components.util.DomUtil
import japgolly.scalajs.react.{ComponentScopeM, ReactComponentB}
import org.scalajs.dom
import org.scalajs.dom.{Event, html}

import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 */
trait ClickAwayable {
  def onClickAway()

  var listener: js.Function1[Event, _] = null
}

object ClickAwayable {

  def mixin[P, S, B] = (c: ReactComponentB[P, S, B]) => {
    def initiateListener(t: ComponentScopeM[_, _, _]) = {
      val b = t.backend.asInstanceOf[ClickAwayable]
      b.listener =
        (e: dom.Event) => {
          val el = t.getDOMNode()
          if (t.isMounted() && el != e.target && !DomUtil.isDecedant(el, e.target.asInstanceOf[html.Element])) {
            b.onClickAway
          }
        }
    }
    c.componentDidMount(scope => {
      initiateListener(scope)
      dom.document.addEventListener("click", scope.backend.asInstanceOf[ClickAwayable].listener)
      })
      .componentWillUnmount(scope => dom.document.removeEventListener("click", scope.backend.asInstanceOf[ClickAwayable].listener))
  }
}

package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom._
import org.scalajs.dom.ext.PimpedNodeList

import scala.scalajs.js
import scala.scalajs.js.JSON

/**
  *
  * To load resources(javascript,stylesheet) on fly
  */
trait AsyncLoad {

  def jsResources: Vector[String] = Vector.empty

  def cssResources: Vector[String] = Vector.empty

}

object AsyncLoad {
  def mixin[P, S, B <: AsyncLoad, N <: TopNode] = (c: ReactComponentB[P, S, B, N]) =>
    c.componentWillMount{$ =>
      val links = dom.document.getElementsByTagName("link")
      val scripts = dom.document.getElementsByTagName("src")

      Callback{
        $.backend.cssResources.foreach{s =>
          val head = dom.document.head
          val link = dom.document.createElement("link")
          link.setAttribute("rel","stylesheet")
          link.setAttribute("href",s)
          if(!links.contains(link)) head.appendChild(link)
        }

        $.backend.jsResources.foreach{s =>
          val body = dom.document.body
          val script = dom.document.createElement("script")
          script.setAttribute("type","text/javascript")
          script.setAttribute("src",s)
          if(!scripts.contains(script)) body.appendChild(script)
        }
      }
    }
}


object Events {
  def register(element: EventTarget,
               tpe: String,
               _cb: Event => Callback,
               capture: Boolean = false): Callback = {
    val cb: js.Function1[Event, Unit] = (e: Event) => _cb(e).runNow()
    element.addEventListener(tpe, cb, capture)
    Callback(element.removeEventListener(tpe, cb, capture))
  }
}

object JsonUtil {

  def jsonArrayToMap(json: String): Vector[Map[String,Any]] = {
    if(!json.isEmpty) {
      JSON.parse(json).asInstanceOf[js.Array[js.Dynamic]].toVector
        .map(item => item.asInstanceOf[js.Dictionary[Any]].toMap)
    } else null
  }
}

object RCustomStyles extends RCustomStyles

/**
  * Eventually these should be copied to scalajs-react core
  */
trait RCustomStyles {
  val MsFlexAlign =          "MsFlexAlign".reactStyle
  val MsFlexDirection =      "MsFlexDirection".reactStyle
  val MsFlexWrap =           "MsFlexWrap".reactStyle
  val WebkitAlignItems =     "WebkitAlignItems".reactStyle
  val WebkitBackgroundClip = "WebkitBackgroundClip".reactStyle
  val WebkitBoxAlign =       "WebkitBoxAlign".reactStyle
  val WebkitBoxDirection =   "WebkitBoxDirection".reactStyle
  val WebkitBoxOrient =      "WebkitBoxOrient".reactStyle
  val WebkitBoxShadow =      "WebkitBoxShadow".reactStyle
  val WebkitFlexDirection =  "WebkitFlexDirection".reactStyle
  val WebkitFlexWrap =       "WebkitFlexWrap".reactStyle
  val WebkitTransform =      "WebkitTransform".reactStyle
  val mozTransform =         "mozTransform".reactStyle
  val msTransform =          "msTransform".reactStyle
}

object RefHolder{
  def apply[N]: RefHolder[N]= new RefHolder[N]
}

final class RefHolder[N]{
  private var r: js.UndefOr[N] = js.undefined

  def apply() = get

  val set: N => Unit =
    t => r = js.UndefOr.any2undefOrA(t)

  val get: CallbackOption[N] =
    CallbackOption.liftOptionLike(r)

  val invalidate: Unit =
    r = js.undefined
}
package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom._
import org.scalajs.dom.ext.PimpedNodeList
import org.scalajs.dom.raw.HTMLScriptElement

import scala.scalajs.js
import scala.scalajs.js.JSON

object WithAsyncScript {
  class Props(val scripts: Set[String], _toRender: ⇒ ReactElement, val loadingScreenOpt: js.UndefOr[Set[String] => ReactElement]){
    lazy val toRender = _toRender
  }

  case class Backend($: BackendScope[Props, Set[String]]){
    def render(P: Props, loadedScripts: Set[String]) =
        if (P.scripts == loadedScripts) P.toRender
        else P.loadingScreenOpt.fold[ReactElement](<.div())(f => f(P.scripts -- loadedScripts))

    def load(P: Props, alreadyLoaded: Set[String]): Callback = {
      val scripts       = dom.document.getElementsByTagName("src")

      Callback {
        val loaded = P.scripts.map { s =>
          val body   = dom.document.body
          val script = dom.document.createElement("script").asInstanceOf[HTMLScriptElement]

          script.setAttribute("type", "text/javascript")
          script.setAttribute("src", s)

          if (scripts.contains(script))
            Some(s)
          else {
            script.onload = (e: Event) => {
              console.log(s"Loaded $s")
              $.setState(alreadyLoaded + s).runNow()
            }
            body.appendChild(script)
            None
          }
        }
        $.setState(loaded.flatten).runNow()
      }
    }
  }

  val component =
    ReactComponentB[Props]("AsyncLoadC")
    .initialState(Set.empty[String])
    .renderBackend[Backend]
    .componentWillMount($ => $.backend.load($.props, $.state))
    .build

  def apply(scripts: String*)(e: ⇒ ReactElement, loadingScreenOpt: js.UndefOr[Set[String] => ReactElement] = js.undefined) =
    component(new Props(scripts.toSet, e, loadingScreenOpt))
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
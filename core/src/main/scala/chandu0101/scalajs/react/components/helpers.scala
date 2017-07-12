package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import org.scalajs.dom._
import org.scalajs.dom.ext.PimpedNodeList
import org.scalajs.dom.raw.HTMLScriptElement

import scala.scalajs.js
import scala.scalajs.js.JSON

object WithAsyncScript {
  class Props(val scripts: Set[String],
              _toRender: ⇒ VdomElement,
              val loadingScreenOpt: js.UndefOr[Set[String] => VdomElement]) {
    lazy val toRender = _toRender
  }

  case class Backend($ : BackendScope[Props, Set[String]]) {
    def render(P: Props, loadedScripts: Set[String]): VdomElement =
      if (P.scripts == loadedScripts) P.toRender
      else P.loadingScreenOpt.fold[VdomElement](<.div())(f => f(P.scripts -- loadedScripts))

    def load(P: Props, alreadyLoaded: Set[String]): Callback = {
      val scripts = dom.document.getElementsByTagName("src")

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
    ScalaComponent
      .builder[Props]("AsyncLoadC")
      .initialState(Set.empty[String])
      .renderBackend[Backend]
      .componentWillMount($ => $.backend.load($.props, $.state))
      .build

  def apply(scripts: String*)(e: ⇒ VdomElement,
                              loadingScreenOpt: js.UndefOr[Set[String] => VdomElement] =
                                js.undefined) =
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

  def jsonArrayToMap(json: String): Vector[Map[String, Any]] = {
    if (!json.isEmpty) {
      JSON
        .parse(json)
        .asInstanceOf[js.Array[js.Dynamic]]
        .toVector
        .map(item => item.asInstanceOf[js.Dictionary[Any]].toMap)
    } else null
  }
}

object RCustomStyles extends RCustomStyles

/**
  * Eventually these should be copied to scalajs-react core
  */
trait RCustomStyles {
  val MsFlexAlign          = VdomStyle("MsFlexAlign")
  val MsFlexDirection      = VdomStyle("MsFlexDirection")
  val MsFlexWrap           = VdomStyle("MsFlexWrap")
  val WebkitAlignItems     = VdomStyle("WebkitAlignItems")
  val WebkitBackgroundClip = VdomStyle("WebkitBackgroundClip")
  val WebkitBoxAlign       = VdomStyle("WebkitBoxAlign")
  val WebkitBoxDirection   = VdomStyle("WebkitBoxDirection")
  val WebkitBoxOrient      = VdomStyle("WebkitBoxOrient")
  val WebkitBoxShadow      = VdomStyle("WebkitBoxShadow")
  val WebkitFlexDirection  = VdomStyle("WebkitFlexDirection")
  val WebkitFlexWrap       = VdomStyle("WebkitFlexWrap")
  val WebkitTransform      = VdomStyle("WebkitTransform")
  val mozTransform         = VdomStyle("mozTransform")
  val msTransform          = VdomStyle("msTransform")
}

object RefHolder {
  def apply[N]: RefHolder[N] = new RefHolder[N]
}

final class RefHolder[N] {
  private var r: js.UndefOr[N] = js.undefined

  def apply() = get

  val set: N => Unit =
    t => r = js.UndefOr.any2undefOrA(t)

  val get: CallbackOption[N] =
    CallbackOption.liftOptionLike(r)

  val invalidate: Unit =
    r = js.undefined
}

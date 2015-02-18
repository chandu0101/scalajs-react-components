package chandu0101.scalajs.react.components.util

import japgolly.scalajs.react.TopNode
import org.scalajs.dom.{Event, EventTarget}

import scala.scalajs.js

/**
 * Created by chandrasekharkode .
 */
object Events {

  def once(element : TopNode , tpe : String, callback : js.Function1[Event,Any]) = {
    lazy val cb: js.Function1[Event, Any] = { (e: Event) =>
      e.target.removeEventListener(e.`type`, cb) // using cb here
      callback(e)
    }
    tpe.split(" ").foreach(item => element.addEventListener(item, cb))
  }
  def on(element : EventTarget , tpe : String,callback : js.Function1[Event,_] ,capture : Boolean = false) = {
    element.addEventListener(tpe,callback,capture)
  }

  def off(element : EventTarget , tpe : String,callback : js.Function1[Event,_] ,capture : Boolean = false) = {
    element.removeEventListener(tpe,callback,capture)
  }

 val KEYUP = "keyup"
 val CLICK = "click"
 val KEYDOWN = "keydown"

}

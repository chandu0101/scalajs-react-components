package chandu0101.scalajs.react.components
package util

import scala.scalajs.js
import scala.scalajs.js.JSON

object JsonUtil {

  def jsonArrayToMap(json : String) : Vector[Map[String,Any]] = {
     if(!json.isEmpty) {
       JSON.parse(json).asInstanceOf[js.Array[js.Dynamic]].toVector
       .map(item => item.asInstanceOf[js.Dictionary[Any]].toMap)
     } else null
  }
}

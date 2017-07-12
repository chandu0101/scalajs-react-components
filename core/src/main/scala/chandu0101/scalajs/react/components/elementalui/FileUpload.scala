package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React

import scala.scalajs.js

case class File(lastModifiedDate: String, name: String, isClosed: Boolean, size: Long, `type`: String) {
  val toJS = JSMacro[File](this)
}

object File {
  def fromJson(obj: js.Dynamic) = File(
    lastModifiedDate = obj.lastModifiedState.toString,
    name = obj.name.toString,
    isClosed = obj.isClosed.toString.toBoolean,
    size = obj.size.toString.toLong,
    `type` = obj.`type`.toString)

}

case class FileUpload(className: js.UndefOr[String] = js.undefined,
    accept: js.UndefOr[String] = js.undefined,
    buttonLabelChange: js.UndefOr[String] = js.undefined,
    buttonLabelInitial: js.UndefOr[String] = js.undefined,
    file: js.UndefOr[File] = js.undefined,
    onChange: js.UndefOr[ReactEvent => Callback] = js.undefined) {

  def apply() = {
    val props = JSMacro[FileUpload](this)
    val component = JsComponent[js.Object, Children.None, Null](Eui.FileUpload)
    component(props)
  }
}

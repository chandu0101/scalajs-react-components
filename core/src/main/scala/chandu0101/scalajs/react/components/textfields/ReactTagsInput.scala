package chandu0101.scalajs.react.components
package textfields

import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}

case class ReactTagsInput(onBlur: U[Callback] = uNone,
                          onKeyDown: U[ReactEventI => Callback] = uNone,
                          onTagRemove: U[String => Callback] = uNone,
                          onChange: U[(JArray[String], String) => Callback] = uNone,
                          removeKeys: U[JArray[Int]] = uNone,
                          validate: U[String => Boolean] = uNone,
                          classNamespace: U[String] = uNone,
                          ref: U[ReactTagsInputM => Unit] = uNone,
                          addOnBlur: U[Boolean] = uNone,
                          placeholder: U[String] = uNone,
                          valueLink: U[js.Object] = uNone,
                          onKeyUp: U[ReactEventI => Callback] = uNone,
                          key: U[String] = uNone,
                          addKeys: U[JArray[Int]] = uNone,
                          onTagAdd: U[String => Callback] = uNone,
                          validateAsync: U[js.Function] = uNone,
                          onChangeInput: U[String => Callback] = uNone,
                          defaultValue: U[JArray[String]] = uNone,
                          transform: U[String => Callback] = uNone,
                          value: U[JArray[String]] = uNone) {

  def apply() = {
    val props = JSMacro[ReactTagsInput](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.ReactTagsInput)
    f(props).asInstanceOf[ReactComponentU_]
  }

}

@js.native
trait ReactTagsInputM extends js.Object {

  def focus(): Unit = js.native

  def clear(): Unit = js.native

  def getTags(): JArray[String] = js.native

  def addTag(tag: String): Unit = js.native

  def removeTag(tag: String): Unit = js.native

}

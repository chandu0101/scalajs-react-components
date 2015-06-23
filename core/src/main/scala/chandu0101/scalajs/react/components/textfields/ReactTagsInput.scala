package chandu0101.scalajs.react.components.textfields

import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.{Array => JArray}

/**
 * key: PropTypes.string,
ref: PropTypes.String,
value: React.PropTypes.JArray[String],
valueLink: React.PropTypes.object,
defaultValue: React.PropTypes.JArray[String],
placeholder: React.PropTypes.string,
classNamespace: React.PropTypes.string,
addKeys: React.PropTypes.JArray[Int],
removeKeys: React.PropTypes.JArray[Int],
addOnBlur: React.PropTypes.bool,
onChange: React.PropTypes.(JArray[String],String) => Unit,
onChangeInput: React.PropTypes.String => Unit,
onBlur: React.PropTypes.() => Unit,
onKeyDown: React.PropTypes.ReactEventI => Unit,
onKeyUp: React.PropTypes.ReactEventI => Unit,
onTagAdd: React.PropTypes.String => Unit,
onTagRemove: React.PropTypes.String => Unit,
transform: React.PropTypes.String => Unit,
validate: React.PropTypes.String => Boolean,
validateAsync: React.PropTypes.func

 */

object ReactTagsInput {

  def apply(onBlur: js.UndefOr[() => Unit] = js.undefined,
            onKeyDown: js.UndefOr[ReactEventI => Unit] = js.undefined,
            onTagRemove: js.UndefOr[String => Unit] = js.undefined,
            onChange: js.UndefOr[(JArray[String], String) => Unit] = js.undefined,
            removeKeys: js.UndefOr[JArray[Int]] = js.undefined,
            validate: js.UndefOr[String => Boolean] = js.undefined,
            classNamespace: js.UndefOr[String] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            addOnBlur: js.UndefOr[Boolean] = js.undefined,
            placeholder: js.UndefOr[String] = js.undefined,
            valueLink: js.UndefOr[js.Object] = js.undefined,
            onKeyUp: js.UndefOr[ReactEventI => Unit] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            addKeys: js.UndefOr[JArray[Int]] = js.undefined,
            onTagAdd: js.UndefOr[String => Unit] = js.undefined,
            validateAsync: js.UndefOr[js.Function] = js.undefined,
            onChangeInput: js.UndefOr[String => Unit] = js.undefined,
            defaultValue: js.UndefOr[JArray[String]] = js.undefined,
            transform: js.UndefOr[String => Unit] = js.undefined,
            value: js.UndefOr[JArray[String]] = js.undefined) = {

    val p = js.Dynamic.literal()
    onBlur.foreach(v => p.updateDynamic("onBlur")(v))
    onKeyDown.foreach(v => p.updateDynamic("onKeyDown")(v))
    onTagRemove.foreach(v => p.updateDynamic("onTagRemove")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    removeKeys.foreach(v => p.updateDynamic("removeKeys")(v))
    validate.foreach(v => p.updateDynamic("validate")(v))
    classNamespace.foreach(v => p.updateDynamic("classNamespace")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    addOnBlur.foreach(v => p.updateDynamic("addOnBlur")(v))
    placeholder.foreach(v => p.updateDynamic("placeholder")(v))
    valueLink.foreach(v => p.updateDynamic("valueLink")(v))
    onKeyUp.foreach(v => p.updateDynamic("onKeyUp")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    addKeys.foreach(v => p.updateDynamic("addKeys")(v))
    onTagAdd.foreach(v => p.updateDynamic("onTagAdd")(v))
    validateAsync.foreach(v => p.updateDynamic("validateAsync")(v))
    onChangeInput.foreach(v => p.updateDynamic("onChangeInput")(v))
    defaultValue.foreach(v => p.updateDynamic("defaultValue")(v))
    transform.foreach(v => p.updateDynamic("transform")(v))
    value.foreach(v => p.updateDynamic("value")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.ReactTagsInput)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


trait ReactTagsInputM extends js.Object {

  def focus(): Unit = js.native

  def clear(): Unit = js.native

  def getTags(): JArray[String] = js.native

  def addTag(tag: String): Unit = js.native

  def removeTag(tag: String): Unit = js.native

}

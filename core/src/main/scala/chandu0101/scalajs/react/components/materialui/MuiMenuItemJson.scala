package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import chandu0101.macros.tojs.JSMacro

//todo: not sure how many of these are in use
case class MuiMenuItemJson(
  attribute:      js.UndefOr[ReactElement]         = js.undefined,
  className:      js.UndefOr[String]               = js.undefined,
  data:           js.UndefOr[String]               = js.undefined,
  defaultToggled: js.UndefOr[Boolean]              = js.undefined,
  disabled:       js.UndefOr[Boolean]              = js.undefined,
  icon:           js.UndefOr[ReactElement]         = js.undefined,
  iconClassName:  js.UndefOr[String]               = js.undefined,
  id:             js.UndefOr[String]               = js.undefined,
//  items:          js.UndefOr[Seq[MuiMenuItemJson]] = js.undefined, //todo: macro doesnt support nested structures
  number:         js.UndefOr[String]               = js.undefined,
  payload:        js.UndefOr[String]               = js.undefined,
  route:          js.UndefOr[String]               = js.undefined,
  selected:       js.UndefOr[Boolean]              = js.undefined,
  style:          js.UndefOr[CssProperties]        = js.undefined,
  target:         js.UndefOr[String]               = js.undefined,
  text:           js.UndefOr[String]               = js.undefined,
  toggle:         js.UndefOr[Boolean]              = js.undefined,
  `type`:         js.UndefOr[MuiMenuItemType]      = js.undefined) {

  val toJS = JSMacro[MuiMenuItemJson](this)
}

object MuiMenuItemJson {
  def link(text: String, payload: String, disabled: js.UndefOr[Boolean] = js.undefined) =
    MuiMenuItemJson(`type` = MuiMenuItemType.LINK, text = text, payload = payload, disabled = disabled)

  def subheader(text: String) =
    MuiMenuItemJson(`type` = MuiMenuItemType.SUBHEADER, text = text)

//  def nested(text: String, items: Seq[MuiMenuItemJson]) =
//    MuiMenuItemJson(`type` = MuiMenuItemType.NESTED, text = text, items = items)

//  def fromJson(obj: js.Dynamic) =
//    MuiMenuItem(
//      defaultToggled = if (js.isUndefined(obj.defaultToggled)) js.undefined else obj.defaultToggled.asInstanceOf[Boolean],
//      text = if (js.isUndefined(obj.text)) js.undefined else obj.text.asInstanceOf[String],
//      data = if (js.isUndefined(obj.data)) js.undefined else obj.text.asInstanceOf[String],
//      number = if (js.isUndefined(obj.number)) js.undefined else obj.number.asInstanceOf[String],
//      iconClassName = if (js.isUndefined(obj.iconClassName)) js.undefined else obj.iconClassName.asInstanceOf[String],
//      route = if (js.isUndefined(obj.route)) js.undefined else obj.route.asInstanceOf[String],
//      disabled = if (js.isUndefined(obj.disabled)) js.undefined else obj.disabled.asInstanceOf[Boolean],
//      payload = if (js.isUndefined(obj.payload)) js.undefined else obj.payload.asInstanceOf[String],
//      toggle = if (js.isUndefined(obj.toggle)) js.undefined else obj.toggle.asInstanceOf[Boolean],
//      id = if (js.isUndefined(obj.id)) js.undefined else obj.id.asInstanceOf[String],
//      className = if (js.isUndefined(obj.className)) js.undefined else obj.className.asInstanceOf[String],
//      style = if (js.isUndefined(obj.style)) js.undefined else obj.style.asInstanceOf[js.Any],
//      selected = if (js.isUndefined(obj.selected)) js.undefined else obj.selected.asInstanceOf[Boolean]
//    )
}

class MuiMenuItemType private(val value: String) extends AnyVal

object MuiMenuItemType {

  val SUBHEADER = new MuiMenuItemType("SUBHEADER")
  val LINK = new MuiMenuItemType("LINK")
  val NESTED = new MuiMenuItemType("NESTED")

  def newType(name: String) = new MuiMenuItemType(name)

}
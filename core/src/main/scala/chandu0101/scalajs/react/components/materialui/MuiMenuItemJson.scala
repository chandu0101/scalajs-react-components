package chandu0101.scalajs.react.components
package materialui

import japgolly.scalajs.react._
import scala.scalajs.js
import chandu0101.macros.tojs.JSMacro

@deprecated("Use composition instead")
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
}

class MuiMenuItemType private(val value: String) extends AnyVal

object MuiMenuItemType {

  val SUBHEADER = new MuiMenuItemType("SUBHEADER")
  val LINK = new MuiMenuItemType("LINK")
  val NESTED = new MuiMenuItemType("NESTED")

  def newType(name: String) = new MuiMenuItemType(name)

}
package chandu0101.scalajs.react.components.materialui


import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{Array => JArray}

/**
key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
  className: React.PropTypes.string,
    autoWidth: React.PropTypes.bool,
    onChange: React.PropTypes.(ReactEvent,Int,Item) => Unit,
    menuItems: React.PropTypes.JArray[Item].isRequired,
    menuItemStyle: React.PropTypes.js.Any,
    selectedIndex: React.PropTypes.number

  */

object MuiDropdownMenu {


  def apply(menuItems: JArray[Item],
            style: js.UndefOr[js.Any] = js.undefined,
            onChange: js.UndefOr[(ReactEvent, Int, js.Object) => Unit] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            menuItemStyle: js.UndefOr[js.Any] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            autoWidth: js.UndefOr[Boolean] = js.undefined,
            className: js.UndefOr[String] = js.undefined,
            selectedIndex: js.UndefOr[Int] = js.undefined) = {

    val p = js.Dynamic.literal()
    p.updateDynamic("menuItems")(menuItems.map(_.toJson))
    style.foreach(v => p.updateDynamic("style")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    menuItemStyle.foreach(v => p.updateDynamic("menuItemStyle")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    autoWidth.foreach(v => p.updateDynamic("autoWidth")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    selectedIndex.foreach(v => p.updateDynamic("selectedIndex")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.DropDownMenu)
    f(p).asInstanceOf[ReactComponentU_]
  }

  case class Item(payload: String, text: String) {
    def toJson = {
      val p = json()
      p.updateDynamic("text")(text)
      p.updateDynamic("payload")(payload)
      p
    }
  }

  object Item {
    def fromJson(obj: js.Dynamic) = Item(text = obj.text.toString, payload = obj.payload.toString)
  }

}

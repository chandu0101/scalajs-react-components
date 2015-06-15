package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{Array => JArray}


/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
 className: React.PropTypes.string,
    docked: React.PropTypes.bool,
    header: React.PropTypes.element,
    menuItems: React.PropTypes.JArray[MuiMenuItem].isRequired,
    onChange: React.PropTypes.(ReactEvent,Int,js.Object) => Unit,
    onNavOpen: React.PropTypes.() => Unit,
    onNavClose: React.PropTypes.() => Unit,
    openRight: React.PropTypes.bool,
    selectedIndex: React.PropTypes.number

 */
object MuiLeftNav {

  def apply(menuItems: JArray[MuiMenuItem],
            style: js.UndefOr[js.Any] = js.undefined,
            onChange: js.UndefOr[(ReactEvent, Int, js.Object) => Unit] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            onNavClose: js.UndefOr[() => Unit] = js.undefined,
            onNavOpen: js.UndefOr[() => Unit] = js.undefined,
            key: js.UndefOr[String] = js.undefined,
            className: js.UndefOr[String] = js.undefined,
            docked: js.UndefOr[Boolean] = js.undefined,
            header: js.UndefOr[ReactElement] = js.undefined,
            selectedIndex: js.UndefOr[Int] = js.undefined,
            openRight: js.UndefOr[Boolean] = js.undefined) = {

    val p = js.Dynamic.literal()
    p.updateDynamic("menuItems")(menuItems.map(_.toJson))
    style.foreach(v => p.updateDynamic("style")(v))
    onChange.foreach(v => p.updateDynamic("onChange")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    onNavClose.foreach(v => p.updateDynamic("onNavClose")(v))
    onNavOpen.foreach(v => p.updateDynamic("onNavOpen")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    docked.foreach(v => p.updateDynamic("docked")(v))
    header.foreach(v => p.updateDynamic("header")(v))
    selectedIndex.foreach(v => p.updateDynamic("selectedIndex")(v))
    openRight.foreach(v => p.updateDynamic("openRight")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.LeftNav)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

trait MuiLeftNavM extends js.Object {

  def close(): Unit = js.native

  def toggle(): Unit = js.native
}


/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
  autoWidth: React.PropTypes.bool,
    onItemTap: React.PropTypes.(ReactEvent,Int,js.Object) => Unit,
    onToggle: React.PropTypes.(ReactEvent,Int,Boolean) => Unit,
    menuItems: React.PropTypes.JArray[MuiMenuItem].isRequired,
    selectedIndex: React.PropTypes.number,
    hideable: React.PropTypes.bool,
    visible: React.PropTypes.bool,
    zDepth: React.PropTypes.number,
    menuItemStyle: React.PropTypes.js.Any,
    menuItemStyleSubheader: React.PropTypes.js.Any,
    menuItemStyleLink: React.PropTypes.js.Any,
    menuItemClassName: React.PropTypes.string,
    menuItemClassNameSubheader: React.PropTypes.string,
    menuItemClassNameLink: React.PropTypes.string,

 */
object MuiMenu {

  def apply(onToggle : js.UndefOr[(ReactEvent,Int,Boolean) => Unit] = js.undefined,
            menuItems : JArray[MuiMenuItem],
            visible : js.UndefOr[Boolean]=js.undefined,
            style : js.UndefOr[js.Any] = js.undefined,
            ref : js.UndefOr[String] = js.undefined,
            onItemTap : js.UndefOr[(ReactEvent,Int,js.Object) => Unit] = js.undefined,
            menuItemStyleLink : js.UndefOr[js.Any] = js.undefined,
            zDepth : js.UndefOr[Int] = js.undefined,
            menuItemStyle : js.UndefOr[js.Any] = js.undefined,
            key : js.UndefOr[String] = js.undefined,
            autoWidth : js.UndefOr[Boolean]=js.undefined,
            menuItemClassNameSubheader : js.UndefOr[String] = js.undefined,
            menuItemStyleSubheader : js.UndefOr[js.Any] = js.undefined,
            hideable : js.UndefOr[Boolean]=js.undefined,
            menuItemClassNameLink : js.UndefOr[String] = js.undefined,
            menuItemClassName : js.UndefOr[String] = js.undefined,
            selectedIndex : js.UndefOr[Int] = js.undefined) = {

    val p = js.Dynamic.literal()
    onToggle.foreach(v => p.updateDynamic("onToggle")(v))
    p.updateDynamic("menuItems")(menuItems.map(_.toJson))
    visible.foreach(v => p.updateDynamic("visible")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    onItemTap.foreach(v => p.updateDynamic("onItemTap")(v))
    menuItemStyleLink.foreach(v => p.updateDynamic("menuItemStyleLink")(v))
    zDepth.foreach(v => p.updateDynamic("zDepth")(v))
    menuItemStyle.foreach(v => p.updateDynamic("menuItemStyle")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    autoWidth.foreach(v => p.updateDynamic("autoWidth")(v))
    menuItemClassNameSubheader.foreach(v => p.updateDynamic("menuItemClassNameSubheader")(v))
    menuItemStyleSubheader.foreach(v => p.updateDynamic("menuItemStyleSubheader")(v))
    hideable.foreach(v => p.updateDynamic("hideable")(v))
    menuItemClassNameLink.foreach(v => p.updateDynamic("menuItemClassNameLink")(v))
    menuItemClassName.foreach(v => p.updateDynamic("menuItemClassName")(v))
    selectedIndex.foreach(v => p.updateDynamic("selectedIndex")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.Menu)
    f(p).asInstanceOf[ReactComponentU_]
  }

}


case class MuiMenuItem(payload: js.UndefOr[String] = js.undefined,
                       text: js.UndefOr[String] = js.undefined,
                       id: js.UndefOr[String] = js.undefined,
                       number: js.UndefOr[String] = js.undefined,
                       data: js.UndefOr[String] = js.undefined,
                       iconClassName: js.UndefOr[String] = js.undefined,
                       toggle: js.UndefOr[Boolean] = js.undefined,
                       disabled: js.UndefOr[Boolean] = js.undefined,
                       defaultToggled: js.UndefOr[Boolean] = js.undefined,
                       route: js.UndefOr[String] = js.undefined,
                       `type`: js.UndefOr[MuiMenuItemType] = js.undefined) {
  def toJson = {
    val p = json()
    defaultToggled.foreach(v => p.updateDynamic("defaultToggled")(v))
    text.foreach(v => p.updateDynamic("text")(v))
    number.foreach(v => p.updateDynamic("number")(v))
    data.foreach(v => p.updateDynamic("data")(v))
    iconClassName.foreach(v => p.updateDynamic("iconClassName")(v))
    `type`.foreach(v => p.updateDynamic("type")(v.name))
    route.foreach(v => p.updateDynamic("route")(v))
    disabled.foreach(v => p.updateDynamic("disabled")(v))
    payload.foreach(v => p.updateDynamic("payload")(v))
    toggle.foreach(v => p.updateDynamic("toggle")(v))
    id.foreach(v => p.updateDynamic("id")(v))
    p
  }
}

object MuiMenuItem {
  def fromJson(obj: js.Dynamic) = MuiMenuItem(defaultToggled = if (js.isUndefined(obj.defaultToggled)) js.undefined else obj.defaultToggled.asInstanceOf[Boolean],
    text = if (js.isUndefined(obj.text)) js.undefined else obj.text.asInstanceOf[String],
    data = if (js.isUndefined(obj.data)) js.undefined else obj.text.asInstanceOf[String],
    number = if (js.isUndefined(obj.number)) js.undefined else obj.number.asInstanceOf[String], iconClassName = if (js.isUndefined(obj.iconClassName)) js.undefined else obj.iconClassName.asInstanceOf[String], route = if (js.isUndefined(obj.route)) js.undefined else obj.route.asInstanceOf[String], disabled = if (js.isUndefined(obj.disabled)) js.undefined else obj.disabled.asInstanceOf[Boolean], payload = if (js.isUndefined(obj.payload)) js.undefined else obj.payload.asInstanceOf[String], toggle = if (js.isUndefined(obj.toggle)) js.undefined else obj.toggle.asInstanceOf[Boolean], id = if (js.isUndefined(obj.id)) js.undefined else obj.id.asInstanceOf[String])
}

class MuiMenuItemType private(val name: String) extends AnyVal

object MuiMenuItemType {

  val SUBHEADER = new MuiMenuItemType("SUBHEADER")
  val LINK = new MuiMenuItemType("LINK")
  val NESTED = new MuiMenuItemType("NESTED")

  def newType(name: String) = new MuiMenuItemType(name)


}
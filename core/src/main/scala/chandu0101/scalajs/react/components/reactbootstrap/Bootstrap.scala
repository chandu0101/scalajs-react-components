package chandu0101.scalajs.react.components
package reactbootstrap

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{React, ReactComponentU_}
import scala.scalajs.js

/**
 *
 *  Its wrapper for reactbootstrap, you need js source file from
 *   Warning: its not currently supported
 *
 */

@js.native
object ReactBootstrap extends js.Object {

  def Button: js.Dynamic = js.native

  def Accordion: js.Dynamic = js.native

  def Affix: js.Dynamic = js.native

  def Alert: js.Dynamic = js.native

  def Badge: js.Dynamic = js.native

  def ButtonGroup: js.Dynamic = js.native

  def ButtonToolbar: js.Dynamic = js.native

  def Carousel: js.Dynamic = js.native

  def Col: js.Dynamic = js.native

  def DropdownButton: js.Dynamic = js.native

  def DropdownMenu: js.Dynamic = js.native

  def Glyphicon: js.Dynamic = js.native

  def Grid: js.Dynamic = js.native

  def Input: js.Dynamic = js.native

  def Interpolate: js.Dynamic = js.native

  def Jumbotron: js.Dynamic = js.native

  def Label: js.Dynamic = js.native

  def ListGroup: js.Dynamic = js.native

  def ListGroupItem: js.Dynamic = js.native

  def MenuItem: js.Dynamic = js.native

  def Modal: js.Dynamic = js.native

  def ModalTrigger: js.Dynamic = js.native

  def Nav: js.Dynamic = js.native

  def NavItem: js.Dynamic = js.native

  def Navbar: js.Dynamic = js.native

  def OverlayTrigger: js.Dynamic = js.native

  def PageHeader: js.Dynamic = js.native

  def PageItem: js.Dynamic = js.native

  def Pager: js.Dynamic = js.native

  def Panel: js.Dynamic = js.native

  def PanelGroup: js.Dynamic = js.native

  def Popover: js.Dynamic = js.native

  def ProgressBar: js.Dynamic = js.native

  def Row: js.Dynamic = js.native

  def SplitButton: js.Dynamic = js.native

  def propTypes: js.Dynamic = js.native

  def SubNav: js.Dynamic = js.native

  def TabPane: js.Dynamic = js.native

  def TabbedArea: js.Dynamic = js.native

  def Table: js.Dynamic = js.native

  def Tooltip: js.Dynamic = js.native

  def Well: js.Dynamic = js.native

}

object bootStrap {

  case class Button(bsSize: U[String] = uNone, onClick: U[js.Function0[Unit]] = uNone,
                    navDropdown: U[Boolean] = uNone, block: U[Boolean] = uNone, disabled: U[Boolean] = uNone, bsStyle: U[String] = uNone, componentClass: U[String] = uNone, navItem: U[Boolean] = uNone, bsClass: U[String] = uNone, active: U[Boolean] = uNone ,hrefB: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      active.foreach(v => p.updateDynamic("active")(v))
      hrefB.foreach(v => p.updateDynamic("href")(v))
      navItem.foreach(v => p.updateDynamic("navItem")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      navDropdown.foreach(v => p.updateDynamic("navDropdown")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      disabled.foreach(v => p.updateDynamic("disabled")(v))
      block.foreach(v => p.updateDynamic("block")(v))
      onClick.foreach(v => p.updateDynamic("block")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      componentClass.foreach(v => p.updateDynamic("componentClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Button)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Accordion() {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      p
    }

    def apply(): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Accordion)
      f(toJs).asInstanceOf[ReactComponentU_]
    }
  }

  case class Affix(offset: U[Double] = uNone, offsetTop: U[Double] = uNone, offsetBottom: U[Double] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      offset.foreach(v => p.updateDynamic("offset")(v))
      offsetTop.foreach(v => p.updateDynamic("offsetTop")(v))
      offsetBottom.foreach(v => p.updateDynamic("offsetBottom")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Affix)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  //TODO  onDismiss: React.PropTypes.func,
  case class Alert(bsClass: U[String] = uNone, bsStyle: U[String] = uNone, bsSize: U[String] = uNone, dismissAfter: U[Double] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      dismissAfter.foreach(v => p.updateDynamic("dismissAfter")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Alert)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Badge(pullRight: U[Boolean] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      pullRight.foreach(v => p.updateDynamic("pullRight")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Badge)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class ButtonGroup(justified: U[Boolean] = uNone, bsSize: U[String] = uNone, vertical: U[Boolean] = uNone, bsStyle: U[String] = uNone, bsClass: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      justified.foreach(v => p.updateDynamic("justified")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      vertical.foreach(v => p.updateDynamic("vertical")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.ButtonGroup)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class ButtonToolbar(bsClass: U[String] = uNone, bsStyle: U[String] = uNone, bsSize: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.ButtonToolbar)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  //TODO   onSelect: React.PropTypes.func,
  // onSlideEnd: React.PropTypes.func,
  case class Carousel(bsSize: U[String] = uNone, defaultActiveIndex: U[Double] = uNone, onSlideEnd: U[js.Any] = uNone, direction: U[String] = uNone, wrap: U[Boolean] = uNone, slide: U[Boolean] = uNone, indicators: U[Boolean] = uNone, activeIndex: U[Double] = uNone, pauseOnHover: U[Boolean] = uNone, onSelect: U[js.Any] = uNone, bsStyle: U[String] = uNone, bsClass: U[String] = uNone, controls: U[Boolean] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      controls.foreach(v => p.updateDynamic("controls")(v))
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      indicators.foreach(v => p.updateDynamic("indicators")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      defaultActiveIndex.foreach(v => p.updateDynamic("defaultActiveIndex")(v))
      activeIndex.foreach(v => p.updateDynamic("activeIndex")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      slide.foreach(v => p.updateDynamic("slide")(v))
      pauseOnHover.foreach(v => p.updateDynamic("pauseOnHover")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      direction.foreach(v => p.updateDynamic("direction")(v))
      wrap.foreach(v => p.updateDynamic("wrap")(v))
      onSlideEnd.foreach(v => p.updateDynamic("onSlideEnd")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Carousel)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Col(xs: U[Double] = uNone, lgPush: U[Double] = uNone, xsOffset: U[Double] = uNone, smPush: U[Double] = uNone, xsPull: U[Double] = uNone, xsPush: U[Double] = uNone, smOffset: U[Double] = uNone, lg: U[Double] = uNone, sm: U[Double] = uNone, lgPull: U[Double] = uNone, mdOffset: U[Double] = uNone, componentClass: U[String], mdPush: U[Double] = uNone, md: U[Double] = uNone, lgOffset: U[Double] = uNone, smPull: U[Double] = uNone, mdPull: U[Double] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      lgPush.foreach(v => p.updateDynamic("lgPush")(v))
      lg.foreach(v => p.updateDynamic("lg")(v))
      mdOffset.foreach(v => p.updateDynamic("mdOffset")(v))
      mdPush.foreach(v => p.updateDynamic("mdPush")(v))
      sm.foreach(v => p.updateDynamic("sm")(v))
      lgPull.foreach(v => p.updateDynamic("lgPull")(v))
      xsOffset.foreach(v => p.updateDynamic("xsOffset")(v))
      smPull.foreach(v => p.updateDynamic("smPull")(v))
      lgOffset.foreach(v => p.updateDynamic("lgOffset")(v))
      xsPush.foreach(v => p.updateDynamic("xsPush")(v))
      md.foreach(v => p.updateDynamic("md")(v))
      smOffset.foreach(v => p.updateDynamic("smOffset")(v))
      mdPull.foreach(v => p.updateDynamic("mdPull")(v))
      smPush.foreach(v => p.updateDynamic("smPush")(v))
      componentClass.foreach(v => p.updateDynamic("componentClass")(v))
      xs.foreach(v => p.updateDynamic("xs")(v))
      xsPull.foreach(v => p.updateDynamic("xsPull")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Col)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  // TODO  onClick:   React.PropTypes.func,
  //  onSelect:  React.PropTypes.func,
  case class DropdownButton(bsSize: U[String] = uNone, onClick: U[js.Any] = uNone, dropup: U[Boolean] = uNone, onSelect: U[js.Any] = uNone, bsStyle: U[String] = uNone, title: U[String] = uNone, href: U[String] = uNone, navItem: U[Boolean] = uNone, pullRight: U[Boolean] = uNone, bsClass: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      navItem.foreach(v => p.updateDynamic("navItem")(v))
      pullRight.foreach(v => p.updateDynamic("pullRight")(v))
      onClick.foreach(v => p.updateDynamic("onClick")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      href.foreach(v => p.updateDynamic("href")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      dropup.foreach(v => p.updateDynamic("dropup")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.DropdownButton)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  //TODO   onSelect: React.PropTypes.func
  case class DropdownMenu(pullRight: U[Boolean] = uNone, onSelect: U[js.Any] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      pullRight.foreach(v => p.updateDynamic("pullRight")(v))
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.DropdownMenu)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Glyphicon(glyph: U[String]) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      glyph.foreach(v => p.updateDynamic("glyph")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Glyphicon)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  //TODO     componentClass: React.PropTypes.node.isRequired

  case class Grid(fluid: U[Boolean] = uNone, componentClass: U[String]) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      fluid.foreach(v => p.updateDynamic("fluid")(v))
      componentClass.foreach(v => p.updateDynamic("componentClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Grid)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class input(groupClassName: U[String] = uNone, wrapperClassName: U[String] = uNone, labelB: U[String] = uNone, labelClassName: U[String] = uNone, addonBefore: U[String] = uNone, buttonAfter: U[String] = uNone, help: U[String] = uNone, buttonBefore: U[String] = uNone, hasFeedback: U[Boolean] = uNone, addonAfter: U[String] = uNone, disabledB: U[Boolean] = uNone, bsStyle: U[String] = uNone, typeB: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      labelB.foreach(v => p.updateDynamic("label")(v))
      buttonBefore.foreach(v => p.updateDynamic("buttonBefore")(v))
      groupClassName.foreach(v => p.updateDynamic("groupClassName")(v))
      help.foreach(v => p.updateDynamic("help")(v))
      wrapperClassName.foreach(v => p.updateDynamic("wrapperClassName")(v))
      hasFeedback.foreach(v => p.updateDynamic("hasFeedback")(v))
      buttonAfter.foreach(v => p.updateDynamic("buttonAfter")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      addonAfter.foreach(v => p.updateDynamic("addonAfter")(v))
      disabledB.foreach(v => p.updateDynamic("disabled")(v))
      typeB.foreach(v => p.updateDynamic("type")(v))
      addonBefore.foreach(v => p.updateDynamic("addonBefore")(v))
      labelClassName.foreach(v => p.updateDynamic("labelClassName")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Input)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Interpolate(format: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      format.foreach(v => p.updateDynamic("format")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Interpolate)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Jumbotron() {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Jumbotron)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class label(bsClass: U[String] = uNone,bsStyle: U[String] = uNone,bsSize: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Label)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  //TODO onClick: React.PropTypes.func
  case class ListGroup(onClick: U[js.Any] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onClick.foreach(v => p.updateDynamic("onClick")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.ListGroup)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class ListGroupItem(bsSize: U[String] = uNone,onClick: U[js.Any] = uNone,header: U[String] = uNone,disabled: U[js.Any] = uNone,bsStyle: U[String] = uNone,eventKey: U[js.Any] = uNone,bsClass: U[String] = uNone,active: U[js.Any] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      active.foreach(v => p.updateDynamic("active")(v))
      eventKey.foreach(v => p.updateDynamic("eventKey")(v))
      onClick.foreach(v => p.updateDynamic("onClick")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      disabled.foreach(v => p.updateDynamic("disabled")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      header.foreach(v => p.updateDynamic("header")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.ListGroupItem)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class MenuItem(divider: U[Boolean] = uNone,
                      header: U[Boolean] = uNone,onSelect: U[js.Any] = uNone,title: U[String] = uNone,href: U[String] = uNone,eventKey: U[String]=uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      divider.foreach(v => p.updateDynamic("divider")(v))
      eventKey.foreach(v => p.updateDynamic("eventKey")(v))
      href.foreach(v => p.updateDynamic("href")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      header.foreach(v => p.updateDynamic("header")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.MenuItem)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Modal(backdrop: U[String] = uNone,onRequestHide: U[js.Any],keyboard: U[Boolean] = uNone,bsSize: U[String] = uNone,closeButton: U[Boolean] = uNone,animation: U[Boolean] = uNone,bsStyle: U[String] = uNone,title: U[String] = uNone,bsClass: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      keyboard.foreach(v => p.updateDynamic("keyboard")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      backdrop.foreach(v => p.updateDynamic("backdrop")(v))
      animation.foreach(v => p.updateDynamic("animation")(v))
      onRequestHide.foreach(v => p.updateDynamic("onRequestHide")(v))
      closeButton.foreach(v => p.updateDynamic("closeButton")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Modal)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class ModalTrigger(modal: U[String]) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      modal.foreach(v => p.updateDynamic("modal")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.ModalTrigger)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Nav(stacked: U[Boolean] = uNone,navbar: U[Boolean] = uNone,justified: U[Boolean] = uNone,defaultExpanded: U[Boolean] = uNone,expanded: U[Boolean] = uNone,collapsable: U[Boolean] = uNone,onSelect: U[js.Any] = uNone,bsStyle: U[String] = uNone,eventKey: U[js.Any]=uNone,right: U[Boolean] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      navbar.foreach(v => p.updateDynamic("navbar")(v))
      collapsable.foreach(v => p.updateDynamic("collapsable")(v))
      right.foreach(v => p.updateDynamic("right")(v))
      stacked.foreach(v => p.updateDynamic("stacked")(v))
      expanded.foreach(v => p.updateDynamic("expanded")(v))
      eventKey.foreach(v => p.updateDynamic("eventKey")(v))
      justified.foreach(v => p.updateDynamic("justified")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      defaultExpanded.foreach(v => p.updateDynamic("defaultExpanded")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Nav)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class NavItem(bsSize: U[String] = uNone,disabled: U[Boolean] = uNone,onSelect: U[js.Any] = uNone,bsStyle: U[String] = uNone,title: U[String] = uNone,href: U[String] = uNone,eventKey: U[js.Any]=uNone,bsClass: U[String] = uNone,active: U[Boolean] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      active.foreach(v => p.updateDynamic("active")(v))
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      eventKey.foreach(v => p.updateDynamic("eventKey")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      disabled.foreach(v => p.updateDynamic("disabled")(v))
      href.foreach(v => p.updateDynamic("href")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.NavItem)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Navbar(onToggle: U[js.Any] = uNone,toggleButton: U[String] = uNone,bsSize: U[String] = uNone,fluid: U[Boolean] = uNone,role: U[String] = uNone,fixedTop: U[Boolean] = uNone,staticTop: U[Boolean] = uNone,navExpanded: U[Boolean] = uNone,brand: U[String] = uNone,inverse: U[Boolean] = uNone,fixedBottom: U[Boolean] = uNone,defaultNavExpanded: U[Boolean] = uNone,bsStyle: U[String] = uNone,componentClass: U[String],bsClass: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      defaultNavExpanded.foreach(v => p.updateDynamic("defaultNavExpanded")(v))
      navExpanded.foreach(v => p.updateDynamic("navExpanded")(v))
      inverse.foreach(v => p.updateDynamic("inverse")(v))
      onToggle.foreach(v => p.updateDynamic("onToggle")(v))
      staticTop.foreach(v => p.updateDynamic("staticTop")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      fixedBottom.foreach(v => p.updateDynamic("fixedBottom")(v))
      fixedTop.foreach(v => p.updateDynamic("fixedTop")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      componentClass.foreach(v => p.updateDynamic("componentClass")(v))
      role.foreach(v => p.updateDynamic("role")(v))
      toggleButton.foreach(v => p.updateDynamic("toggleButton")(v))
      fluid.foreach(v => p.updateDynamic("fluid")(v))
      brand.foreach(v => p.updateDynamic("brand")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Navbar)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class OverlayTrigger(delay: U[Double] = uNone,overlay: U[ReactComponentU_],delayShow: U[Double] = uNone,delayHide: U[Double] = uNone,placement: U[String] = uNone,defaultOverlayShown: U[Boolean] = uNone,trigger: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      delayShow.foreach(v => p.updateDynamic("delayShow")(v))
      placement.foreach(v => p.updateDynamic("placement")(v))
      delayHide.foreach(v => p.updateDynamic("delayHide")(v))
      trigger.foreach(v => p.updateDynamic("trigger")(v))
      overlay.foreach(v => p.updateDynamic("overlay")(v))
      defaultOverlayShown.foreach(v => p.updateDynamic("defaultOverlayShown")(v))
      delay.foreach(v => p.updateDynamic("delay")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.OverlayTrigger)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class PageHeader() {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()

      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.PageHeader)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class PageItem(previous: U[Boolean] = uNone,next: U[Boolean] = uNone,disabled: U[Boolean] = uNone,onSelect: U[js.Any] = uNone,eventKey: U[js.Any]=uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      eventKey.foreach(v => p.updateDynamic("eventKey")(v))
      next.foreach(v => p.updateDynamic("next")(v))
      disabled.foreach(v => p.updateDynamic("disabled")(v))
      previous.foreach(v => p.updateDynamic("previous")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.PageItem)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Pager(onSelect: U[js.Any] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Pager)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Panel(bsSize: U[String] = uNone,defaultExpanded: U[Boolean] = uNone,
                   expanded: U[Boolean] = uNone,collapsable: U[Boolean] = uNone,
                   header: U[String] = uNone,onSelect: U[js.Any] = uNone,bsStyle: U[String] = uNone,eventKey: U[js.Any]=uNone,footer: U[String] = uNone,bsClass: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      collapsable.foreach(v => p.updateDynamic("collapsable")(v))
      expanded.foreach(v => p.updateDynamic("expanded")(v))
      eventKey.foreach(v => p.updateDynamic("eventKey")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      footer.foreach(v => p.updateDynamic("footer")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      header.foreach(v => p.updateDynamic("header")(v))
      defaultExpanded.foreach(v => p.updateDynamic("defaultExpanded")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Panel)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class PanelGroup(activeKey: U[js.Any]=uNone,bsSize: U[String] = uNone,collapsable: U[Boolean] = uNone,defaultActiveKey: U[js.Any]=uNone,onSelect: U[js.Any] = uNone,bsStyle: U[String] = uNone,bsClass: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      activeKey.foreach(v => p.updateDynamic("activeKey")(v))
      defaultActiveKey.foreach(v => p.updateDynamic("defaultActiveKey")(v))
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      collapsable.foreach(v => p.updateDynamic("collapsable")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.PanelGroup)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Popover(bsSize: U[String] = uNone,positionLeft: U[Double] = uNone,positionTop: U[Double] = uNone,arrowOffsetLeft: U[Double] = uNone,placement: U[String] = uNone,bsStyle: U[String] = uNone,title: U[String] = uNone,bsClass: U[String] = uNone,arrowOffsetTop: U[Double] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      arrowOffsetLeft.foreach(v => p.updateDynamic("arrowOffsetLeft")(v))
      placement.foreach(v => p.updateDynamic("placement")(v))
      positionTop.foreach(v => p.updateDynamic("positionTop")(v))
      positionLeft.foreach(v => p.updateDynamic("positionLeft")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      arrowOffsetTop.foreach(v => p.updateDynamic("arrowOffsetTop")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Popover)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class ProgressBar(label: U[String] = uNone,
                         bsStyle: U[String] = uNone,
                         key: U[Int] = uNone,
                         striped: U[Boolean] = uNone,min: U[Double] = uNone,now: U[Double] = uNone,max: U[Double] = uNone,srOnly: U[Boolean] = uNone,active: U[Boolean] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      label.foreach(v => p.updateDynamic("label")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      key.foreach(v => p.updateDynamic("key")(v))
      active.foreach(v => p.updateDynamic("active")(v))
      max.foreach(v => p.updateDynamic("max")(v))
      striped.foreach(v => p.updateDynamic("striped")(v))
      now.foreach(v => p.updateDynamic("now")(v))
      srOnly.foreach(v => p.updateDynamic("srOnly")(v))
      min.foreach(v => p.updateDynamic("min")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.ProgressBar)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Row(componentClass: U[String]) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      componentClass.foreach(v => p.updateDynamic("componentClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Row)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class SplitButton(bsSize: U[String] = uNone,onClick: U[js.Any] = uNone,dropdownTitle: U[String] = uNone,disabled: U[Boolean] = uNone,onSelect: U[js.Any] = uNone,bsStyle: U[String] = uNone,title: U[String] = uNone,href: U[String] = uNone,pullRight: U[Boolean] = uNone,bsClass: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      dropdownTitle.foreach(v => p.updateDynamic("dropdownTitle")(v))
      pullRight.foreach(v => p.updateDynamic("pullRight")(v))
      onClick.foreach(v => p.updateDynamic("onClick")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      disabled.foreach(v => p.updateDynamic("disabled")(v))
      href.foreach(v => p.updateDynamic("href")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.SplitButton)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class propTypes(bsSize: U[String] = uNone,text: U[String] = uNone,disabled: U[Boolean] = uNone,onSelect: U[js.Any] = uNone,bsStyle: U[String] = uNone,title: U[String] = uNone,href: U[String] = uNone,bsClass: U[String] = uNone,active: U[Boolean] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      active.foreach(v => p.updateDynamic("active")(v))
      text.foreach(v => p.updateDynamic("text")(v))
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      disabled.foreach(v => p.updateDynamic("disabled")(v))
      href.foreach(v => p.updateDynamic("href")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.propTypes)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class SubNav(bsSize: U[String] = uNone,text: U[String] = uNone,disabled: U[Boolean] = uNone,onSelect: U[js.Any] = uNone,bsStyle: U[String] = uNone,title: U[String] = uNone,href: U[String] = uNone,bsClass: U[String] = uNone,active: U[Boolean] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      active.foreach(v => p.updateDynamic("active")(v))
      text.foreach(v => p.updateDynamic("text")(v))
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      disabled.foreach(v => p.updateDynamic("disabled")(v))
      href.foreach(v => p.updateDynamic("href")(v))
      title.foreach(v => p.updateDynamic("title")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.SubNav)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class TabPane() {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()

      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.TabPane)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class TabbedArea(bsSize: U[String] = uNone,animation: U[Boolean] = uNone,onSelect: U[js.Any] = uNone,bsStyle: U[String] = uNone,bsClass: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      onSelect.foreach(v => p.updateDynamic("onSelect")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      animation.foreach(v => p.updateDynamic("animation")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.TabbedArea)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class table(bordered: U[Boolean] = uNone,hover: U[Boolean] = uNone,striped: U[Boolean] = uNone,condensed: U[Boolean] = uNone,responsive: U[Boolean] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      bordered.foreach(v => p.updateDynamic("bordered")(v))
      striped.foreach(v => p.updateDynamic("striped")(v))
      condensed.foreach(v => p.updateDynamic("condensed")(v))
      responsive.foreach(v => p.updateDynamic("responsive")(v))
      hover.foreach(v => p.updateDynamic("hover")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Table)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Tooltip(bsSize: U[String] = uNone,positionLeft: U[Double] = uNone,positionTop: U[Double] = uNone,arrowOffsetLeft: U[Double] = uNone,placement: U[String] = uNone,bsStyle: U[String] = uNone,bsClass: U[String] = uNone,arrowOffsetTop: U[Double] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      arrowOffsetLeft.foreach(v => p.updateDynamic("arrowOffsetLeft")(v))
      placement.foreach(v => p.updateDynamic("placement")(v))
      positionTop.foreach(v => p.updateDynamic("positionTop")(v))
      positionLeft.foreach(v => p.updateDynamic("positionLeft")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      arrowOffsetTop.foreach(v => p.updateDynamic("arrowOffsetTop")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Tooltip)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

  case class Well(bsClass: U[String] = uNone,bsStyle: U[String] = uNone,bsSize: U[String] = uNone) {
    def toJs: js.Object = {
      val p = js.Dynamic.literal()
      bsClass.foreach(v => p.updateDynamic("bsClass")(v))
      bsStyle.foreach(v => p.updateDynamic("bsStyle")(v))
      bsSize.foreach(v => p.updateDynamic("bsSize")(v))
      p
    }

    def apply(children: TagMod*): ReactComponentU_ = {
      val f = React.asInstanceOf[js.Dynamic].createFactory(ReactBootstrap.Well)
      f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
    }
  }

}

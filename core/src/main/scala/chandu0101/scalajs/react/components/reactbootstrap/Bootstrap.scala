package chandu0101.scalajs.react.components.reactbootstrap

import japgolly.scalajs.react.{React, ReactComponentU_}
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


/**
 *
 *  Its wrapper for reactbootstrap , you need js source file from
 *   Warning : its not currently supported
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

  def Interpolate : js.Dynamic = js.native

  def Jumbotron : js.Dynamic = js.native

  def Label : js.Dynamic = js.native

  def ListGroup : js.Dynamic = js.native

  def ListGroupItem : js.Dynamic = js.native

  def MenuItem : js.Dynamic = js.native

  def Modal : js.Dynamic = js.native

  def ModalTrigger : js.Dynamic = js.native

  def Nav : js.Dynamic = js.native

  def NavItem : js.Dynamic = js.native

  def Navbar : js.Dynamic = js.native

  def OverlayTrigger : js.Dynamic = js.native

  def PageHeader : js.Dynamic = js.native

  def PageItem : js.Dynamic = js.native

  def Pager : js.Dynamic = js.native

  def Panel : js.Dynamic = js.native

  def PanelGroup : js.Dynamic = js.native

  def Popover : js.Dynamic = js.native

  def ProgressBar : js.Dynamic = js.native

  def Row : js.Dynamic = js.native

  def SplitButton : js.Dynamic = js.native

  def propTypes : js.Dynamic = js.native

  def SubNav : js.Dynamic = js.native

  def TabPane : js.Dynamic = js.native

  def TabbedArea : js.Dynamic = js.native

  def Table : js.Dynamic = js.native

  def Tooltip : js.Dynamic = js.native

  def Well : js.Dynamic = js.native


}


object bootStrap {

  case class Button(bsSize: js.UndefOr[String] = js.undefined, onClick : js.UndefOr[js.Function0[Unit]] = js.undefined,
                    navDropdown: js.UndefOr[Boolean] = js.undefined, block: js.UndefOr[Boolean] = js.undefined, disabled: js.UndefOr[Boolean] = js.undefined, bsStyle: js.UndefOr[String] = js.undefined, componentClass: js.UndefOr[String] = js.undefined, navItem: js.UndefOr[Boolean] = js.undefined, bsClass: js.UndefOr[String] = js.undefined, active: js.UndefOr[Boolean] = js.undefined ,hrefB : js.UndefOr[String] = js.undefined) {
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

  case class Affix(offset: js.UndefOr[Double] = js.undefined, offsetTop: js.UndefOr[Double] = js.undefined, offsetBottom: js.UndefOr[Double] = js.undefined) {
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
  case class Alert(bsClass: js.UndefOr[String] = js.undefined, bsStyle: js.UndefOr[String] = js.undefined, bsSize: js.UndefOr[String] = js.undefined, dismissAfter: js.UndefOr[Double] = js.undefined) {
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

  case class Badge(pullRight: js.UndefOr[Boolean] = js.undefined) {
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

  case class ButtonGroup(justified: js.UndefOr[Boolean] = js.undefined, bsSize: js.UndefOr[String] = js.undefined, vertical: js.UndefOr[Boolean] = js.undefined, bsStyle: js.UndefOr[String] = js.undefined, bsClass: js.UndefOr[String] = js.undefined) {
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


  case class ButtonToolbar(bsClass: js.UndefOr[String] = js.undefined, bsStyle: js.UndefOr[String] = js.undefined, bsSize: js.UndefOr[String] = js.undefined) {
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
  case class Carousel(bsSize: js.UndefOr[String] = js.undefined, defaultActiveIndex: js.UndefOr[Double] = js.undefined, onSlideEnd: js.UndefOr[js.Any] = js.undefined, direction: js.UndefOr[String] = js.undefined, wrap: js.UndefOr[Boolean] = js.undefined, slide: js.UndefOr[Boolean] = js.undefined, indicators: js.UndefOr[Boolean] = js.undefined, activeIndex: js.UndefOr[Double] = js.undefined, pauseOnHover: js.UndefOr[Boolean] = js.undefined, onSelect: js.UndefOr[js.Any] = js.undefined, bsStyle: js.UndefOr[String] = js.undefined, bsClass: js.UndefOr[String] = js.undefined, controls: js.UndefOr[Boolean] = js.undefined) {
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


  case class Col(xs: js.UndefOr[Double] = js.undefined, lgPush: js.UndefOr[Double] = js.undefined, xsOffset: js.UndefOr[Double] = js.undefined, smPush: js.UndefOr[Double] = js.undefined, xsPull: js.UndefOr[Double] = js.undefined, xsPush: js.UndefOr[Double] = js.undefined, smOffset: js.UndefOr[Double] = js.undefined, lg: js.UndefOr[Double] = js.undefined, sm: js.UndefOr[Double] = js.undefined, lgPull: js.UndefOr[Double] = js.undefined, mdOffset: js.UndefOr[Double] = js.undefined, componentClass: js.UndefOr[String], mdPush: js.UndefOr[Double] = js.undefined, md: js.UndefOr[Double] = js.undefined, lgOffset: js.UndefOr[Double] = js.undefined, smPull: js.UndefOr[Double] = js.undefined, mdPull: js.UndefOr[Double] = js.undefined) {
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
  case class DropdownButton(bsSize: js.UndefOr[String] = js.undefined, onClick: js.UndefOr[js.Any] = js.undefined, dropup: js.UndefOr[Boolean] = js.undefined, onSelect: js.UndefOr[js.Any] = js.undefined, bsStyle: js.UndefOr[String] = js.undefined, title: js.UndefOr[String] = js.undefined, href: js.UndefOr[String] = js.undefined, navItem: js.UndefOr[Boolean] = js.undefined, pullRight: js.UndefOr[Boolean] = js.undefined, bsClass: js.UndefOr[String] = js.undefined) {
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
  case class DropdownMenu(pullRight: js.UndefOr[Boolean] = js.undefined, onSelect: js.UndefOr[js.Any] = js.undefined) {
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

  case class Glyphicon(glyph: js.UndefOr[String]) {
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

  case class Grid(fluid: js.UndefOr[Boolean] = js.undefined, componentClass: js.UndefOr[String]) {
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


  case class input(groupClassName: js.UndefOr[String] = js.undefined, wrapperClassName: js.UndefOr[String] = js.undefined, labelB: js.UndefOr[String] = js.undefined, labelClassName: js.UndefOr[String] = js.undefined, addonBefore: js.UndefOr[String] = js.undefined, buttonAfter: js.UndefOr[String] = js.undefined, help: js.UndefOr[String] = js.undefined, buttonBefore: js.UndefOr[String] = js.undefined, hasFeedback: js.UndefOr[Boolean] = js.undefined, addonAfter: js.UndefOr[String] = js.undefined, disabledB: js.UndefOr[Boolean] = js.undefined, bsStyle: js.UndefOr[String] = js.undefined, typeB: js.UndefOr[String] = js.undefined) {
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

  case class Interpolate(format : js.UndefOr[String] = js.undefined) {
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

  case class label(bsClass : js.UndefOr[String] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,bsSize : js.UndefOr[String] = js.undefined) {
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
  case class ListGroup(onClick : js.UndefOr[js.Any] = js.undefined) {
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



  case class ListGroupItem(bsSize : js.UndefOr[String] = js.undefined,onClick : js.UndefOr[js.Any] = js.undefined,header : js.UndefOr[String] = js.undefined,disabled : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,eventKey : js.UndefOr[js.Any] = js.undefined,bsClass : js.UndefOr[String] = js.undefined,active : js.UndefOr[js.Any] = js.undefined) {
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

  case class MenuItem(divider : js.UndefOr[Boolean] = js.undefined,
                      header : js.UndefOr[Boolean] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,title : js.UndefOr[String] = js.undefined,href : js.UndefOr[String] = js.undefined,eventKey : js.UndefOr[String]=js.undefined) {
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

  case class Modal(backdrop : js.UndefOr[String] = js.undefined,onRequestHide : js.UndefOr[js.Any],keyboard : js.UndefOr[Boolean] = js.undefined,bsSize : js.UndefOr[String] = js.undefined,closeButton : js.UndefOr[Boolean] = js.undefined,animation : js.UndefOr[Boolean] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,title : js.UndefOr[String] = js.undefined,bsClass : js.UndefOr[String] = js.undefined) {
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


  case class ModalTrigger(modal : js.UndefOr[String]) {
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

  case class Nav(stacked : js.UndefOr[Boolean] = js.undefined,navbar : js.UndefOr[Boolean] = js.undefined,justified : js.UndefOr[Boolean] = js.undefined,defaultExpanded : js.UndefOr[Boolean] = js.undefined,expanded : js.UndefOr[Boolean] = js.undefined,collapsable : js.UndefOr[Boolean] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,eventKey : js.UndefOr[js.Any]=js.undefined,right : js.UndefOr[Boolean] = js.undefined) {
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

  case class NavItem(bsSize : js.UndefOr[String] = js.undefined,disabled : js.UndefOr[Boolean] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,title : js.UndefOr[String] = js.undefined,href : js.UndefOr[String] = js.undefined,eventKey : js.UndefOr[js.Any]=js.undefined,bsClass : js.UndefOr[String] = js.undefined,active : js.UndefOr[Boolean] = js.undefined) {
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

  case class Navbar(onToggle : js.UndefOr[js.Any] = js.undefined,toggleButton : js.UndefOr[String] = js.undefined,bsSize : js.UndefOr[String] = js.undefined,fluid : js.UndefOr[Boolean] = js.undefined,role : js.UndefOr[String] = js.undefined,fixedTop : js.UndefOr[Boolean] = js.undefined,staticTop : js.UndefOr[Boolean] = js.undefined,navExpanded : js.UndefOr[Boolean] = js.undefined,brand : js.UndefOr[String] = js.undefined,inverse : js.UndefOr[Boolean] = js.undefined,fixedBottom : js.UndefOr[Boolean] = js.undefined,defaultNavExpanded : js.UndefOr[Boolean] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,componentClass : js.UndefOr[String],bsClass : js.UndefOr[String] = js.undefined) {
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


  case class OverlayTrigger(delay : js.UndefOr[Double] = js.undefined,overlay : js.UndefOr[ReactComponentU_],delayShow : js.UndefOr[Double] = js.undefined,delayHide : js.UndefOr[Double] = js.undefined,placement : js.UndefOr[String] = js.undefined,defaultOverlayShown : js.UndefOr[Boolean] = js.undefined,trigger : js.UndefOr[String] = js.undefined) {
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

  case class PageItem(previous : js.UndefOr[Boolean] = js.undefined,next : js.UndefOr[Boolean] = js.undefined,disabled : js.UndefOr[Boolean] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,eventKey : js.UndefOr[js.Any]=js.undefined) {
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

  case class Pager(onSelect : js.UndefOr[js.Any] = js.undefined) {
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


  case class Panel(bsSize : js.UndefOr[String] = js.undefined,defaultExpanded : js.UndefOr[Boolean] = js.undefined,
                   expanded : js.UndefOr[Boolean] = js.undefined,collapsable : js.UndefOr[Boolean] = js.undefined,
                   header : js.UndefOr[String] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,eventKey : js.UndefOr[js.Any]=js.undefined,footer : js.UndefOr[String] = js.undefined,bsClass : js.UndefOr[String] = js.undefined) {
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


  case class PanelGroup(activeKey : js.UndefOr[js.Any]=js.undefined,bsSize : js.UndefOr[String] = js.undefined,collapsable : js.UndefOr[Boolean] = js.undefined,defaultActiveKey : js.UndefOr[js.Any]=js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,bsClass : js.UndefOr[String] = js.undefined) {
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

  case class Popover(bsSize : js.UndefOr[String] = js.undefined,positionLeft : js.UndefOr[Double] = js.undefined,positionTop : js.UndefOr[Double] = js.undefined,arrowOffsetLeft : js.UndefOr[Double] = js.undefined,placement : js.UndefOr[String] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,title : js.UndefOr[String] = js.undefined,bsClass : js.UndefOr[String] = js.undefined,arrowOffsetTop : js.UndefOr[Double] = js.undefined) {
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

  case class ProgressBar(label : js.UndefOr[String] = js.undefined,
                         bsStyle : js.UndefOr[String] = js.undefined,
                         key : js.UndefOr[Int] = js.undefined,
                         striped : js.UndefOr[Boolean] = js.undefined,min : js.UndefOr[Double] = js.undefined,now : js.UndefOr[Double] = js.undefined,max : js.UndefOr[Double] = js.undefined,srOnly : js.UndefOr[Boolean] = js.undefined,active : js.UndefOr[Boolean] = js.undefined) {
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


  case class Row(componentClass : js.UndefOr[String]) {
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

  case class SplitButton(bsSize : js.UndefOr[String] = js.undefined,onClick : js.UndefOr[js.Any] = js.undefined,dropdownTitle : js.UndefOr[String] = js.undefined,disabled : js.UndefOr[Boolean] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,title : js.UndefOr[String] = js.undefined,href : js.UndefOr[String] = js.undefined,pullRight : js.UndefOr[Boolean] = js.undefined,bsClass : js.UndefOr[String] = js.undefined) {
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


  case class propTypes(bsSize : js.UndefOr[String] = js.undefined,text : js.UndefOr[String] = js.undefined,disabled : js.UndefOr[Boolean] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,title : js.UndefOr[String] = js.undefined,href : js.UndefOr[String] = js.undefined,bsClass : js.UndefOr[String] = js.undefined,active : js.UndefOr[Boolean] = js.undefined) {
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

  case class SubNav(bsSize : js.UndefOr[String] = js.undefined,text : js.UndefOr[String] = js.undefined,disabled : js.UndefOr[Boolean] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,title : js.UndefOr[String] = js.undefined,href : js.UndefOr[String] = js.undefined,bsClass : js.UndefOr[String] = js.undefined,active : js.UndefOr[Boolean] = js.undefined) {
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


  case class TabbedArea(bsSize : js.UndefOr[String] = js.undefined,animation : js.UndefOr[Boolean] = js.undefined,onSelect : js.UndefOr[js.Any] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,bsClass : js.UndefOr[String] = js.undefined) {
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

  case class table(bordered : js.UndefOr[Boolean] = js.undefined,hover : js.UndefOr[Boolean] = js.undefined,striped : js.UndefOr[Boolean] = js.undefined,condensed : js.UndefOr[Boolean] = js.undefined,responsive : js.UndefOr[Boolean] = js.undefined) {
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

  case class Tooltip(bsSize : js.UndefOr[String] = js.undefined,positionLeft : js.UndefOr[Double] = js.undefined,positionTop : js.UndefOr[Double] = js.undefined,arrowOffsetLeft : js.UndefOr[Double] = js.undefined,placement : js.UndefOr[String] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,bsClass : js.UndefOr[String] = js.undefined,arrowOffsetTop : js.UndefOr[Double] = js.undefined) {
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

  case class Well(bsClass : js.UndefOr[String] = js.undefined,bsStyle : js.UndefOr[String] = js.undefined,bsSize : js.UndefOr[String] = js.undefined) {
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

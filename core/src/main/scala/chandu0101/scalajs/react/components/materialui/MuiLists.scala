package chandu0101.scalajs.react.components.materialui

import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
  inset: React.PropTypes.bool,

 */
object MuiListDivider {

  def apply(key: js.UndefOr[String] = js.undefined,
            style: js.UndefOr[js.Any] = js.undefined,
            ref: js.UndefOr[String] = js.undefined,
            inset: js.UndefOr[Boolean] = js.undefined) = {

    val p = js.Dynamic.literal()
    key.foreach(v => p.updateDynamic("key")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    inset.foreach(v => p.updateDynamic("inset")(v))

    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListDivider)
    f(p).asInstanceOf[ReactComponentU_]
  }

}

/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
    disableTouchTap: React.PropTypes.bool,
    insetChildren: React.PropTypes.bool,
    leftAvatar: React.PropTypes.element,
    leftCheckbox: React.PropTypes.element,
    leftIcon: React.PropTypes.element,
    onMouseOut: React.PropTypes.ReactEvent => Unit,
    onMouseOver: React.PropTypes.ReactEvent => Unit,
    rightAvatar: React.PropTypes.element,
    rightIcon: React.PropTypes.element,
    rightToggle: React.PropTypes.element,
    secondaryText: React.PropTypes.node,
    secondaryTextLines: React.PropTypes.number

 */
case class MuiListItem(secondaryText: js.UndefOr[ReactElement] = js.undefined,
                       style: js.UndefOr[js.Any] = js.undefined,
                       disableTouchTap: js.UndefOr[Boolean] = js.undefined,
                       insetChildren: js.UndefOr[Boolean] = js.undefined,
                       ref: js.UndefOr[String] = js.undefined,
                       rightAvatar: js.UndefOr[ReactElement] = js.undefined,
                       leftAvatar: js.UndefOr[ReactElement] = js.undefined,
                       key: js.UndefOr[String] = js.undefined,
                       onMouseOver: js.UndefOr[ReactEvent => Unit] = js.undefined,
                       onMouseOut: js.UndefOr[ReactEvent => Unit] = js.undefined,
                       secondaryTextLines: js.UndefOr[Int] = js.undefined,
                       leftIcon: js.UndefOr[ReactElement] = js.undefined,
                       rightIcon: js.UndefOr[ReactElement] = js.undefined,
                       rightToggle: js.UndefOr[ReactElement] = js.undefined,
                       leftCheckbox: js.UndefOr[ReactElement] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    secondaryText.foreach(v => p.updateDynamic("secondaryText")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    disableTouchTap.foreach(v => p.updateDynamic("disableTouchTap")(v))
    insetChildren.foreach(v => p.updateDynamic("insetChildren")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    rightAvatar.foreach(v => p.updateDynamic("rightAvatar")(v))
    leftAvatar.foreach(v => p.updateDynamic("leftAvatar")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    onMouseOver.foreach(v => p.updateDynamic("onMouseOver")(v))
    onMouseOut.foreach(v => p.updateDynamic("onMouseOut")(v))
    secondaryTextLines.foreach(v => p.updateDynamic("secondaryTextLines")(v))
    leftIcon.foreach(v => p.updateDynamic("leftIcon")(v))
    rightIcon.foreach(v => p.updateDynamic("rightIcon")(v))
    rightToggle.foreach(v => p.updateDynamic("rightToggle")(v))
    leftCheckbox.foreach(v => p.updateDynamic("leftCheckbox")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListItem)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


/**
 * key: PropTypes.string,
style: PropTypes.js.Any,
ref: PropTypes.String,
 insetSubheader: React.PropTypes.bool,
    subheader: React.PropTypes.string,
    subheaderStyle: React.PropTypes.js.Any

 *
 */
case class MuiList(subheaderStyle: js.UndefOr[js.Any] = js.undefined,
                   insetSubheader: js.UndefOr[Boolean] = js.undefined,
                   style: js.UndefOr[js.Any] = js.undefined,
                   ref: js.UndefOr[String] = js.undefined,
                   key: js.UndefOr[String] = js.undefined,
                   subheader: js.UndefOr[String] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    subheaderStyle.foreach(v => p.updateDynamic("subheaderStyle")(v))
    insetSubheader.foreach(v => p.updateDynamic("insetSubheader")(v))
    style.foreach(v => p.updateDynamic("style")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    subheader.foreach(v => p.updateDynamic("subheader")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.List)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

package chandu0101.scalajs.react.components.materialui


import japgolly.scalajs.react._
import materialui.Mui

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, undefined}


/**
 * Created by chandrasekharkode .
 *
 * key: PropTypes.string,
   ref: PropTypes.String,
   onLeftIconButtonTouchTap: React.PropTypes.ReactEventH => Unit,
    onRightIconButtonTouchTap: React.PropTypes.ReactEventH => Unit,
    showMenuIconButton: React.PropTypes.bool,
    iconClassNameLeft: React.PropTypes.string,
    iconClassNameRight: React.PropTypes.string,
    iconElementLeft: React.PropTypes.element,
    iconElementRight: React.PropTypes.element,
    iconStyleRight: React.PropTypes.object,
    title : React.PropTypes.string,
    zDepth: React.PropTypes.number,
 */


case class MuiAppBar(iconStyleRight: UndefOr[js.Object] = undefined,
                  ref: UndefOr[String] = undefined,
                  iconClassNameRight: UndefOr[String] = undefined,
                  iconClassNameLeft: UndefOr[String] = undefined,
                  zDepth: UndefOr[Int] = undefined,
                  key: UndefOr[String] = undefined,
                  iconElementLeft: UndefOr[ReactElement] = undefined,
                  showMenuIconButton: UndefOr[Boolean] = undefined,
                  title: UndefOr[String] = undefined,
                  onLeftIconButtonTouchTap: UndefOr[ReactEventH => Unit] = undefined,
                  iconElementRight: UndefOr[ReactElement] = undefined,
                  onRightIconButtonTouchTap: UndefOr[ReactEventH => Unit] = undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    iconStyleRight.foreach(v => p.updateDynamic("iconStyleRight")(v))
    ref.foreach(v => p.updateDynamic("ref")(v))
    iconClassNameRight.foreach(v => p.updateDynamic("iconClassNameRight")(v))
    iconClassNameLeft.foreach(v => p.updateDynamic("iconClassNameLeft")(v))
    zDepth.foreach(v => p.updateDynamic("zDepth")(v))
    key.foreach(v => p.updateDynamic("key")(v))
    iconElementLeft.foreach(v => p.updateDynamic("iconElementLeft")(v))
    showMenuIconButton.foreach(v => p.updateDynamic("showMenuIconButton")(v))
    title.foreach(v => p.updateDynamic("title")(v))
    onLeftIconButtonTouchTap.foreach(v => p.updateDynamic("onLeftIconButtonTouchTap")(v))
    iconElementRight.foreach(v => p.updateDynamic("iconElementRight")(v))
    onRightIconButtonTouchTap.foreach(v => p.updateDynamic("onRightIconButtonTouchTap")(v))
    p
  }

  def apply(children: ReactNode*) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.AppBar)
    f(toJS, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}


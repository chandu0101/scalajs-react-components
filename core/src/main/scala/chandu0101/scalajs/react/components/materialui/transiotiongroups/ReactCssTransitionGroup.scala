package chandu0101.scalajs.react.components.materialui.transiotiongroups

import japgolly.scalajs.react.{React, ReactComponentU_, ReactNode, vdom}

import scala.scalajs.js
/**
 * Created by chandrasekharkode .
 */
object ReactCssTransitionGroup {
  /** Items in the CSSTransitionGroup need this attribute for animation to work properly. */
  @inline final def key = vdom.Attrs.key

}

case class ReactCssTransitionGroup(name: String,
                                   className : js.UndefOr[String] = js.undefined,
                                   enter: js.UndefOr[Boolean] = js.undefined,
                                   leave: js.UndefOr[Boolean] = js.undefined,
                                   component: js.UndefOr[String] = js.undefined) {
  def toJs: js.Object = {
    val p = js.Dynamic.literal("transitionName" -> name)
    className.foreach(v => p.updateDynamic("className")(v))
    enter.foreach(v => p.updateDynamic("transitionEnter")(v))
    leave.foreach(v => p.updateDynamic("transitionLeave")(v))
    component.foreach(v => p.updateDynamic("component")(v))
    p
  }

  def apply(children: ReactNode*): ReactComponentU_ = {
    val f = React.addons.CSSTransitionGroup
    f(toJs, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}
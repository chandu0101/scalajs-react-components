package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js



/**
 * Created by chandrasekharkode on 12/5/14.
 * action: React.PropTypes.string,
    icon: React.PropTypes.string,
    message: React.PropTypes.string,
    onClick: React.PropTypes.func,
    open: React.PropTypes.bool
 */
object MuiToast {

  val component = ReactComponentB[Props]("radioButton")
    .initialState(State(open = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val classes = CommonUtils.cssMapM(P.classNames, mui_toast -> true,
      mui_open -> S.open)
    span(classSetM(classes))(
      if (!P.message.isEmpty) span(cls := mui_toast_message)(P.message) else "",
      if (!P.action.isEmpty) span(cls := mui_toast_action, onClick ==> B.onActionClick)(P.action) else ""
    )
  })
    .componentWillReceiveProps((scope, nextProps) => {
    scope.modState(_.copy(open = nextProps.open))
  })
    .build

  def apply(onClick: REventIUnit = null, icon: String = "", open: Boolean = false, message: String = "", classNames: CssClassType = Map(), action: String = "", ref: js.UndefOr[String] = "", key: js.Any = {}) = {
    component.set(key, ref)(Props(onClick, icon, open, message, classNames, action))
  }

  case class Props(onClick: REventIUnit, icon: String, open: Boolean, message: String, classNames: CssClassType, action: String)

  case class State(open: Boolean)

  class Backend(t: BackendScope[Props, State]) {

    def onActionClick(e: ReactEventI) = {
      if (t.props.onClick != null) t.props.onClick(e)
      t.modState(s => State(!s.open))
    }

    def toggle() = t.modState(s => State(!s.open))

  }


}

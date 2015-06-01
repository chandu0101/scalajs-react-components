package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import chandu0101.scalajs.react.components.mixins.WindowListeners
import chandu0101.scalajs.react.components.util.{CommonUtils, Events}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.ext.KeyCode
import org.scalajs.dom.{Event, KeyboardEvent, html}

import scala.scalajs.js

/**
 * Created by chandrasekharkode on 12/21/14.
 *
 * actions: React.PropTypes.array,
    contentClassName: React.PropTypes.string,
    openImmediately: React.PropTypes.bool,
    onClickAway: React.PropTypes.func,
    onDismiss: React.PropTypes.func,
    onShow: React.PropTypes.func,
    repositionOnUpdate: React.PropTypes.bool
 * sync 21/12/2014
 */
object MuiDialogWindow {


  case class State(open: Boolean)

  class Backend(t: BackendScope[Props, State]) extends WindowListeners {

    def positionDialog(container: html.Element) = {
      if (t.state.open) {
        val dialogWindow = theDialogWindowRef(t).get.getDOMNode()
        val containerHeight = container.offsetHeight
        //Reset the height in case the window was resized.
        dialogWindow.style.height = ""
        val dialogWindowHeight = dialogWindow.offsetHeight

        //Vertically center the dialog window, but make sure it doesn't
        //transition to that position.
        if (t.props.repositionOnUpdate || container.style.paddingTop.isEmpty) {
          container.style.paddingTop = (((containerHeight - dialogWindowHeight) / 2) - 64).toString.concat("px")
        }
      }
    }

    def isOpen = t.state.open

    def dismiss() = {
//      CssEvents.onTransitionEnd(t.getDOMNode(),(e : Event) => {
        //allow scrolling
        val body = dom.document.getElementsByTagName("body")(0).asInstanceOf[html.Element]
        body.style.overflow = ""
        body.style.position = ""
//      })
      t.modState(_.copy(open = false))
      if (t.props.onDismiss != null) t.props.onDismiss
    }

    def show() = {
      //prevent scrolling
      val body = dom.document.getElementsByTagName("body")(0).asInstanceOf[html.Element]
       body.style.overflow = "hidden"
       body.style.position = "fixed"
      if (t.props.onShow != null) t.props.onShow
      t.modState(_.copy(open = true))
    }

    def handleOverlatTouchTap() = dismiss()

    lazy val handleWindowKeyUp: js.Function1[Event, _] = (e: Event) => {
      if (e.asInstanceOf[KeyboardEvent].keyCode == KeyCode.escape) dismiss()
    }
    override val listeners: List[(String, js.Function1[Event, _])] = List((Events.KEYUP, handleWindowKeyUp))
  }

  val theDialogWindowRef = Ref.to(MuiPaper.component,"thePaperDialogWindow")

  val component = ReactComponentB[Props]("MuiDialogWindow")
    .initialStateP(p => State(p.openImmediately))
    .backend(new Backend(_))
    .render((P, C, S, B) => {
    val classes = CommonUtils.cssMap(mui_dialog_window, (mui_is_shown, S.open)).++(P.clsNames)
    val contentClasses = CommonUtils.cssMap(P.contentClassName.concat(s" $mui_dialog_window_contents"))
    <.div(^.classSetM(classes))(
      MuiPaper(ref = theDialogWindowRef, clsNames = contentClasses, zDepth = 4, rounded = true)(
        C,
        <.div(^.cls := mui_dialog_window_actions, ^.key := "actionsdiv")(
          P.actions
        )
      ),
      MuiOverlay(show = S.open, onTouchTap = B.dismiss _)
    )
  }).domType[html.Element]
    .componentDidMount($ => $.backend.positionDialog($.getDOMNode()))
    .componentDidUpdate(($, _, _) => $.backend.positionDialog($.getDOMNode()))
    .configure(WindowListeners.mixin)
    .build


  case class Props(contentClassName: String, onDismiss: EmptyFunc, onShow: EmptyFunc, openImmediately: Boolean, onClickAway: REventIUnit, clsNames: CssClassType, ref: js.UndefOr[String], key: js.Any, actions: List[ReactNode], repositionOnUpdate: Boolean)

  def apply(contentClassName: String = "", onDismiss: EmptyFunc = null, onShow: EmptyFunc = null, openImmediately: Boolean = false, onClickAway: REventIUnit = null, clsNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {}, actions: List[ReactNode] = List(), repositionOnUpdate: Boolean = false)(children: ReactNode*) =
    component.set(key, ref)(Props(contentClassName, onDismiss, onShow, openImmediately, onClickAway, clsNames, ref, key, actions, repositionOnUpdate), children)

}

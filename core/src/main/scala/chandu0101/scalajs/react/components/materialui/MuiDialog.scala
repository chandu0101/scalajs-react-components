package chandu0101.scalajs.react.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom.html

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object MuiDialog {


  case class Action(text: String, onClick: REventIUnit = null)

  case class State(open: Boolean)

  class Backend(t: BackendScope[Props, State]) {

    def dismiss(e:ReactEventI) : Unit = {
      theDialogWindowRef(t).get.backend.dismiss
    }

    def show(e:ReactEventI) = {
      theDialogWindowRef(t).get.backend.show
    }

    def getDialogActions  : List[ReactNode] = t.props.actions.zipWithIndex.map {
      case (action,index) => val onCLickHandler : REventIUnit = if(action.onClick != null) action.onClick else dismiss _
        MuiFlatButton(clsNames = Map(mui_dialog_window_action -> true),key = index,onTouchTap = onCLickHandler,label = action.text ,secondary = true)
    }
  }

  val theDialogContentRef = Ref[html.Element]("theDialogContent")

  val theDialogWindowRef = Ref.to(MuiDialogWindow.component,"theDialogWindowRefInDialog")

  lazy val component = ReactComponentB[Props]("MuiDialog")
    .initialStateP(p => State(p.openImmediately))
    .backend(new Backend(_))
    .render((P, C, S, B) => {
      MuiDialogWindow( ref = theDialogWindowRef , clsNames = Map(mui_dialog -> true) ,actions = B.getDialogActions)(
       h3( cls := mui_dialog_title ,key := "title" ,P.title),
       div( ref := theDialogContentRef, key := "content" ,cls := mui_dialog_content)(
         C
       )
      )
    })
    .build

  val theDialogRef = Ref.to(component,"theDialogRef")

  case class Props(onDismiss: REventIUnit, onShow: REventIUnit, openImmediately: Boolean, actions: List[Action], title: String, classNames: CssClassType)

  def apply(onDismiss: REventIUnit = null, onShow: REventIUnit = null, openImmediately: Boolean = false, actions: List[Action] = List(), title: String = "", classNames: CssClassType = Map(), ref: js.UndefOr[String] = "", key: js.Any = {})(children: ReactNode*) = {
    component.set(key,ref)(Props(onDismiss, onShow, openImmediately, actions, title, classNames), children)
  }

}

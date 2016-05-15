package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiListDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  import Mui.SvgIcons.{ActionGrade, ActionInfo, ContentDrafts, ContentInbox, ContentSend}

  val component = ReactComponentB[Unit]("MuiListDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiList")(
          MobileTearSheet(
            MuiList()(
              MuiListItem(
                leftIcon           = ContentInbox()(),
                onKeyboardFocus    = CallbackDebug.f1("onKeyboardFocus"),
                onMouseLeave       = CallbackDebug.f1("onMouseLeave"),
                onMouseEnter       = CallbackDebug.f1("onMouseEnter"),
                onNestedListToggle = CallbackDebug.f1("onNestedListToggle"),
                onTouchStart       = CallbackDebug.f1("onTouchStart"),
                onTouchTap         = CallbackDebug.f1("onTouchTap")

              )("Inbox"),
              MuiListItem(primaryText = "Starred",   leftIcon = ActionGrade()())(),
              MuiListItem(primaryText = "Sent Mail", leftIcon = ContentSend()())(),
              MuiListItem(primaryText = "Drafts",    leftIcon = ContentDrafts()())()
            ),
            MuiDivider()(),
            MuiList()(
              MuiListItem(primaryText = "All mail",  rightIcon = ActionInfo()())(),
              MuiListItem(primaryText = "Trash",     rightIcon = ActionInfo()())(),
              MuiListItem(primaryText = "Spam",      rightIcon = ActionInfo()())(),
              MuiListItem(primaryText = "Follow up", rightIcon = ActionInfo()())()
            )
          )
        )
      )
    }).build

  // EXAMPLE:END

  def apply() = component()
}

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
            MuiList(key = "list1")(
              MuiListItem(
                key                = "item1",
                leftIcon           = ContentInbox()(),
                onKeyboardFocus    = CallbackDebug.f1("onKeyboardFocus"),
                onMouseLeave       = CallbackDebug.f1("onMouseLeave"),
                onMouseEnter       = CallbackDebug.f1("onMouseEnter"),
                onNestedListToggle = CallbackDebug.f1("onNestedListToggle"),
                onTouchStart       = CallbackDebug.f1("onTouchStart"),
                onTouchTap         = CallbackDebug.f1("onTouchTap")
              )("Inbox"),
              MuiListItem(key = "item2", primaryText = "Starred",   leftIcon = ActionGrade()())(),
              MuiListItem(key = "item3", primaryText = "Sent Mail", leftIcon = ContentSend()())(),
              MuiListItem(key = "item4", primaryText = "Drafts",    leftIcon = ContentDrafts()())()
            ),
            MuiDivider(key = "div")(),
            MuiList(key = "list2")(
              MuiListItem(key = "item1", primaryText = "All mail",  rightIcon = ActionInfo()())(),
              MuiListItem(key = "item2", primaryText = "Trash",     rightIcon = ActionInfo()())(),
              MuiListItem(key = "item3", primaryText = "Spam",      rightIcon = ActionInfo()())(),
              MuiListItem(key = "item4", primaryText = "Follow up", rightIcon = ActionInfo()())()
            )
          )
        )
      )
    }).build

  // EXAMPLE:END

  def apply() = component()
}

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

  import Mui.SvgIcons.{ContentInbox, ActionGrade, ContentSend, ContentDrafts, ActionInfo}

  val component = ReactComponentB[Unit]("MuiListDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiList")(
          MobileTearSheet(
            MuiList()(
              MuiListItem(
                leftIcon           = ContentInbox()(),
                onKeyboardFocus    = DummyEvents.f1("onKeyboardFocus"),
                onMouseLeave       = DummyEvents.f1("onMouseLeave"),
                onMouseEnter       = DummyEvents.f1("onMouseEnter"),
                onNestedListToggle = DummyEvents.f1_("onNestedListToggle"),
                onTouchStart       = DummyEvents.f1("onTouchStart"),
                onTouchTap         = DummyEvents.f1("onTouchTap")

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
    }).buildU

  // EXAMPLE:END

  def apply() = component()
}

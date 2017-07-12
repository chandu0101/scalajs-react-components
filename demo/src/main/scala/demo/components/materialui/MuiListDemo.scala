package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object MuiListDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  import Mui.SvgIcons.{ActionGrade, ActionInfo, ContentDrafts, ContentInbox, ContentSend}
  import MuiSvgIcon._

  val component = ScalaComponent.builder[Unit]("MuiListDemo")
    .render(P => {
      // Compiler has trouble with too many implicit conversions at once
      def iconElement(svg: MuiSvgIcon): VdomElement = svg()().vdomElement

      <.div(
        CodeExample(code, "MuiList")(
          MobileTearSheet(
            MuiList(key = "list1")(
              MuiListItem(
                key                = "item1",
                leftIcon           = iconElement(ContentInbox),
                onKeyboardFocus    = CallbackDebug.f2("onKeyboardFocus"),
                onMouseLeave       = CallbackDebug.f1("onMouseLeave"),
                onMouseEnter       = CallbackDebug.f1("onMouseEnter"),
                onNestedListToggle = CallbackDebug.f1("onNestedListToggle"),
                onTouchStart       = CallbackDebug.f1("onTouchStart"),
                onTouchTap         = CallbackDebug.f1("onTouchTap")
              )("Inbox"),
              MuiListItem(key = "item2", primaryText = "Starred",   leftIcon = iconElement(ActionGrade))(),
              MuiListItem(key = "item3", primaryText = "Sent Mail", leftIcon = iconElement(ContentSend))(),
              MuiListItem(key = "item4", primaryText = "Drafts",    leftIcon = iconElement(ContentDrafts))()
            ),
            MuiDivider(key = "div")(),
            MuiList(key = "list2")(
              MuiListItem(key = "item1", primaryText = "All mail",  rightIcon = iconElement(ActionInfo))(),
              MuiListItem(key = "item2", primaryText = "Trash",     rightIcon = iconElement(ActionInfo))(),
              MuiListItem(key = "item3", primaryText = "Spam",      rightIcon = iconElement(ActionInfo))(),
              MuiListItem(key = "item4", primaryText = "Follow up", rightIcon = iconElement(ActionInfo))()
            )
          )
        )
      )
    }).build

  // EXAMPLE:END

  def apply() = component()
}

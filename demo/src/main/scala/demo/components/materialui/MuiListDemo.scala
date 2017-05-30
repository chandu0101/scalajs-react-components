package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiListDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  import Mui.SvgIcons._

  val component = ScalaComponent
    .builder[Unit]("MuiListDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiList")(
          MobileTearSheet(
            MuiList(key = "list1")(
              MuiListItem(
                key = "item1",
                leftIcon = js.defined(ContentInbox()()),
                onKeyboardFocus = CallbackDebug.f2("onKeyboardFocus"),
                onMouseLeave = CallbackDebug.f1("onMouseLeave"),
                onMouseEnter = CallbackDebug.f1("onMouseEnter"),
                onNestedListToggle = CallbackDebug.f1("onNestedListToggle"),
                onTouchStart = CallbackDebug.f1("onTouchStart"),
                onTouchTap = CallbackDebug.f1("onTouchTap")
              )("Inbox"),
              MuiListItem(key = "item2",
                          primaryText = js.defined("Starred"),
                          leftIcon = js.defined(ActionGrade()()))(),
              MuiListItem(key = "item3",
                          primaryText = js.defined("Sent Mail"),
                          leftIcon = js.defined(ContentSend()()))(),
              MuiListItem(key = "item4",
                          primaryText = js.defined("Drafts"),
                          leftIcon = js.defined(ContentDrafts()()))()
            ),
            MuiDivider(key = "div")(),
            MuiList(key = "list2")(
              MuiListItem(key = "item1",
                          primaryText = js.defined("All mail"),
                          rightIcon = js.defined(ActionInfo()()))(),
              MuiListItem(key = "item2",
                          primaryText = js.defined("Trash"),
                          rightIcon = js.defined(ActionInfo()()))(),
              MuiListItem(key = "item3",
                          primaryText = js.defined("Spam"),
                          rightIcon = js.defined(ActionInfo()()))(),
              MuiListItem(key = "item4",
                          primaryText = js.defined("Follow up"),
                          rightIcon = js.defined(ActionInfo()()))()
            )
          )
        )
      )
    })
    .build

  // EXAMPLE:END

  def apply() = component()
}

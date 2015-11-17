package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui.{MuiList, MuiListItem}
import demo.components.materialui.svgicons._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiListDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiListDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiList")(
          MobileTearSheet(
            MuiList()(
              MuiListItem(leftIcon = ContentInbox())("Inbox"),
              MuiListItem(leftIcon = ActionGrade())("Starred"),
              MuiListItem(leftIcon = ContentSend())("Sent Mail"),
              MuiListItem(leftIcon = ContentDrafts())("Drafts")
            )
          )
        )
      )
    }).buildU

  // EXAMPLE:END

  def apply() = component()
}

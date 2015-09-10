package chandu0101.scalajs.react.components
package demo.components.materialui

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.demo.components.materialui.svgicons._
import chandu0101.scalajs.react.components.materialui.{MuiList, MuiListItem}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object MuiListDemo {

  val code =
    """
      | MuiList()(
      |            MuiListItem(leftIcon = ContentInbox())("Inbox")
      |            MuiListItem(leftIcon = ActionGrade())("Starred"),
      |            MuiListItem(leftIcon = ContentSend())("Sent Mail"),
      |            MuiListItem(leftIcon = ContentDrafts())("Drafts")
      |          )
      |
    """.stripMargin
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


  def apply() = component()
}

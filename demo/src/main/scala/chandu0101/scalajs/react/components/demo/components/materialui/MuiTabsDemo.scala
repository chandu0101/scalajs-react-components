package chandu0101.scalajs.react.components
package demo.components.materialui

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.fascades.LatLng
import chandu0101.scalajs.react.components.materialui.{MuiTab, MuiTabs}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object MuiTabsDemo {

  object Style extends StyleSheet.Inline {

    import dsl._

    val tabContent = style(textAlign.center,
      padding(40.px))
  }


  val code =
    """
      |   MuiTabs(
      |    )(
      |       MuiTab(label = "Tab1")(
      |          <.h3(Style.tabContent, "Tab1 Content")
      |        ),
      |        MuiTab(label = "Tab2")(
      |          <.h3(Style.tabContent, "Tab2 Content")
      |        )
      |      )
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("MuiTabsDemo")
    .render(P => {
    <.div(
      CodeExample(code, "MuiTabs")(
        MuiTabs(
        )(
            MuiTab(label = "Tab1")(
              <.h3(Style.tabContent, "Tab1 Content")
            ),
            MuiTab(label = "Tab2")(
              <.h3(Style.tabContent, "Tab2 Content")
            )
          )
      )
    )
  }).buildU

  lazy val latlng = LatLng(16.3008, 80.4428)

  def apply() = component()
}

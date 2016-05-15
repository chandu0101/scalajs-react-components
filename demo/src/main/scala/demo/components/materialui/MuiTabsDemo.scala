package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
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

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiTabsDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiTabs")(
          MuiTabs()(
            MuiTab(label = "Tab1")(
              <.h3(Style.tabContent, "Tab1 Content")
            ),
            MuiTab(label = "Tab2")(
              <.h3(Style.tabContent, "Tab2 Content")
            )
          )
        )
      )
    }).build

  // EXAMPLE:END

  def apply() = component()
}

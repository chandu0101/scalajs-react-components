package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.ReactElement
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ScalaCssReact._

object MuiTabsDemo {

  val cssSettings = scalacss.devOrProdDefaults
  import cssSettings._

  object Style extends StyleSheet.Inline {

    import dsl._

    val tabContent = style(textAlign.center, padding(40.px))
  }

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  case class Backend($ : BackendScope[Unit, Int]) {
    val onChange: (Int, ReactEventFromHtml, ReactElement) => Callback =
      (chosen, _, _) ⇒ $.setState(chosen) >> Callback.info(s"chose $chosen")

    def render(current: Int) =
      <.div(
        CodeExample(code, "MuiTabs")(
          MuiTabs[Int](value = current, onChange = onChange)(
            MuiTab[Int](label = "Tab1", value = 1)(
              <.h3(Style.tabContent, "Tab1 Content")
            ),
            MuiTab[Int](label = "Tab2", value = 2)(
              <.h3(Style.tabContent, "Tab2 Content")
            )
          )
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("MuiTabsDemo")
    .initialState(2)
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

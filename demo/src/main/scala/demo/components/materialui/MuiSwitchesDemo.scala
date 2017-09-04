package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._

object MuiSwitchesDemo {

  object Style extends StyleSheet.Inline {

    import dsl._

    val container = style(maxWidth(1024 px))

    val content = style(
      display.flex,
      padding(30.px),
      flexDirection.column,
      alignItems.center
    )
  }
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ScalaComponent
    .builder[Unit]("MuiSwitchesDemo")
    .render(
      P =>
        CodeExample(code, "MuiSwitches")(
          <.div(
            Style.container,
            <.h3("Switches"),
            MuiTabs()(
              MuiTab(label = js.defined("Checkbox"))(
                <.div(
                  Style.content,
                  MuiCheckbox(
                    name = "checkboxName1",
                    value = 1,
                    label = js.defined("went for a run today")
                  )(),
                  MuiCheckbox(
                    name = "checkboxName2",
                    value = "checkboxValue2",
                    label = js.defined("feed the dog")
                  )(),
                  MuiCheckbox(
                    name = "checkboxName3",
                    value = "checkboxValue3",
                    label = js.defined("built a house on the moon"),
                    disabled = true
                  )()
                )
              ),
              MuiTab(label = js.defined("RadioButton"))(
                <.div(
                  Style.content,
                  MuiRadioButtonGroup(name = "shipspeed",
                                      defaultSelected = js.defined("not_light"))(
                    MuiRadioButton(value = "light",
                                   label = js.defined("prepare for light speed"))(),
                    MuiRadioButton(value = "no_light",
                                   label = js.defined("light speed too slow"))(),
                    MuiRadioButton(value = "ludicrous",
                                   label = js.defined("go to ludicrous speed"),
                                   disabled = true)()
                  )
                )
              ),
              MuiTab(label = js.defined("Toggle"))(
                <.div(
                  Style.content,
                  MuiToggle(name = "toggleName1",
                            value = "togglevalue1",
                            label = js.defined("active thrusters"))(),
                  MuiToggle(name = "toggleName2",
                            value = "togglevalue2",
                            label = js.defined("auto-pilot"),
                            defaultToggled = true)(),
                  MuiToggle(name = "toggleName3",
                            value = "togglevalue3",
                            label = js.defined("initiate self-destruct sequence"),
                            disabled = true)()
                )
              )
            )
          )
      ))
    .build

  // EXAMPLE:END

  def apply() = component()

}

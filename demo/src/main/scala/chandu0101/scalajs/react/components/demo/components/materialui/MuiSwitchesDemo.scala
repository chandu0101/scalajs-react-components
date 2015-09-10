package chandu0101.scalajs.react.components
package demo.components.materialui

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline

object MuiSwitchesDemo {

  val code =
    """
      | MuiAppBar(title = "Title")()
      |
    """.stripMargin

  val checkboxCode =
    """
      | MuiCheckBox(name="checkboxName1",
      |                value="checkboxValue1",
      |                label="went for a run today"),
      | MuiCheckBox(name="checkboxName2",
      |                value="checkboxValue2",
      |                label="feed the dog"),
      | MuiCheckBox(name="checkboxName3",
      |                value="checkboxValue3",
      |                label="built a house on the moon",
      |                disabled = true
      |              )
      |
    """.stripMargin

  val radioButtonCode =
    """
      | MuiRadioButtonGroup(name = "shipspeed",
      |                defaultSelected = "not_light")(
      |                MuiRadioButton(value = "light" ,label = "prepare for light speed"),
      |                MuiRadioButton(value = "no_light" ,label = "light speed too slow"),
      |                MuiRadioButton(value = "ludicrous" ,label = "go to ludicrous speed",disabled = true)
      |              )
      |
    """.stripMargin

  val toggleCode =
    """
      |MuiToggle(name = "toggleName1" , value = "togglevalue1" ,label = "active thrusters"),
      |MuiToggle(name = "toggleName2" , value = "togglevalue2" ,label = "auto-pilot",defaultToggled = true),
      |MuiToggle(name = "toggleName3" , value = "togglevalue3" ,label = "initiate self-destruct sequence",disabled = true)
      |
    """.stripMargin

  object Style extends Inline {

    import dsl._

    val container = style(maxWidth(1024 px))


    val content = style(display.flex,
      padding(30.px),
      flexDirection.column,
      alignItems.center)
  }


  val component = ReactComponentB[Unit]("MuiSwitchesDemo")
    .render(P => {
    <.div(Style.container,
      <.h3("Switches"),
      MuiTabs()(
        MuiTab(label = "Checkbox")(
          CodeExample(checkboxCode)(
            <.div(Style.content,
              MuiCheckBox(name="checkboxName1",
                value="checkboxValue1",
                label="went for a run today")(),
              MuiCheckBox(name="checkboxName2",
                value="checkboxValue2",
                label="feed the dog")(),
              MuiCheckBox(name="checkboxName3",
                value="checkboxValue3",
                label="built a house on the moon",
                disabled = true
              )()
            )
          )
        ),
        MuiTab(label = "RadioButton")(
          CodeExample(radioButtonCode)(
            <.div(Style.content,
              MuiRadioButtonGroup(name = "shipspeed",
                defaultSelected = "not_light")(
                MuiRadioButton(value = "light" ,label = "prepare for light speed")(),
                MuiRadioButton(value = "no_light" ,label = "light speed too slow")(),
                MuiRadioButton(value = "ludicrous" ,label = "go to ludicrous speed",disabled = true)()
              )
            )
          )
        ),
        MuiTab(label = "Toggle")(
          CodeExample(toggleCode)(
            <.div(Style.content,
              MuiToggle(name = "toggleName1" , value = "togglevalue1" ,label = "active thrusters")(),
              MuiToggle(name = "toggleName2" , value = "togglevalue2" ,label = "auto-pilot",defaultToggled = true)(),
              MuiToggle(name = "toggleName3" , value = "togglevalue3" ,label = "initiate self-destruct sequence",disabled = true)()
            )
          )
        )
      )
    )
  }).buildU


  def apply() = component()


}

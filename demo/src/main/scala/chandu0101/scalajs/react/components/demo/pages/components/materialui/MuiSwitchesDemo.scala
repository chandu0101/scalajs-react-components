package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.{MuiCheckbox, MuiRadioButton, MuiToggle}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

/**
 * Created by chandrasekharkode .
 */
object MuiSwitchesDemo {

  val checkBoxCode =
    """
      | MuiCheckbox(name = "checkBoxName1", value = "checkboxValue1", onCheck = B.onCheckBoxClick ,label = "get out of box"),
      | MuiCheckbox(name = "checkBoxName2", value = "checkboxValue2", onCheck = B.onCheckBoxClick , label = "see nature conciously" , defaultChecked = true),
      | MuiCheckbox(name = "checkBoxName3", value = "checkboxValue3", disabled = true ,label = "live every moment")
      |
    """.stripMargin

  val radioButtonCode =
    """
      | MuiRadioButton( name = "shipped" ,value = "light" ,label = "prepare for light speed" ,onCheck = B.onRadioButtonClick),
      | MuiRadioButton( name = "shipped" ,value = "not_light" ,label = "light speed too slow",onCheck = B.onRadioButtonClick ,defaultChecked = true),
      | MuiRadioButton( name = "shipped" ,value = "ludicrous" ,label = "go to ludicous speed",onCheck = B.onRadioButtonClick ,disabled = true)
    """.stripMargin

  val toggleCode =
    """
      |MuiToggle(onToggle = B.onToggle,name = "togllename1" ,value = "togllename1" ,label = "active thursters" ,defaultToggled = true)
      |
    """.stripMargin

  class Backend(t: BackendScope[_, _]) {

    def onCheckBoxClick(e: ReactEventI, checked: Boolean) = println("MuiCheckbox checked : " + checked)
    def onRadioButtonClick(e: ReactEventI, value : String) = println("Radiobutton checked : " + value)
    def onToggle(e: ReactEventI, toggled: Boolean) = println("Toggled : " + toggled)

  }

  val component = ReactComponentB[Unit]("MuiSwitchesDemo")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    div(
      h3("Checkbox"),
      CodeExample(checkBoxCode)(
          MuiCheckbox(name = "checkBoxName1", value = "checkboxValue1", onCheck = B.onCheckBoxClick ,label = "get out of box" ,key = "check1"),
          MuiCheckbox(name = "checkBoxName2", value = "checkboxValue2", onCheck = B.onCheckBoxClick , label = "see nature conciously" , defaultChecked = true ,key = "check2"),
            MuiCheckbox(name = "checkBoxName3", value = "checkboxValue3", disabled = true ,label = "live every moment" ,key = "check3")
      ),
      h3("Radiobutton"),
      CodeExample(radioButtonCode)(
          MuiRadioButton( name = "shipped" ,value = "light" ,label = "prepare for light speed" ,onCheck = B.onRadioButtonClick ,key = "radio1"),
          br(),
          MuiRadioButton( name = "shipped" ,value = "not_light" ,label = "light speed too slow",onCheck = B.onRadioButtonClick ,defaultChecked = true ,key = "radio2"),
          br(),
          MuiRadioButton( name = "shipped" ,value = "ludicrous" ,label = "go to ludicous speed",onCheck = B.onRadioButtonClick ,disabled = true ,key = "radio3")
      ),
      h3("Toggle"),
      CodeExample(toggleCode)(
         MuiToggle(onToggle = B.onToggle,name = "togllename1" ,value = "togllename1" ,label = "active thursters" ,defaultToggled = true ,key = "toggle1")
      )
    )
  }).buildU

  def apply() = component()
}

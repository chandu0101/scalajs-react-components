package chandu0101.scalajs.react.components.demo.pages.components.materialui


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.MuiTextField
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

/**
 * Created by chandrasekharkode on 2/12/15.
 */
object MuiTextFieldDemo {

  val code =
    """
      | // Inline Hint text
      |MuiTextField(hintText = "Hint Text", defaultValue = "Default Value"),
      |MuiTextField(hintText = "Hint Text" ,value = S.propValue,onChange = B.handleInputChange ),
      |MuiTextField(hintText = "Hint Text(multi line )" ,multiLine = true),
      |MuiTextField(hintText = "Hint Text" ,errorText = "fix me now"),
      |MuiTextField(hintText = " Disabled Hint Text" ,disabled = true),
      |MuiTextField(hintText = "Disabled Hint Text" ,disabled = true ,defaultValue = " Disabled with value") 
      
      | // floating hint text 
      |MuiTextField(hintText = "Hint Text" ,floatingLabelText = "Floating Label Text" ,defaultValue = "Default Value"),
      |MuiTextField(hintText = "Hint Text" ,floatingLabelText = "Floating Label Text" ,value = "Real Value"),
      |MuiTextField(hintText = "Hint Text(Multi Line)" ,floatingLabelText = "Floating Label Text" ,multiLine = true),
      |MuiTextField(hintText = "Hint Text" ,floatingLabelText = "Floating Label Text" ,errorText = "fix me now"),
      |MuiTextField(hintText = "Disabled Hint Text" ,floatingLabelText = "Floating Label Text" ,disabled = true),
      |MuiTextField(hintText = "Disabled Hint Text" ,floatingLabelText = "Floating Label Text",disabled = true,defaultValue = "Disabled With Value")
      |
    """.stripMargin

  object Style {
    val textFieldExamples = Seq(^.display := "flex", ^.flexWrap := "wrap", ^.justifyContent := "space-around")

    val textFieldGroup = Seq(^.display := "flex", ^.flexDirection := "column")
  }

  case class State(propValue : String = "propValue")
  class Backend(t: BackendScope[_, State]) {
     def handleInputChange(e : ReactEventI) = t.modState(_.copy(propValue = e.target.value))
  }


  val component = ReactComponentB[Unit]("MuiTextFieldDemo")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
    <.div(
      <.h3("Text Field" ,^.key := "heading"),
      CodeExample(code ,key = "codeexample")(
        <.div(Style.textFieldExamples , ^.key := "examples")(
          <.div(Style.textFieldGroup, ^.key := "group")(
            MuiTextField(hintText = "Hint Text", defaultValue = "Default Value",key = "inline2"),
            MuiTextField(hintText = "Hint Text" ,value = S.propValue,onChange = B.handleInputChange,key = "inline3" ),
            MuiTextField(hintText = "Hint Text(multi line )" ,multiLine = true,key = "inline4"),
            MuiTextField(hintText = "Hint Text" ,errorText = "fix me now",key = "inline5"),
            MuiTextField(hintText = " Disabled Hint Text" ,disabled = true,key = "inline6"),
            MuiTextField(hintText = "Disabled Hint Text" ,disabled = true ,defaultValue = " Disabled with value",key = "inline7")
          ),
          <.div(Style.textFieldGroup ,^.key := "group2" )(
            MuiTextField(hintText = "Hint Text" ,floatingLabelText = "Floating Label Text" ,defaultValue = "Default Value",key = "finline2"),
            MuiTextField(hintText = "Hint Text" ,floatingLabelText = "Floating Label Text" ,value = "Real Value",key = "finline3"),
            MuiTextField(hintText = "Hint Text(Multi Line)" ,floatingLabelText = "Floating Label Text" ,multiLine = true,key = "finline4"),
            MuiTextField(hintText = "Hint Text" ,floatingLabelText = "Floating Label Text" ,errorText = "fix me now",key = "finline5"),
            MuiTextField(hintText = "Disabled Hint Text" ,floatingLabelText = "Floating Label Text" ,disabled = true,key = "finline6"),
            MuiTextField(hintText = "Disabled Hint Text" ,floatingLabelText = "Floating Label Text",disabled = true,defaultValue = "Disabled With Value",key = "finline7")
          )
        )
      )
    )
  }).buildU

  def apply() = component()
}

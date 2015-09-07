package chandu0101.scalajs.react.components.demo.components.reactselect

import chandu0101.macros.tojs.JSMacro
import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.optionselectors.ReactSelect
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.{Array => JArray}


object ReactSelectDemo {

  val code =
    """
      |  case class SampleOption(value : String,label : String) extends SelectOption {
      |    override def toJson: js.Dynamic = json(value = value,label = label)
      |  }
      |
      |  val options = JArray(
      |   SampleOption("value1","label1"),
      |   SampleOption("value2","label2"),
      |   SampleOption("value3","label3"),
      |   SampleOption("value4","label4"),
      |   SampleOption("value5","label5")
      |  )
      |
      |ReactSelect(options = options,
      |            value = S.value,
      |            onChange = B.onChange _)
      |
      |//multi
      |ReactSelect(options = options,
      |            value = S.value,
      |            multi = true,
      |            onChange = B.onMultiChange _)
      |
    """.stripMargin


  case class State(value: String = "", multiValue: String = "")

  class Backend(t: BackendScope[_, State]) {


    def onChange(value: String) = {
      t.modState(_.copy(value = value))
    }

    def onMultiChange(value: String) = {
      t.modState(_.copy(multiValue = value))
    }

  }


  val component = ReactComponentB[Unit]("ReactSelectDemo")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(
      CodeExample(code, "Demo")(
        <.div(
          <.h3("Single Select"),
          ReactSelect(options = options,
            value = S.value,
            onChange = B.onChange _)()
        ),
        <.div(
          <.h3("Multi Select"),
          ReactSelect(options = options,
            value = S.multiValue,
            multi = true,
            onChange = B.onMultiChange _)()
        )
      )
    )
  }).buildU

  case class SampleOption(value: String, label: String) {
    val toJS: js.Object = JSMacro[SampleOption](this)
  }

  object SampleOption {
    def fromJson(obj: js.Dynamic) = SampleOption(value = obj.value.toString, label = obj.label.toString)
  }

  val options = JArray(
    SampleOption("value1", "label1").toJS,
    SampleOption("value2", "label2").toJS,
    SampleOption("value3", "label3").toJS,
    SampleOption("value4", "label4").toJS,
    SampleOption("value5", "label5").toJS
  )

  def apply() = component()
}

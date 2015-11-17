package demo
package components
package reacttable

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.tables.ReactTable
import chandu0101.scalajs.react.components.util.JsonUtil
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactTableCustomCell {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Backend($: BackendScope[_, _]) {
    val data: Vector[Map[String, Any]] =
      JsonUtil.jsonArrayToMap(SampleData.personJson)
    val columns: List[String] =
      List("fname", "lname", "email", "country")

    //config is a List of touple4 (String, Option[(Any) => ReactElement], Option[(Model, Model) => Boolean],Option[Double])
    // ._1: columnname you want to config
    // ._2: custom render function (custom cell factory)
    // ._3: Sorting function
    // ._4: column width (flex := width)
    // let say if i want to turn all fnames to grey that starts with J (you can return any ReactElement(buttons,well another ReactTable if you want!)

    val config = List(("fname", Some(customFname), None, None))

    def customFname: Any => ReactElement =
      fname => {
        val name = fname.toString
        if (name.startsWith("J"))
          <.span(^.backgroundColor := "grey")(name)
        else <.span(name)
      }

    def render =
      <.div(
        <.h2(^.cls := "mui-font-style-headline")("Custom Cell Factory"),
        CodeExample(code)(
          ReactTable(data = data, columns = columns, config = config)
        )
      )
  }

  val component = ReactComponentB[Unit]("plain")
    .renderBackend[Backend]
    .buildU

  // EXAMPLE:END

  def apply() = component()

}

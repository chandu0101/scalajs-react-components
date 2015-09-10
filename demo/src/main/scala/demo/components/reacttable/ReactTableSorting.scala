package demo
package components
package reacttable

import chandu0101.scalajs.react.components.tables.ReactTable
import chandu0101.scalajs.react.components.util.JsonUtil
import demo.util.SampleData
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactTableSorting {

  val code =
    """
      | val data: Vector[Map[String, Any]] = JsonUtil.jsonArrayToMap(SampleData.personJson)
      |  val columns: List[String] = List("fname", "lname", "email", "country")
      |  /**
      |   *  ._1 : String = column name
      |   *  ._2 : Option[Any => ReactElement] = custom cell
      |   *  ._3 : Option[(Model,Model) => Boolean] = sorting function
      |   *  ._4 : Option[Double] = column width interms of flex property
      |   */
      |  val config  = List(("fname",None,Some(ReactTable.getStringSort("fname")),None)) // getStringSort is helper function
      |  ReactTable(data = data ,columns = columns , config = config)
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("ReactTableSorting")
    .render(P => {
   <.div(
     <.h2(^.cls := "mui-font-style-headline")("Sorting Table"),
      CodeExample(code)(
       ReactTable(data = data ,columns = columns , config = config)
      )
    )
  }).buildU

  val data: Vector[Map[String, Any]] = JsonUtil.jsonArrayToMap(SampleData.personJson)
  val columns: List[String] = List("fname", "lname", "email", "country")
  //config is a List of touple4 (String, Option[(Any) => ReactElement], Option[(Model, Model) => Boolean],Option[Double])
  // ._1 : columnname you want to config
  // ._2 : custom render function (custom cell factory)
  // ._3 : Sorting function
  // ._4 : column width (flex := width)
  val config  = List(("fname",None,Some(ReactTable.getStringSort("fname")),None)) // getStringSort is helper function

  def apply() = component()
}

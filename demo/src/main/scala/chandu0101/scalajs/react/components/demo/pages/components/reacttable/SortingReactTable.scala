package chandu0101.scalajs.react.components.demo.pages.components.reacttable

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.demo.util.SampleData
import chandu0101.scalajs.react.components.tables.ReactTable
import chandu0101.scalajs.react.components.util.JsonUtil
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object SortingReactTable {

  val code =
    """
      |  val data: Vector[Map[String, Any]] = JsonUtil.jsonArrayToMap(SampleData.personJson)
      |  val columns: List[String] = List("fname", "lname", "email", "country")
      |  //config is a List of touple3 (String, Function1[Any, TagMod], Function2[Map[String, Any], Map[String, Any], Boolean])
      |  // ._1 : columnname you want to config
      |  // ._2 : custom render function (custom cell factory) ( use null if you want to use  just toString
      |  // ._3 : Sorting function
      |  val config  = List(("fname",null,ReactTable.getStringSort("fname"))) // getStringSort is helper function
      |  ReactTable(data = data ,columns = columns , config = config)
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("plain")
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
  //config is a List of touple3 (String, Function1[Any, TagMod], Function2[Map[String, Any], Map[String, Any], Boolean])
  // ._1 : columnname you want to config
  // ._2 : custom render function (custom cell factory) ( use null if you want to use  just toString
  // ._3 : Sorting function
  val config  = List(("fname",null,ReactTable.getStringSort("fname"))) // getStringSort is helper function

  def apply() = component()
}

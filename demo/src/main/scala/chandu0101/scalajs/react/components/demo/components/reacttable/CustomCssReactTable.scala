package chandu0101.scalajs.react.components.demo.components.reacttable

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.demo.util.SampleData
import chandu0101.scalajs.react.components.tables.ReactTable
import chandu0101.scalajs.react.components.util.JsonUtil
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object CustomCssReactTable {

  val code =
    """
      |  val data : Vector[Map[String,Any]] = JsonUtil.jsonArrayToMap(SampleData.personJson)
      |  val columns : List[String] = List("fname","lname","email","country")
      |  /*
      |   Default CSS values
      |
      |   case class CSS(table : String = "table table-hover",tableResponsive :String = "table-responsive-vertical shadow-z-1" ,ascendingIcon :String = "ascendingIcon" ,descendingIcon :String = "descendingIcon" ,searchBoxForm : String = "form-group" ,searchBoxControl : String = "form-control")
      |
      |   table - table element classes
      |
      |   tableResponsive - table element parent div classes
      |
      |   ascendingIcon - Sort Ascending
      |
      |   descendingIcon - Sort Descending
      |
      |   searchBoxForm -  input box element parent form classes
      |
      |   searchBoxControl - input box element classes
      |
      |  */
      |  // if i want to change table class
      |  val newCss = ReactTable.CSS( table = "table table-hover table-striped table-mc-blue")
      |
      |  ReactTable(data = data ,columns = columns , css = newCss)
      |
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("plain")
    .render(P => {
   <.div(
     <.h2(^.cls := "mui-font-style-headline")("Custom Css"),
      CodeExample(code)(
       ReactTable(data = data ,columns = columns )
      )
    )
  }).buildU

  val data : Vector[Map[String,Any]] = JsonUtil.jsonArrayToMap(SampleData.personJson)
  val columns : List[String] = List("fname","lname","email","country")
  /*
   Default CSS values

   case class CSS(table : String = "table table-hover",tableResponsive :String = "table-responsive-vertical shadow-z-1" ,ascendingIcon :String = "ascendingIcon" ,descendingIcon :String = "descendingIcon" ,searchBoxForm : String = "form-group" ,searchBoxControl : String = "form-control")

   table - table element classes

   tableResponsive - table element parent div classes

   ascendingIcon - Sort Ascending

   descendingIcon - Sort Descending

   searchBoxForm -  input box element parent form classes

   searchBoxControl - input box element classes

  */
  // if i want to change table class
  val newCss = ReactTable.CSS( table = "table table-hover table-striped table-mc-blue")

  def apply() = component()

}

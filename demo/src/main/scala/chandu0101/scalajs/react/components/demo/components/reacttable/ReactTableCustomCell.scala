package chandu0101.scalajs.react.components
package demo.components.reacttable

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.demo.util.SampleData
import chandu0101.scalajs.react.components.tables.ReactTable
import chandu0101.scalajs.react.components.util.JsonUtil
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object ReactTableCustomCell {

  val code =
    """
      |  val data: Vector[Map[String, Any]] = JsonUtil.jsonArrayToMap(SampleData.personJson)
      |  val columns: List[String] = List("fname", "lname", "email", "country")
      |  def customFname = (fname : Any) => { val name = fname.toString ; if(name.startsWith("J")) <.span(^.backgroundColor := "grey")(name).render else <.span(name).render }
      |  //config is a List of touple4 (String, Option[(Any) => ReactElement], Option[(Model, Model) => Boolean],Option[Double])
      | /**
      |   *  ._1 : String = column name
      |   *  ._2 : Option[Any => ReactElement] = custom cell
      |   *  ._3 : Option[(Model,Model) => Boolean] = sorting function
      |   *  ._4 : Option[Double] = column width interms of flex property
      |   */
      |  val config  = List(("fname",Some(customFname),None,None))
      |  ReactTable( data = data ,columns = columns , config = config)
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("plain")
    .render(P => {
   <.div(
     <.h2(^.cls := "mui-font-style-headline")("Custom Cell Factory"),
      CodeExample(code)(
        ReactTable( data = data ,columns = columns , config = config)
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
  // let say if i want to turn all fnames to grey that starts with J (you can return any ReactElement(buttons,well another ReactTable if you want!)
  def customFname = (fname : Any) => { val name = fname.toString ; if(name.startsWith("J")) <.span(^.backgroundColor := "grey")(name).render else <.span(name).render }

  val config  = List(("fname",Some(customFname),None,None))

  def apply() = component()

}

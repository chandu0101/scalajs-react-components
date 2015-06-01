package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.datepicker.MuiDatePicker
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object MuiDatePickerDemo {
  object Style {

    val example  = Seq(
      MsFlexDirection := "column" ,
      WebkitBoxDirection := "normal" ,
      WebkitBoxOrient := "vertical" ,
      WebkitFlexDirection := "column" ,
      ^.display := "-ms-flexbox" ,
      ^.display := "-webkit-box" ,
      ^.display := "-webkit-flex" ,
      ^.display := "flex" ,
      ^.flexDirection := "column"
    )
  }

  val code =
    """
      | MuiDatePicker( name = "PortraitDialogDate" , placeholder = "Protrait Dialog"  )
      |
      | MuiDatePicker( name = "LandscapeDialogDate" , placeholder = "Landscape Dialog" , mode = MuiDatePicker.LANDSCAPE )
      |
    """.stripMargin


  val component = ReactComponentB[Unit]("MuiDatePickerDemo")
    .render(P => {
    <.div(
      <.h3("Date Picker"),
      CodeExample(code)(
        <.div(Style.example)(
          <.div(^.margin := "10px")(MuiDatePicker( key = "dp", name = "PortraitDialogDate" , placeholder = "Protrait Dialog"  )),
          <.div(^.margin := "10px")(MuiDatePicker( key = "dp2", name = "LandscapeDialogDate" , placeholder = "Landscape Dialog" , mode = MuiDatePicker.LANDSCAPE ))
        )

      )
    )
  }).buildU

  def apply() = component()
}

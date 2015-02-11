package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.MuiPaper
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode .
 */
object MuiPaperDemo {

  val code =
    """
      |//Rounded Corners :
      | MuiPaper( zDepth = 1)(),
      | MuiPaper( zDepth = 2)(),
      | MuiPaper( zDepth = 3)(),
      | MuiPaper( zDepth = 4)(),
      | MuiPaper( zDepth = 5)()
      |
      |// Sharp Corners
      |  MuiPaper( zDepth = 1 ,rounded = false)(),
      |  MuiPaper( zDepth = 2,rounded = false)(),
      |  MuiPaper( zDepth = 3,rounded = false)(),
      |  MuiPaper( zDepth = 4,rounded = false)(),
      |  MuiPaper( zDepth = 5,rounded = false)()
      |
      |// Circular
      | MuiPaper( zDepth = 1,circle = true)(),
      | MuiPaper( zDepth = 2,circle = true)(),
      | MuiPaper( zDepth = 3,circle = true)(),
      | MuiPaper( zDepth = 4,circle = true)(),
      | MuiPaper( zDepth = 5,circle = true)()
    """.stripMargin


  object Style {

    val paperStyle = Seq(width := "100px",height := "100px" ,marginBottom := "64px")

    val paperExamples = Seq( display := "flex",flexWrap := "wrap" ,justifyContent := "space-around")

    val paperGroup = Seq(display := "flex" , flexDirection := "column", margin := "0 50px")
  }


  val component = ReactComponentB[Unit]("MuiPaperDemo")
    .render(P => {
    div(
      h3("Paper"),
      CodeExample(code)(
       div(Style.paperExamples)(
         div(Style.paperGroup)(
             (1 to 5).toList.map(i => MuiPaper(zDepth = i, style = Style.paperStyle)())
         ),
         div(Style.paperGroup)(
           (1 to 5).toList.map(i => MuiPaper(zDepth = i, style = Style.paperStyle ,rounded = false)())
         ),
         div(Style.paperGroup)(
           (1 to 5).toList.map(i => MuiPaper(zDepth = i, style = Style.paperStyle ,circle = true)())
         )
       )
      )
    )
  }).buildU

  def apply() = component()

}

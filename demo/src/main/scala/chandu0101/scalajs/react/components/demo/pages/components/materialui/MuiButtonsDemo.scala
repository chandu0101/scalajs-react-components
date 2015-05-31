package chandu0101.scalajs.react.components.demo.pages.components.materialui

import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.materialui.svgicons.MuiActionGrade
import chandu0101.scalajs.react.components.materialui.{MuiFlatButton, MuiFloatingActionButton, MuiRaisedButton}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object MuiButtonsDemo {

  object Style {

    val buttonExamples = Seq(  MsFlexWrap := "wrap" ,
      WebkitFlexWrap := "wrap" ,
      ^.display := "-ms-flexbox" ,
      ^.display := "-webkit-box" ,
      ^.display := "-webkit-flex" ,
      ^.display := "flex" ,

      flexDirection := "space-between",
      flexWrap := "wrap" )

    val buttonGroup = Seq( MsFlexDirection := "column" ,
      MsFlexPack := "justify" ,
      WebkitBoxDirection := "normal" ,
      WebkitBoxOrient := "vertical" ,
      WebkitBoxPack := "justify" ,
      ^.marginBottom := "30px",
      WebkitFlexDirection := "column" ,
      ^.display := "-ms-flexbox" ,
      ^.display := "-webkit-box" ,
      ^.display := "-webkit-flex" ,
      ^.display := "flex" ,
      MsFlex := "1" ,
      WebkitBoxFlex := "1" ,
      WebkitFlex := "1" ,
      ^.flex := "1",
        ^.flexDirection := "column" ,
      ^.maxHeight := "400px" )

    val buttonContainer = Seq(^.margin := "10px" ,^.textAlign := "center")

  }

  val code =
    """
      |//Flat Buttons:
      |MuiFlatButton(label = "Default")
      |MuiFlatButton(label = "Primary" , primary = true)
      |MuiFlatButton(label = "Secondary" , secondary = true)
      |MuiFlatButton(label = "Disabled" , disabled = true)
      |
      |//Raised Buttons Buttons:
      |MuiRaisedButton(label = "Default")
      |MuiRaisedButton(label = "Primary" , primary = true)
      |MuiRaisedButton(label = "Secondary" , secondary = true)
      |MuiRaisedButton(label = "Disabled" , disabled = true)
      |
      |//Floating Action Buttons :
      |MuiFloatingActionButton(iconClassName="muidocs-icon-action-grade")
      |MuiFloatingActionButton(iconClassName="muidocs-icon-action-grade", mini = true)
      |MuiFloatingActionButton(iconClassName="muidocs-icon-action-grade", disabled = true)
      |MuiFloatingActionButton(iconClassName="muidocs-icon-action-grade", mini = true, disabled = true)
      |MuiFloatingActionButton(iconClassName="muidocs-icon-action-grade", secondary = true)
      |MuiFloatingActionButton(iconClassName="muidocs-icon-action-grade", secondary = true, mini = true)
      |
    """.stripMargin

  lazy val raisedButtons : List[ReactNode] = List( MuiRaisedButton( label = "Default"),
    MuiRaisedButton( label = "Primary" , primary = true),
    MuiRaisedButton( label = "Secondary" , secondary = true),
    MuiRaisedButton( label = "Disabled" ,disabled = true))

  lazy val floatingActionButtons1 : List[ReactNode] = List(
    MuiFloatingActionButton.withChildren()(MuiActionGrade()),
      MuiFloatingActionButton.withChildren(mini = true)(MuiActionGrade()),
        MuiFloatingActionButton.withChildren(disabled = true)(MuiActionGrade()),
      MuiFloatingActionButton.withChildren(disabled = true,mini = true)(MuiActionGrade())
      )
  lazy val floatingActionButtons2 : List[ReactNode] = List(
    MuiFloatingActionButton.withChildren(secondary = true)(MuiActionGrade() ),
    MuiFloatingActionButton.withChildren(mini = true,secondary = true)(MuiActionGrade()))

  lazy val flatButtons : List[ReactNode] = List( MuiFlatButton( label = "Default"),
    MuiFlatButton( label = "Primary" , primary = true),
    MuiFlatButton( label = "Secondary" , secondary = true),
    MuiFlatButton( label = "Disabled" ,disabled = true))

  val component = ReactComponentB[Unit]("MuiButtonsDemo")

    .render( P => {
       <.div(
        <.h3("Buttons"),
        CodeExample(code)(
           <.div(Style.buttonExamples)(
            <.div(Style.buttonGroup)(
              flatButtons.map(item => <.div(Style.buttonContainer)(item))
            ),
             <.div(Style.buttonGroup)(
               raisedButtons.map(item => <.div(Style.buttonContainer)(item))
            ),
             <.div(Style.buttonGroup)(
              floatingActionButtons1.map(item => <.div(Style.buttonContainer)(item))
            ),
             <.div(Style.buttonGroup)(
               floatingActionButtons2.map(item => <.div(Style.buttonContainer)(item))
             )
           )
        )
       )
    }).buildU


  def apply() = component()

}

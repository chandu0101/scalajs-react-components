package demo
package components
package reactpopover

import chandu0101.scalajs.react.components.popovers.ReactPopOver
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

/**
 * Created by chandrasekharkode .
 */
object ReactPopoverDemo {

  val code =
    """
      | ReactPopover(placement = "top", ref = theTopRef)( "I am Top Pop Over" ),
      | LocalDemoButton(name = "Top Button" ,onButtonClick = B.onTopButtonClick)
      |          
      | ReactPopover(placement = "left", ref = theLeftRef, title = "Left Title")("I am Left Popover"),
      | LocalDemoButton(name = "Left Button" ,onButtonClick = B.onLeftButtonClick)  
      |          
      | ReactPopover(ref = theRightRef, title = "Right Title")("I am right Popover" ),
      | LocalDemoButton(name = "Right Button" ,onButtonClick = B.onRightButtonClick)
      |          
      | ReactPopover(placement = "bottom", ref = theBottomtRef)("I am bottom Popover" ),
      | LocalDemoButton(name = "Bottom Button" ,onButtonClick = B.onBottomButtonClick)
      | 
    """.stripMargin


  object Style {

    val popoverExample = Seq(^.display := "flex", ^.flexDirection := "column" , ^.alignItems := "center")
  }

  class Backend(t: BackendScope[_, _]) {

    def onRightButtonClick(e: ReactEventH) = {
      theRightRef(t).get.backend.toggle(e.target)
    }

    def onLeftButtonClick(e: ReactEventH) = {
      theLeftRef(t).get.backend.toggle(e.target)
    }

    def onTopButtonClick(e: ReactEventH) = {
      theTopRef(t).get.backend.toggle(e.target)
    }

    def onBottomButtonClick(e: ReactEventH) = {
      theBottomtRef(t).get.backend.toggle(e.target)
    }
  }

  val theRightRef = Ref.to(ReactPopOver.component, "theRightRef")
  val theLeftRef = Ref.to(ReactPopOver.component, "theLeftRef")
  val theTopRef = Ref.to(ReactPopOver.component, "theTopRef")
  val theBottomtRef = Ref.to(ReactPopOver.component, "theBottomRef")


  val component = ReactComponentB[Unit]("ReactPopoverDemo")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(
      <.h3("Demo"),
      CodeExample(code)(
       <.div(Style.popoverExample)(
        <.div(^.padding := "20px")(
          ReactPopOver(placement = "top", ref = theTopRef)(
            "I am Top Pop Over"
          ),
          LocalDemoButton(name = "Top Button" ,onButtonClick = B.onTopButtonClick)
        ),
        <.div(^.padding := "20px")(
          ReactPopOver(placement = "left", ref = theLeftRef, title = "Left Title")(
            "I am Left Popover"
          ),
          LocalDemoButton(name = "Left Button" ,onButtonClick = B.onLeftButtonClick)
        ),
        <.div(^.padding := "20px")(
          ReactPopOver(ref = theRightRef, title = "Right Title")(
            "I am right Popover"
          ),
          LocalDemoButton(name = "Right Button" ,onButtonClick = B.onRightButtonClick)
        ),

        <.div(^.padding := "20px")(
          ReactPopOver(placement = "bottom", ref = theBottomtRef)(
            "I am bottom Popover"
          ),
          LocalDemoButton(name = "Bottom Button" ,onButtonClick = B.onBottomButtonClick)
        )
       )
      )
    )
  }).buildU

  def apply() = component()

}

package demo
package components
package reactpopover

import chandu0101.scalajs.react.components._
import chandu0101.scalajs.react.components.popovers.ReactPopOver
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactPopoverDemo {

  val code =
    """
      | ReactPopover(placement = "top", ref = theTopRef)( "I am Top Pop Over" ),
      | LocalDemoButton(name = "Top Button" ,onButtonClick = onTopButtonClick)
      |          
      | ReactPopover(placement = "left", ref = theLeftRef, title = "Left Title")("I am Left Popover"),
      | LocalDemoButton(name = "Left Button" ,onButtonClick = onLeftButtonClick)  
      |          
      | ReactPopover(ref = theRightRef, title = "Right Title")("I am right Popover" ),
      | LocalDemoButton(name = "Right Button" ,onButtonClick = onRightButtonClick)
      |          
      | ReactPopover(placement = "bottom", ref = theBottomtRef)("I am bottom Popover" ),
      | LocalDemoButton(name = "Bottom Button" ,onButtonClick = onBottomButtonClick)
      | 
    """.stripMargin

  val theRightRef = Ref.to(ReactPopOver.component, "theRightRef")
  val theLeftRef = Ref.to(ReactPopOver.component, "theLeftRef")
  val theTopRef = Ref.to(ReactPopOver.component, "theTopRef")
  val theBottomtRef = Ref.to(ReactPopOver.component, "theBottomRef")

  object Style {
    val popoverExample = Seq(^.display := "flex", ^.flexDirection := "column", ^.alignItems := "center")
  }

  class Backend(t: BackendScope[_, _]) {
    val withRight  = withRef(theRightRef, t) _
    val withLeft   = withRef(theLeftRef, t) _
    val withTop    = withRef(theTopRef, t) _
    val withBottom = withRef(theBottomtRef, t) _

    def onRightButtonClick(e: ReactEventH) =
      withRight(_.backend.toggle(e.target))

    def onLeftButtonClick(e: ReactEventH) =
      withLeft(_.backend.toggle(e.target))

    def onTopButtonClick(e: ReactEventH) =
      withTop(_.backend.toggle(e.target))

    def onBottomButtonClick(e: ReactEventH) =
      withBottom(_.backend.toggle(e.target))

    def render = {
    <.div(
      <.h3("Demo"),
      CodeExample(code)(
       <.div(Style.popoverExample)(
        <.div(^.padding := "20px")(
          ReactPopOver(placement = "top", ref = theTopRef)(
            "I am Top Pop Over"
          ),
          LocalDemoButton(name = "Top Button" ,onButtonClick = onTopButtonClick _)
        ),
        <.div(^.padding := "20px")(
          ReactPopOver(placement = "left", ref = theLeftRef, title = "Left Title")(
            "I am Left Popover"
          ),
          LocalDemoButton(name = "Left Button" ,onButtonClick = onLeftButtonClick _)
        ),
        <.div(^.padding := "20px")(
          ReactPopOver(ref = theRightRef, title = "Right Title")(
            "I am right Popover"
          ),
          LocalDemoButton(name = "Right Button" ,onButtonClick = onRightButtonClick _)
        ),

        <.div(^.padding := "20px")(
          ReactPopOver(placement = "bottom", ref = theBottomtRef)(
            "I am bottom Popover"
          ),
          LocalDemoButton(name = "Bottom Button" ,onButtonClick = onBottomButtonClick _)
        )
       )
      )
    )
    }
  }

  val component = ReactComponentB[Unit]("ReactPopoverDemo")
    .renderBackend[Backend]
    .buildU

  def apply() = component()

}

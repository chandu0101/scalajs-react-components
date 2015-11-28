package demo
package components
package reactpopover

import chandu0101.scalajs.react.components.popovers.ReactPopOver
import chandu0101.scalajs.react.components.popovers.ReactPopOver.{Props, State}
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

  object Style {
    val popoverExample = Seq(^.display := "flex", ^.flexDirection := "column", ^.alignItems := "center")
  }

  class Backend(t: BackendScope[_, _]) {
    val topRef    = Ref.to(ReactPopOver.component, "top")
    val rightRef  = Ref.to(ReactPopOver.component, "right")
    val leftRef   = Ref.to(ReactPopOver.component, "left")
    val bottomRef = Ref.to(ReactPopOver.component, "bottom")

    def toggleCB(ref: RefComp[Props, State, ReactPopOver.Backend, TopNode]): ReactEventH => Callback =
      e => CallbackOption.liftOptionLike(ref(t)).flatMap(_.backend.toggle(e.target))

    def render = {
      <.div(
        <.h3("Demo"),
        CodeExample(code)(
          <.div(Style.popoverExample)(
            <.div(^.padding := "20px")(
              ReactPopOver(ref = topRef, placement = "top", title = "Top Title")("I am Top Pop Over"),
              LocalDemoButton(name = "Top Button", onButtonClick = toggleCB(topRef))
            ),
            <.div(^.padding := "20px")(
              ReactPopOver(ref = leftRef, placement = "left", title = "Left Title")("I am Left Popover"),
              LocalDemoButton(name = "Left Button", onButtonClick = toggleCB(leftRef))
            ),
            <.div(^.padding := "20px")(
              ReactPopOver(ref = rightRef, placement = "right", title = "Right Title")("I am right Popover"),
              LocalDemoButton(name = "Right Button", onButtonClick = toggleCB(rightRef))
            ),
            <.div(^.padding := "20px")(
              ReactPopOver(ref = bottomRef, placement = "bottom", title = "Bottom Title")("I am bottom Popover"),
              LocalDemoButton(name = "Bottom Button", onButtonClick = toggleCB(bottomRef))
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

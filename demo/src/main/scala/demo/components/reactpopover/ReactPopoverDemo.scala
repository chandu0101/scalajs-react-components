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

  object Style {
    val popoverExample = Seq(^.display := "flex", ^.flexDirection := "column", ^.alignItems := "center")
  }

  class Backend(t: BackendScope[_, _]) {
    val rightRef  = RefHolder[ReactPopOver.Type]
    val leftRef   = RefHolder[ReactPopOver.Type]
    val topRef    = RefHolder[ReactPopOver.Type]
    val bottomRef = RefHolder[ReactPopOver.Type]

    val onRightButtonClick: ReactEventH => Callback =
      e => rightRef().flatMap(_.backend.toggle(e.target))

    val onLeftButtonClick: ReactEventH => Callback =
      e => leftRef().flatMap(_.backend.toggle(e.target))

    val onTopButtonClick: ReactEventH => Callback =
      e => topRef().flatMap(_.backend.toggle(e.target))

    val onBottomButtonClick: ReactEventH => Callback =
      e => bottomRef().flatMap(_.backend.toggle(e.target))

    def render = {
      <.div(
        <.h3("Demo"),
        CodeExample(code)(
          <.div(Style.popoverExample)(
            <.div(^.padding := "20px")(
              ReactPopOver(placement = "top", ref = topRef.set)(
                "I am Top Pop Over"
              ),
              LocalDemoButton(name = "Top Button", onButtonClick = onTopButtonClick)
            ),
            <.div(^.padding := "20px")(
              ReactPopOver(placement = "left", ref = leftRef.set, title = "Left Title")(
                "I am Left Popover"
              ),
              LocalDemoButton(name = "Left Button", onButtonClick = onLeftButtonClick)
            ),
            <.div(^.padding := "20px")(
              ReactPopOver(placement = "right", ref = rightRef.set, title = "Right Title")(
                "I am right Popover"
              ),
              LocalDemoButton(name = "Right Button", onButtonClick = onRightButtonClick)
            ),

            <.div(^.padding := "20px")(
              ReactPopOver(placement = "bottom", ref = bottomRef.set)(
                "I am bottom Popover"
              ),
              LocalDemoButton(name = "Bottom Button", onButtonClick = onBottomButtonClick)
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

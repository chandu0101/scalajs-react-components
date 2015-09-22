package chandu0101.scalajs.react.components
package textfields

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.html
import org.scalajs.dom.html.{Input, Element}
import scala.scalajs.js

object AutoSizeInput {

  val theSizerRef = Ref[html.Element]("theSizerRef")
  val theInputRef = Ref[html.Input]("theInputRef")

  val component = ReactComponentB[Props]("AutoSizeInput")
    .initialState_P(p => State(p.minWidth))
    .renderBackend[Backend]
    .componentDidMount($ =>
      $.backend.copyInputStyles >> $.backend.updateInputWidth($.props, $.state)
    )
    .componentDidUpdate(($, _, _) =>
      $.backend.updateInputWidth($.props, $.state)
    ).build

  def apply(minWidth: Int = 1, ref: U[String] = "", key: js.Any = {}, defaultValue: String = "", value: String = "", onFocus: EmptyFunc = null, onChange: REventIUnit = null, style: Style = new Style {})(inputProps: TagMod*) =
    component.set(key, ref)(Props(minWidth, ref, key, defaultValue, value, onFocus, onChange, style, inputProps))

  trait Style {

    def autoSizeInputWrapper: TagMod = Seq[TagMod](^.display := "inline-block")

    def autoSizeInput: TagMod = Seq[TagMod]()

    def sizerStyle = Seq(^.position := "absolute", ^.visibility := "hidden", ^.height := 0, ^.width := 0, ^.overflow := "scroll", ^.whiteSpace := "wrap")

  }

  case class State(inputWidth: Int)

  class Backend(t: BackendScope[Props, State]) {
    
    val inputRefC   = callbackRef(theInputRef, t)
    val sizerInputC = callbackRef(theSizerRef, t)

    def focus: Callback =
      inputRefC.map(_.getDOMNode().focus())

    def select: Callback =
      inputRefC.map(_.getDOMNode().select())

    def copyInputStyles: Callback =
      for {
        input <- inputRefC
        sizer <- sizerInputC
        if t.isMounted()
        if !js.isUndefined(js.Dynamic.global.getComputedStyle)
        inputStyle = dom.window.getComputedStyle(input.getDOMNode())
      } yield {
        sizer.getDOMNode().style.fontSize   = inputStyle.fontSize
        sizer.getDOMNode().style.fontFamily = inputStyle.fontFamily
      }

    def updateInputWidth(P: Props, S: State): Callback =
      for {
        sizer <- sizerInputC
        if t.isMounted()
        newInputWidth = math.min(P.minWidth, sizer.getDOMNode().scrollWidth + 20)
        if newInputWidth != S.inputWidth
        _ <- t.modState(_.copy(inputWidth = newInputWidth))
      } yield ()

    def render(P: Props, S: State) = {
      val nbpsValue = P.value.replaceAll(" ", "&nbsp;")
      val inputStyle: TagMod = P.style.autoSizeInput.+(^.width := S.inputWidth)
     <.div(P.style.autoSizeInputWrapper)(
        <.input(P.inputProps, ^.ref := theInputRef, inputStyle),
       <.div(^.ref := theSizerRef, P.style.sizerStyle)(^.dangerouslySetInnerHtml(nbpsValue))
      )
    }
  }

  case class Props(minWidth: Int, ref: U[String], key: js.Any, defaultValue: String, value: String, onFocus: EmptyFunc, onChange: REventIUnit, style: Style, inputProps: TagMod*)
}

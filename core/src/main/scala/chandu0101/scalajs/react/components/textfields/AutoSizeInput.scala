package chandu0101.scalajs.react.components
package textfields

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import org.scalajs.dom.html
import scala.scalajs.js

object AutoSizeInput {

  val theSizerRef = Ref[html.Element]("theSizerRef")
  val theInputRef = Ref[html.Input]("theInputrRef")

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
    
    val withInput = withRef(theInputRef, t) _
    val withSizer = withRef(theSizerRef, t) _

    def focus: Callback = withInput(s => Callback(s.getDOMNode().focus()))

    def select: Callback =
      withInput(s => Callback(s.getDOMNode().select()))

    def copyInputStyles: Callback =
      withInput(input => Callback {
        val inputStyle = dom.window.getComputedStyle(theInputRef(t).get.getDOMNode())
        val widthNode = theSizerRef(t).get.getDOMNode()
        widthNode.style.fontSize = inputStyle.fontSize
        widthNode.style.fontFamily = inputStyle.fontFamily
      }).conditionally(t.isMounted() && !js.isUndefined(js.Dynamic.global.getComputedStyle)).void

    def updateInputWidth(P: Props, S: State): Callback =
      withSizer{sizer =>
        var newInputWidth = sizer.getDOMNode().scrollWidth + 20
        if (newInputWidth < P.minWidth) newInputWidth = P.minWidth

        t.modState(_.copy(inputWidth = newInputWidth))
          .conditionally(newInputWidth != S.inputWidth)
          .void
      }.conditionally(t.isMounted()).void

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

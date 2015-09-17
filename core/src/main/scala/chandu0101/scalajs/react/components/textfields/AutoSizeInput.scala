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
    .initialStateP(p => State(p.minWidth))
    .backend(new Backend(_))
    .render((P, S, B) => {
    val nbpsValue = P.value.replaceAll(" ", "&nbsp;")
    val inputStyle: TagMod = P.style.autoSizeInput.+(^.width := S.inputWidth)
   <.div(P.style.autoSizeInputWrapper)(
      <.input(P.inputProps, ^.ref := theInputRef, inputStyle),
     <.div(^.ref := theSizerRef, P.style.sizerStyle)(^.dangerouslySetInnerHtml(nbpsValue))
    )

  })
    .componentDidMount(scope => {
    scope.backend.copyInputStyles
    scope.backend.updateInputWidth
  })
    .componentDidUpdate((scope, _, _) => {
    scope.backend.updateInputWidth
  })
    .build

  def apply(minWidth: Int = 1, ref: U[String] = "", key: js.Any = {}, defaultValue: String = "", value: String = "", onFocus: EmptyFunc = null, onChange: REventIUnit = null, style: Style = new Style {})(inputProps: TagMod*) =
    component.set(key, ref)(Props(minWidth, ref, key, defaultValue, value, onFocus, onChange, style, inputProps))

  trait Style {

    def autoSizeInputWrapper: TagMod = Seq[TagMod](^.display := "inline-block")

    def autoSizeInput: TagMod = Seq[TagMod]()

    def sizerStyle = Seq(^.position := "absolute", ^.visibility := "hidden", ^.height := 0, ^.width := 0, ^.overflow := "scroll", ^.whiteSpace := "wrap")

  }

  case class State(inputWidth: Int)

  class Backend(t: BackendScope[Props, State]) {

    def getInput = theInputRef(t).get

    def focus() = {
      theInputRef(t).tryFocus()
    }

    def select() = theInputRef(t).get.getDOMNode().select()

    def copyInputStyles() = {
      if (t.isMounted() && !js.isUndefined(js.Dynamic.global.getComputedStyle)) {
        val inputStyle = dom.window.getComputedStyle(theInputRef(t).get.getDOMNode())
        val widthNode = theSizerRef(t).get.getDOMNode()
        widthNode.style.fontSize = inputStyle.fontSize
        widthNode.style.fontFamily = inputStyle.fontFamily
      }
    }

    def updateInputWidth() = {
      if (t.isMounted()) {
        var newInputWidth = theSizerRef(t).get.getDOMNode().scrollWidth + 20
        if (newInputWidth < t.props.minWidth) newInputWidth = t.props.minWidth
        if (newInputWidth != t.state.inputWidth) t.modState(_.copy(inputWidth = newInputWidth))
      }
    }

  }

  case class Props(minWidth: Int, ref: U[String], key: js.Any, defaultValue: String, value: String, onFocus: EmptyFunc, onChange: REventIUnit, style: Style, inputProps: TagMod*)
}

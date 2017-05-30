package chandu0101.scalajs.react.components

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw._

import scala.scalajs.js

case class ReactTagsInput(
    key: js.UndefOr[String] = js.undefined,
    ref: js.UndefOr[ReactTagsInputM => Unit] = js.undefined,
    /* An array of tags. */
    value: js.Array[String],
    /* Callback when tags change. */
    onChange: js.Array[String] => Callback,
    /* An array of key codes that add a tag, default is [9, 13] (Tab and Enter). */
    addKeys: js.UndefOr[js.Array[Int]] = js.undefined,
    /* An array of key codes that remove a tag, default is [8] (Backspace). */
    removeKeys: js.UndefOr[js.Array[Int]] = js.undefined,
    /* Props passed down to every tag component. Defualt is: {className: 'react-tagsinput-tag', classNameRemove: 'react-tagsinput-remove'}. */
    tagProps: js.UndefOr[js.Any] = js.undefined,
    /* Props passed down to input. Default is: {className: 'react-tagsinput-input'} */
    inputProps: js.UndefOr[js.Any] = js.undefined,
    /* Render function for every tag. Default is:
    function defaultRenderTag (props) {
      let {tag, key, onRemove, ...other} = props
      return (
        <span key={key} {...other}>
          {tag}
          <a onClick={(e) => onRemove(key)} />
        </span>
      )
    }*/
    renderTag: js.UndefOr[js.Any] = js.undefined,
    /* Render function for input. Default is:
    function defaultRenderInput (props) {
      let {onChange, value, ...other} = props
      return (
        <input type='text' onChange={onChange} value={value} {...other} />
      )
    }
     */
    renderInput: js.UndefOr[js.Any] = js.undefined,
    /* Renders the layout of the component. Takes tagComponents and inputComponent as args. Default is:
    function defaultRenderLayout (tagComponents, inputComponent) {
      return (
        <span>
          {tagComponents}
          {inputComponent}
        </span>
      )
    } */
    renderLayout: js.UndefOr[js.Any] = js.undefined,
    onBlur: js.UndefOr[Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactEventFromInput => Callback] = js.undefined,
    onKeyUp: js.UndefOr[ReactEventFromInput => Callback] = js.undefined
) {

  def apply() = {
    val props = JSMacro[ReactTagsInput](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.ReactTagsInput)
    f(props).asInstanceOf[ScalaComponent.Unmounted[_, _, _]]
  }

}

@js.native
trait ReactTagsInputM extends js.Object {
  def focus(): Unit = js.native
  def blur(): Unit  = js.native
}

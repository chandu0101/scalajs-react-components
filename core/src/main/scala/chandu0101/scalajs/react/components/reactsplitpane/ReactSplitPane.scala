package chandu0101.scalajs.react.components.reactsplitpane

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object ReactSplitPane {

  val DefaultStyle = new ReactSplitPaneStyle()

}


case class ReactSplitPane(
  // Specify whether resizing is allowed
  allowResize: js.UndefOr[Boolean] = true,

  className: js.UndefOr[String] = js.undefined,

  primary: js.UndefOr[String] = js.undefined,

  minSize : js.UndefOr[Double] = js.undefined,

  maxSize : js.UndefOr[Double] = js.undefined,

  defaultSize : js.UndefOr[Double] = js.undefined,

  size : js.UndefOr[Double] = js.undefined,

  split : js.UndefOr[String] = js.undefined,

  onDragStarted : js.UndefOr[Callback] = js.undefined,

  onDragFinished : js.UndefOr[Callback] = js.undefined,

  onChange : js.UndefOr[Double => Callback] = js.undefined,

  onResizerClick : js.UndefOr[Callback] = js.undefined,

  onResizerDoubleClick : js.UndefOr[Callback] = js.undefined,

  style : js.UndefOr[js.Object] = js.undefined,

  resizerStyle : js.UndefOr[js.Object] = js.undefined,

  paneStyle : js.UndefOr[js.Object] = js.undefined,

  pane1Style : js.UndefOr[js.Object] = js.undefined,

  pane2Style : js.UndefOr[js.Object] = js.undefined,

  resizerClassName : js.UndefOr[String] = ReactSplitPane.DefaultStyle.Resizer.htmlClass,

  step : js.UndefOr[Double] = js.undefined

) {
  def apply(first: VdomElement, second: VdomElement): JsComponent.Unmounted[_, _] = {

    val props = JSMacro[ReactSplitPane](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](js.Dynamic.global.ReactSplitPane)

    component(props)(
      <.div(
        ^.cls := "splitPaneContent",
        first
      ),
      <.div(
        ^.cls := "splitPaneContent",
        second
      )
    )
  }
}

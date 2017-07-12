package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiRefreshIndicator(key: js.UndefOr[String] = js.undefined,
                               ref: js.UndefOr[MuiRefreshIndicatorM => Unit] = js.undefined,
                               /* Override the theme's color of the indicator while it's status is
     "ready" and it's percentage is less than 100. */
                               color: js.UndefOr[MuiColor] = js.undefined,
                               /* The absolute left position of the indicator in pixels. */
                               left: Int,
                               /* Override the theme's color of the indicator while
     it's status is "loading" or when it's percentage is 100. */
                               loadingColor: js.UndefOr[MuiColor] = js.undefined,
                               /* The confirmation progress to fetch data. Max value is 100. */
                               percentage: js.UndefOr[Double] = js.undefined,
                               /* Size in pixels. */
                               size: js.UndefOr[Int] = js.undefined,
                               /* The display status of the indicator. If the status is
     "ready", the indicator will display the ready state
     arrow. If the status is "loading", it will display
     the loading progress indicator. If the status is "hide",
     the indicator will be hidden. */
                               status: js.UndefOr[ReadyLoadingHide] = js.undefined,
                               /* Override the inline-styles of the root element. */
                               style: js.UndefOr[CssProperties] = js.undefined,
                               /* The absolute top position of the indicator in pixels. */
                               top: Int) {

  def apply() = {

    val props     = JSMacro[MuiRefreshIndicator](this)
    val component = JsComponent[js.Object, Children.None, Null](Mui.RefreshIndicator)
    component(props)
  }
}
@js.native
class MuiRefreshIndicatorM extends js.Object {
  def getArcDeg(): js.Dynamic = js.native

  def getCircleAttr(): js.Dynamic = js.native

  def getCircleStyle(): js.Dynamic = js.native

  def getFactor(): js.Dynamic = js.native

  def getPaddingSize(): js.Dynamic = js.native

  def getPaperSize(): js.Dynamic = js.native

  def getPolygonStyle(): js.Dynamic = js.native

  def getTheme(): js.Dynamic = js.native

  def renderChildren(): js.Dynamic = js.native

  def rotateWrapper(wrapper: js.Any): js.Dynamic = js.native

  def scalePath(path: js.Any, step: js.Any): js.Dynamic = js.native
}

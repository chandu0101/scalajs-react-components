package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.{React, ReactElement}
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.`|`

/**
 * This file is generated - submit issues instead of PR against it
 */
    
case class MuiTabs[T](
  key:                       js.UndefOr[String]                                     = js.undefined,
  ref:                       js.UndefOr[MuiTabsM => Unit]                           = js.undefined,
  /* The css class name of the root element. */
  className:                 js.UndefOr[String]                                     = js.undefined,
  /* The css class name of the content's container. */
  contentContainerClassName: js.UndefOr[String]                                     = js.undefined,
  /* Override the inline-styles of the content's container. */
  contentContainerStyle:     js.UndefOr[CssProperties]                              = js.undefined,
  /* Specify initial visible tab index.
     If `initialSelectedIndex` is set but larger than the total amount of specified tabs,
     `initialSelectedIndex` will revert back to default.
     If `initialSelectedIndex` is set to any negative value, no tab will be selected intially. */
  initialSelectedIndex:      js.UndefOr[Int]                                        = js.undefined,
  /* Override the inline-styles of the InkBar. */
  inkBarStyle:               js.UndefOr[CssProperties]                              = js.undefined,
  /* Called when the selected value change. */
  onChange:                  js.UndefOr[(T, ReactEventFromHtml, ReactElement) => Callback] = js.undefined,
  /* Override the inline-styles of the root element. */
  style:                     js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the inline-styles of the tab-labels container. */
  tabItemContainerStyle:     js.UndefOr[CssProperties]                              = js.undefined,
  /* Override the default tab template used to wrap the content of each tab element. */
  tabTemplate:               js.UndefOr[js.Any]                                     = js.undefined,
  /* Override the inline-styles of the tab template. */
  tabTemplateStyle:          js.UndefOr[CssProperties]                              = js.undefined,
  /* Makes Tabs controllable and selects the tab whose value prop matches this prop. */
  value:                     js.UndefOr[T]                                          = js.undefined){

  /**
    * @param children Should be used to pass `Tab` components.
   */
  def apply(children: VdomNode*) = {
    implicit def evT(t: T): js.Any = t.asInstanceOf[js.Any]
    val props = JSMacro[MuiTabs[T]](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Mui.Tabs)
    component(props)(children: _*)
  }
}


@js.native
class MuiTabsM extends js.Object {
  def getSelected(tab: js.Any, index: js.Any): js.Dynamic = js.native

  def getSelectedIndex(props: js.Any): js.Dynamic = js.native

  def getTabCount(): js.Dynamic = js.native

  def getTabs(): js.Dynamic = js.native

  def getValueLink(props: js.Any): js.Dynamic = js.native
}

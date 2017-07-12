package chandu0101.scalajs.react.components
package elementalui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode

import scala.scalajs.js

//		children: _react2['default'].PropTypes.node.isRequired,
//		clearfix: _react2['default'].PropTypes.bool,
//		gutter: _react2['default'].PropTypes.number,
//		maxWidth: _react2['default'].PropTypes.number,
//		style: _react2['default'].PropTypes.object
case class Container(className: js.UndefOr[String] = js.undefined,
                     clearFix: js.UndefOr[Boolean] = js.undefined,
                     guter: js.UndefOr[Int] = js.undefined,
                     maxWidth: js.UndefOr[Int] = js.undefined) {

  def apply(children: VdomNode*) = {
    val props     = JSMacro[Container](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](Eui.Container)
    component(props)(children: _*)
  }
}

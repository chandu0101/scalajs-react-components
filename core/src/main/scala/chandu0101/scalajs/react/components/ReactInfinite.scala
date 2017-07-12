package chandu0101.scalajs.react.components

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js

case class ReactInfinite(handleScroll: js.UndefOr[HTMLElement => Callback] = js.undefined,
                         preloadAdditionalHeight: js.UndefOr[Int] = js.undefined,
                         isInfiniteLoading: js.UndefOr[Boolean] = js.undefined,
                         preloadBatchSize: js.UndefOr[Int] = js.undefined,
                         containerHeight: Int,
                         ref: js.UndefOr[ReactInfiniteM => Unit] = js.undefined,
                         loadingSpinnerDelegate: js.UndefOr[VdomElement] = js.undefined,
                         timeScrollStateLastsForAfterUserScrolls: js.UndefOr[Int] = js.undefined,
                         elementHeight: Double,
                         key: js.UndefOr[String] = js.undefined,
                         className: js.UndefOr[String] = js.undefined,
                         infiniteLoadBeginBottomOffset: js.UndefOr[Int] = js.undefined,
                         onInfiniteLoad: js.UndefOr[Callback] = js.undefined) {

  def apply(children: Seq[VdomElement]) = {
    val props     = JSMacro[ReactInfinite](this)
    val component = JsComponent[js.Object, Children.Varargs, Null](js.Dynamic.global.Infinite)
    component(props)(children: _*)
  }
}

@js.native
trait ReactInfiniteM extends js.Object {
  def getScrollTop(): Double = js.native
}

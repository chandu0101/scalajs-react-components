package chandu0101.scalajs.react.components

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce

case class ReactInfinite(handleScroll: js.UndefOr[HTMLElement => Callback] = js.undefined,
                         preloadAdditionalHeight: js.UndefOr[Int] = js.undefined,
                         isInfiniteLoading: js.UndefOr[Boolean] = js.undefined,
                         preloadBatchSize: js.UndefOr[Int] = js.undefined,
                         containerHeight: Int,
                         ref: js.UndefOr[ReactInfiniteM => Unit] = js.undefined,
                         loadingSpinnerDelegate: js.UndefOr[ReactElement] = js.undefined,
                         timeScrollStateLastsForAfterUserScrolls: js.UndefOr[Int] = js.undefined,
                         elementHeight: Double,
                         key: js.UndefOr[String] = js.undefined,
                         className: js.UndefOr[String] = js.undefined,
                         infiniteLoadBeginBottomOffset: js.UndefOr[Int] = js.undefined,
                         onInfiniteLoad: js.UndefOr[Callback] = js.undefined) {

  def apply(children: Seq[ReactElement]) = {
    val props = JSMacro[ReactInfinite](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.Infinite)
    f(props, children.toJSArray).asInstanceOf[ReactComponentU_]
  }
}

@js.native
trait ReactInfiniteM extends js.Object {
  def getScrollTop(): Double = js.native
}
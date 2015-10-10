package chandu0101.scalajs.react.components
package listviews

import japgolly.scalajs.react._
import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce

case class ReactInfinite(handleScroll: U[HTMLElement => Callback] = uNone,
                         preloadAdditionalHeight: U[Int] = uNone,
                         isInfiniteLoading: U[Boolean] = uNone,
                         preloadBatchSize: U[Int] = uNone,
                         containerHeight: Int,
                         ref: U[ReactInfiniteM => Unit] = uNone,
                         loadingSpinnerDelegate: U[ReactElement] = uNone,
                         timeScrollStateLastsForAfterUserScrolls: U[Int] = uNone,
                         elementHeight: Double,
                         key: U[String] = uNone,
                         className: U[String] = uNone,
                         infiniteLoadBeginBottomOffset: U[Int] = uNone,
                         onInfiniteLoad: U[Callback] = uNone) {

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
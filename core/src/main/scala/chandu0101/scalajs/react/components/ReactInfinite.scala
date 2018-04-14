package chandu0101.scalajs.react.components

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import japgolly.scalajs.react.raw._
import japgolly.scalajs.react.vdom.VdomElement
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("react-infinite", JSImport.Default) @js.native
object ReactInfiniteRequire extends js.Any

case class ReactInfinite(
    handleScroll: js.UndefOr[HTMLElement => Callback] = js.undefined,
    preloadAdditionalHeight: js.UndefOr[Int] = js.undefined,
    isInfiniteLoading: js.UndefOr[Boolean] = js.undefined,
    preloadBatchSize: js.UndefOr[Int] = js.undefined,
    containerHeight: Int,
    ref: js.UndefOr[ReactInfiniteM => Unit] = js.undefined,
    loadingSpinnerDelegate: js.UndefOr[React.Element] = js.undefined,
    timeScrollStateLastsForAfterUserScrolls: js.UndefOr[Int] = js.undefined,
    elementHeight: Double,
    key: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    infiniteLoadBeginBottomOffset: js.UndefOr[Int] = js.undefined,
    onInfiniteLoad: js.UndefOr[Callback] = js.undefined
) {

  def apply(children: Seq[VdomElement]) = {
    val props = JSMacro[ReactInfinite](this)
    val f     = JsComponent[js.Object, Children.Varargs, Null](ReactInfiniteRequire)
    f(props)(children: _*)
  }
}

@js.native
trait ReactInfiniteM extends js.Object {
  def getScrollTop(): Double = js.native
}

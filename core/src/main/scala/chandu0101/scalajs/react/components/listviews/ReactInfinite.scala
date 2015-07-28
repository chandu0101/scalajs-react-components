package chandu0101.scalajs.react.components.listviews

import japgolly.scalajs.react._
import org.scalajs.dom.raw.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce


/**

key: PropTypes.string,
    ref: PropTypes.String,
    handleScroll: React.PropTypes.HTMLElement => Unit,
    preloadBatchSize: React.PropTypes.number,
    preloadAdditionalHeight: React.PropTypes.number,
    elementHeight: React.PropTypes.Seq[Double].isRequired,
    containerHeight: React.PropTypes.number.isRequired,
    infiniteLoadBeginBottomOffset: React.PropTypes.number,
    onInfiniteLoad: React.PropTypes.() => Unit,
    loadingSpinnerDelegate: React.PropTypes.node,
    isInfiniteLoading: React.PropTypes.bool,
    timeScrollStateLastsForAfterUserScrolls: React.PropTypes.number,
    className: React.PropTypes.string

  */
case class ReactInfinite(handleScroll: js.UndefOr[HTMLElement => Unit] = js.undefined,
                         preloadAdditionalHeight: js.UndefOr[Int] = js.undefined,
                         isInfiniteLoading: js.UndefOr[Boolean] = js.undefined,
                         preloadBatchSize: js.UndefOr[Int] = js.undefined,
                         containerHeight: Int,
                         ref: js.UndefOr[String] = js.undefined,
                         loadingSpinnerDelegate: js.UndefOr[ReactElement] = js.undefined,
                         timeScrollStateLastsForAfterUserScrolls: js.UndefOr[Int] = js.undefined,
                         elementHeight: Double,
                         key: js.UndefOr[String] = js.undefined,
                         className: js.UndefOr[String] = js.undefined,
                         infiniteLoadBeginBottomOffset: js.UndefOr[Int] = js.undefined,
                         onInfiniteLoad: js.UndefOr[() => Unit] = js.undefined) {
  def toJS = {
    val p = js.Dynamic.literal()
    handleScroll.foreach(v => p.updateDynamic("handleScroll")(v))
    preloadAdditionalHeight.foreach(v => p.updateDynamic("preloadAdditionalHeight")(v))
    isInfiniteLoading.foreach(v => p.updateDynamic("isInfiniteLoading")(v))
    preloadBatchSize.foreach(v => p.updateDynamic("preloadBatchSize")(v))
    p.updateDynamic("containerHeight")(containerHeight)
    ref.foreach(v => p.updateDynamic("ref")(v))
    loadingSpinnerDelegate.foreach(v => p.updateDynamic("loadingSpinnerDelegate")(v))
    timeScrollStateLastsForAfterUserScrolls.foreach(v => p.updateDynamic("timeScrollStateLastsForAfterUserScrolls")(v))
    p.updateDynamic("elementHeight")(elementHeight)
    key.foreach(v => p.updateDynamic("key")(v))
    className.foreach(v => p.updateDynamic("className")(v))
    infiniteLoadBeginBottomOffset.foreach(v => p.updateDynamic("infiniteLoadBeginBottomOffset")(v))
    onInfiniteLoad.foreach(v => p.updateDynamic("onInfiniteLoad")(v))
    p
  }

  def apply(children: Seq[ReactElement]) = {
    val f = React.asInstanceOf[js.Dynamic].createFactory(js.Dynamic.global.Infinite)
    f(toJS, children.toJSArray).asInstanceOf[ReactComponentU_]
  }
}


trait ReactInfiniteM extends js.Object {
  def getScrollTop(): Double = js.native
}
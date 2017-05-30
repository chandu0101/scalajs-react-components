package chandu0101.scalajs.react.components

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.{Date, UndefOr}

@js.native
trait StrategyOverrides extends js.Object {
  var shouldRejectClick: js.UndefOr[
    js.Function2[ /* lastTouchEventTimestamp */ Date, /* clickEventTimestamp */ Date, Boolean]] =
    js.native
}

@JSImport("react-tap-event-plugin", "default")
@js.native
object ReactTapEventPlugin
    extends js.Function1[ /* strategyOverrides */ js.UndefOr[StrategyOverrides], Unit] {
  override def apply(strategyOverrides: UndefOr[StrategyOverrides]): Unit = js.native
}

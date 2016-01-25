package chandu0101.scalajs.react.components.reactselect

import japgolly.scalajs.react._

import scala.scalajs.js

@js.native
trait ValueProps[T] extends js.Any {
  /* disabled prop passed to ReactSelect */
  def disabled: js.UndefOr[Boolean]
  /* method to handle click on value label */
  def onClick: js.UndefOr[(ValueOption[T], ReactEvent) => Callback]
  /* method to handle removal of the value */
  def onRemove: js.UndefOr[ValueOption[T] => Callback]
  /* the option object for this value */
  def value: ValueOption[T]
}

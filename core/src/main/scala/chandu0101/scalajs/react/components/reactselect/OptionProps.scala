package chandu0101.scalajs.react.components.reactselect

import japgolly.scalajs.react._

import scala.scalajs.js

@js.native
trait OptionProps[T] extends js.Any {
  /* className (based on mouse position) */
  def className: js.UndefOr[String]
  /* the option is disabled */
  def isDisabled: js.UndefOr[Boolean]
  /* the option is focused */
  def isFocused: js.UndefOr[Boolean]
  /* the option is selected */
  def isSelected: js.UndefOr[Boolean]
  /* method to handle click on option element */
  def onSelect: js.UndefOr[(ValueOption[T], ReactEvent) => Callback]
  /* method to handle mouseEnter on option element */
  def onFocus: js.UndefOr[(ValueOption[T], ReactEvent) => Callback]
  /* method to handle mouseLeave on option element */
  def onUnfocus: js.UndefOr[(ValueOption[T], ReactEvent) => Callback]
  /* object that is base for that option */
  def option: ValueOption[T]
}

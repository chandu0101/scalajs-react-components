package chandu0101.scalajs.react.components.reactselect

import chandu0101.scalajs.react.components._

import scala.scalajs.js

@js.native
trait ValueOption[T] extends js.Any {
  var value: T
  var label: String
  var style: js.UndefOr[CssProperties]
  var title: js.UndefOr[String]
  var href: js.UndefOr[String]
  var className: js.UndefOr[String]
}

object ValueOption {
  def apply[T](
    value:     T,
    label:     String,
    style:     js.UndefOr[CssProperties] = js.undefined,
    title:     js.UndefOr[String]        = js.undefined,
    href:      js.UndefOr[String]        = js.undefined,
    className: js.UndefOr[String]        = js.undefined
  ): ValueOption[T] =

    js.Dynamic.literal(
      value     = value.asInstanceOf[js.Any],
      label     = label,
      style     = style,
      title     = title,
      href      = href,
      className = className
    ).asInstanceOf[ValueOption[T]]
}

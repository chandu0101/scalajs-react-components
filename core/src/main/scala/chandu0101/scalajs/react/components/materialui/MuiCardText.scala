package chandu0101.scalajs.react.components
package materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.`|`

/**
  * This file is generated - submit issues instead of PR against it
  */
case class MuiCardText(key: js.UndefOr[String] = js.undefined,
                       ref: js.UndefOr[String] = js.undefined,
                       /* If true, a click on this card component expands the card. */
                       actAsExpander: js.UndefOr[Boolean] = js.undefined,
                       /* Override the CardText color. */
                       color: js.UndefOr[MuiColor] = js.undefined,
                       /* If true, this card component is expandable. */
                       expandable: js.UndefOr[Boolean] = js.undefined,
                       /* Override the inline-styles of the root element. */
                       style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children Can be used to render elements inside the Card Text.
    */
  def apply(children: ReactNode*) = {

    val props = JSMacro[MuiCardText](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Mui.CardText)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

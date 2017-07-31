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
case class MuiTableFooter(key: js.UndefOr[String] = js.undefined,
                          ref: js.UndefOr[String] = js.undefined,
                          /* Controls whether or not header rows should be adjusted
     for a checkbox column. If the select all checkbox is true,
     this property will not influence the number of columns.
     This is mainly useful for "super header" rows so that
     the checkbox column does not create an offset that needs
     to be accounted for manually. */
                          adjustForCheckbox: js.UndefOr[Boolean] = js.undefined,
                          /* The css class name of the root element. */
                          className: js.UndefOr[String] = js.undefined,
                          /* Override the inline-styles of the root element. */
                          style: js.UndefOr[CssProperties] = js.undefined) {

  /**
    * @param children Children passed to table footer.
    */
  def apply(children: ReactNode*) = {

    val props = JSMacro[MuiTableFooter](this)
    val f     = React.asInstanceOf[js.Dynamic].createFactory(Mui.TableFooter)
    if (children.isEmpty)
      f(props).asInstanceOf[ReactComponentU_]
    else if (children.size == 1)
      f(props, children.head).asInstanceOf[ReactComponentU_]
    else
      f(props, children.toJsArray).asInstanceOf[ReactComponentU_]
  }
}

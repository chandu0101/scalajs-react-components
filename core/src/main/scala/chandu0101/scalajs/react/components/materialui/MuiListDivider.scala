
package chandu0101.scalajs.react.components.materialui

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._
import scala.scalajs.js
import scala.scalajs.js.`|`
  
case class MuiListDivider(
	key: js.UndefOr[String]   = js.undefined,
	ref: js.UndefOr[String]   = js.undefined)
{

  def apply() = {
    val props = JSMacro[MuiListDivider](this)
    val f = React.asInstanceOf[js.Dynamic].createFactory(Mui.ListDivider)
    f(props).asInstanceOf[ReactComponentU_]
  }
}
    

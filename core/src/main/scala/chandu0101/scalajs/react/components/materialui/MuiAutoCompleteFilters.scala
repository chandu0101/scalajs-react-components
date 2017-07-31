package chandu0101.scalajs.react.components.materialui

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native @JSImport("material-ui/AutoComplete", JSImport.Default)
object MuiAutoCompleteFilters extends js.Object {
  val noFilter: js.Function3[String, String, String, Boolean]                  = js.native
  val defaultFilter: js.Function3[String, String, String, Boolean]             = js.native
  val caseInsensitiveFilter: js.Function3[String, String, String, Boolean]     = js.native
  val levenshteinDistanceFilter: js.Function3[String, String, String, Boolean] = js.native
  val fuzzyFilter: js.Function3[String, String, String, Boolean]               = js.native
}

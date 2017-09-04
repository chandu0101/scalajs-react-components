package chandu0101.scalajs.react.components.hljs

import scala.scalajs.js
import scala.scalajs.js.{RegExp, `|`}

@js.native
trait IModeBase extends js.Object {
  var aliases: js.UndefOr[js.Array[String]] = js.native
  var begin: js.UndefOr[String | RegExp]    = js.native
  var beginKeyword: js.UndefOr[String]      = js.native
  var case_insensitive: js.UndefOr[Boolean] = js.native
  var className: js.UndefOr[String]         = js.native
  var end: js.UndefOr[String | RegExp]      = js.native
  var endsWithParent: js.UndefOr[Boolean]   = js.native
  var excludeBegin: js.UndefOr[Boolean]     = js.native
  var excludeEnd: js.UndefOr[Boolean]       = js.native
  var illegal: js.UndefOr[String]           = js.native
  var lexems: js.UndefOr[String]            = js.native
  var relevance: js.UndefOr[Double]         = js.native
  var returnBegin: js.UndefOr[Boolean]      = js.native
  var returnEnd: js.UndefOr[Boolean]        = js.native
  var starts: js.UndefOr[String]            = js.native
  var subLanguage: js.UndefOr[String]       = js.native
  var subLanguageMode: js.UndefOr[String]   = js.native
  var variants: js.UndefOr[js.Array[IMode]] = js.native
}

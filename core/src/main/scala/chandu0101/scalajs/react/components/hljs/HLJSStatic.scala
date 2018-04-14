package chandu0101.scalajs.react.components.hljs

import scala.scalajs.js

@js.native
trait HLJSStatic extends js.Object {
  var APOS_STRING_MODE: IMode = js.native
  // Common modes
  var BACKSLASH_ESCAPE: IMode     = js.native
  var BINARY_NUMBER_MODE: IMode   = js.native
  var BINARY_NUMBER_RE: String    = js.native
  var CSS_NUMBER_MODE: IMode      = js.native
  var C_BLOCK_COMMENT_MODE: IMode = js.native
  var C_LINE_COMMENT_MODE: IMode  = js.native
  var C_NUMBER_MODE: IMode        = js.native
  var C_NUMBER_RE: String         = js.native
  var HASH_COMMENT_MODE: IMode    = js.native
  // Common regexps
  var IDENT_RE: String                                      = js.native
  var NUMBER_MODE: IMode                                    = js.native
  var NUMBER_RE: String                                     = js.native
  var PHRASAL_WORDS_MODE: IMode                             = js.native
  var QUOTE_STRING_MODE: IMode                              = js.native
  var REGEX_MODE: IMode                                     = js.native
  var RE_STARTERS_RE: String                                = js.native
  var TITLE_MODE: IMode                                     = js.native
  var UNDERSCORE_IDENT_RE: String                           = js.native
  var UNDERSCORE_TITLE_MODE: IMode                          = js.native
  def inherit(parent: js.Object, obj: js.Object): js.Object = js.native
}

package chandu0101.scalajs.react.components.hljs

import org.scalajs.dom.Node

import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.{RegExp, UndefOr, `|`}

object Css {
  @js.native @JSImport("highlight.js/styles/github.css", JSImport.Namespace)
  object Github extends js.Any
}

object Languages {
  @js.native @JSImport("highlight.js/lib/languages/scala", JSImport.Namespace)
  object Scala extends js.Function1[ /* hljs */ js.UndefOr[HLJSStatic], IModeBase] {
    override def apply(arg1: UndefOr[HLJSStatic]): IModeBase = js.native
  }
}

@JSImport("highlight.js/lib/highlight.js", JSImport.Default)
@js.native
object Hljs extends js.Any {
  var APOS_STRING_MODE: IMode                                                           = js.native
  var BACKSLASH_ESCAPE: IMode                                                           = js.native
  var BINARY_NUMBER_MODE: IMode                                                         = js.native
  var BINARY_NUMBER_RE: String                                                          = js.native
  var CSS_NUMBER_MODE: IMode                                                            = js.native
  var C_BLOCK_COMMENT_MODE: IMode                                                       = js.native
  var C_LINE_COMMENT_MODE: IMode                                                        = js.native
  var C_NUMBER_MODE: IMode                                                              = js.native
  var C_NUMBER_RE: String                                                               = js.native
  var HASH_COMMENT_MODE: IMode                                                          = js.native
  var IDENT_RE: String                                                                  = js.native
  var NUMBER_MODE: IMode                                                                = js.native
  var NUMBER_RE: String                                                                 = js.native
  var PHRASAL_WORDS_MODE: IMode                                                         = js.native
  var QUOTE_STRING_MODE: IMode                                                          = js.native
  var REGEX_MODE: IMode                                                                 = js.native
  var RE_STARTERS_RE: String                                                            = js.native
  var TITLE_MODE: IMode                                                                 = js.native
  var UNDERSCORE_IDENT_RE: String                                                       = js.native
  var UNDERSCORE_TITLE_MODE: IMode                                                      = js.native
  def COMMENT(begin: String | RegExp, end: String | RegExp, inherits: IModeBase): IMode = js.native
  def configure(options: IOptions): Unit                                                = js.native
  def fixMarkup(value: String): String                                                  = js.native
  def getLanguage(name: String): IMode                                                  = js.native
  def highlight(name: String, value: String): IHighlightResult                          = js.native
  def highlight(name: String, value: String, ignore_illegals: Boolean): IHighlightResult =
    js.native
  def highlight(name: String,
                value: String,
                ignore_illegals: Boolean,
                continuation: Boolean): IHighlightResult = js.native
  def highlightAuto(value: String): IAutoHighlightResult = js.native
  def highlightAuto(value: String, languageSubset: js.Array[String]): IAutoHighlightResult =
    js.native
  def highlightBlock(block: Node): Unit                     = js.native
  def inherit(parent: js.Object, obj: js.Object): js.Object = js.native
  def initHighlighting(): Unit                              = js.native
  def initHighlightingOnLoad(): Unit                        = js.native
  def listLanguages(): js.Array[String]                     = js.native
  def registerLanguage(
      name: String,
      language: js.Function1[ /* hljs */ js.UndefOr[HLJSStatic], IModeBase]): Unit = js.native
}

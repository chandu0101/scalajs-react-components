package com.olvind
package requiresjs

import ammonite.ops.{Path, read}
import jdk.nashorn.internal.parser.Parser
import jdk.nashorn.internal.runtime.options.Options
import jdk.nashorn.internal.runtime.{Context, ErrorManager, Source}

object JsParser {

  val options = new Options("nashorn")
  options.set("anon.functions", true)
  options.set("parse.only", true)
  options.set("scripting", true)
  options.set("optimistic.types", true)

  def cleanupLine(str: String) =
    str.replaceAll("//.*$", "") //remove end line (//) comments here, they break stuff, particularly in the middle of a declaration.

  def apply(jsFile: Path): ParsedFile = {
    val content = read.lines(jsFile).map(cleanupLine).toList.mkString("\n")

    /* setup */
    val errors  = new ErrorManager()
    val context = new Context(options, errors, Thread.currentThread().getContextClassLoader)
    val source  = Source.sourceFor(jsFile.toString, content)
    val parser  = new Parser(context.getEnv, source, errors)
    val parsed  = parser.parse()

    ParsedFile(jsFile, content, parsed)
  }
}

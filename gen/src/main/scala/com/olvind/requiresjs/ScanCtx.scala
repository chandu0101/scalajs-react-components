package com.olvind.requiresjs

import ammonite.ops.Path
import com.olvind.CompName

import scala.collection.mutable

class ScanCtx {

  private val parsedFiles   = mutable.Map.empty[Path, ParsedFile]
  private val requiredFiles = mutable.Map.empty[Path, Lazy[Required]]
  private val comps         = mutable.Map.empty[CompName, FoundComponent]

  def parsedFile(p: Path): ParsedFile =
    parsedFiles.getOrElseUpdate(p, JsParser(p))

  def required(p: Path, require: ScanCtx ⇒ Lazy[Required]): Lazy[Required] =
    requiredFiles.getOrElseUpdate(p, new Lazy(this).flatMap(require))

}

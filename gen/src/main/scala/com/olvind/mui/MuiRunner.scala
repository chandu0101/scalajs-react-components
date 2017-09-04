package com.olvind
package mui

import ammonite.ops.Path

object MuiRunner extends App {
  args.toList match {
    case OutputFolder(buildFolder) :: OutputFolder(outputFolder) :: Nil =>
      val outs: Seq[Path] = Runner(MuiLibrary(buildFolder), outputFolder)
    case _ =>
      System.err.println("Syntax: MuiRunner <directory with transpiled javascript> <output folder>")
      System.exit(1)
  }
}

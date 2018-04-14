package com.olvind
package eui

import ammonite.ops.Path

object EuiRunner extends App {
  args.toList match {
    case OutputFolder(buildFolder) :: OutputFolder(outputFolder) :: Nil =>
      val outs: Seq[Path] = Runner(EuiLibrary(buildFolder), outputFolder)
    case _ =>
      System.err.println("Syntax: EuiRunner <directory with transpiled javascript> <output folder>")
      System.exit(1)
  }
}

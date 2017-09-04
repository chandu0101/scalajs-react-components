package com.olvind
package requiresjs

import ammonite.ops.{Path, exists}

case class ResolvedPath(file: Path, folder: Path)

object ResolvePath {
  def apply(p: Path, indexNames: Set[String]): ResolvedPath =
    if (exists(p)) {
      if (p.isDir) {
        val file = indexNames.find { name =>
          (p / name).toIO.exists
        }
        ResolvedPath(p / file.get, p)
      } else {
        panic("handle this when it happens")
      }

    } else {
      val withExtension: Path =
        p.copy(segments = p.segments.dropRight(1) :+ p.segments.last + ".js")

      if (exists(withExtension)) {
        ResolvedPath(withExtension, p.copy(segments = p.segments.dropRight(1)))
      } else {
        panic(s"Could not resolve path: $p")
      }
    }
}

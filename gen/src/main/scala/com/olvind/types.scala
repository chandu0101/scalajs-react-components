package com.olvind

import ammonite.ops.Path

trait Wrapper[A] {
  def value: A
  override def toString = value.toString
}
case class MemberMethod(name: String, paramNames: Seq[String])

final case class CompName(value: String) extends Wrapper[String] {
  def map(f: String => String) =
    CompName(f(value))
}

final case class PropName(value: String) extends AnyVal {
  def clean: PropName =
    PropName(value.replaceAll("Deprecated:", "").replaceAll("or children", "").trim)
}

final case class PropComment(value: Option[String], anns: Seq[Annotation] = Seq.empty)

object PropComment {

  def clean(s: String): PropComment = {
    val cleanLines =
      s.split("\n")
        .map(
          _.trim
            .replaceAll("(^/\\*\\*?|^//|\\*?\\*/$|^\\*)", "")
            .trim)
        .filterNot(_.isEmpty)

    val (_ans: List[Annotation], _lines: List[String]) =
      cleanLines.foldLeft[(List[Annotation], List[String])]((Nil, Nil)) {
        case ((as, lines), line) if line.toLowerCase.startsWith("@ignore") => (Ignore :: as, lines)
        case ((as, lines), line) if line.toLowerCase.startsWith("@param") =>
          (Param(line.drop("@param".length).trim) :: as, lines)
        case ((Param(value) :: as, lines), line) => (Param(value + "\n" + line) :: as, lines)
        case ((as, lines), line)                 => (as, lines :+ line)
      }

    PropComment(if (_lines.nonEmpty) Some(_lines.mkString("\n")) else None, _ans.reverse)
  }

  def apply(str: String) = new PropComment(Some(str), Seq.empty)
}

final case class VarName(value: String) extends Wrapper[String]

final case class Import(
    varName: VarName,
    target: Either[Path, String]
)

case class Identifier private (value: String) extends Wrapper[String]

object Identifier {
  var counter = 0
  def safe(m: String): Identifier = {
    counter = counter + 1
    val memberName = if(m.isEmpty) {
      "_" + counter
    } else if (m.head.isDigit) {
      "_" + m
    }
    else {
      m
    }
    Identifier(memberName.replaceAll("[-/]", "_"))
  }
}

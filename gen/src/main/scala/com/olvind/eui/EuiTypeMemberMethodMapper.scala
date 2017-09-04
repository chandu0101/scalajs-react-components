package com.olvind
package eui

object EuiTypeMemberMethodMapper extends MemberMapper {

  override def apply(compName: CompName)(memberMethod: MemberMethod): ParsedMethod =
    ParsedMethod(
      apply(compName, memberMethod.paramNames, memberMethod.name),
      None
    )

  private def apply(c: CompName, args: Seq[String], m: String) =
    (c.value, args.size, m) match {
      //      case ("TimePicker", 0, "isControlled") => "isControlled(): Boolean"

      case other ⇒
        println("missing types for method: " + other)
        m + args.map(sanitize(_) + ": js.Any").mkString("(", ", ", ")") + ": js.Dynamic"
    }
  def sanitize(s: String) =
    if (s == "val") "`val`" else s
}

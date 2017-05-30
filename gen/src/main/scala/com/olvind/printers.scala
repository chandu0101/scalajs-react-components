package com.olvind

sealed trait OutFile
case class PrimaryOutFile(filename: CompName, content: String, secondaries: Seq[SecondaryOutFile])
    extends OutFile
case class SecondaryOutFile(filename: String, content: String) extends OutFile

object Printer {
  case class FieldStats(maxFieldNameLen: Int, maxTypeNameLen: Int)

  def apply(prefix: String, comp: ParsedComponent): (PrimaryOutFile, Seq[SecondaryOutFile]) = {
    val fs: FieldStats =
      FieldStats(
        maxFieldNameLen = comp.fields.map(_.name.value.length).max,
        maxTypeNameLen = comp.fields.map(_.typeName.length).max
      )

    val p =
      PrimaryOutFile(
        comp.name,
        Seq(
          s"\ncase class ${comp.nameDef(prefix, withBounds = true)}(",
          comp.fields
            .filterNot(_.name == PropName("children"))
            .map(
              p => outProp(p, fs)
            )
            .mkString("", ",\n", ")") + bodyChildren(prefix, comp)
        ) mkString "\n",
        comp.methodClassOpt.toSeq map outMethodClass
      )

    (p, comp.enumClases map outEnumClass)
  }

  def hack(comp: ParsedComponent): String =
    comp.genericParams
      .map { p ⇒
        s"""implicit def ev${p.name}(${p.name.toLowerCase}: ${p.name}): js.Any = ${p.name.toLowerCase}.asInstanceOf[js.Any]
implicit def ev2${p.name}(${p.name.toLowerCase}: ${p.name} | js.Array[${p.name}]): js.Any = ${p.name.toLowerCase}.asInstanceOf[js.Any]"""
      }
      .mkString(";")

  def bodyChildren(prefix: String, comp: ParsedComponent): String =
    (comp.childrenOpt, comp.definition.multipleChildren) match {
      case (None, _) =>
        s"""{
          |
          |${indent(1)}def apply() = {
          |${indent(2)}${hack(comp)}
          |${indent(2)}val props = JSMacro[${comp.nameDef(prefix)}](this)
          |${indent(2)}val f = JsComponent[js.Object, Children.None, Null]($prefix.${comp.name.value})
          |${indent(2)}f(props)
          |${indent(1)}}
          |}
        """.stripMargin

      case (Some(childrenProp), true) =>
        s"""{
           |
           |${outChildrenComment(childrenProp.commentOpt)}
           |${indent(1)}def apply(children: ${childrenProp.baseType.name}*) = {
           |${indent(2)}${hack(comp)}
           |${indent(2)}val props = JSMacro[${comp.nameDef(prefix)}](this)
           |${indent(2)}val f = JsComponent[js.Object, Children.Varargs, Null]($prefix.${comp.name.value})
           |${indent(2)}f(props)(children: _*)
           |${indent(1)}}
           |}""".stripMargin

      case (Some(childrenProp), false) =>
        s"""{
           |
           |${outChildrenComment(childrenProp.commentOpt)}
           |${indent(1)}def apply(child: ${childrenProp.typeName} = js.undefined) = {
           |${indent(2)}${if (!childrenProp.isRequired) "import js.UndefOr._"}
           |${indent(2)}${hack(comp)}
           |${indent(2)}val props = JSMacro[${comp.nameDef(prefix)}](this)
           |${indent(2)}val f = JsComponent[js.Object, Children.Varargs, Null]($prefix.${comp.name.value})
           |${indent(2)}${if (childrenProp.isRequired) "f(props)(child)"
           else "child.fold(f(props)())(ch => f(props)(ch))"}
           |${indent(1)}}
           |}""".stripMargin
    }

  def outChildrenComment(oc: Option[PropComment]): String =
    oc.flatMap(_.value) match {
      case Some(c) =>
        c.split("\n")
          .mkString(
            s"${indent(1)}/**\n ${indent(1)} * @param children ",
            "\n" + indent(2),
            s"\n${indent(1)} */"
          )
      case None => ""
    }

  def outComment(_commentOpt: Option[PropComment], inheritedFrom: Option[CompName]): String = {
    val inheritedLine: Option[String] =
      inheritedFrom.map(i => s"(Passed on to $i)")

    val lines: Seq[String] =
      _commentOpt match {
        case None => inheritedLine.toSeq
        case Some(comment) =>
          val anns: Seq[String] =
            comment.anns.collect {
              case Param(value) => s"@param $value"
            }

          comment.value.toSeq ++ inheritedLine ++ (if (anns.isEmpty) Nil else Seq("\n")) ++ anns
      }

    if (lines.isEmpty) ""
    else lines.flatMap(_.split("\n")).mkString(s"${indent(1)}/** ", s"\n${indent(2)} ", " */\n")
  }

  def safeName(name: String): String = {
    val safeSubstitutions = Map(
      ("super" -> "`super`"),
      ("type"  -> "`type`")
    )
    safeSubstitutions.get(name).getOrElse(name)
  }

  def outProp(p: ParsedProp, fs: FieldStats): String = {
    val comment = outComment(p.commentOpt, p.inheritedFrom)

    val intro: String = {
      val fixedName: String = safeName(p.name.value)
      val deprecation: String =
        (p.deprecatedMsg, p.commentOpt.exists(_.anns.contains(Ignore))) match {
          case (Some(msg), _) => s"""${indent(1)}@deprecated("$msg", "")\n"""
          case (None, true)   => "" //s"""${indent(1)}@deprecated("Internal API", "")\n"""
          case _              => ""
        }
      s"$comment$deprecation${indent(1)}${padTo(fixedName + ": ")(fs.maxFieldNameLen + 2)}"
    }

    p.isRequired match {
      case true  => intro + p.typeName
      case false => intro + padTo(p.typeName)(fs.maxTypeNameLen) + " = js.undefined"
    }
  }

  def outEnumClass(c: ParsedEnumClass): SecondaryOutFile =
    SecondaryOutFile(
      c.name,
      s"""
         |class ${c.name}(val value: String) extends AnyVal
         |object ${c.name} {
         |${c.identifiers
           .map {
             case (ident, original) =>
               s"""${indent(1)}val ${safeName(ident.value)} = new ${c.name}("$original")"""
           }
           .mkString("\n")}
         |${indent(1)}val values = ${c.identifiers.map(_._1.value).map(safeName).toList}
         |}""".stripMargin
    )

  def outMethodClass(c: ParsedMethodClass): SecondaryOutFile =
    SecondaryOutFile(
      c.className,
      s"""
         |@js.native
         |trait ${c.className} extends js.Object {
         |${c.methods
           .map { m =>
             val deprecated: String =
               if (m.toString.toLowerCase.contains("deprecated"))
                 s"""${indent(1)}@deprecated("", "")\n"""
               else ""
             val comment = outComment(m.commentOpt, None)
             s"$comment$deprecated${indent(1)}def ${m.definition} = js.native"
           }
           .mkString("\n\n")}
         |}""".stripMargin
    )
}

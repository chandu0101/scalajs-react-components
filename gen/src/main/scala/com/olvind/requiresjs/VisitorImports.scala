package com.olvind
package requiresjs

import ammonite.ops.Path
import jdk.nashorn.internal.ir._

import scala.collection.JavaConverters._
import scala.collection.mutable

case class VisitorImports(n: FunctionNode, currentPath: Path)
    extends VisitorHelperNameStack[FunctionNode, Seq[Import]](n) {
  private val ret: mutable.Map[VarName, Import] =
    mutable.Map.empty[VarName, Import]

  override def enterCallNode(n: CallNode): Boolean =
    matcher((n.getFunction, n.getArgs.asScala.toList)) {
      case (i: IdentNode, List(o: LiteralNode[_])) if i.getName == "require" =>
        val target =
          if (o.getString.startsWith(".")) Left(add(currentPath, o.getString))
          else Right(o.getString)

        val name = nameStack.headOption.getOrElse(VarName(o.getString))
        ret(name) = Import(name, target)

      case (i: IdentNode, List(arg: IdentNode)) if i.getName.contains("interopRequireDefault") =>
        ret(VarName(arg.getName)) = ret(VarName(arg.getName)).copy(varName = nameStack.head)
    }

  override protected def fetchValue(): Seq[Import] = {
    ret.values.toSeq
  }
}

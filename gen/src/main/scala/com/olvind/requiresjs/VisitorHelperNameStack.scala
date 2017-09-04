package com.olvind
package requiresjs

import jdk.nashorn.internal.ir._

abstract class VisitorHelperNameStack[N <: Node, Out](n: N) extends VisitorHelper[N, Out](n) {
  protected var nameStack: List[VarName] = Nil

  override def enterPropertyNode(n: PropertyNode): Boolean =
    matcher(n.getKey) {
      case (i: IdentNode) =>
        nameStack = VarName(i.getName) :: nameStack
    }

  override def leavePropertyNode(n: PropertyNode): Node = {
    (nameStack.headOption, n.getKey) match {
      case (Some(n1), n2: IdentNode) if n1.value == n2.getName =>
        nameStack = nameStack drop 1
      case _ => ()
    }
    n
  }

  override def enterVarNode(n: VarNode): Boolean =
    matcher(n.getName) {
      case name =>
        nameStack = VarName(name.getName) :: nameStack
    }

  override def leaveVarNode(n: VarNode): Node = {
    (nameStack.headOption, n.getName) match {
      case (Some(n1), n2) if n1.value == n2.getName =>
        nameStack = nameStack drop 1
      case _ => ()
    }
    n
  }

  override protected def assertions(): Unit =
    require(nameStack.isEmpty)
}

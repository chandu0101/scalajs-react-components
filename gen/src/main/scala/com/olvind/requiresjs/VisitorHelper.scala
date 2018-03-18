package com.olvind
package requiresjs

import jdk.nashorn.internal.ir.visitor.NodeVisitor
import jdk.nashorn.internal.ir.{BlockLexicalContext, Node}

abstract class VisitorHelper[N <: Node, Out](n: N) extends NodeVisitor(new BlockLexicalContext) {
  protected def matcher[M](m: M)(f: PartialFunction[M, Unit]): Boolean =
    if (f.isDefinedAt(m)) {
      f(m)
      true
    } else true

  protected def assertions(): Unit = ()
  protected def fetchValue(): Out

  lazy val value: Out = {
    n accept this
    //    assertions()
    fetchValue()
  }
}

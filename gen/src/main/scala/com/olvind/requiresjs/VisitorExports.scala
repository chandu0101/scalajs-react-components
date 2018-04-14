package com.olvind
package requiresjs

import jdk.nashorn.internal.ir._

import scala.collection.mutable

case class VisitorExports(n: FunctionNode) extends VisitorHelper[FunctionNode, Seq[Node]](n) {
  // Left if something is exported at `exported.default` for now
  private var ret: Either[Node, mutable.ArrayBuffer[Node]] =
    Right(mutable.ArrayBuffer.empty)

  def filterNode(rhs: Node): Option[Node] =
    rhs match {
      case a: AccessNode if a.getProperty == "default" ⇒
        Some(a.getBase.asInstanceOf[Node])
      case _: FunctionNode | _: ObjectNode | _: IdentNode ⇒
        Some(rhs)
      case other ⇒
        None
    }

  override def enterBinaryNode(bn: BinaryNode): Boolean = {
    matcher(bn.lhs) {
      case a: AccessNode ⇒
        matcher(a.getBase) {
          case base: IdentNode if base.getName == "exports" ⇒
            (ret, filterNode(bn.rhs), a.getProperty == "default") match {
              case (_, None, _) ⇒
                ()
              case (_, Some(node), true) ⇒
                ret = Left(node)
              case (Right(existing), Some(node), false) ⇒
                existing += node
              case other ⇒
                ???
            }
        }
    }
  }

  override protected def fetchValue(): Seq[Node] =
    ret.fold(Seq(_), _.toSeq)
}

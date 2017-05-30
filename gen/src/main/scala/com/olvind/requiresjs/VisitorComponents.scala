package com.olvind
package requiresjs

import jdk.nashorn.internal.ir._

import scala.collection.JavaConverters._
import scala.collection.mutable

case class VisitorComponents(n: FunctionNode)
    extends VisitorHelperNameStack[FunctionNode, Map[CompName, ObjectNode]](n) {
  private val ret: mutable.Map[CompName, ObjectNode] =
    mutable.Map.empty[CompName, ObjectNode]

  override def enterBinaryNode(bn: BinaryNode): Boolean = {
    bn.lhs match {
      case a: AccessNode if a.getProperty == "exports" =>
        bn.rhs match {
          case right: CallNode =>
            right.getArgs.asScala.collect {
              case o: ObjectNode =>
                o.getElements.asScala.collect {
                  case a: PropertyNode if a.getKeyName == "displayName" =>
                    val name = a.getValue.asInstanceOf[LiteralNode[String]].getValue
                    nameStack = VarName(name) :: nameStack
                  //                    ret(CompName(name)) = o
                }
            }
          case right =>
            println(right)
        }
      case a: AccessNode if a.getProperty == "propTypes" ⇒
        bn.rhs match {
          /* inline object*/
          case o: ObjectNode ⇒
            ret(CompName(a.getBase.asInstanceOf[IdentNode].getName)) = o

          /* referencing variable in scope, so search upwards */
          case i: IdentNode ⇒
            val founds = lc.getBlocks.asScala.toList.flatMap { block ⇒
              block.getStatements.asScala.collect {
                case v: VarNode if v.getName.getName == i.getName ⇒ v.getInit
              }
            }
            val foundOpt = founds collectFirst {
              case o: ObjectNode ⇒ o
            }
            foundOpt.foreach(found ⇒
              ret(CompName(a.getBase.asInstanceOf[IdentNode].getName)) = found)
        }
      case other =>
        ()
    }
    true
  }

  /* old style createClass way of creating react components.
      We dig out `propTypes` out of the structure */
  override def enterCallNode(n: CallNode): Boolean =
    matcher((n.getFunction, n.getArgs.asScala.toList)) {
      case (a: AccessNode, List(o: ObjectNode)) if a.getProperty == "createClass" =>
        o.getElements.asScala
          .collect {
            case p: PropertyNode ⇒ (p.getKey, p.getValue)
          }
          .collectFirst {
            case (i: IdentNode, o: ObjectNode) if i.getName == "propTypes" =>
              nameStack.headOption match {
                case Some(name) => ret(CompName(name.value)) = o
                case None       => ()
              }
          }
    }

  override protected def fetchValue(): Map[CompName, ObjectNode] =
    ret.toMap
}

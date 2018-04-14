package com.olvind
package requiresjs

import jdk.nashorn.internal.ir._

import scala.collection.JavaConverters._
import scala.collection.mutable

case class VisitorComponentMembers(n: FunctionNode)
    extends VisitorHelper[FunctionNode, Map[CompName, Set[MemberMethod]]](n) {
  private val ret: mutable.Map[CompName, Set[MemberMethod]] =
    mutable.Map.empty[CompName, Set[MemberMethod]]

  /* dig out all member methods from a class variant */
  override def enterCallNode(n: CallNode): Boolean =
    matcher((n.getFunction, n.getArgs.asScala.toList)) {
      case (createClassName,
            (compName: IdentNode) :: (members: LiteralNode.ArrayLiteralNode) :: Nil)
          if createClassName.toString.contains("createClass") ⇒
        members.getValue.collect {
          case member: ObjectNode ⇒
            matcher(member.getElements.asScala.toList) {
              case (name: PropertyNode) :: (value: PropertyNode) :: Nil ⇒
                matcher((name.getValue, value.getValue)) {
                  case (fi: LiteralNode[_], f: FunctionNode) ⇒
                    val m         = MemberMethod(fi.getString, f.getParameters.asScala.map(_.getName))
                    val compName_ = CompName(compName.getName)
                    ret.get(compName_) match {
                      case Some(existing) ⇒
                        ret(compName_) = existing + m
                      case None ⇒
                        ret(compName_) = Set(m)
                    }
                }
                name.getKeyName
            }
        }
    }

  override protected def fetchValue(): Map[CompName, Set[MemberMethod]] =
    ret.toMap
}

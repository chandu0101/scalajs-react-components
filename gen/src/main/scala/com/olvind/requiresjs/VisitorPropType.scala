package com.olvind
package requiresjs

import jdk.nashorn.internal.ir._

import scala.collection.JavaConverters._

case class VisitorPropType(
    n: CompName,
    o: ObjectNode,
    jsContent: String,
    is: Seq[Import]
) extends VisitorHelper[ObjectNode, Map[PropName, PropUnparsed]](o) {

  private var ret: Option[Map[PropName, PropUnparsed]] = None

  def mapPropType(
      start: Int,
      ps: List[PropertyNode]
  ): List[(PropName, PropUnparsed)] = {
    ps match {
      case Nil => Nil
      case p :: pt =>
        val commentOS: Option[PropComment] =
          Some(jsContent.substring(start, p.getStart).trim)
            .filterNot(_.isEmpty) map PropComment.clean

        val typeS: PropTypeUnparsed =
          PropTypeUnparsed(jsContent.substring(p.getValue.getStart, p.getValue.getFinish))

        (PropName(p.getKeyName) -> PropUnparsed(n, typeS, commentOS)) +: mapPropType(
          p.getValue.getFinish + 1,
          pt)
    }
  }

  override def enterObjectNode(o: ObjectNode): Boolean = {
    ret = Some(
      mapPropType(o.getStart + 1, o.getElements.asScala.toList).toMap
    )
    false
  }

  override protected def fetchValue(): Map[PropName, PropUnparsed] =
    ret.getOrElse(panic(s"Count not find $n"))
}

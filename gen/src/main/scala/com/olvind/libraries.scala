package com.olvind

import ammonite.ops.Path

final case class ComponentDef(
    name: CompName,
    shared: Option[ComponentDef] = None,
    multipleChildren: Boolean = true,
    domeTypeOpt: Option[DomType] = None, //Some(DomElement),
    forceChildren: Boolean = false
)

trait TypeMapper {
  def apply(compName: CompName, fieldName: PropName, typeString: String): Type
}

trait MemberMapper {
  def apply(compName: CompName)(memberMethod: MemberMethod): ParsedMethod
}

trait Library {
  def name: String
  def prefixOpt: Option[String]
  def locations: Seq[Path]
  def components: Seq[ComponentDef]
  def typeMapper: TypeMapper
  def memberMapper: MemberMapper
  def indexNames: Set[String]
  def packageName: String

  @deprecated("", "")
  final def prefix: String =
    prefixOpt getOrElse ""
}

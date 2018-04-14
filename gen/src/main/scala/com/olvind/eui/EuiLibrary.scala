package com.olvind
package eui

import ammonite.ops._

import scala.language.implicitConversions

case class EuiLibrary(base: Path) extends Library {
  /* todo: make requiresjs clever enough to figure this out by itself */
  override val locations =
    Seq(
      base / 'lib // / 'components
    )

  override val prefixOpt    = Some("Eui")
  override val name         = "elementalui"
  override val typeMapper   = EuiTypeMapper
  override val memberMapper = EuiTypeMemberMethodMapper
  override val indexNames   = Set("Elemental.js", "index.js")
  override val packageName  = "chandu0101.scalajs.react.components.elementalui"

  val formField =
    ComponentDef(CompName("FormField"), forceChildren = true, domeTypeOpt = Some(DomInput))
  val components: Seq[ComponentDef] =
    Seq(
      //      ComponentDef(CompName("BlankState")),
      //      ComponentDef(CompName("BlankStateHeading")), //Error, two components in one file
      //      ComponentDef(CompName("Section")),
      //      ComponentDef(CompName("Body")),
      //      ComponentDef(CompName("Footer")),
      //      ComponentDef(CompName("Header")),
      ComponentDef(CompName("ElementalAlert")),
      ComponentDef(CompName("ButtonGroup")),
      ComponentDef(CompName("Button"), forceChildren = true, domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Card")),
      ComponentDef(CompName("Col")), // Error, comments
      ComponentDef(CompName("Container"), forceChildren = true),
      ComponentDef(CompName("Checkbox"), domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Dropdown")),
      ComponentDef(CompName("EmailInputGroup"), domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Dropzone")),
      ComponentDef(CompName("FileUpload"), domeTypeOpt = Some(DomInput)),
      formField,
      ComponentDef(CompName("FormIconField"),
                   forceChildren = true,
                   shared = Some(formField),
                   domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("FormIcon"), forceChildren = true),
      ComponentDef(CompName("FormInput"), forceChildren = true, domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Form"), forceChildren = true),
      ComponentDef(CompName("FormLabel"), forceChildren = true),
      ComponentDef(CompName("FormNote"), forceChildren = true),
      ComponentDef(CompName("FormRow"), forceChildren = true),
      ComponentDef(CompName("FormSelect"), forceChildren = true),
      ComponentDef(CompName("Glyph"), forceChildren = true),
      ComponentDef(CompName("InputGroup"), forceChildren = true),
      ComponentDef(CompName("InputGroupSection"), forceChildren = true),
      ComponentDef(CompName("ModalBody"), forceChildren = true),
      ComponentDef(CompName("ModalFooter"), forceChildren = true),
      ComponentDef(CompName("ModalHeader"), forceChildren = true),
      ComponentDef(CompName("Modal"), forceChildren = true),
      //      ComponentDef(CompName("Page")),
      ComponentDef(CompName("Pagination")),
      ComponentDef(CompName("PasswordInputGroup"), domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Pill")),
      ComponentDef(CompName("RadioGroup")),
      ComponentDef(CompName("ResponsiveText"), domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Row")),
      ComponentDef(CompName("SegmentedControl")),
      ComponentDef(CompName("Spinner")),
      ComponentDef(CompName("Table")),
      ComponentDef(CompName("Radio"), domeTypeOpt = Some(DomInput))
    )
}

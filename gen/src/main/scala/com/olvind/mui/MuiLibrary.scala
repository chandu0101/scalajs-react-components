package com.olvind
package mui

import ammonite.ops._

import scala.language.implicitConversions

case class MuiLibrary(base: Path) extends Library {
  /* todo: make requiresjs clever enough to figure out by itself */
  override val locations =
    Seq(
      base,
      base / 'styles,
      base / 'internal / 'EnhancedButton,
      base / 'internal / 'EnhancedSwitch,
      base / 'TextField / 'EnhancedTextarea
    )

  override val prefixOpt    = Some("Mui")
  override val name         = "materialui"
  override val typeMapper   = MuiTypeMapper
  override val memberMapper = MuiTypeMemberMethodMapper
  override val indexNames   = Set("index.js")
  override val packageName  = "chandu0101.scalajs.react.components.materialui"

  case object Internal {
    val AppCanvas          = ComponentDef(CompName("AppCanvas"))
    val BeforeAfterWrapper = ComponentDef(CompName("BeforeAfterWrapper"))
    val EnhancedButton     = ComponentDef(CompName("EnhancedButton"))
    val EnhancedSwitch     = ComponentDef(CompName("EnhancedSwitch"))
    val Overlay            = ComponentDef(CompName("Overlay"))
    val CircleRipple       = ComponentDef(CompName("CircleRipple"))
    val FocusRipple        = ComponentDef(CompName("FocusRipple"))
    val TouchRipple        = ComponentDef(CompName("TouchRipple"))
    val RenderToLayer      = ComponentDef(CompName("RenderToLayer"))
    val EnhancedTextarea   = ComponentDef(CompName("EnhancedTextarea"))
    val Tooltip            = ComponentDef(CompName("Tooltip"))
  }

  val DropDownMenu = ComponentDef(CompName("DropDownMenu"))
  val List_        = ComponentDef(CompName("List"))
  val ListItem     = ComponentDef(CompName("ListItem"), Some(Internal.EnhancedButton))
  val Menu         = ComponentDef(CompName("Menu"), Some(List_))
  val Paper        = ComponentDef(CompName("Paper"))
  val RadioButton  = ComponentDef(CompName("RadioButton"), Some(Internal.EnhancedSwitch))
  val TextField = ComponentDef(CompName("TextField"),
                               Some(Internal.EnhancedTextarea),
                               domeTypeOpt = Some(DomInput))

  val components: Seq[ComponentDef] =
    Seq(
      ComponentDef(CompName("AppBar"), Option(Paper)),
      ComponentDef(CompName("AutoComplete"), Some(TextField)),
      ComponentDef(CompName("Avatar"), multipleChildren = false),
      ComponentDef(CompName("Badge")),
      ComponentDef(CompName("Card"), Some(Paper)),
      ComponentDef(CompName("CardActions")),
      //      ComponentDef(CompName("CardExpandable"), None),
      ComponentDef(CompName("CardHeader")),
      ComponentDef(CompName("CardMedia")),
      ComponentDef(CompName("CardText")),
      ComponentDef(CompName("CardTitle")),
      ComponentDef(CompName("Checkbox"), Some(Internal.EnhancedSwitch)),
      ComponentDef(CompName("Chip"), Some(Internal.EnhancedButton)),
      ComponentDef(CompName("CircularProgress")),
      ComponentDef(CompName("DatePicker"), Option(TextField), domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Dialog"), None),
      ComponentDef(CompName("Divider")),
      ComponentDef(CompName("Drawer"), None),
      DropDownMenu,
      ComponentDef(CompName("FlatButton"), Some(Internal.EnhancedButton)),
      ComponentDef(CompName("FloatingActionButton"), Some(Internal.EnhancedButton)),
      ComponentDef(CompName("FontIcon")),
      ComponentDef(CompName("GridList")),
      ComponentDef(CompName("GridTile")),
      ComponentDef(CompName("IconButton"), Some(Internal.EnhancedButton)),
      ComponentDef(CompName("IconMenu"), Option(Menu)),
      ComponentDef(CompName("LinearProgress")),
      List_,
      ListItem,
      Menu,
      ComponentDef(CompName("MenuItem"), Option(ListItem)),
      ComponentDef(CompName("MuiThemeProvider")),
      Paper,
      ComponentDef(CompName("Popover")),
      //      ComponentDef(CompName("PopoverAnimationVertical")),
      RadioButton,
      ComponentDef(CompName("RadioButtonGroup"), Some(RadioButton)),
      ComponentDef(CompName("RaisedButton"), Some(Internal.EnhancedButton)),
      ComponentDef(CompName("RefreshIndicator")),
      ComponentDef(CompName("SelectField"), Option(DropDownMenu)),
      ComponentDef(CompName("Slider")),
      ComponentDef(CompName("Snackbar")),
      ComponentDef(CompName("Step")),
      ComponentDef(CompName("StepContent")),
      ComponentDef(CompName("StepLabel")),
      ComponentDef(CompName("Stepper")),
      ComponentDef(CompName("Subheader")),
      ComponentDef(CompName("Tab"), Some(Internal.EnhancedButton)),
      ComponentDef(CompName("Table")),
      ComponentDef(CompName("TableBody")),
      ComponentDef(CompName("TableFooter")),
      ComponentDef(CompName("TableHeader")),
      ComponentDef(CompName("TableHeaderColumn")),
      ComponentDef(CompName("TableRow")),
      ComponentDef(CompName("TableRowColumn")),
      ComponentDef(CompName("Tabs")),
      TextField,
      ComponentDef(CompName("TimePicker"), Option(TextField), domeTypeOpt = Some(DomInput)),
      ComponentDef(CompName("Toggle"), Some(Internal.EnhancedSwitch)),
      ComponentDef(CompName("Toolbar")),
      ComponentDef(CompName("ToolbarGroup")),
      ComponentDef(CompName("ToolbarSeparator")),
      ComponentDef(CompName("ToolbarTitle"))
    )
}

package com.olvind
package mui

object MuiTypeMapperFunction {
  val TouchTapEventHandler = "TouchTapEvent => Callback"
  val TouchEventHandler    = "ReactTouchEvent => Callback"
  val MouseEventHandler    = "ReactMouseEvent => Callback"
  val FocusEventhandler    = "ReactFocusEvent => Callback"
  val KeyboardEventHandler = "ReactKeyboardEvent => Callback"
  val Callback             = "Callback"

  def apply(compName: CompName, name: PropName): String =
    (compName.value, name.value) match {
      case ("AppBar", "onLeftIconButtonTouchTap")     => TouchTapEventHandler
      case ("AppBar", "onRightIconButtonTouchTap")    => TouchTapEventHandler
      case ("AppBar", "onTitleTouchTap")              => TouchTapEventHandler
      case ("AutoComplete", "onBlur")                 => "ReactFocusEventFromInput => Callback"
      case ("AutoComplete", "onFocus")                => "ReactFocusEventFromInput => Callback"
      case ("AutoComplete", "onNewRequest")           => "(String, Int) => Callback"
      case ("AutoComplete", "onUpdateInput")          => "(String, js.Array[String], js.Object) => Callback"
      case ("AutoComplete", "filter")                 => "(String, String, String) => Boolean"
      case ("AutoComplete", "animation")              => "js.Function"
      case ("AutoComplete", "onClose")                => Callback
      case ("Card", "onExpandChange")                 => "Boolean => Callback"
      case ("CardExpandable", "onExpanding")          => Callback
      case ("Checkbox", "onCheck")                    => "(ReactMouseEvent, Boolean) => Callback"
      case ("Chip", "onRequestDelete")                => TouchEventHandler
      case ("DatePicker", "DateTimeFormat")           => "js.Function"
      case ("DatePicker", "formatDate")               => "js.Date => String"
      case ("DatePicker", "onChange")                 => "(js.UndefOr[Nothing], js.Date) => Callback"
      case ("DatePicker", "onDismiss")                => Callback
      case ("DatePicker", "onShow")                   => Callback
      case ("DatePicker", "shouldDisableDate")        => "js.Date => Boolean"
      case ("DatePickerDialog", "onAccept")           => "js.Date => Callback"
      case ("DatePickerDialog", "DateTimeFormat")     => "js.Function"
      case ("DatePickerDialog", "shouldDisableDate")  => "js.Date => Boolean"
      case ("Dialog", "onRequestClose")               => "Boolean => Callback"
      case ("DialogInline", "onRequestClose")         => "Boolean => Callback"
      case ("Drawer", "onRequestChange")              => "(Boolean, String) => Callback"
      case ("DropDownMenu", "onChange")               => "(TouchTapEvent, Int, T) => Callback"
      case ("DropDownMenu", "animation")              => "js.Function"
      case ("DropDownMenu", "onClose")                => Callback
      case ("EnhancedButton", "onClick")              => "ReactEvent => Callback"
      case ("EnhancedSwitch", "onParentShouldUpdate") => "Boolean => Callback"
      case ("EnhancedSwitch", "onSwitch")             => "(ReactMouseEvent, Boolean) => Callback"
      case ("EnhancedTextarea", "onChange")           => "ReactEvent => Callback"
      case ("EnhancedTextarea", "onHeightChange")     => "(ReactEvent, Int)=> Callback"
      case ("IconButton", "onMouseOut")               => MouseEventHandler
      case ("IconMenu", "animation")                  => "js.Function"
      case ("IconMenu", "onChange")                   => "(ReactEvent, js.UndefOr[T]) => Callback"
      case ("IconMenu", "onItemTouchTap")             => "(ReactTouchEvent, ReactElement) => Callback"
      case ("IconMenu", "onRequestChange")            => "(Boolean, String) => Callback"
      case ("ListItem", "onNestedListToggle")         => "js.Any => Callback"
      case ("Menu", "onEscKeyDown")                   => KeyboardEventHandler
      case ("Menu", "onChange")                       => "(TouchTapEvent, T | js.Array[T]) => Callback"
      case ("Menu", "onMenuItemFocusChange")          => "(js.UndefOr[ReactEvent], Int) => Callback"
      case ("Menu", "onItemTouchTap")                 => "(TouchTapEvent, js.Object) => Callback"
      case ("MenuItem", "animation")                  => "js.Function"
      case ("MenuItem", "onClick")                    => "ReactEvent => Callback"
      case ("Popover", "onRequestClose")              => "String => Callback"
      case ("Popover", "animation")                   => "js.Function"
      case ("RadioButton", "onCheck")                 => "(ReactEvent, T) => Callback"
      case ("RadioButtonGroup", "onCheck")           => "(ReactEvent, T) => Callback"
      case ("RadioButtonGroup", "onChange")           => "(ReactEvent, T) => Callback"
      case ("SelectField", "onChange")                => "(TouchTapEvent, Int, T) => Callback"
      case ("Slider", "onChange")                     => "(ReactMouseEvent, Double) => Callback"
      case ("Slider", "onDragStart")                  => "ReactDragEvent => Callback"
      case ("Slider", "onDragStop")                   => "ReactDragEvent => Callback"
      case ("Slider", "onFocus")                      => FocusEventhandler
      case ("Snackbar", "onActionTouchTap")           => TouchEventHandler
      case ("Snackbar", "onRequestClose")             => "String => Callback"
      case ("StepContent", "transition")              => "js.Any"
      case ("Stepper", "updateCompletedStatus")       => "(Int, ReactNode) => CallbackTo[Boolean]"
      case ("Table", "onCellClick")                   => "(RowId, ColumnId) => Callback"
      case ("Table", "onCellHover")                   => "(RowId, ColumnId) => Callback"
      case ("Table", "onCellHoverExit")               => "(RowId, ColumnId) => Callback"
      case ("Table", "onRowHover")                    => "RowId => Callback"
      case ("Table", "onRowHoverExit")                => "RowId => Callback"
      case ("Table", "onRowSelection")                => "String | js.Array[RowId] => Callback"
      case ("TableBody", "onCellClick")               => "(RowId, ColumnId) => Callback"
      case ("TableBody", "onCellHover")               => "(RowId, ColumnId) => Callback"
      case ("TableBody", "onCellHoverExit")           => "(RowId, ColumnId) => Callback"
      case ("TableBody", "onRowHoverExit")            => "RowId => Callback"
      case ("TableBody", "onRowHover")                => "RowId => Callback"
      case ("TableBody", "onRowSelection")            => "String | js.Array[RowId] => Callback"
      case ("TableHeader", "onSelectAll")             => "Boolean => Callback"
      case ("TableHeaderColumn", "onHover")           => Callback
      case ("TableHeaderColumn", "onHoverExit")       => Callback
      case ("TableHeaderColumn", "onClick")           => "(ReactMouseEvent, ColumnId) => Callback"
      case ("TableRow", "onCellClick")                => "(ReactMouseEvent, RowId, ColumnId) => Callback"
      case ("TableRow", "onCellHover")                => "(ReactMouseEvent, RowId, ColumnId) => Callback"
      case ("TableRow", "onCellHoverExit")            => "(ReactMouseEvent, RowId, ColumnId) => Callback"
      case ("TableRow", "onRowHover")                 => "(ReactMouseEvent, RowId) => Callback"
      case ("TableRow", "onRowClick")                 => "(ReactMouseEvent, RowId) => Callback"
      case ("TableRow", "onRowHoverExit")             => "(ReactMouseEvent, RowId) => Callback"
      case ("TableRowColumn", "onClick")              => "(ReactMouseEvent, ColumnId) => Callback"
      case ("TableRowColumn", "onHover")              => "(ReactMouseEvent, ColumnId) => Callback"
      case ("TableRowColumn", "onHoverExit")          => "(ReactMouseEvent, ColumnId) => Callback"
      case ("Tab", "onActive")                        => "ReactElement => Callback"
      case ("Tabs", "onChange")                       => "(T, ReactEventFromHtml, ReactElement) => Callback"
      case ("Tabs", "tabTemplate")                    => "js.Any"
      case ("TextField", "onChange")                  => "(ReactEventFromInput, String) => Callback"
      case ("TextField", "onEnterKeyDown")            => "ReactKeyboardEventFromInput => Callback"
      case ("TextField", "onBlur")                    => "ReactFocusEventFromInput => Callback"
      case ("TextField", "onFocus")                   => "ReactFocusEventFromInput => Callback"
      case ("TimePicker", "onChange")                 => "(js.UndefOr[Nothing], js.Date) => Callback"
      case ("TimePicker", "onShow")                   => Callback
      case ("TimePicker", "onDismiss")                => Callback
      case ("Toggle", "onToggle")                     => "(ReactMouseEvent, Boolean) => Callback"

      case (_, "onBlur")          => FocusEventhandler
      case (_, "onFocus")         => FocusEventhandler
      case (_, "onKeyDown")       => KeyboardEventHandler
      case (_, "onKeyUp")         => KeyboardEventHandler
      case (_, "onKeyboardFocus") => "(ReactFocusEvent, Boolean) => Callback"
      case (_, "onMouseEnter")    => MouseEventHandler
      case (_, "onMouseLeave")    => MouseEventHandler
      case (_, "onMouseUp")       => MouseEventHandler
      case (_, "onMouseDown")     => MouseEventHandler
      case (_, "onTouchStart")    => TouchEventHandler
      case (_, "onTouchEnd")      => TouchEventHandler
      case (_, "onTouchTap")      => TouchTapEventHandler

      /*Added by roberto@leibman.net*/
      case ("DropDownMenu", "selectionRenderer") => Callback //TODO ???
      case ("SelectField", "selectionRenderer")  => Callback //TODO ???
      case _ =>
        throw new Error(
          s"""case ("${compName.value}", "${name.value}") => Callback  //TODO: Add function type mapping in ${getClass().getName}""")
    }
}

package com.olvind
package mui

object MuiTypeMemberMethodMapper extends MemberMapper {

  override def apply(compName: CompName)(memberMethod: MemberMethod): ParsedMethod =
    ParsedMethod(
      apply(compName, memberMethod.paramNames, memberMethod.name),
      None
    )

  private def apply(c: CompName, args: Seq[String], m: String) =
    (c.value, args.size, m) match {
      case ("DatePicker", 0, "getDate")                => "getDate(): js.Date"
      case ("DatePicker", 1, "setDate")                => "setDate(d: js.Date): Unit"
      case ("DatePicker", 0, "openDialog")             => "openDialog(): Unit"
      case ("DatePicker", 0, "focus")                  => "focus(): Unit"
      case ("Dialog", 0, "dismiss")                    => "dismiss(): Unit"
      case ("Dialog", 0, "show")                       => "show(): Unit"
      case ("Dialog", 0, "isOpen")                     => "isOpen(): Boolean"
      case ("Drawer", 0, "open")                       => "open(): Unit"
      case ("Drawer", 0, "close")                      => "close(): Unit"
      case ("Drawer", 0, "toggle")                     => "toggle(): Unit"
      case ("Snackbar", 0, "dismiss")                  => "dismiss(): Unit"
      case ("Snackbar", 0, "show")                     => "show(): Unit"
      case ("Checkbox", 0, "isChecked")                => "isChecked(): Boolean"
      case ("Checkbox", 1, "setChecked")               => "isChecked(newCheckedValue: Boolean): Unit"
      case ("RadioButtonGroup", 0, "getSelectedValue") => "getSelectedValue(): String"
      case ("RadioButtonGroup", 1, "setSelectedValue") =>
        "setSelectedValue(newSelectionValue: String): Unit"
      case ("RadioButtonGroup", 0, "clearValue") => "clearValue(): Unit"
      case ("Slider", 2, "onDragUpdate") =>
        "onDragUpdate(event: js.Any, `type`: js.Any): js.Dynamic"
      case ("Toggle", 0, "isToggled")       => "isToggled(): Boolean"
      case ("Toggle", 1, "setToggled")      => "setToggled(newToggledValue: Boolean): Unit"
      case ("TextField", 0, "blur")         => "blur(): Unit"
      case ("TextField", 0, "clearValue")   => "clearValue(): Unit"
      case ("TextField", 0, "focus")        => "focus(): Unit"
      case ("TextField", 0, "getValue")     => "getValue(): String"
      case ("TextField", 1, "setErrorText") => "setErrorText(newErrorText: String): Unit"
      case ("TextField", 1, "setValue")     => "setValue(newValue: String): Unit"
      case ("TimePicker", 0, "getTime")     => "getTime(): js.Date"
      case ("TimePicker", 1, "setTime")     => "setTime(d: js.Date): Unit"
      case ("TimePicker", 1, "formatTime")  => "formatTime(d: js.Date): String"
      case ("TimePicker", 0, "openDialog")  => "openDialog(): Unit"
      case ("TimePicker", 0, "focus")       => "focus(): Unit"

      /* Added by roberto@leibman.net for material-ui */
      case ("AutoComplete", 0, "blur")              => "blur(): Unit"
      case ("AutoComplete", 0, "close")             => "close(): Unit"
      case ("AutoComplete", 0, "focus")             => "focus(): Unit"
      case ("CircularProgress", 1, "rotateWrapper") => "rotateWrapper(wrapper: Wrapper): Unit"
      case ("CircularProgress", 1, "scalePath")     => "scalePath(path: CircularProgressPath): Unit"
      case ("DatePicker", 0, "getControlledDate")   => "getControlledDate(): js.Date"
      case ("DatePicker", 0, "isControlled")        => "isControlled(): Unit"
      case ("Drawer", 0, "removeBodyTouchListeners")=> "removeBodyTouchListeners(): Unit"
      case ("Drawer", 1, "close")                   => "close(reason: String): Unit"
      case ("Drawer", 0, "disableSwipeHandling")    => "disableSwipeHandling(): Unit"
      case ("Drawer", 0, "enableSwipeHandling")     => "enableSwipeHandling(): Unit"
      case ("Drawer", 0, "getMaxTranslateX")        => "getMaxTranslateX(): Int"
      case ("Drawer", 0, "getStyles")               => "getStyles(): CssProperties"
      case ("Drawer", 0, "getTranslateMultiplier")  => "getTranslateMultiplier(): Int"
      case ("Drawer", 1, "getTranslateX")           => "getTranslateX(currentX: Int): Int"
      case ("Drawer", 0, "getTranslatedWidth")      => "getTranslatedWidth(): Double"
      case ("Drawer", 1, "open")                    => "open(reason: String): Unit"
      case ("Drawer", 1, "setPosition")             => "setPosition(position: Int): Unit"
      case ("Drawer", 0, "shouldShow")              => "shouldShow(): Boolean"
      case ("DropDownMenu", 0, "getInputNode")      => "getInputNode(): js.Any"
      case ("DropDownMenu", 0, "setWidth")          => "setWidth(): Unit"
      case ("GridTile", 0, "ensureImageCover")      => "ensureImageCover(): Unit"
      case ("IconButton", 0, "hideTooltip")         => "hideTooltip(): Unit"
      case ("IconButton", 0, "setKeyboardFocus")    => "setKeyboardFocus(): Unit"
      case ("IconButton", 0, "showTooltip")         => "showTooltip(): Unit"
      case ("IconMenu", 2, "close")                 => "close(): Unit"
      case ("IconMenu", 0, "isOpen")                => "isOpen(): Boolean"
      case ("IconMenu", 2, "open")                  => "open(reason: String, event: js.Any): Unit"
      case ("LinearProgress", 5, "barUpdate") =>
        "barUpdate(id: String, step: Integer, barElement: String, stepValues: Array[Array[Int]], timeToNextStep: Long): Unit"
      case ("ListItem", 1, "applyFocusState") =>
        "applyFocusState(focusState: MuiFocusedState): Unit /*One of none, focused, keyboardfocused*/"
      case ("ListItem", 3, "createDisabledElement") =>
        "createDisabledElement(styles: CssProperties, contentChildren: Array[CtorType.ChildArg], additionalProps: js.Any): Unit"
      case ("ListItem", 3, "createLabelElement") =>
        "createLabelElement(styles: CssProperties, contentChildren: Array[CtorType.ChildArg], additionalProps: js.Any): Unit"
      case ("ListItem", 3, "createTextElement") =>
        "createTextElement(styles: CssProperties, data: js.Any, key: String): Unit"
      case ("ListItem", 4, "pushElement") =>
        "pushElement(children: Array[CtorType.ChildArg], element: js.Any, baseStyles: CssProperties, additionalProps: js.Any): Unit"
      case ("Menu", 1, "cancelScrollEvent") => "cancelScrollEvent(event: js.Any): Unit"
      case ("Menu", 4, "cloneMenuItem") =>
        "cloneMenuItem(child: js.Any, childIndex: Int, styles: CssProperties, index: Int): Unit"
      case ("Menu", 1, "decrementKeyboardFocusIndex") =>
        "decrementKeyboardFocusIndex(event: js.Any): Unit"
      case ("Menu", 1, "getFilteredChildren") => "getFilteredChildren(): Array[js.Any]"
      case ("Menu", 2, "getLastSelectedIndex") =>
        "getLastSelectedIndex(props: js.Any, filteredChildren: Array[CtorType.ChildArg]): Unit"
      case ("Menu", 1, "getMenuItemCount") => "getMenuItemCount(): Int"
      case ("Menu", 1, "getValueLink")     => "getValueLink(): Unit" //Deprecated
      case ("Menu", 2, "incrementKeyboardFocusIndex") =>
        "incrementKeyboardFocusIndex(event: js.Any, filteredChildren: Array[CtorType.ChildArg]): Unit"
      case ("Menu", 2, "isChildSelected") =>
        "isChildSelected(child: js.Any, props: js.Any): Boolean"
      case ("Menu", 3, "setFocusIndex") =>
        "setFocusIndex(event: js.Any, newIndex: Int, isKeyboardFocused: Boolean): Unit"
      case ("Menu", 2, "setFocusIndexStartsWith") =>
        "setFocusIndexStartsWith(event: js.Any, keys: String): Unit"
      case ("Menu", 1, "setKeyboardFocused")          => "setKeyboardFocused(value: Boolean): Unit"
      case ("Menu", 0, "setScollPosition")            => "setScollPosition(): Unit"
      case ("Menu", 0, "setWidth")                    => "setWidth(): Unit"
      case ("Menu", 3, "setFocusIndexStartsWith")     => "setFocusIndexStartsWith(event: js.Any, keys: js.Any, filteredChildren: js.Any): Unit"
      case ("MenuItem", 0, "applyFocusState")         => "applyFocusState(): Unit"
      case ("MuiThemeProvider", 0, "getChildContext") => "getChildContext(): MuiTheme"
      case ("Popover", 5, "applyAutoPositionIfNeeded") =>
        "applyAutoPositionIfNeeded(anchor: js.Any, target: js.Any, targetOrigin: js.Any, anchorOrigin: js.Any, targetPosition: js.Any): Unit"
      case ("Popover", 1, "autoCloseWhenOffScreen") =>
        "autoCloseWhenOffScreen(anchorPosition: js.Any): Unit"
      case ("Popover", 1, "getAnchorPosition") => "getAnchorPosition(): Position"
      case ("Popover", 3, "getOverlapMode") =>
        "getOverlapMode(anchor: js.Any, target: js.Any, median: js.Any): Unit"
      case ("Popover", 2, "getPositions")      => "getPositions(anchor: js.Any, target: js.Any): Unit"
      case ("Popover", 1, "getTargetPosition") => "getTargetPosition(): Position"
      case ("Popover", 1, "requestClose") =>
        "requestClose(reason: String): Unit" //clickaway or offScren
      case ("RadioButton", 0, "getValue")   => "getValue(): js.Any"
      case ("RadioButton", 0, "isChecked")  => "isChecked(): Boolean"
      case ("RadioButton", 1, "setChecked") => "setChecked(value: Boolean): Unit"
      case ("RadioButtonGroup", 1, "hasCheckAttribute") =>
        "hasCheckAttribute(radioButton: js.Any): Boolean"
      case ("RadioButtonGroup", 1, "updateRadioButtons") =>
        "updateRadioButtons(newSelection: js.Any): Unit"
      case ("RefreshIndicator", 0, "getArcDeg")         => "getArcDeg(): Double"
      case ("RefreshIndicator", 0, "getCircleAttr")     => "getCircleAttr(): Double"
      case ("RefreshIndicator", 0, "getCircleStyle")    => "getCircleStyle(): CssProperties"
      case ("RefreshIndicator", 0, "getFactor")         => "getFactor(): Double"
      case ("RefreshIndicator", 0, "getPaddingSize")    => "getPaddingSize(): Double"
      case ("RefreshIndicator", 0, "getPaperSize")      => "getPaperSize(): Double"
      case ("RefreshIndicator", 0, "getPolygonStyle")   => "getPolygonStyle(): CssProperties"
      case ("RefreshIndicator", 0, "getTheme")          => "getTheme(): MuiTheme"
      case ("RefreshIndicator", 0, "renderChildren")    => "renderChildren(): Unit"
      case ("RefreshIndicator", 1, "rotateWrapper")     => "rotateWrapper(wrapper: js.Any): Unit"
      case ("RefreshIndicator", 2, "scalePath")         => "scalePath(path: js.Any, step: Int): Unit"
      case ("Slider", 0, "clearValue")                  => "clearValue(): Unit"
      case ("Slider", 0, "getTrackOffset")              => "getTrackOffset(): Unit" //TODO
      case ("Slider", 0, "getValue")                    => "getValue(): Unit" //TODO
      case ("Slider", 1, "onDragStart")                 => "onDragStart(): Unit" //TODO
      case ("Slider", 1, "onDragStop")                  => "onDragStop(): Unit" //TODO
      case ("Slider", 2, "setValueFromPosition")        => "setValueFromPosition(): Unit" //TODO
      case ("Snackbar", 0, "setAutoHideTimer")          => "setAutoHideTimer(): Unit" //TODO
      case ("Snackbar", 0, "setTransitionTimer")        => "setTransitionTimer(): Unit" //TODO
      case ("Stepper", 0, "getChildContext")            => "getChildContext(): Unit" //TODO
      case ("Table", 1, "createTableBody")              => "createTableBody(): Unit" //TODO
      case ("Table", 1, "createTableFooter")            => "createTableFooter(): Unit" //TODO
      case ("Table", 1, "createTableHeader")            => "createTableHeader(): Unit" //TODO
      case ("Table", 0, "isScrollbarVisible")           => "isScrollbarVisible(): Boolean"
      case ("TableBody", 1, "createRowCheckboxColumn")  => "createRowCheckboxColumn(): Unit" //TODO
      case ("TableBody", 0, "createRows")               => "createRows(): Unit"
      case ("TableBody", 1, "flattenRanges")            => "flattenRanges(): Unit" //TODO
      case ("TableBody", 2, "genRangeOfValues")         => "genRangeOfValues(): Unit" //TODO
      case ("TableBody", 1, "getColumnId")              => "getColumnId(): Unit" //TODO
      case ("TableBody", 1, "getSelectedRows")          => "getSelectedRows(): Unit" //TODO
      case ("TableBody", 1, "isRowSelected")            => "isRowSelected(): Unit" //TODO
      case ("TableBody", 2, "isValueInRange")           => "isValueInRange(): Unit" //TODO
      case ("TableBody", 2, "processRowSelection")      => "processRowSelection(): Unit" //TODO
      case ("TableBody", 2, "splitRange")               => "splitRange(): Unit" //TODO
      case ("TableHeader", 0, "createBaseHeaderRow")    => "createBaseHeaderRow(): Unit" //TODO
      case ("TableHeader", 2, "createSuperHeaderRow")   => "createSuperHeaderRow(): Unit" //TODO
      case ("TableHeader", 0, "createSuperHeaderRows")  => "createSuperHeaderRows(): Unit" //TODO
      case ("TableHeader", 1, "getCheckboxPlaceholder") => "getCheckboxPlaceholder(): Unit" //TODO
      case ("TableHeader", 1, "getSelectAllCheckboxColumn") =>
        "getSelectAllCheckboxColumn(): Unit" //TODO
      case ("TableRow", 1, "onRowClick")          => "onRowClick(): Unit" //TODO
      case ("TableRow", 1, "onRowHover")          => "onRowHover(): Unit" //TODO
      case ("TableRow", 1, "onRowHoverExit")      => "onRowHoverExit(): Unit" //TODO
      case ("Tabs", 2, "getSelected")             => "getSelected(): Unit" //TODO
      case ("Tabs", 1, "getSelectedIndex")        => "getSelectedIndex(): Int"
      case ("Tabs", 0, "getTabCount")             => "getTabCount(): Int"
      case ("Tabs", 0, "getTabs")                 => "getTabs(): Unit" //TODO
      case ("Tabs", 1, "getValueLink")            => "getValueLink(): Unit" //TODO
      case ("TextField", 0, "getInputNode")       => "getInputNode(): Unit" //TODO
      case ("TextField", 0, "select")             => "select(): Unit"
      case ("TimePicker", 0, "getControlledTime") => "getControlledTime(): js.Date"
      case ("TimePicker", 0, "isControlled")      => "isControlled(): Boolean"

      case other ⇒
        println("missing types for method: " + other)
        m + args.map(sanitize(_) + ": js.Any").mkString("(", ", ", ")") + ": js.Dynamic"
    }
  def sanitize(s: String) =
    if (s == "val") "`val`" else s
}

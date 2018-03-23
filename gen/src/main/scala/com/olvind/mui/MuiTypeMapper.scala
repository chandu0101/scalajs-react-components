package com.olvind
package mui

object MuiTypeMapper extends TypeMapper {
  val typeT   = Normal("T").generic("T")
  val typeTJs = Normal("T").genericJs("T")

  def apply(compName: CompName, fieldName: PropName, typeString: String): Type = {
    def is(s: String) =
      fieldName.value.toLowerCase contains s.toLowerCase
    def split(drop: Int, s: String) =
      s.split("[\'\"\\(\\)\\[\\],\\s]").map(_.trim).filterNot(_.isEmpty).drop(drop)

    //Please note that the following match statement is incredibly order-sensitive, if you change order around you can break things
    (compName.value, fieldName.value, typeString) match {
      // i dont have patience to do this properly (GridList)
      case (_, "cellHeight", _) => Normal("Int")

      case (_, _, e) if e.contains("oneOfType") || e.contains("some(") => {
        val splitted = split(1, e)
        Normal(splitted.map(t => apply(compName, fieldName, t))
          .filter(_.name.nonEmpty)
          .map(_.name)
          .toSet
          .mkString(" | "))
      }
      case (_, _, enum) if enum.startsWith("Mui.oneOf") =>
        Enum(compName, split(1, enum))

      /* Double => Int */
      case (_, "autoHideDuration", "number")            => Normal("Int")
      case (_, "cols", "number")                        => Normal("Int")
      case (_, "columnNumber", "number")                => Normal("Int")
      case (_, "columnId", "number")                    => Normal("Int")
      case (_, "initialSelectedIndex", "number")        => Normal("Int")
      case (_, "left", "number")                        => Normal("Int")
      case (_, "maxHeight", "number")                   => Normal("Int")
      case (_, "nestedLevel", "number")                 => Normal("Int")
      case (_, "padding", "number")                     => Normal("Int")
      case (_, "rowNumber", "number")                   => Normal("Int")
      case (_, "rows", "number")                        => Normal("Int")
      case (_, "rowsMax", "number")                     => Normal("Int")
      case (_, "selectedIndex", "number")               => Normal("Int")
      case ("Avatar", "size", "number")                 => Normal("Int")
      case ("RefreshIndicator", "size", "number")       => Normal("Int")
      case (_, "top", "number")                         => Normal("Int")
      case (_, "touchTapCloseDelay", "number")          => Normal("Int")
      case (_, _, e) if e.toLowerCase.contains("index") => Normal("Int")

      /* specific */
      case ("AutoComplete", "dataSource", "Mui.array")        => Normal("js.Array[String]")
      case ("DatePicker", "value", _)                         => Normal("js.Date")
      case ("DatePicker", "defaultDate", "Mui.object")        => Normal("js.Date")
      case ("DatePicker", "maxDate", "Mui.object")            => Normal("js.Date")
      case ("DatePicker", "minDate", "Mui.object")            => Normal("js.Date")
      case ("DatePicker", "initialDate", "Mui.object")        => Normal("js.Date")
      case ("Dialog", "width", "Mui.any")                     => Normal("Int")
      case ("DropDownMenu", "value", "Mui.any")               => typeT
      case ("EnhancedSwitch", "value", "Mui.any")             => typeT
      case ("RadioButtonGroup", "defaultSelected", "Mui.any") => typeT
      case ("RadioButtonGroup", "valueSelected", "Mui.any")   => typeT
      case ("RadioButton", "value", "Mui.any")                => typeT
      case ("Tab", "index", "Mui.any")                        => Normal("js.Any")
      case ("ListItem", "nestedItems", "Mui.arrayOf(Mui.element)") =>
        Normal("js.Array[VdomElement]")
      case ("Menu", "value", "Mui.any")                             => Normal("T | js.Array[T]").generic("T")
      case ("MenuItem", "value", "Mui.any")                         => typeT
      case ("SelectField", "selectFieldRoot", "Mui.object")         => Normal("CssProperties")
      case ("SelectField", "value", "Mui.any")                      => typeT
      case ("Slider", "defaultValue", "valueInRangePropType")       => Normal("Double")
      case ("Slider", "max", "minMaxPropType")                      => Normal("Double")
      case ("Slider", "min", "minMaxPropType")                      => Normal("Double")
      case ("Slider", "value", "valueInRangePropType")              => Normal("Double")
      case ("Step", "controlButtonsGroup", "Mui.arrayOf(Mui.node)") => Normal("js.Array[VdomNode]")
      case ("Step", "actions", "Mui.arrayOf(Mui.node)")             => Normal("js.Array[VdomNode]")
      case ("Tab", "value", "Mui.any")                              => typeTJs
      case ("Tabs", "value", "Mui.any")                             => typeTJs
      case ("TextField", "value", "Mui.any")                        => Normal("String")
      case ("TextField", "defaultValue", "Mui.any")                 => Normal("String")
      case ("TimePicker", "defaultTime", "Mui.object")              => Normal("js.Date")
      case ("TimePicker", "value", "Mui.object")                    => Normal("js.Date")
      case ("DatePicker", "utils", "Mui.object")                    => Normal("DatePickerUtils") //TODO ???
      case ("SelectField", "dropDownMenuProps", "Mui.object") =>
        Normal("DropDownMenuProps") //TODO ???

      /* TODO: dubious */
      case ("EnhancedTextarea", "defaultValue", "Mui.any")        => Normal("js.Any")
      case ("GridTile", "rootClass", "Mui.object")                => Normal("js.Any")
      case ("Popover", "anchorEl", "Mui.object")                  => Normal("js.Any")
      case ("Stepper", "createIcon", "Mui.func")                  => Normal("js.Function")
      case ("Stepper", "updateAvatarBackgroundColor", "Mui.func") => Normal("js.Function")
      case (_, "valueLink", "Mui.object")                         => Normal("js.Any")

      /* mui general */
      case (_, _, "Mui.string") if is("color")            => Normal("MuiColor")
      case (_, _, "Mui.object") if is("style")            => Normal("CssProperties")
      case (_, _, "Mui.object") if is("muiTheme")         => Normal("MuiTheme")
      case (_, _, "Mui.object")                           => Normal("js.Object")
      case (_, _, "Mui.any")                              => Normal("js.Any")
      case (_, "label", "validateLabel")                  => Normal("String")
      case (_, "zDepth", _)                               => Normal("ZDepth")
      case (_, _, "Mui.origin")                           => Normal("Origin")
      case (_, _, "_propTypes4.default.origin")           => Normal("Origin") //TODO???
      case (_, _, "_propTypes4.default.cornersAndCenter") => Normal("CornersAndCenter") //TODO???
      case (_, _, "_propTypes4.default.stringOrNumber")   => Normal("String | Double") //TODO???
      case (_, _, "Mui.cornersAndCenter")                 => Normal("CornersAndCenter")
      case (_, _, "Mui.corners")                          => Normal("Corners")
      case (_, _, "Mui.stringOrNumber")                   => Normal("String | Double")

      /* general */
      case (_, _, "Mui.string")                        => Normal("String")
      case (_, _, "Mui.bool")                          => Normal("Boolean")
      case (_, "children", "Mui.element")              => Normal("VdomElement")
      case (_, _, "Mui.element")                       => Normal("VdomElement")
      case (_, "children", "Mui.node")                 => Normal("VdomNode")
      case (_, _, "Mui.node")                          => Normal("VdomNode")
      case (_, _, "Mui.number")                        => Normal("Double")
      case (_, "children", "Mui.arrayOf(Mui.element)") => Normal("js.Array[VdomElement]")

      case ("Stepper", "children", "Mui.arrayOf(Mui.node)") => Normal("js.Any")

      case ("FormField","control","Mui.oneOf") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("FormField","control","button") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("FormField","control","input") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("FormField","control","select") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("FormField","control","textarea") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("FormField","type","_lib.customevery([_lib.customdemand(['control'])])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("FormGroup","grouped","_lib.customevery([_lib.customdisallow(['inline']), Mui.bool])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("FormGroup","inline","_lib.customevery([_lib.customdisallow(['grouped']), Mui.bool])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Grid","celled","Mui.oneOf") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Grid","celled","internally") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Grid","divided","Mui.oneOf") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Grid","divided","vertically") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Grid","padded","Mui.oneOf") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Grid","padded","horizontally") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Grid","padded","vertically") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case (_, _, "Mui.func") =>
        Normal(MuiTypeMapperFunction(compName, fieldName))

    }
  }
}

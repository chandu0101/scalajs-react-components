package com.olvind
package sui

object SuiTypeMapper extends TypeMapper {
  val typeT = Normal("T").generic("T")
  val typeTJs = Normal("T").genericJs("T")

  def apply(compName: CompName, fieldName: PropName, typeString: String): Type = {
    def is(s: String) =
      fieldName.value.toLowerCase contains s.toLowerCase

    def split(drop: Int, s: String) =
      s.split("[\'\"\\(\\)\\[\\],\\s]").map(_.trim).filterNot(_.isEmpty).drop(drop)

    (compName.value, fieldName.value, typeString) match {
      case ("Input", "icon", _) => Normal("SuiIconType")
      case ("Flag", "name", _) => Normal("String | SuiCountry")
      case ("Header", "as", _) => Normal("String | js.Function")
      case ("Header", "image", _) => Normal("String | React.Element")
      case ("Header", "icon", _) => Normal("String | js.Object | React.Element")
      case ("Button", "children", _) => Normal("VdomNode")
      case ("Button", "animated", _) => Normal("Boolean | ButtonAnimatedType")
      case ("Icon", "name", "_lib.customsuggest(_lib.SUI.ALL_ICONS_IN_ALL_CONTEXTS)") =>
        Normal("SuiIconType")
      case (_, "textAlign", _) =>
        Enum(compName, Seq("left", "center", "right", "justified"), "SuiTextAlignment")

      case (_, "size", _) =>
        Enum(compName,
          Seq("mini", "tiny", "small", "medium", "large", "big", "huge", "massive"),
          "SuiSize")
      case ("IconGroup", "name", "_lib.customsuggest(_lib.SUI.ALL_ICONS_IN_ALL_CONTEXTS)") =>
        Normal("SuiIconType")
      case (_, _, e) if e.contains("oneOfType") || e.contains("some(") => {
        val splitted = split(1, e)
        Normal(splitted.map(t => apply(compName, fieldName, t))
          .filter(_.name.nonEmpty)
          .map(_.name)
          .toSet
          .mkString(" | "))
      }
      case (_, _, "Mui.oneOf(_lib.SUI.WIDTHS)") => Normal("Double")
      case (_, _, "Mui.oneOf(_lib.SUI.COLORS)") =>
        Enum(compName,
          Seq("red",
            "orange",
            "yellow",
            "olive",
            "green",
            "teal",
            "blue",
            "violet",
            "purple",
            "pink",
            "brown",
            "grey",
            "black"),
          "SuiColor")
      case (_, _, "Mui.oneOf(_lib.SUI.FLOATS)") => Enum(compName, Seq("left", "right"), "SuiFloat")
      case (_, _, "Mui.oneOf(_lib.SUI.SIZES)") =>
        Enum(compName,
          Seq("mini", "tiny", "small", "medium", "large", "big", "huge", "massive"),
          "SuiSize")
      case (_, _, "Mui.oneOf(_lib.SUI.TEXT_ALIGNMENTS)") =>
        Enum(compName, Seq("left", "center", "right", "justified"), "SuiTextAlignment")
      case (_, _, "Mui.oneOf(_lib.SUI.VERTICAL_ALIGNMENTS)") =>
        Enum(compName, Seq("bottom", "middle", "top"), "SuiVerticalAlignment")

      case (a, b, enum) if enum.contains("oneOf(") && enum.contains(']') =>
        val found = "(\\[.*?\\])".r.findAllIn(enum).toList
        val array =
          found.last.replaceAll("\\[|\\]", "").split(", ").map(_.replace("'", "").replace(" ", ""))
        Enum(compName, array)
      case (a, b, enum) if enum.contains("oneOf(") && !enum.contains(']') =>
        Enum(compName, split(1, enum))

      case (_, _, "_lib.customas") => Normal("js.Any") //TODO: what to do with this?

      /* general */
      case (_, "valueLink", "object") => Normal("js.Any")
      case (_, _, "string") => Normal("String")
      case (_, _, "bool") => Normal("Boolean")
      case (_, "children", "element") => Normal("VdomElement")
      case (_, _, "element") => Normal("React.Element")
      case (_, "children", "node") => Normal("VdomNode")
      case (_, _, "node") => Normal("React.Node")
      case (_, _, "number") => Normal("Double")
      case (_, "children", "arrayOf(element)") => Normal("js.Array[React.Element]")

      case (_, _, "Mui.arrayOf") => Normal("js.Array[js.Any]")
      case (_, "valueLink", "Mui.object") => Normal("js.Any")
      case (_, _, "Mui.string") => Normal("String")
      case (_, _, "Mui.bool") => Normal("Boolean")
      case (_, "children", "Mui.element") => Normal("VdomElement")
      case (_, _, "Mui.element") => Normal("React.Element")
      case (_, "children", "Mui.node") => Normal("VdomNode")
      case (_, _, "Mui.node") => Normal("React.Node")
      case (_, _, "Mui.object") => Normal("js.Object")
      case (_, _, "Mui.number") => Normal("Double")
      case (_, "children", "Mui.arrayOf(Mui.element)") => Normal("js.Array[React.Element]")

      case ("AutoComplete", "popoverProps", "object") => Normal("js.Any")
      case ("RadioButtonGroup", "defaultSelected", "any") => Normal("js.Any")
      case ("RadioButtonGroup", "valueSelected", "any") => Normal("js.Any")
      case ("Stepper", "children", "arrayOf(node)") => Normal("VdomElement")
      /*Added by roberto@leibman.net*/
      case ("DatePicker", "utils", "object") => Normal("DatePickerUtils") //TODO ???
      case ("SelectField", "dropDownMenuProps", "object") => Normal("DropDownMenuProps") //TODO ???
      case (_, _, "_lib.customcontentShorthand") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case (_, _, "_lib.customcollectionShorthand") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case (_, _, "_lib.customitemShorthand") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case (_, "control", "_FormField2.default.propTypes.control") => Normal("js.Any") //TODO ???
      case ("GridColumn", "only", "_lib.customonlyProp(_lib.SUI.VISIBILITY)") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Image", "fluid", "_lib.customevery([Mui.bool, _lib.customdisallow(['size'])])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Image", "spaced", _) => Enum(compName, Seq("left", "right"), "LeftRight")
      case ("List", "relaxed", _) => Normal("js.Any") //TODO Enum, very
      case ("Menu", "floated", _) => Normal("js.Any") //TODO Enum, right
      case ("Menu", "icon", _) => Normal("js.Any") //TODO Enum, labeled
      case ("Menu", "tabular", _) => Normal("js.Any") //TODO Enum, right
      case ("Menu","onItemClick","_lib.customevery([_lib.customdisallow(['children']), Mui.func])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("MenuItem", "fitted", _) => Enum(compName, Seq("horizontally", "vertically"), "SuiHorizontallyOrVertically")
      case ("Segment", "padded", _) => Normal("Boolean | String") //TODO |Enum "very"
      case ("Dropdown", "allowAdditions", "_lib.customevery([_lib.customdemand(['options', 'selection', 'search']), Mui.bool])") => Normal("Boolean")
      case ("Dropdown", "children", "_lib.customevery([_lib.customdisallow(['options', 'selection']), _lib.customgivenProps({ children: Mui.any }, Mui.element)])") => Normal("VdomElement")
      case ("Dropdown", "options", "_lib.customevery([_lib.customdisallow(['children']), Mui.arrayOf(Mui.shape(_DropdownItem2.default.propTypes))])") => Normal("js.Array[SuiDropDownOption]")
      case ("Dropdown", "pointing", _) => Normal("Boolean | PointingDirection")
      case ("Dropdown", "selectedLabel", "_lib.customdemand") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Dropdown", "selectedLabel", "multiple") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Dropdown", "selection", "_lib.customevery([_lib.customdisallow(['children']), _lib.customdemand(['options']), Mui.bool])") => Normal("Boolean")
      case ("Dropdown", "trigger", "_lib.customevery([_lib.customdisallow(['selection', 'text']), Mui.node])") => Normal("VdomNode")
      case ("Dropdown", "defaultSelectedLabel", "_lib.customdemand") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Dropdown", "defaultSelectedLabel", "multiple") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Dropdown", "searchInput", "Mui.array") => Normal("js.Array[js.Object] | VdomNode | js.Object")
      case ("FormField", "control", _) => Enum(compName, Seq("button", "input", "select", "textarea"), "SuiFormFieldControlType")
      case ("FormField", "type", "_lib.customevery([_lib.customdemand(['control'])])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("FormGroup", "grouped", "_lib.customevery([_lib.customdisallow(['inline']), Mui.bool])") => Normal("Boolean")
      case ("FormGroup", "inline", "_lib.customevery([_lib.customdisallow(['grouped']), Mui.bool])") => Normal("Boolean")
      case ("Grid", "celled", _) => Normal("js.Any") //TODO Enum, internally
      case ("Grid", "divided", _) => Normal("js.Any") //TODO Enum, vertically
      case ("Grid", "padded", _) => Enum(compName, Seq("horizontally", "vertically"), "SuiHorizontallyOrVertically")
      case ("Grid", "relaxed", _) => Normal("js.Any") //TODO Enum, very
      case ("Grid","reversed","_lib.custommultipleProp(['computer', 'computer vertically', 'mobile', 'mobile vertically', 'tablet', 'tablet vertically'])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("GridColumn","only","_lib.custommultipleProp(_lib.SUI.VISIBILITY)") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("ListItem", "icon", "_lib.customevery([_lib.customdisallow(['image']), _lib.customitemShorthand])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("ListItem", "image", "_lib.customevery([_lib.customdisallow(['icon']), _lib.customitemShorthand])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Modal", "actions", "Mui.arrayOf(_lib.customitemShorthand)") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Modal", "dimmer", _) => Enum(compName, Seq("inverted", "blurring"), "SuiModalDimmer")
      case ("Modal", "mountNode", "Mui.any") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("ModalActions", "actions", "_lib.customevery([_lib.customdisallow(['children']), Mui.arrayOf(_lib.customitemShorthand)])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("ModalActions","onActionClick","_lib.customevery([_lib.customdisallow(['children']), Mui.func])") => Normal("ReactEvent => Callback") //TODO write this Missing in TypeMapper
      case ("Radio", "slider", "_Checkbox2.default.propTypes.slider") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Radio", "toggle", "_Checkbox2.default.propTypes.toggle") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Radio", "type", "_Checkbox2.default.propTypes.type") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Rating", "clearable", _) => Normal("js.Any") //TODO enum, auto
      case ("Checkbox", "radio", "_lib.customevery([Mui.bool, _lib.customdisallow(['slider', 'toggle'])])") => Normal("Boolean") //TODO write this Missing in TypeMapper
      case ("Checkbox", "slider", "_lib.customevery([Mui.bool, _lib.customdisallow(['radio', 'toggle'])])") => Normal("Boolean") //TODO write this Missing in TypeMapper
      case ("Checkbox", "toggle", "_lib.customevery([Mui.bool, _lib.customdisallow(['radio', 'slider'])])") => Normal("Boolean") //TODO write this Missing in TypeMapper
      case ("Popup","on", _) => Normal("js.Any") //TODO Enum, hover, click or focus
      case ("Popup","wide", _) => Normal("js.Any") //TODO Enum, very
      case ("Table","basic", _) => Normal("js.Any") //TODO Enum, very
      case ("Table","compact", _) => Normal("js.Any") //TODO Enum, very
      case ("Table","padded", _) => Normal("js.Any") //TODO Enum, very
      case ("Table","renderBodyRow","_lib.customevery([_lib.customdisallow(['children']), _lib.customdemand(['tableData']), Mui.func])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Table","tableData","_lib.customevery([_lib.customdisallow(['children']), _lib.customdemand(['renderBodyRow']), Mui.array])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("GridRow","only","_lib.custommultipleProp(_lib.SUI.VISIBILITY)") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("GridRow","reversed","_lib.custommultipleProp(['computer', 'computer vertically', 'mobile', 'mobile vertically', 'tablet', 'tablet vertically'])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Label","corner", _) => Enum(compName, Seq("left", "right"), "LeftRight")
      case ("Label","empty","_lib.customevery([Mui.bool, _lib.customdemand(['circular'])])") => Normal("js.Any") //TODO write this Missing in TypeMapper
      case ("Label","pointing", _) => Normal("js.Any") //TODO enum above, below, left, right
      case ("Label","ribbon", _) => Enum(compName, Seq("left", "right"), "LeftRight")
      case ("Search","results", _) => Normal("js.Object | js.Array[js.Object]") //TODO One of:  - array of Search.Result props e.g. `{ title: '', description: '' }` or     - object of categories e.g. `{ name: '', results: [{ title: '', description: '' }]`
      case ("SearchCategory","results","Mui.array") => Normal("js.Array[js.Object]") //TODO write this Missing in TypeMapper
      case (_, "attached", _) => Enum(compName, Seq("left", "right", "top", "bottom"), "SuiFourDirections")
      case ("List","onItemClick","_lib.customevery([_lib.customdisallow(['children']), Mui.func])") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (_, _, "Mui.func") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (_, _, "func") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (a, b, c) =>
        println(s"""case ("$a","$b","$c") => Normal("js.Any") //TODO write this Missing in TypeMapper""")
        Normal("js.Any /*//TODO: fix this in the TypeMapper*/")

    }
  }
}

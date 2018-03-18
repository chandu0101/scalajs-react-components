package com.olvind
package sui

object SuiTypeMapper extends TypeMapper {
  val typeT   = Normal("T").generic("T")
  val typeTJs = Normal("T").genericJs("T")

  def apply(compName: CompName, fieldName: PropName, typeString: String): Type = {
    def is(s: String) =
      fieldName.value.toLowerCase contains s.toLowerCase
    def split(drop: Int, s: String) =
      s.split("[\'\"\\(\\)\\[\\],\\s]").map(_.trim).filterNot(_.isEmpty).drop(drop)

    (compName.value, fieldName.value, typeString) match {
      case ("Input", "icon", _)      => Normal("SuiIconType")
      case ("Flag", "name", _)       => Normal("String | SuiCountry")
      case ("Header", "as", _)       => Normal("String | js.Function")
      case ("Header", "image", _)    => Normal("String | ReactElement")
      case ("Header", "icon", _)     => Normal("String | js.Object | ReactElement")
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
        Normal(splitted.map(t => apply(compName, fieldName, t)) map (_.name) mkString " | ")
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
      case (_, "valueLink", "object")          => Normal("js.Any")
      case (_, _, "string")                    => Normal("String")
      case (_, _, "bool")                      => Normal("Boolean")
      case (_, "children", "element")          => Normal("VdomElement")
      case (_, _, "element")                   => Normal("ReactElement")
      case (_, "children", "node")             => Normal("VdomNode")
      case (_, _, "node")                      => Normal("ReactNode")
      case (_, _, "number")                    => Normal("Double")
      case (_, "children", "arrayOf(element)") => Normal("js.Array[ReactElement]")

      case (_, _, "Mui.arrayOf")                       => Normal("js.Array[js.Any]")
      case (_, "valueLink", "Mui.object")              => Normal("js.Any")
      case (_, _, "Mui.string")                        => Normal("String")
      case (_, _, "Mui.bool")                          => Normal("Boolean")
      case (_, "children", "Mui.element")              => Normal("VdomElement")
      case (_, _, "Mui.element")                       => Normal("ReactElement")
      case (_, "children", "Mui.node")                 => Normal("VdomNode")
      case (_, _, "Mui.node")                          => Normal("ReactNode")
      case (_, _, "Mui.object")                        => Normal("js.Object")
      case (_, _, "Mui.number")                        => Normal("Double")
      case (_, "children", "Mui.arrayOf(Mui.element)") => Normal("js.Array[ReactElement]")

      case ("AutoComplete", "popoverProps", "object")     => Normal("js.Any")
      case ("RadioButtonGroup", "defaultSelected", "any") => Normal("js.Any")
      case ("RadioButtonGroup", "valueSelected", "any")   => Normal("js.Any")
      case ("Stepper", "children", "arrayOf(node)")       => Normal("js.Any")
      /*Added by roberto@leibman.net*/
      case ("DatePicker", "utils", "object")              => Normal("DatePickerUtils")   //TODO ???
      case ("SelectField", "dropDownMenuProps", "object") => Normal("DropDownMenuProps") //TODO ???

      case (_, _, "Mui.func") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (_, _, "func") =>
        Normal(SuiTypeMapperFunction(compName, fieldName))
      case (a, b, c) =>
        println(s"""case ("$a","$b","$c") => Normal("") //TODO write this Missing in TypeMapper""")
        Normal("js.Any /*//TODO: fix this in the TypeMapper*/")

    }
  }
}

package com.olvind
package eui

object EuiTypeMapper extends TypeMapper {
  val typeT   = Normal("T").generic("T")
  val typeTJs = Normal("T").genericJs("T")

  def apply(compName: CompName, fieldName: PropName, typeString: String): Type = {
    def is(s: String) =
      fieldName.value.toLowerCase contains s.toLowerCase
    def split(drop: Int, s: String) =
      s.split("[\'\"\\(\\)\\[\\],\\s]").map(_.trim).filterNot(_.isEmpty).drop(drop)

    (compName.value, fieldName.value, typeString) match {
      //      /* Double => Int */
      //      case (_, "autoHideDuration", "number") => Normal("Int")
      //
      //      /* specific */
      //      case ("AutoComplete", "dataSource", "Mui.array") => Normal("js.Array[String]")
      //
      //      /* general */
      case ("FormIconField", "iconKey", _)  => Normal("Octicons")
      case ("Dropdown", "items", _)         => Normal("js.Array[EuiDropdownMenuItem]")
      case ("Modal", "width", _)            => Normal("ModalSize | Double")
      case (_, _, "array")                  => Normal("js.Array[js.Any]")
      case (_, "children", "any")           => Normal("VdomNode")
      case (_, _, "any")                    => Normal("js.Any")
      case (_, _, "bool")                   => Normal("Boolean")
      case (_, _, "Form")                   => Normal("Form")
      case (_, _, "React.bool")             => Normal("Boolean")
      case (_, _, "string")                 => Normal("String")
      case (_, _, "React.string")           => Normal("String")
      case (_, _, "React.object")           => Normal("js.Object")
      case (_, _, "object")                 => Normal("js.Object")
      case (_, "children", "React.node")    => Normal("VdomNode")
      case (_, "children", "node")          => Normal("VdomNode")
      case (_, _, "React.node")             => Normal("ReactNode")
      case (_, "children", "React.element") => Normal("VdomNode")
      case (_, _, "React.element")          => Normal("React.Element")
      case (_, _, "number")                 => Normal("Double")
      case (_, _, "React.number")           => Normal("Double")
      case ("Glyph", "icon", _)             => Normal("Octicons")

      case ("FormField", "width", enum) => Enum(compName, split(1, enum), "FormFieldWidth")
      case ("Glyph", "type", enum)      => Enum(compName, split(1, enum), "GlyphType")
      case ("Form", "type", enum)       => Enum(compName, split(1, enum), "FormType")
      case (_, _, "React.oneOf(COLOR_VARIANTS)") =>
        Enum(
          compName,
          Seq("danger", "default", "primary", "success", "warning"),
          "ColorVariant"
        )

      case (_, _, "React.oneOf(BUTTON_SIZES)") =>
        Enum(
          compName,
          Seq("lg", "sm", "xs"),
          "ButtonSize"
        )
      case (_, _, "React.oneOf(NOTE_TYPES)") =>
        Enum(
          compName,
          Seq("default", "primary", "success", "warning", "danger"),
          "NoteType"
        )
      case (_, _, "React.oneOf(BUTTON_TYPES)") =>
        Enum(
          compName,
          Seq(
            "default",
            "default-primary",
            "default-success",
            "default-warning",
            "default-danger",
            "hollow-primary",
            "hollow-success",
            "hollow-warning",
            "hollow-danger",
            "primary",
            "success",
            "warning",
            "danger",
            "link",
            "link-text",
            "link-primary",
            "link-success",
            "link-warning",
            "link-danger",
            "link-cancel",
            "link-delete"
          ),
          "ButtonType"
        )
      case (_, _, "React.oneOf(ALERT_TYPES)") =>
        Enum(compName,
             Seq("danger", "error", "info", "primary", "success", "warning", "success_inverted"),
             "AlertType")
      case (_, _, enum) if enum.contains("oneOfType") => {
        val splitted = split(1, enum)
        Normal(splitted.map(t => apply(compName, fieldName, t))
          .filter(_.name.nonEmpty)
          .map(_.name)
          .toSet
          .mkString(" | "))
      }
      case (_, _, enum) if enum.contains("oneOf")          => Enum(compName, split(1, enum))
      case (_, "children", "React.arrayOf(React.element)") => Normal("js.Array[VdomElement]")
      case (_, _, "React.array")                           => Normal("js.Array[js.Object]")
      case ("FormSelect", "options", array)                => Normal("js.Array[FormSelectOption]")
      case (_, _, "func")                                  => Normal(EuiTypeMapperFunction(compName, fieldName))
      case (_, _, "React.func")                            => Normal(EuiTypeMapperFunction(compName, fieldName))
      //      case a=>
      //        println(a)
      //        throw new Error()

    }
  }
}

package com.olvind

object ParseComponent {
  val ignoredMembers: Set[String] =
    Set(
      "render",
      "componentDidMount",
      "componentWillMount",
      "componentWillReceiveProps",
      "componentDidUpdate",
      "componentWillUnmount",
      "shouldComponentUpdate"
    )

  def apply(
      scope: Map[CompName, requiresjs.FoundComponent],
      library: Library,
      comp: ComponentDef
  ): ParsedComponent = {

    val propTypes: Map[PropName, PropUnparsed] =
      scope
        .get(comp.name)
        .map(_.props)
        .getOrElse(
          panic(s"No Proptypes found for ${comp.name}")
        )

    val inheritedProps: Map[PropName, PropUnparsed] =
      comp.shared match {
        case None => Map.empty
        case Some(shared) =>
          scope
            .get(shared.name)
            .map(_.props)
            .getOrElse(
              panic(s"$comp: No Proptypes found for $shared")
            )
      }

    val methodClassOpt: Option[ParsedMethodClass] =
      scope
        .get(comp.name)
        .flatMap(_.methods)
        .map(_.filterNot(m ⇒
          ignoredMembers(m.name) || m.name.startsWith("handle") || m.name.startsWith("_")))
        .filter(_.nonEmpty)
        .map(
          members ⇒
            ParsedMethodClass(
              library.prefixOpt.getOrElse("") + comp.name + "M",
              members.toSeq.sortBy(_.name).map(library.memberMapper(comp.name))
          ))

    val basicFields: Seq[ParsedProp] =
      Seq(
        ParsedProp(PropName("key"), isRequired = false, Normal("String"), None, None, None),
        ParsedProp(PropName("ref"),
                   isRequired = false,
                   Normal(methodClassOpt.fold("String")(c => c.className + " => Unit")),
                   None,
                   None,
                   None)
      )

    val parsedProps: Seq[ParsedProp] =
      (inheritedProps ++ propTypes)
        .filterNot(t => basicFields.exists(_.name == t._1))
        .toSeq
        .sortBy(p => (p._2.fromComp != comp.name, p._1.clean.value))
        .map {
          case (propName, PropUnparsed(origComp, tpe, commentOpt)) =>
            ParseProp(
              library,
              comp.name,
              origComp,
              propName,
              tpe,
              commentOpt
            )
        }

    val domProps: Seq[ParsedProp] =
      comp.domeTypeOpt
        .map(domType => domType.handlers ++ domType.props)
        .toSeq
        .flatten
        .filterNot(p ⇒ parsedProps.exists(_.name == p.name))

    ParsedComponent(comp, basicFields ++ parsedProps ++ domProps, methodClassOpt)
  }
}

object ParseProp {
  //  "Deprecated(string, 'Instead, use a custom `actions` property.')"
  val Pattern = "Deprecated\\(([^,]+), '(.+)'\\)".r

  def apply(
      library: Library,
      compName: CompName,
      origCompName: CompName,
      propName: PropName,
      propString: PropTypeUnparsed,
      commentOpt: Option[PropComment]
  ): ParsedProp = {
    val _clean: String = propString.value
      .replace("PropTypes.", "")
      .replace(".isRequired", "")
      /* old style */
      .replace("_react2['default'].", "")
      //TODO: this is fairly mui specific, and actually breaks Sui
      .replace("_utilsPropTypes2['default'].", "Mui.")
      .replace("(0, _utilsDeprecatedPropType2['default'])", "Deprecated")
      /* new style */
      .replace("_react2.default.", "")
      .replace("_propTypes2.default.", "Mui.")
      .replace("(0, _deprecatedPropType2.default)", "Deprecated")
      /* even another style*/
      .replace("_react.", "")

    val (typeStr: String, deprecatedOpt: Option[String]) = _clean match {
      case Pattern(tpe, depMsg) => (tpe, Some(depMsg))
      case tpe                  => (tpe, None)
    }

    val mappedType: Type =
      library.typeMapper(origCompName, propName, typeStr)

    val isRequired: Boolean =
      propString.value.contains(".isRequired")

    val inheritedFrom: Option[CompName] =
      if (compName == origCompName) None else Some(origCompName)

    ParsedProp(
      propName,
      isRequired && inheritedFrom.isEmpty,
      mappedType,
      commentOpt,
      deprecatedOpt,
      inheritedFrom
    )
  }
}

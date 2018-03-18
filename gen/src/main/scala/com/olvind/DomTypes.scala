package com.olvind

case object DomNode    extends DomType("")
case object DomElement extends DomType("FromHtml")
case object DomInput extends DomType("FromInput") {

  private val formMethodType =
    com.olvind.Enum(CompName("Input"), Seq("get", "post"), "FormMethodType")
  private val formTarget = com.olvind.Enum(CompName("Input"),
                                           Seq("_blank", "_self", "_parent", "_top", "framename"),
                                           "FormTarget")
  private val inputAutoComplete =
    com.olvind.Enum(CompName("Input"), Seq("on", "off"), "AutoComplete")
  private val inputType = com.olvind.Enum(
    CompName("Input"),
    Seq(
      "button",
      "checkbox",
      "color",
      "date",
      "datetime-local",
      "email",
      "file",
      "hidden",
      "image",
      "month",
      "number",
      "password",
      "radio",
      "range",
      "reset",
      "search",
      "submit",
      "tel",
      "text",
      "time",
      "url",
      "week"
    ),
    "InputType"
  )
  private val inputEncodingType = com.olvind.Enum(
    CompName("Input"),
    Seq("application/x-www-form-urlencoded", "multipart/form-data", "text/plain"),
    "InputEncodingType")

  override val props = super.props ++
    Seq(
      ParsedProp(
        PropName("accept"),
        baseType = Normal("String"),
        commentOpt = Some(
          PropComment(
            "Specifies the types of files that the server accepts (only for type='file')"))
      ),
      ParsedProp(PropName("alt"),
                 baseType = Normal("String"),
                 commentOpt = Some(
                   PropComment("Specifies an alternate text for images (only for type='image')"))),
      ParsedProp(
        PropName("autocomplete"),
        baseType = inputAutoComplete,
        commentOpt =
          Some(PropComment("Specifies whether an <input> element should have autocomplete enabled"))
      ),
      ParsedProp(
        PropName("autofocus"),
        baseType = Normal("Boolean"),
        commentOpt = Some(
          PropComment(
            "Specifies that an <input> element should automatically get focus when the page loads"))
      ),
      ParsedProp(
        PropName("checked"),
        baseType = Normal("Boolean"),
        commentOpt = Some(PropComment(
          "Specifies that an <input> element should be pre-selected when the page loads (for type='checkbox' or type='radio')"))
      ),
      ParsedProp(PropName("dirname"),
                 baseType = Normal("Boolean"),
                 commentOpt =
                   Some(PropComment("Specifies that the text direction will be submitted"))),
      ParsedProp(PropName("disabled"),
                 baseType = Normal("Boolean"),
                 commentOpt =
                   Some(PropComment("Specifies that an <input> element should be disabled"))),
      ParsedProp(PropName("form"),
                 baseType = Normal("String"),
                 commentOpt =
                   Some(PropComment("Specifies one or more forms the <input> element belongs to"))),
      ParsedProp(
        PropName("formaction"),
        baseType = Normal("String"),
        commentOpt = Some(PropComment(
          "Specifies the URL of the file that will process the input control when the form is submitted (for type='submit' and type='image')"))
      ),
      ParsedProp(
        PropName("formenctype"),
        baseType = inputEncodingType,
        commentOpt = Some(PropComment(
          "Specifies how the form-data should be encoded when submitting it to the server (for type='submit' and type='image')"))
      ),
      ParsedProp(
        PropName("formmethod"),
        baseType = formMethodType,
        commentOpt = Some(PropComment(
          "Defines the HTTP method for sending data to the action URL (for type='submit' and type='image')"))
      ),
      ParsedProp(
        PropName("formnovalidate"),
        baseType = Normal("Boolean"),
        commentOpt =
          Some(PropComment("Defines that form elements should not be validated when submitted"))
      ),
      ParsedProp(
        PropName("formtarget"),
        baseType = formTarget,
        commentOpt = Some(PropComment(
          "Specifies where to display the response that is received after submitting the form (for type='submit' and type='image')"))
      ),
      ParsedProp(
        PropName("height"),
        baseType = Normal("Int"),
        commentOpt =
          Some(PropComment("Specifies the height of an <input> element (only for type='image')"))),
      ParsedProp(
        PropName("list"),
        baseType = Normal("String"),
        commentOpt = Some(PropComment(
          "Refers to a <datalist> element that contains pre-defined options for an <input> element"))
      ),
      ParsedProp(PropName("max"),
                 baseType = Normal("Long | String"),
                 commentOpt =
                   Some(PropComment("Specifies the maximum value for an <input> element"))),
      ParsedProp(
        PropName("maxlength"),
        baseType = Normal("Int"),
        commentOpt = Some(
          PropComment("Specifies the maximum number of characters allowed in an <input> element"))),
      ParsedProp(
        PropName("min"),
        baseType = Normal("Long | String"),
        commentOpt = Some(PropComment("Specifies a minimum value for an <input> element"))),
      ParsedProp(
        PropName("multiple"),
        baseType = Normal("Boolean"),
        commentOpt = Some(
          PropComment("Specifies that a user can enter more than one value in an <input> element"))
      ),
      ParsedProp(PropName("name"),
                 baseType = Normal("String"),
                 commentOpt = Some(PropComment("Specifies the name of an <input> element"))),
      ParsedProp(
        PropName("pattern"),
        baseType = Normal("String"),
        commentOpt = Some(
          PropComment(
            "Specifies a regular expression that an <input> element's value is checked against"))
      ),
      ParsedProp(
        PropName("placeholder"),
        baseType = Normal("String"),
        commentOpt = Some(
          PropComment(
            "Specifies a short hint that describes the expected value of an <input> element"))
      ),
      ParsedProp(PropName("readonly"),
                 baseType = Normal("Boolean"),
                 commentOpt = Some(PropComment("Specifies that an input field is read-only"))),
      ParsedProp(
        PropName("required"),
        baseType = Normal("Boolean"),
        commentOpt = Some(
          PropComment(
            "Specifies that an input field must be filled out before submitting the form"))
      ),
      ParsedProp(PropName("size"),
                 baseType = Normal("Int"),
                 commentOpt =
                   Some(PropComment("Specifies the width; in characters; of an <input> element"))),
      ParsedProp(
        PropName("src"),
        baseType = Normal("String"),
        commentOpt = Some(
          PropComment(
            "Specifies the URL of the image to use as a submit button (only for type='image')"))
      ),
      ParsedProp(PropName("step"),
                 baseType = Normal("Int"),
                 commentOpt =
                   Some(PropComment("Specifies the legal number intervals for an input field"))),
      ParsedProp(PropName("type"),
                 baseType = inputType,
                 commentOpt = Some(PropComment("Specifies the type <input> element to display"))),
      ParsedProp(PropName("value"),
                 baseType = Normal("String"),
                 commentOpt = Some(PropComment("Specifies the value of an <input> element "))),
      ParsedProp(
        PropName("width"),
        baseType = Normal("Int"),
        commentOpt =
          Some(PropComment("Specifies the width of an <input> element (only for type='image')")))
    )
}
case object DomTextArea extends DomType("FromTextArea")

sealed abstract class DomType(val suffix: String) {
  def props: Seq[ParsedProp] = Seq()

  private def handler(name: String, param: String): ParsedProp = {
    ParsedProp(
      name = PropName(name),
      isRequired = false,
      baseType = Normal(s"$param${suffix} => Callback"),
      commentOpt = None,
      deprecatedMsg = None,
      inheritedFrom = Some(CompName("DOM"))
    )
  }

  val handlers: Seq[ParsedProp] =
    Seq(
      handler("onAnimationEnd", "ReactEvent"),
      handler("onAnimationIteration", "ReactEvent"),
      handler("onAnimationStart", "ReactEvent"),
      handler("onBlur", "ReactFocusEvent"),
      handler("onChange", "ReactEvent"),
      handler("onClick", "ReactMouseEvent"),
      handler("onCompositionEnd", "ReactCompositionEvent"),
      handler("onCompositionStart", "ReactCompositionEvent"),
      handler("onCompositionUpdate", "ReactCompositionEvent"),
      handler("onContextMenu", "ReactEvent"),
      handler("onCopy", "ReactClipboardEvent"),
      handler("onCut", "ReactClipboardEvent"),
      handler("onDoubleClick", "ReactMouseEvent"),
      handler("onDrag", "ReactDragEvent"),
      handler("onDragEnd", "ReactDragEvent"),
      handler("onDragEnter", "ReactDragEvent"),
      handler("onDragExit", "ReactDragEvent"),
      handler("onDragLeave", "ReactDragEvent"),
      handler("onDragOver", "ReactDragEvent"),
      handler("onDragStart", "ReactDragEvent"),
      handler("onDrop", "ReactDragEvent"),
      handler("onFocus", "ReactFocusEvent"),
      handler("onInput", "ReactKeyboardEvent"),
      handler("onKeyDown", "ReactKeyboardEvent"),
      handler("onKeyPress", "ReactKeyboardEvent"),
      handler("onKeyUp", "ReactKeyboardEvent"),
      handler("onMouseDown", "ReactMouseEvent"),
      handler("onMouseEnter", "ReactMouseEvent"),
      handler("onMouseLeave", "ReactMouseEvent"),
      handler("onMouseMove", "ReactMouseEvent"),
      handler("onMouseUp", "ReactMouseEvent"),
      handler("onPaste", "ReactClipboardEvent"),
      handler("onScroll", "ReactUIEvent"),
      handler("onSelect", "ReactUIEvent"),
      handler("onSubmit", "ReactEvent"),
      handler("onTouchCancel", "ReactTouchEvent"),
      handler("onTouchEnd", "ReactTouchEvent"),
      handler("onTouchMove", "ReactTouchEvent"),
      handler("onTouchStart", "ReactTouchEvent"),
      handler("onTransitionEnd", "ReactTouchEvent"),
      handler("onWheel", "ReactWheelEvent")
    )
}

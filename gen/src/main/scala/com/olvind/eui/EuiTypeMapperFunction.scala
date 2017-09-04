package com.olvind
package eui

object EuiTypeMapperFunction {
  val Callback = "Callback"

  def apply(compName: CompName, name: PropName): String =
    (compName.value, name.value) match {
      case ("Dropzone", "onDrop")                     => "js.Array[File] => Callback" //TODO
      case ("Page", "onSelect")                       => Callback //TODO
      case ("Dropdown", "onSelect")                   => Callback //TODO
      case ("EmailInputGroup", "onChange")            => "ReactEventFromInput => Callback"
      case ("FileUpload", "onChange")                 => Callback //TODO
      case ("FormInput", "onChange")                  => "ReactEventFromInput => Callback"
      case ("FormSelect", "onChange")                 => "String => Callback"
      case ("ModalHeader", "onClose")                 => "ReactEventFromHtml => Callback"
      case ("Modal", "onCancel")                      => "ReactEventFromHtml => Callback"
      case ("Pagination", "onPageSelect")             => "Int => Callback" //TODO
      case ("PasswordInputGroup", "onChange")         => "ReactEventFromInput => Callback" //TODO
      case ("PasswordInputGroup", "validatePassword") => "String => CallbackTo[Boolean]"
      case ("Pill", "onClear")                        => "ReactEvent => Callback"
      case ("Pill", "onClick")                        => "ReactEventFromHtml => Callback"
      case ("RadioGroup", "onChange")                 => "String => Callback"
      case ("SegmentedControl", "onChange")           => Callback
      case _ =>
        throw new Error(
          s"""case ("${compName.value}", "${name.value}") => Callback  //TODO: Add function type mapping in ${getClass().getName}""")
    }
}

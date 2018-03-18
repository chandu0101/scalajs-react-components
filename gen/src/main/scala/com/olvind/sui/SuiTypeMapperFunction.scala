package com.olvind
package sui

object SuiTypeMapperFunction {
  val Callback = "Callback"

  def apply(compName: CompName, name: PropName): String =
    (compName.value, name.value) match {
      case (_, "onClick")  => "ReactMouseEventFromInput => Callback"
      case (_, "onChange") => "ReactEventFromInput => Callback"
      case _ =>
        throw new Error(
          s"""case ("${compName.value}", "${name.value}") => Callback  //TODO: Add function type mapping in ${getClass().getName}""")
    }
}

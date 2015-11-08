package chandu0101.scalajs.react.components
package materialui



class MuiProgressMode private(val value: String) extends AnyVal

object MuiProgressMode {

  val DETERMINATE = new MuiProgressMode("determinate")

  val INDETERMINATE = new MuiProgressMode("indeterminate")

  def newMode(mode: String) = new MuiProgressMode(mode)

}
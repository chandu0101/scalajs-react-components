package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui.{SemanticCOUNTRY, SuiDivider, SuiFlag, SuiSegment}
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object SuiFlagDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START


  case class Backend($: BackendScope[Unit, Unit]) {

    def render() =
      <.div(
        CodeExample(code, "SuiFlag")(
          <.b("A flag can use the two digit country code, the full name, or a common alias."),
          SuiSegment()(
            SuiFlag(name = SemanticCOUNTRY.AE)(),
            SuiFlag(name = SemanticCOUNTRY.INDIA)(),
            SuiFlag(name = SemanticCOUNTRY.FRANCE)(),
            SuiFlag(name = SemanticCOUNTRY.MYANMAR)()
          )
        )
      )
  }

  val component = ReactComponentB[Unit]("SuiFlagDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

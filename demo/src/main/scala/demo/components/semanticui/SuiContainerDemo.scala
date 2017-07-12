package demo.components.semanticui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.semanticui.{SemanticSIZES, SuiContainer, SuiIcon, SuiIconGroup}
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object SuiContainerDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START


  case class Backend($: BackendScope[Unit, Unit]) {

    def render() =
      <.div(
        CodeExample(code, "SuiContainer")(
          <.b("A standard container"),
          SuiContainer()(
            <.p("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa strong. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede link mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi.")
          )
        )
      )
  }

  val component = ScalaComponent.builder[Unit]("SuiContainerDemo")
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

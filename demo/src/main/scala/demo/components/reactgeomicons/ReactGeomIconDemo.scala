package demo
package components
package reactgeomicons

import chandu0101.scalajs.react.components.icons.{IconName, ReactGeomIcon}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ReactGeomIconDemo {

  val code =
    """
      | ReactGeomIcon(name = IconName.CAMERA ,width = "2em", height = "2em", fill = "red"),
      | ReactGeomIcon(name = IconName.CALENDAR ,width = "2em", height = "2em", fill = "blue"),
      | ReactGeomIcon(name = IconName.CHAT ,width = "2em", height = "2em", fill = "black"),
      | ReactGeomIcon(name = IconName.CHEVRONDOWN ,width = "2em", height = "2em", fill = "orange")
      |
    """.stripMargin

  case class State(value: String = "", multiValue: String = "")

  class Backend(t: BackendScope[_, State]) {
    def render(S: State) = {
      <.div(
        CodeExample(code, "Demo")(
          <.div(
            ReactGeomIcon(name = IconName.CAMERA, width = "2em", height = "2em", fill = "red")(),
            ReactGeomIcon(name = IconName.CALENDAR, width = "2em", height = "2em", fill = "blue")(),
            ReactGeomIcon(name = IconName.CHAT, width = "2em", height = "2em", fill = "black")(),
            ReactGeomIcon(name = IconName.CHEVRONDOWN, width = "2em", height = "2em", fill = "orange")()
          )
        )
      )
    }
  }

  val component = ReactComponentB[Unit]("ReactGeomIconDemo")
    .initialState(State())
    .renderBackend[Backend]
    .buildU

  def apply() = component()

}

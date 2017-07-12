package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiDropDownMenuDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Item(id: String, name: String)

  val items: Seq[Item] =
    Seq(
      Item("1", "Never"),
      Item("2", "Every Night"),
      Item("3", "Weeknights"),
      Item("4", "Weekends"),
      Item("5", "Weekly")
    )

  case class Backend($ : BackendScope[Unit, Item]) {
    val onChange: (TouchTapEvent, Int, Item) => Callback =
      (e, idx, value) => $.setState(value) >> Callback.info(s"idx: $idx, value: $value")

    def render(chosen: Item) =
      <.div(
        CodeExample(code, "MuiDropDownMenu")(
          MuiDropDownMenu(onChange = onChange, value = chosen)(
            items.map { item =>
              MuiMenuItem(key = item.id, value = item, primaryText = item.name)()
            }.toVdomArray
          )
        )
      )
  }
  val component = ScalaComponent
    .builder[Unit]("MuiDropDownMenuDemo")
    .initialState(items.head)
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

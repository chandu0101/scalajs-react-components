package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.{Px, Reusability}
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object MuiSvgIconDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class Props(icons: js.Array[(String, Int)])

  case class State(accepts: Accepts, hovered: js.UndefOr[String])

  case class Accepts(search: js.UndefOr[String]) {
    private val lower = search map (_.toLowerCase)
    def apply(name: String): Boolean =
      lower forall name.toLowerCase.contains
  }

  case class Backend($ : BackendScope[Props, State]) {
    implicit val r0 = Reusability.by_==[Props]
    implicit val r1 = Reusability.by_==[Accepts]

    def lookupIcon(name: String): MuiSvgIcon = {
      val lookup = Mui.SvgIcons.asInstanceOf[js.Dynamic]
      lookup.selectDynamic(name).asInstanceOf[MuiSvgIcon]
    }

    val select: String => ReactMouseEventH => Callback =
      name => e => $.modState(_.copy(hovered = name))

    val unselect: ReactMouseEventH => Callback =
      e => $.modState(_.copy(hovered = js.undefined))

    val onSearchChange: (ReactEventI, String) => Callback =
      (e, str) => $.modState(_.copy(accepts = Accepts(e.target.value)))

    /* rendering all icons turned out to be expensive, so
     *  we cache things based on search string */
    val renderedIconsPx: Px[js.Array[JsComponentU[MuiSvgIconProps, js.Any, TopNode]]] =
      Px.cbA($.props zip $.state.map(_.accepts)).map {
        case (p, accepts) =>
          p.icons collect {
            case (name, idx) if accepts(name) =>
              lookupIcon(name).apply(
                key = idx.toString,
                style = js.Dynamic.literal(width = "30px", height = "30px"),
                hoverColor = Mui.Styles.colors.amber500,
                onMouseEnter = select(name),
                onMouseLeave = unselect,
                viewBox = "0 0 30 30"
              )()
          }
      }

    def render(P: Props, S: State) =
      <.div(
        CodeExample(code, "MuiSvgIcons")(
          <.div(
            <.h4(s"Current icon: ${S.hovered.getOrElse("None")}"),
            <.label("Search: "),
            MuiTextField(value = S.accepts.search, onChange = js.defined(onSearchChange))()
          ),
          <.div(
            ^.height := "300px",
            ^.overflowY := "scroll",
            renderedIconsPx.value()
          )
        )
      )
  }
  val component = ReactComponentB[Props]("MuiSvgIconDemo")
    .initialState(State(Accepts(js.undefined), js.undefined))
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component(Props(js.Object.keys(Mui.SvgIcons).zipWithIndex))
}

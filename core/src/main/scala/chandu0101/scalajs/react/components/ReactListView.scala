package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._

object ReactListView {

  class Style extends StyleSheet.Inline {
    import dsl._

    val listGroup = style(
      marginBottom(20.px),
      paddingLeft.`0`,
      &.firstChild.lastChild(borderBottomLeftRadius(4 px), borderBottomRightRadius(4 px)))

    val listItem = styleF.bool(
      selected =>
        styleS(
          position.relative,
          display.block,
          padding(v = 10.px, h = 15.px),
          border :=! "1px solid #ecf0f1",
          cursor.pointer,
          mixinIfElse(selected)(color.white, fontWeight._500, backgroundColor :=! "#146699")(
            backgroundColor.white,
            &.hover(color :=! "#555555", backgroundColor :=! "#ecf0f1"))
      ))

  }

  object DefaultStyle extends Style

  case class State(filterText: String, selectedItem: String)

  class Backend(t: BackendScope[Props, State]) {

    def onTextChange(text: String): Callback =
      t.modState(_.copy(filterText = text))

    def onItemSelect(onItemSelect: js.UndefOr[String => Callback])(value: String): Callback = {
      val setSelected = t.modState(_.copy(selectedItem = value))
      val onSelect    = onItemSelect.asCbo(value)

      setSelected >> onSelect
    }

    def render(P: Props, S: State) = {
      val fItems =
        P.items.filter(item => item.toString.toLowerCase.contains(S.filterText.toLowerCase))
      <.div(
        P.showSearchBox ?= ReactSearchBox(onTextChange = onTextChange),
        <.ul(
          P.style.listGroup,
          fItems.map { item =>
            val selected = item.toString == S.selectedItem
            <.li(P.style.listItem(selected),
                 ^.onClick --> onItemSelect(P.onItemSelect)(item.toString),
                 item)
          }
        )
      )
    }
  }

  val component = ReactComponentB[Props]("ReactListView")
    .initialState(State(filterText = "", selectedItem = ""))
    .renderBackend[Backend]
    .build

  case class Props(items: List[String],
                   onItemSelect: js.UndefOr[String => Callback],
                   showSearchBox: Boolean,
                   style: Style)

  def apply(items: List[String],
            onItemSelect: js.UndefOr[String => Callback] = js.undefined,
            showSearchBox: Boolean = false,
            style: Style = DefaultStyle,
            ref: js.UndefOr[String] = js.undefined,
            key: js.Any = {}) =
    component.set(key, ref)(Props(items, onItemSelect, showSearchBox, style))

}

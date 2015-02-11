package chandu0101.scalajs.react.components.listviews


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object ReactListView {


  val component = ReactComponentB[Props]("ReactListView")
    .initialState(State())
    .backend(new Backend(_))
    .render((P, S, B) => {
    val fItems = P.items.filter(item => item.toString.toLowerCase.contains(S.filterText.toLowerCase))
    div(P.style.reactListView)(
      P.showSearchBox ?= ReactSearchBox(onTextChange = B.onTextChange),
      ul(P.style.listGroup)(
        fItems.zipWithIndex.map { case (item, index) => {
          val selected = item.toString == S.selectedItem
          val first = index == 0
          val last = index == fItems.length - 1
          val hover = S.hoverIndex == index
          li(P.style.listGroupItem, selected ?= P.style.selectedListGroupItem,
            first ?= P.style.firstListGroupItem,
            last ?= P.style.lastListGroupItem,
            hover ?= P.style.listGroupItemHover)(onClick --> B.onItemSelect(item.toString),
              onMouseEnter --> B.onMouseEnter(index),
              onMouseOut --> B.onMouseLeave(index))(item)
        }
        }
      )
    )
  })
    .build


  trait Style {

    def reactListView: TagMod = Seq[TagMod]()

    def listGroup: TagMod = Seq(marginBottom := "20px",
      paddingLeft := 0)

    def listGroupItem: TagMod = Seq(position := "relative",
      display := "block",
      padding := "10px 15px",
      marginBottom := "-1px",
      backgroundColor := "white",
      border := "1px solid #ecf0f1",
      cursor := "pointer")

    def selectedListGroupItem: TagMod = Seq(
      color := "white",
      fontWeight := 500,
      backgroundColor := "#146699"
    )

    def lastListGroupItem: TagMod = firstListGroupItem.+(marginBottom := 0)

    def firstListGroupItem: TagMod = Seq(borderBottomLeftRadius := "4px",
      borderBottomRightRadius := "4px")

    def listGroupItemHover: TagMod = Seq(color := "#555555",
      backgroundColor := "#ecf0f1")

  }

  case class State(filterText: String = "", selectedItem: String = "", hoverIndex: Int = -1)

  class Backend(t: BackendScope[Props, State]) {

    def onTextChange(text: String) = {
      t.modState(_.copy(filterText = text))
    }

    def onItemSelect(value: String) = {
      t.modState(_.copy(selectedItem = value, hoverIndex = -1))
      if (t.props.onItemSelect != null) t.props.onItemSelect(value)
    }

    def onMouseEnter(index: Int) = {
      t.modState(_.copy(hoverIndex = index))
    }

    def onMouseLeave(index: Int) = {
      t.modState(_.copy(hoverIndex = -1))
    }

  }

  case class Props(items: List[String], onItemSelect: StringUnit, showSearchBox: Boolean, style: Style)

  def apply(items: List[String], onItemSelect: StringUnit = null, showSearchBox: Boolean = false, style: Style = new Style {}, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(items, onItemSelect, showSearchBox, style))

}

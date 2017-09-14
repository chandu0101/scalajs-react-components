package chandu0101.scalajs.react.components.reacttable

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.component.Scala.BackendScope
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._

case class ReactTableRow[T](
  configs : Seq[ReactTable.ColumnConfig[T]],
  selectable : Boolean,
  multiSelectable : Boolean,
  data : T,
  selected : Boolean,
  style : ReactTableStyle
) {

  case class RowProps(
    configs : Seq[ReactTable.ColumnConfig[T]],
    data : T,
    selectable : Boolean,
    multiSelectable : Boolean,
    style : ReactTableStyle
  )

  case class RowState(
    selected : Boolean
  )

  class RowBackend(s : BackendScope[RowProps, RowState]) {

    def rowDiv(config : ReactTable.ColumnConfig[T]) : TagMod = {
      config.width match {
        case None => <.div(^.flex := "1" )
        case Some(w) => <.div(^.width := w)
      }
    }

    def render(p: RowProps, s: RowState) : VdomElement = {
      <.div(
        p.style.tableRow,
        p.configs.zipWithIndex.map { case (config, columnIndex) => rowDiv(config)(config.cellRenderer(p.data)) }.toTagMod
      )
//      <.tr(
//        props.style.tableRow,
//        <.input(
//          (^.`type` := "checkbox").when(props.multiSelectable),
//          (^.`type` := "radio").unless(props.multiSelectable),
//          ^.checked := state.selectedState.contains(index),
//          ^.onChange --> singleSelect(state.selectedState, index)
//        ).when(props.selectable),
//        props.configs.map(config =>
//          <.td(
//            ^.whiteSpace.nowrap.when(config.nowrap),
//            ^.verticalAlign.middle,
//            config.cellRenderer(model)
//          )
//        ).toTagMod
//      )

    }
  }

  val component = ScalaComponent.builder[RowProps]("ReactTableRow")
    .initialState(RowState(selected))
    .renderBackend[RowBackend]
    .build

  def apply() = component(RowProps(
    configs = configs,
    data = data,
    selectable = selectable,
    multiSelectable = multiSelectable,
    style = style
  ))()
}

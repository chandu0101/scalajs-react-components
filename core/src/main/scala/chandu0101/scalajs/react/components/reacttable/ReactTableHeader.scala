package chandu0101.scalajs.react.components.reacttable

import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Scala.BackendScope
import japgolly.scalajs.react.extra.components.TriStateCheckbox

import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._
import japgolly.scalajs.react.vdom.html_<^._

import chandu0101.scalajs.react.components.reacttable.SortDirection._

case class ReactTableHeader[T](
  configs : Seq[ReactTable.ColumnConfig[T]],
  allSelectable : Boolean,
  style : ReactTableStyle,
  allSelected : TriStateCheckbox.State,
  sortedState : Map[Int, SortDirection]
) {

  case class HeaderProps(
    configs : Seq[ReactTable.ColumnConfig[T]],
    allSelectable : Boolean,
    style : ReactTableStyle
  )

  case class HeaderState(
    allSelected : TriStateCheckbox.State
  )

  class HeaderBackend(s: BackendScope[HeaderProps, HeaderState]) {

    def render(p : HeaderProps, s : HeaderState): VdomElement = {

      def headerDiv(config : ReactTable.ColumnConfig[T]) : TagMod = {
        config.width match {
          case None => <.div(^.flex := "1" )
          case Some(w) => <.div(^.width := w)
        }
      }

      <.div(
        p.style.tableHeader,
        p.configs.zipWithIndex.map { case (config, columnIndex) => headerDiv(config)(config.name) }.toTagMod
      )

//      <.tr(
//        props.style.tableHeader,
//        <.th(
//          ^.textAlign := "left",
//          allCheckbox.when(
//            props.selectable && props.multiSelectable && props.allSelectable
//          )
//        ).when(props.selectable),
//        props.configs.zipWithIndex.map {
//          case (config, columnIndex) =>
//            val cell = getHeaderDiv(config)
//            cell(
//              ^.textAlign := "left",
//              ^.cursor := "pointer",
//              ^.onClick --> sort(config.ordering, columnIndex),
//              config.name.capitalize,
//              props.style
//                .sortIcon(
//                  state.sortedState.isDefinedAt(columnIndex) && state.sortedState(columnIndex) == ASC
//                )
//                .when(state.sortedState.isDefinedAt(columnIndex))
//            )
//        }.toTagMod
//      )

    }

  }

  val component = ScalaComponent.builder[HeaderProps]("ReactTableHeader")
    .initialState(HeaderState(allSelected))
    .renderBackend[HeaderBackend]
    .build

  def apply() = component(
    HeaderProps(
      configs, allSelectable, style
    )
  )
}
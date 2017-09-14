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
  sortedState : Map[Int, SortDirection],
  onToggleSort : (Int, SortDirection) => Callback,
  onToggleSelectAll : Boolean => Callback
) {

  case class HeaderProps(
    configs : Seq[ReactTable.ColumnConfig[T]],
    allSelectable : Boolean,
    style : ReactTableStyle,
    sortedState : Map[Int, SortDirection],
    allSelected : TriStateCheckbox.State
  )

  class HeaderBackend(b: BackendScope[HeaderProps, Unit]) {

    def render(p : HeaderProps): VdomElement = {

      val toggleSort : Int => Callback = { index : Int =>

        val dir: SortDirection = p.sortedState.get(index) match {
          case Some(ASC) => DSC
          case _ => ASC
        }

        onToggleSort(index, dir)
      }

      def headerDiv(config : ReactTable.ColumnConfig[T]) : TagMod = {
        config.width match {
          case None => <.div(^.flex := "1" )
          case Some(w) => <.div(^.width := w)
        }
      }

      <.div(
        p.style.tableHeader,
        <.div(
          style.selectColumn,
          TriStateCheckbox.Props(
            p.allSelected,
            onToggleSelectAll(p.allSelected.nextDeterminate == TriStateCheckbox.Checked)
          ).render
        ).when(p.allSelectable),
        p.configs.zipWithIndex.map { case (config, columnIndex) =>
          headerDiv(config)(
            ^.cursor := "pointer",
            ^.onClick --> toggleSort(columnIndex),
            config.name.capitalize,
            p.style.sortIcon(
              p.sortedState.isDefinedAt(columnIndex) && p.sortedState(columnIndex) == ASC
            )
            .when(p.sortedState.isDefinedAt(columnIndex))
          )
        }.toTagMod
      )
    }

  }

  val component = ScalaComponent.builder[HeaderProps]("ReactTableHeader")
    .renderBackend[HeaderBackend]
    .build

  def apply() = component(
    HeaderProps(
      configs = configs,
      allSelectable = allSelectable,
      allSelected = allSelected,
      style = style,
      sortedState = sortedState
    )
  )
}
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
  selectable : Boolean,
  allSelectable : Boolean,
  style : ReactTableStyle,
  allSelected : TriStateCheckbox.State,
  sortedState : Option[(Int, SortDirection)],
  onToggleSort : (Int, SortDirection) => Callback,
  onToggleSelectAll : Boolean => Callback
) {

  case class HeaderProps(
    configs : Seq[ReactTable.ColumnConfig[T]],
    selectable : Boolean,
    allSelectable : Boolean,
    style : ReactTableStyle,
    sortedState : Option[(Int, SortDirection)],
    allSelected : TriStateCheckbox.State
  )

  class HeaderBackend(b: BackendScope[HeaderProps, Unit]) {

    def render(p : HeaderProps): VdomElement = {

      val toggleSort : Int => Callback = { index : Int =>

        val dir: SortDirection = p.sortedState match {
          case Some((i, ASC)) if i == index => DSC
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
          ).render.when(p.allSelectable)
        ).when(p.selectable),
        p.configs.zipWithIndex.map { case (config, columnIndex) =>
          headerDiv(config)(
            ^.cursor := "pointer",
            ^.onClick --> toggleSort(columnIndex),
            config.name.capitalize,
            p.style.sortIcon(
              p.sortedState.isDefined && p.sortedState.get._1 == columnIndex && p.sortedState.get._2 == ASC
            )
            .when(p.sortedState.isDefined && p.sortedState.get._1 == columnIndex)
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
      selectable = selectable,
      allSelected = allSelected,
      style = style,
      sortedState = sortedState
    )
  )
}
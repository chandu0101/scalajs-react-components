package chandu0101.scalajs.react.components.reacttable

import japgolly.scalajs.react.{Callback, ScalaComponent}
import japgolly.scalajs.react.component.Scala.BackendScope
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.ProdDefaults._
import scalacss.ScalaCssReact._

case class ReactTableRow[T](
  configs : Seq[ReactTable.ColumnConfig[T]],
  selectable : Boolean,
  multiSelectable : Boolean,
  data : (T, String),
  selected : Boolean,
  style : ReactTableStyle,
  onSingleSelect : (T, String) => Callback
) {

  case class RowProps(
    configs : Seq[ReactTable.ColumnConfig[T]],
    data : (T, String),
    selectable : Boolean,
    multiSelectable : Boolean,
    style : ReactTableStyle,
    selected : Boolean
  )

  class RowBackend(s : BackendScope[RowProps, Unit]) {

    def rowDiv(config : ReactTable.ColumnConfig[T]) : TagMod = {
      config.width match {
        case None => <.div(^.flex := "1" )
        case Some(w) => <.div(^.width := w)
      }
    }

    def render(p: RowProps) : VdomElement = {
      <.div(
        p.style.tableRow.unless(p.selected),
        p.style.tableRowSelected.when(p.selected),
        <.div(
          style.selectColumn,
          <.input(
            (^.`type` := "checkbox").when(p.multiSelectable),
            (^.`type` := "radio").unless(p.multiSelectable),
            ^.checked := p.selected,
            ^.onChange --> onSingleSelect(data._1, data._2)
          )
        ).when(p.selectable),
        p.configs.zipWithIndex.map { case (config, columnIndex) =>
          rowDiv(config)(
            config.cellRenderer(p.data._1)
          )
        }.toTagMod
      )
    }
  }

  val component = ScalaComponent.builder[RowProps]("ReactTableRow")
    .renderBackend[RowBackend]
    .build
    .withKey(data._2)

  def apply() = component(RowProps(
    configs = configs,
    data = data,
    selectable = selectable,
    multiSelectable = multiSelectable,
    style = style,
    selected = selected
  ))()
}

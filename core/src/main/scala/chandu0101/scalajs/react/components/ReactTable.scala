package chandu0101.scalajs.react.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.collection.immutable
import scala.scalajs.js.Date
import scalacss.ScalaCssReact._

object ReactTable {

  val cssSettings = scalacss.devOrProdDefaults
  import cssSettings._

  type Model = Map[String, Any]

  /**
   *  ._1: String = column name
   *  ._2: Option[Any => VdomElement] = custom cell
   *  ._3: Option[(Model,Model) => Boolean] = sorting function
   *  ._4: Option[Double] = column width interms of flex property
   */
  type Config = (String, Option[Any => VdomElement], Option[(Model, Model) => Boolean],Option[Double])

  val ASC: String = "asc"
  val DSC: String = "dsc"

  class Style extends StyleSheet.Inline {

    import dsl._

    val reactTableContainer = style(display.flex,
      flexDirection.column)

    val table = style(display.flex,
      flexDirection.column,
      boxShadow := "0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.24)",
      media.maxWidth(740 px)(
        boxShadow := "none"
       )
      )

    val tableRow = style(display.flex,
      padding :=! "0.8rem",
      &.hover.apply(
        backgroundColor :=! "rgba(244, 244, 244, 0.77)"
      ),
      media.maxWidth(740 px)(
        display.flex,
        flexDirection.column,
        textAlign.center,
        boxShadow := "0 1px 3px grey",
        margin(5 px)
      ),
      unsafeChild("div")(
        flex := "1"
      )
    )

    val tableHeader = style(fontWeight.bold,
      borderBottom :=! "1px solid #e0e0e0",
      tableRow)

    val settingsBar = style(display.flex,
      margin :=! "15px 0",
      justifyContent.spaceBetween
    )

    val sortIcon = styleF.bool(ascending => styleS(
      &.after.apply(
        fontSize(9 px),
        marginLeft(5 px),
        if (ascending) content := "'\\25B2'"
        else content := "'\\25BC'"
      )
    ))

  }

  object DefaultStyle extends Style

  case class State(
    filterText: String,
    offset: Int,
    rowsPerPage: Int,
    filteredModels: Vector[Model],
    sortedState: Map[String, String]
  )

  class Backend(t: BackendScope[Props, State]) {

    def onTextChange(P: Props)(value: String): Callback =
      t.modState(_.copy(filteredModels = getFilteredModels(value, P.data), offset = 0))

    def onPreviousClick: Callback =
      t.modState(s => s.copy(offset = s.offset - s.rowsPerPage))

    def onNextClick: Callback =
      t.modState(s => s.copy(offset = s.offset + s.rowsPerPage))

    def getFilteredModels(text: String, models: Vector[Model]): Vector[Model] =
      if (text.isEmpty) models
      else models.filter(_.values.mkString.toLowerCase.contains(text.toLowerCase))

    def sort(f: (Map[String, Any], Map[String, Any]) => Boolean, item: String): Callback = 
      t.modState{ S => 
        val rows = S.filteredModels
        S.sortedState.getOrElse(item, "") match {
          case ASC => S.copy(filteredModels = rows.reverse, sortedState = Map(item -> DSC), offset = 0)
          case DSC => S.copy(filteredModels = rows.sortWith(f), sortedState = Map(item -> ASC), offset = 0)
          case _   => S.copy(filteredModels = rows.sortWith(f), sortedState = Map(item -> ASC), offset = 0)
        }
      }

    def onPageSizeChange(value: String): Callback = 
      t.modState(_.copy(rowsPerPage = value.toInt))

    def render(P: Props, S: State) =
      <.div(
        P.style.reactTableContainer,
        ReactSearchBox(
          onTextChange = onTextChange(P),
          style = P.searchBoxStyle).when(P.enableSearch),
        settingsBar((P, this, S)),
        tableC((P, S, this)),
        Pager(
          S.rowsPerPage,
          S.filteredModels.length,
          S.offset,
          onNextClick,
          onPreviousClick
        )
      )
  }

  def getIntSort(key: String) = (m1: Model, m2: Model) => m1(key).asInstanceOf[Int] < m2(key).asInstanceOf[Int]

  def getDoubleSort(key: String) = (m1: Model, m2: Model) => m1(key).asInstanceOf[Double] < m2(key).asInstanceOf[Double]

  def getLongSort(key: String) = (m1: Model, m2: Model) => m1(key).asInstanceOf[Long] < m2(key).asInstanceOf[Long]

  def getStringSort(key: String) = (m1: Model, m2: Model) => m1(key).toString < m2(key).toString

  def getDateSort(key: String) = (m1: Model, m2: Model) => m1(key).asInstanceOf[Date].getTime() < m2(key).asInstanceOf[Date].getTime()

  def getRenderFunction(key: String, config: List[Config]) = {
    val group = config.groupBy(_._1).getOrElse(key, Nil)
    if (group.nonEmpty) group.head._2 else None
  }

  def getSortFunction(key: String, config: List[Config]) = {
    val group = config.groupBy(_._1).getOrElse(key, Nil)
    if (group.nonEmpty) group.head._3 else None
  }

  def getColumnDiv(key: String, config: List[Config]) = {
    val group = config.groupBy(_._1).getOrElse(key, Nil)
    if (group.nonEmpty && group.head._4.isDefined) <.div(^.flex := group.head._4.get.toString)
    else <.div()
  }

  def arrowUp: TagMod =
    Seq(
      ^.width := "0",
      ^.height := "0",
      ^.borderLeft := "5px solid transparent",
      ^.borderRight := "5px solid transparent",
      ^.borderBottom := "5px solid black"
    ).toTagMod

  def arrowDown: TagMod =
    Seq(
      ^.width := "0",
      ^.height := "0",
      ^.borderLeft := "5px solid transparent",
      ^.borderRight := "5px solid transparent",
      ^.borderTop := "5px solid black"
    ).toTagMod

  def emptyClass: TagMod =
    Seq(^.padding := "1px").toTagMod

  val tableHeader = ScalaComponent.builder[(Props, Backend, State)]("reactTableHeader")
    .render{$ =>
      val (props, b, state) = $.props
      <.div(props.style.tableHeader)(
        if (props.config.nonEmpty) {
          props.columns.map { item => {
            val cell = getColumnDiv(item,props.config)
            val f    = getSortFunction(item, props.config)
            if (f.isDefined) {
              cell(^.cursor := "pointer",
                ^.onClick --> b.sort(f.get, item), item.capitalize,
                if (state.sortedState.isDefinedAt(item)) {
                  props.style.sortIcon(state.sortedState(item) == ASC)
                } else EmptyVdom
              )
            }
            else cell(item.capitalize)
          }
          }
        }.toTagMod
        else props.columns.map(s => <.div(s.capitalize)).toTagMod
      )
    }.build

  val tableRow = ScalaComponent.builder[(Model, Props)]("TableRow")
    .render{$ =>
      val (row, props) = $.props
      <.div(props.style.tableRow,
        if (props.config.nonEmpty) {
          props.columns.map { item =>
            val cell = getColumnDiv(item,props.config)
            val f = getRenderFunction(item, props.config)
            if (f.isDefined) cell(f.get(row(item)))
            else cell(row(item).toString)
          }
        }.toTagMod
        else props.columns.map { item => <.div(row(item).toString)}.toTagMod
      )
    }.build

  val tableC = ScalaComponent.builder[(Props, State, Backend)]("table")
    .render{$ =>
      val (props, state, b) = $.props
      val rows = state.filteredModels
        .slice(state.offset, state.offset + state.rowsPerPage)
        .zipWithIndex.map {
          case (row, i) => tableRow.withKey(i)((row, props))
        }
      <.div(props.style.table)(
        tableHeader((props, b, state)),
        rows.toTagMod
      )
    }.build

  val settingsBar = ScalaComponent.builder[(Props, Backend, State)]("settingbar")
    .render{$ =>
      val (p, b, s) = $.props
      var value = ""
      var options: List[String] = Nil
      val total = s.filteredModels.length
      if (total > p.rowsPerPage) {
        value = s.rowsPerPage.toString
        options = immutable.Range.inclusive(p.rowsPerPage, total, 10 * (total / 100 + 1)).:+(total).toList.map(_.toString)
      }
      <.div(p.style.settingsBar)(
        <.div(<.strong("Total: " + s.filteredModels.size)),
        DefaultSelect(label = "Page Size: ",
          options = options,
          value = value,
          onChange = b.onPageSizeChange)
      )
    }.build

  val component = ScalaComponent.builder[Props]("ReactTable")
    .initialStateFromProps(p => State(filterText = "", offset = 0, p.rowsPerPage, p.data, Map()))
    .renderBackend[Backend]
    .componentWillReceiveProps(e => Callback.when(e.currentProps.data != e.nextProps.data)
      (e.backend.onTextChange(e.nextProps)(e.state.filterText))
    ).build

  case class Props(data: Vector[Model],
                   columns: List[String],
                   config: List[Config],
                   rowsPerPage: Int,
                   style: Style,
                   enableSearch: Boolean,
                   searchBoxStyle: ReactSearchBox.Style)

  def apply(data: Vector[Model], columns: List[String], config: List[Config] = List(), rowsPerPage: Int = 5,
            style: Style = DefaultStyle, enableSearch: Boolean = true,
            searchBoxStyle: ReactSearchBox.Style = ReactSearchBox.DefaultStyle) =
    component(Props(data, columns, config, rowsPerPage, style, enableSearch, searchBoxStyle))
}

package demo.components.elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js.`|`

object EuiMiscDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(
      currentPage: Int = 1,
      pageSize: Int = 25,
      plural: String = "Potatoes",
      singular: String = "Potato",
      total: Int = 123,
      limit: Int = 5
  )

  case class Backend($ : BackendScope[Unit, State]) {
    def handleClear(event: ReactEvent) =
      $.modState(identity)

    def handlePageSelect(page: Int) =
      $.modState(_.copy(currentPage = page))

    def handleCurrentPageChange(event: ReactEventFromInput) = {
      val value = event.target.value.toInt match {
        case x if x < 0 => 0
        case x          => x
      }
      $.modState(_.copy(currentPage = value))
    }

    def handlePageSizeChange(event: ReactEventFromInput) = {
      val value = event.target.value.toInt match {
        case x if x > 100 => 100
        case x if x < 1   => 1
        case x            => x
      }
      $.modState(_.copy(pageSize = value))
    }

    def handleTotalChange(event: ReactEventFromInput) = {
      val value = event.target.value.toInt match {
        case x if x > 1000 => 1000
        case x if x < 1    => 1
        case x             => x
      }
      $.modState(_.copy(total = value))
    }

    def handleLimitChange(event: ReactEventFromInput) = {
      val value = event.target.value.toInt match {
        case x if x < 1 => 1
        case x          => x
      }
      $.modState(_.copy(limit = value))
    }

    def handlePluralChange(event: ReactEventFromInput) = {
      $.modState(_.copy(plural = event.target.value))
    }

    def handleSingularChange(event: ReactEventFromInput) =
      $.modState(_.copy(singular = event.target.value))

    def renderAlerts =
      <.div(
        EuiElementalAlert(`type` = AlertType.info)(
          <.strong("Info"),
          "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
        EuiElementalAlert(`type` = AlertType.success)(
          <.strong("Success"),
          "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
        EuiElementalAlert(`type` = AlertType.warning)(
          <.strong("Warning"),
          "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
        EuiElementalAlert(`type` = AlertType.danger)(
          <.strong("Error"),
          "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u")
      )

    def renderCards =
      <.div(
        EuiCard()("Hello, this is a very simple card, but blah blah blah"),
        EuiRow()(
          EuiCol(xs = "1/2")(EuiCard()("Use")),
          EuiCol(xs = "1/2")(EuiCard()("Me"))
        ),
        EuiRow()(
          EuiCol(xs = "1/3")(EuiCard()("In")),
          EuiCol(xs = "1/3")(EuiCard()("A")),
          EuiCol(xs = "1/3")(EuiCard()("Grid"))
        )
      )

    def renderPagination(S: State) =
      <.div(
        EuiPagination(
          currentPage = S.currentPage,
          onPageSelect = handlePageSelect _,
          pageSize = S.pageSize,
          plural = S.plural,
          singular = S.singular,
          total = S.total,
          limit = S.limit
        )(),
        EuiInputGroup()(
          EuiInputGroupSection(grow = true)(
            EuiFormField(label = "Current Page")(
              EuiFormInput(
                name = "currentPage",
                `type` = "number",
                value = S.currentPage: String | Int,
                onChange = handleCurrentPageChange _,
                placeholder = "Current Page"
              )()
            )
          ),
          EuiInputGroupSection(grow = true)(
            EuiFormField(label = "Page Size")(
              EuiFormInput(
                name = "pageSize",
                `type` = "number",
                value = S.pageSize: String | Int,
                onChange = handlePageSizeChange _,
                placeholder = "Page Size"
              )()
            )
          ),
          EuiInputGroupSection(grow = true)(
            EuiFormField(label = "Plural")(
              EuiFormInput(
                name = "plural",
                `type` = "number",
                value = S.plural: String | Int,
                onChange = handlePluralChange _,
                placeholder = "Plural"
              )()
            )
          ),
          EuiInputGroupSection(grow = true)(
            EuiFormField(label = "Singular")(
              EuiFormInput(
                name = "singular",
                `type` = "number",
                value = S.singular: String | Int,
                onChange = handleSingularChange _,
                placeholder = "Singular"
              )()
            )
          ),
          EuiInputGroupSection(grow = true)(
            EuiFormField(label = "Total")(
              EuiFormInput(
                name = "total",
                `type` = "number",
                value = S.total: String | Int,
                onChange = handleTotalChange _,
                placeholder = "Total"
              )()
            )
          ),
          EuiInputGroupSection(grow = true)(
            EuiFormField(label = "Limit")(
              EuiFormInput(
                name = "limit",
                `type` = "number",
                value = S.limit: String | Int,
                onChange = handleLimitChange _,
                placeholder = "Limit"
              )()
            )
          )
        )
      )

    def renderPills =
      <.div(
        EuiPill(label = "Create", `type` = AlertType.success_inverted)(),
        EuiPill(label = "First Pill", `type` = AlertType.primary, onClear = handleClear _)(),
        EuiPill(label = "Second Pill", `type` = AlertType.primary, onClear = handleClear _)(),
        EuiPill(label = "Third Pill", `type` = AlertType.primary, onClear = handleClear _)(),
        EuiPill(label = "Clear All")()
      )

    def render(S: State) =
      CodeExample(code, "EuiMisc")(
        <.div(
          <.h1("Miscellaneous"),
          <.h2("Alerts"),
          renderAlerts,
          <.h2("Cards"),
          renderCards,
          <.h2("Pagination"),
          renderPagination(S),
          <.h2("Pills"),
          renderPills
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("EuiMiscDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

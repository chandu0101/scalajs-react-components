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

  case class State(currentPage: Int = 1,
                   pageSize: Int = 25,
                   plural: String = "Potatoes",
                   singular: String = "Potato",
                   total: Int = 123,
                   limit: Int = 5
                  )

  case class Backend($: BackendScope[Unit, State]) {
    def handleClear(event: ReactEvent) =
      $.modState(identity)

    def handlePageSelect(page: Int) =
      $.modState(_.copy(currentPage = page))

    def handleCurrentPageChange(event: ReactEventFromInput) = {
      val value = event.target.value.toInt match {
        case x if x < 0 => 0
        case x => x
      }
      $.modState(_.copy(currentPage = value))
    }

    def handlePageSizeChange(event: ReactEventFromInput) = {
      val value = event.target.value.toInt match {
        case x if x > 100 => 100
        case x if x < 1 => 1
        case x => x
      }
      $.modState(_.copy(pageSize = value))
    }

    def handleTotalChange(event: ReactEventFromInput) = {
      val value = event.target.value.toInt match {
        case x if x > 1000 => 1000
        case x if x < 1 => 1
        case x => x
      }
      $.modState(_.copy(total = value))
    }

    def handleLimitChange(event: ReactEventFromInput) = {
      val value = event.target.value.toInt match {
        case x if x < 1 => 1
        case x => x
      }
      $.modState(_.copy(limit = value))
    }

    def handlePluralChange(event: ReactEventFromInput) = {
      val newValue = event.target.value
      $.modState(_.copy(plural = newValue))
    }

    def handleSingularChange(event: ReactEventFromInput) = {
      val newValue = event.target.value
      $.modState(_.copy(singular = newValue))
    }
    
    def renderAlerts = 
      <.div(
        Alert(`type` = AlertType.INFO)(<.strong("Info"), "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
        Alert(`type` = AlertType.SUCCESS)(<.strong("Success"), "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
        Alert(`type` = AlertType.WARNING)(<.strong("Warning"), "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
        Alert(`type` = AlertType.DANGER)(<.strong("Error"), "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"))

    def renderCards = 
      <.div(
        Card()("Hello, this is a very simple card, but blah blah blah"),
        Row()(
          Col(xs = "1/2")(Card()("Use")),
          Col(xs = "1/2")(Card()("Me"))),
        Row()(
          Col(xs = "1/3")(Card()("In")),
          Col(xs = "1/3")(Card()("A")),
          Col(xs = "1/3")(Card()("Grid"))))

    def renderPagination(S: State) = 
      <.div(
        Pagination(
          currentPage = S.currentPage,
          onPageSelect = handlePageSelect _,
          pageSize = S.pageSize,
          plural = S.plural,
          singular = S.singular,
          total = S.total,
          limit = S.limit
        )(),
        InputGroup()(
          InputGroupSection(grow = true)(
            FormField(label = "Current Page")(
              FormInput(
                name = "currentPage", 
                `type` = "number", 
                value = S.currentPage: String | Int,
                onChange = handleCurrentPageChange _, 
                placeholder = "Current Page")())
          ),
          InputGroupSection(grow = true)(
            FormField(label = "Page Size")(
              FormInput(
                name = "pageSize", 
                `type` = "number", 
                value = S.pageSize: String | Int,
                onChange = handlePageSizeChange _, 
                placeholder = "Page Size")()
            )
          ),
          InputGroupSection(grow = true)(
            FormField(label = "Plural")(
              FormInput(
                name = "plural", 
                `type` = "text",
                value = S.plural: String | Int,
                onChange = handlePluralChange _,
                placeholder = "Plural")()))
          ,
          InputGroupSection(grow = true)(
            FormField(label = "Singular")(
              FormInput(
                name = "singular", 
                `type` = "text",
                value = S.singular: String | Int,
                onChange = handleSingularChange _, 
                placeholder = "Singular")()))
          ,
          InputGroupSection(grow = true)(
            FormField(label = "Total")(
              FormInput(
                name = "total", 
                `type` = "number", 
                value = S.total: String | Int,
                onChange = handleTotalChange _, 
                placeholder = "Total")()))
          ,
          InputGroupSection(grow = true)(
            FormField(label = "Limit")(
              FormInput(
                name = "limit", 
                `type` = "number", 
                value = S.limit: String | Int,
                onChange = handleLimitChange _, 
                placeholder = "Limit")()
            )
          )
        )
      )

    def renderPills =
      <.div(
        Pill(label = "Create", `type` = PillType.success_inverted)(),
        Pill(label = "First Pill", `type` = PillType.primary, onClear = handleClear _)(),
        Pill(label = "Second Pill", `type` = PillType.primary, onClear = handleClear _)(),
        Pill(label = "Third Pill", `type` = PillType.primary, onClear = handleClear _)(),
        Pill(label = "Clear All")())

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

  val component = ScalaComponent.builder[Unit]("EuiMiscDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

package demo.components.elementalui

import chandu0101.scalajs.react.components.elementalui._
import demo.components.materialui.svgicons.ActionGrade
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.StyleSheet.Inline
import scala.scalajs.js.`|`

object EuiMiscDemo {

  case class State(
    currentPage: Int = 1,
    pageSize: Int = 25,
    plural: String = "Potatoes",
    singular: String = "Potato",
    total: Int = 123,
    limit: Int = 5)
  case class Backend($: BackendScope[Unit, State]) {
    def handleClear(event: ReactEvent) = {
      $.modState(identity)
    }
    def handlePageSelect(page: Int) = {
      $.modState(_.copy(currentPage = page))
    }
    def handleCurrentPageChange(event: ReactEventI) = {
      val value = (event.target.value).toInt match {
        case x if x < 0 ⇒ 0
        case x          ⇒ x
      }
      $.modState(_.copy(currentPage = value))
    }
    def handlePageSizeChange(event: ReactEventI) = {
      val value = (event.target.value).toInt match {
        case x if x > 100 ⇒ 100
        case x if x < 1   ⇒ 1
        case x            ⇒ x
      }
      $.modState(_.copy(pageSize = value))
    }
    def handleTotalChange(event: ReactEventI) = {
      val value = (event.target.value).toInt match {
        case x if x > 1000 ⇒ 1000
        case x if x < 1    ⇒ 1
        case x             ⇒ x
      }
      $.modState(_.copy(total = value))
    }
    def handleLimitChange(event: ReactEventI) = {
      val value = (event.target.value).toInt match {
        case x if x < 1 ⇒ 1
        case x          ⇒ x
      }
      $.modState(_.copy(limit = value))
    }
    def handlePluralChange(event: ReactEventI) = {
      $.modState(_.copy(plural = event.target.value))
    }
    def handleSingularChange(event: ReactEventI) = {
      $.modState(_.copy(singular = event.target.value))
    }
  }

  val component = ReactComponentB[Unit]("EuiMiscDemo")
    .initialState(State())
    .backend(Backend(_))
    .render($ ⇒ {
      def renderAlerts = {
        <.div(
          Alert(`type` = AlertType.INFO)(<.strong("Info"), "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
          Alert(`type` = AlertType.SUCCESS)(<.strong("Success"), "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
          Alert(`type` = AlertType.WARNING)(<.strong("Warning"), "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"),
          Alert(`type` = AlertType.DANGER)(<.strong("Error"), "Blah Blah Blah au au oeu oeau eouaoeu eou  aouo u"))
      }

      def renderCards = {
        <.div(
          Card()("Hello, this is a very simple card, but blah blah blah"),
          Row()(
            Col(xs = "1/2")(Card()("Use")),
            Col(xs = "1/2")(Card()("Me"))),
          Row()(
            Col(xs = "1/3")(Card()("In")),
            Col(xs = "1/3")(Card()("A")),
            Col(xs = "1/3")(Card()("Grid"))))
      }
      def renderPagination = {
        <.div(
          Pagination(
            currentPage = $.state.currentPage,
            onPageSelect = $.backend.handlePageSelect _,
            pageSize = $.state.pageSize,
            plural = $.state.plural,
            singular = $.state.singular,
            total = $.state.total,
            limit = $.state.limit)(),
          InputGroup()(
            InputGroupSection(grow = true)(FormField(label = "Current Page")(FormInput(name = "currentPage", `type` = "number", value = ($.state.currentPage: String | Int), onChange = $.backend.handleCurrentPageChange _, placeholder = "Current Page")())),
            InputGroupSection(grow = true)(FormField(label = "Page Size")(FormInput(name = "pageSize", `type` = "number", value = ($.state.pageSize: String | Int), onChange = $.backend.handlePageSizeChange _, placeholder = "Page Size")())),
            InputGroupSection(grow = true)(FormField(label = "Plural")(FormInput(name = "plural", `type` = "number", value = ($.state.plural: String | Int), onChange = $.backend.handlePluralChange _, placeholder = "Plural")())),
            InputGroupSection(grow = true)(FormField(label = "Singular")(FormInput(name = "singular", `type` = "number", value = ($.state.singular: String | Int), onChange = $.backend.handleSingularChange _, placeholder = "Singular")())),
            InputGroupSection(grow = true)(FormField(label = "Total")(FormInput(name = "total", `type` = "number", value = ($.state.total: String | Int), onChange = $.backend.handleTotalChange _, placeholder = "Total")())),
            InputGroupSection(grow = true)(FormField(label = "Limit")(FormInput(name = "limit", `type` = "number", value = ($.state.limit: String | Int), onChange = $.backend.handleLimitChange _, placeholder = "Limit")()))))
      }
      def renderPills = {
        <.div(
          Pill(label = "Create", `type` = PillType.success_inverted)(),
          Pill(label = "First Pill", `type` = PillType.primary, onClear = $.backend.handleClear _)(),
          Pill(label = "Second Pill", `type` = PillType.primary, onClear = $.backend.handleClear _)(),
          Pill(label = "Third Pill", `type` = PillType.primary, onClear = $.backend.handleClear _)(),
          Pill(label = "Clear All")())
      }

      <.div(
        <.h1("Miscellaneous"),
        <.h2("Alerts"),
        renderAlerts,
        <.h2("Cards"),
        renderCards,
        <.h2("Pagination"),
        renderPagination,
        <.h2("Pills"),
        renderPills)
    }).buildU
  def apply() = component()
}

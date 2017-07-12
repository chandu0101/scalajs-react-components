package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scalacss.Defaults._
import scalacss.ScalaCssReact._

object ScalaCSSTutorial {

  object Style extends StyleSheet.Inline {

    import dsl._
    val content = style(
      padding(80.px),
      unsafeChild("a")(
        color.red,
        margin(20.px),
        textDecoration := "none"
      )
    )
  }

  val basicCode =
    """
      |
      | //place this code at starting point of u r app / page where u using this component
      |
      | GlobalRegistry.register(ReactTable.DefaultStyle) // register style
      |
      | GlobalRegistry.addToDocumentOnRegistration() // add to html in runtime
      |
      |
    """.stripMargin

  val customCode =
    """
      |
      | object CustomTableStyle extends ReactTable.Style {
      |
      |  val original = new ReactTable.Style or  ReactTable.DefaultStyle // we need this hack as scala doesn't allow super.val :(
      |
      |  import dsl._
      |
      |  override val tableRow = style(original.tableRow.style,
      |     &.hover(
      |      backGroundColor.red
      |     )
      |   )
      | }
      |
      |// make sure you register ur new style
      | GlobalRegistry.register(CustomTableStyle)
      |
      |
      |
    """.stripMargin

  val component = ScalaComponent.static("ScalaCSSTutorial")(
    <.div(
      Style.content,
      <.div(
        <.h4("Basic Usage :"),
        <.p(
          "To use scalacss based components, u just need to register component style",
          <.br(),
          "For example if you want to use ReactTable component in ur project "
        ),
        <.pre(
          CodeHighlight(basicCode)
        ),
        <.a(
          ^.href := "https://github.com/chandu0101/scalajs-react-components/blob/master/demo/src/main/scala/chandu0101/scalajs/react/components/demo/css/AppCSS.scala",
          "real world example",
          ^.target := "_blank"
        )
      ),
      <.div(
        <.h4("Custom Styles:"),
        <.p(
          "If you want to customize style of a component then define a new style by extending base style class of component ",
          <.br(),
          "For example we want to add custom hover color for ReactTable component"
        ),
        <.pre(
          CodeHighlight(customCode)
        )
      )
    )
  )

  def apply() = component()

}

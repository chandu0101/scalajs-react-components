package demo
package components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._
import scalacss.ScalaCssReact._

object MuiPaperDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val component = ReactComponentB[Unit]("MuiPaperDemo")
    .render(P => {
      <.div(
        CodeExample(code, "MuiPaper")(
          <.div(Style.paperContainer,
            MuiPaper(zDepth = ZDepth._1)(<.p("zDepth = 1")),
            MuiPaper(zDepth = ZDepth._2)(<.p("zDepth = 2")),
            MuiPaper(zDepth = ZDepth._3)(<.p("zDepth = 3")),
            MuiPaper(zDepth = ZDepth._4)(<.p("zDepth = 4")),
            MuiPaper(zDepth = ZDepth._5)(<.p("zDepth = 5")),
            MuiPaper(zDepth = ZDepth._1, rounded = false)(<.p("rounded = false")),
            MuiPaper(zDepth = ZDepth._2, rounded = false)(<.p("rounded = false")),
            MuiPaper(zDepth = ZDepth._3, rounded = false)(<.p("rounded = false")),
            MuiPaper(zDepth = ZDepth._4, rounded = false)(<.p("rounded = false")),
            MuiPaper(zDepth = ZDepth._5, rounded = false)(<.p("rounded = false")),
            MuiPaper(zDepth = ZDepth._1, circle = true)(<.p("circle = true")),
            MuiPaper(zDepth = ZDepth._2, circle = true)(<.p("circle = true")),
            MuiPaper(zDepth = ZDepth._3, circle = true)(<.p("circle = true")),
            MuiPaper(zDepth = ZDepth._4, circle = true)(<.p("circle = true")),
            MuiPaper(zDepth = ZDepth._5, circle = true)(<.p("circle = true"))
          )
        )
      )
    }).buildU

  object Style extends StyleSheet.Inline {
    import dsl._
    val paperContainer = style(display.flex,
      flexWrap.wrap,
      paddingTop(20.px),
      unsafeChild("div")(
        margin(15 px),
        unsafeChild("p")(
          padding(15 px)
        )
      )
    )
  }

  // EXAMPLE:END

  def apply() = component()
}

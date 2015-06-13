package chandu0101.scalajs.react.components.demo.components.materialui

import chandu0101.scalajs.react.components.demo.components.CodeExample
import chandu0101.scalajs.react.components.materialui.{MuiPaper, MuiAppBar}
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scala.scalajs.js
import scala.scalajs.js.undefined
import scala.scalajs.js.UndefOr
import scalacss.Defaults._
import scalacss.ScalaCssReact._
object MuiPaperDemo {

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



  val code =
    """
      |  MuiPaper(zDepth = 1)(<.p("zDepth = 1")),
      |  MuiPaper(zDepth = 2)(<.p("zDepth = 2")),
      |  MuiPaper(zDepth = 3)(<.p("zDepth = 3")),
      |  MuiPaper(zDepth = 4)(<.p("zDepth = 4")),
      |  MuiPaper(zDepth = 5)(<.p("zDepth = 5")),
      |  MuiPaper(zDepth = 1,rounded = false)(<.p("rounded = false")),
      |  MuiPaper(zDepth = 2,rounded = false)(<.p("rounded = false")),
      |  MuiPaper(zDepth = 3,rounded = false)(<.p("rounded = false")),
      |  MuiPaper(zDepth = 4,rounded = false)(<.p("rounded = false")),
      |  MuiPaper(zDepth = 5,rounded = false)(<.p("rounded = false")),
      |  MuiPaper(zDepth = 1,circle = true)(<.p("circle = true")),
      |  MuiPaper(zDepth = 2,circle = true)(<.p("circle = true")),
      |  MuiPaper(zDepth = 3,circle = true)(<.p("circle = true")),
      |  MuiPaper(zDepth = 4,circle = true)(<.p("circle = true")),
      |  MuiPaper(zDepth = 5,circle = true)(<.p("circle = true"))
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("MuiPaperDemo")
    .render(P => {
    <.div(
      CodeExample(code, "MuiPaper")(
        <.div( Style.paperContainer,
          MuiPaper(zDepth = 1)(<.p("zDepth = 1")),
          MuiPaper(zDepth = 2)(<.p("zDepth = 2")),
          MuiPaper(zDepth = 3)(<.p("zDepth = 3")),
          MuiPaper(zDepth = 4)(<.p("zDepth = 4")),
          MuiPaper(zDepth = 5)(<.p("zDepth = 5")),
          MuiPaper(zDepth = 1,rounded = false)(<.p("rounded = false")),
          MuiPaper(zDepth = 2,rounded = false)(<.p("rounded = false")),
          MuiPaper(zDepth = 3,rounded = false)(<.p("rounded = false")),
          MuiPaper(zDepth = 4,rounded = false)(<.p("rounded = false")),
          MuiPaper(zDepth = 5,rounded = false)(<.p("rounded = false")),
          MuiPaper(zDepth = 1,circle = true)(<.p("circle = true")),
          MuiPaper(zDepth = 2,circle = true)(<.p("circle = true")),
          MuiPaper(zDepth = 3,circle = true)(<.p("circle = true")),
          MuiPaper(zDepth = 4,circle = true)(<.p("circle = true")),
          MuiPaper(zDepth = 5,circle = true)(<.p("circle = true"))
        )
      )
    )
  }).buildU


  def apply() = component()
}

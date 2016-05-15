package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._

object ReactTagsInputInfo {

   object Style extends StyleSheet.Inline {
       import dsl._
       val content = style(textAlign.center,
         fontSize(30.px),
         paddingTop(40.px))
     }

  val component = ReactComponentB[Unit]("ReactTagsInputInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "textfields/ReactTagsInput.scala")(
     <.div(
       <.h3("React Tags Input "),
       <.p("scalajs-react wrapper for ",
         RedLink("tags input","https://github.com/olahol/react-tagsinput")
       ),
       <.div(
        <.h4("Supported Version :"),
        <.span("3.0.3")
       ),
       <.div(
         <.h4("How To Use :"),
         <.p("Follow the installation guide from :",RedLink("here","https://github.com/olahol/react-tagsinput#install")
         )
       )
     )
    )

  }).build

  def apply() = component()
}

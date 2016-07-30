package demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._

object SpinnerInfo {

   object Style extends StyleSheet.Inline {
       import dsl._
       val content = style(textAlign.center,
         fontSize(30.px),
         paddingTop(40.px))
     }

  val component = ReactComponentB[Unit]("SpinnerInfo")
    .render(P => {
    InfoTemplate(componentFilePath = "spinners/Spinner.scala")(
     <.div(
       <.h3("Spinner "),
       <.p("scalajs-react wrapper for ",
         RedLink("react-spinner","https://github.com/chenglou/react-spinner")
       ),
       <.div(
        <.h4("Supported Version :"),
        <.span("0.2.2")
       ),
       <.div(
         <.h4("How To Use :"),
         <.p("Follow the installation guide from :",RedLink("here","https://github.com/chenglou/react-spinner#install")
         )
       )
     )
    )

  }).build

  def apply() = component()
}

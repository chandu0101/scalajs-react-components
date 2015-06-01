package chandu0101.scalajs.react.components.demo.pages.components.materialui


import chandu0101.scalajs.react.components.demo.pages.util.InfoTemplate
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

/**
 * Created by chandrasekharkode .
 */
object MInfo {


  val component = ReactComponentB[Unit]("MInfo")
    .render(P => {
      InfoTemplate(cssPath = "styles/materialui.css" ,componentFilePath = "materialui/MuiAppBar.scala")(
        <.p("This is ", <.a(^.target := "_blank", ^.href := "http://material-ui.com/#/")("material-ui"),"  port to scalajs -react")
      )
    }).buildU

  def apply() = component()
}

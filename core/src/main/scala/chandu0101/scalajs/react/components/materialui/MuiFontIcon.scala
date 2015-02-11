package chandu0101.scalajs.react.components.materialui


import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode on 2/7/15.
 */
object MuiFontIcon {


  val component = ReactComponentB[Props]("MuiFontIcon")
    .render(P => {
    span(cls := s"mui-font-icon ${P.className}", P.dynamicProps)
  }).build

  case class Props(className :String,dynamicProps: TagMod*)

  def apply(className : String,dynamicProps: TagMod*) = component(Props(className,dynamicProps))
}

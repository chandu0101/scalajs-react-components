package chandu0101.scalajs.react.components.demo.components.reacttable

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._


/**
 * Created by chandrasekharkode .
 */
object ReactTableInfo {
  val component = ReactComponentB[Unit]("reactableinfo")
    .render(P => {
   <.div(^.cls := "full-width-section")(
     <.h3("React Table :"),
      <.p("Responsive HTML table with the following features"),
      <.ul(^.paddingLeft := "25px")(
        <.li("Search"),
        <.li("Pagination"),
        <.li("Sorting"),
        <.li("Custom Css"),
        <.li("Custom Cell Factory")
      ),
     <.h3("CSS :"),
      <.p("Get it ",<.a(^.href := "#css")("here"))
    )
  }).buildU


  def apply() = component()
}

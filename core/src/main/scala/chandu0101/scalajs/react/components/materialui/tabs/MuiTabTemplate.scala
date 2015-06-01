package chandu0101.scalajs.react.components.materialui.tabs


import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
 * Created by chandrasekharkode on 2/7/15.
 */
object MuiTabTemplate {

    val component = ReactComponentB[Unit]("MuiTabTemplate")
      .render( (P,C) => {
        <.div( ^.cls := "mui-tab-template")(C)
      }).buildU

    def apply(children: ReactNode*) = component(children)

}

package chandu0101.scalajs.react.components.demo.pages

import chandu0101.scalajs.react.components.demo.codesamples.BootstrapSamples
import chandu0101.scalajs.react.components.demo.util.SingleSide
import chandu0101.scalajs.react.components.reactbootstrap.bootStrap
import japgolly.scalajs.react.ReactComponentB

import japgolly.scalajs.react.vdom.ReactVDom.ReactVExt_Attr
import japgolly.scalajs.react.vdom.ReactVDom.all._
import japgolly.scalajs.react.{BackendScope, ReactComponentB}

/**
 * Created by chandrasekharkode on 12/1/14.
 */
object BootstrapPage {

  val buttons = ReactComponentB[Unit]("buttons")
   .render(P => {
     div(
      bootStrap.Button()("Hello")
     )
  }).buildU



  val BootstrapDemos = ReactComponentB[Unit]("bootstrapdemo")
   .render(P => {
      div(
      SingleSide.component(BootstrapSamples.buttonsCode,buttons())
      )
  }).buildU



  def content = BootstrapDemos()

}

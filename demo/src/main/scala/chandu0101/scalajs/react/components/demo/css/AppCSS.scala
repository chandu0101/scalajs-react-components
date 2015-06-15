package chandu0101.scalajs.react.components.demo.css

import chandu0101.scalajs.react.components.demo.components.materialui._
import chandu0101.scalajs.react.components.demo.components.{LeftNavPage, LeftNav}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalacss.mutable.GlobalRegistry

object AppCSS {

  def load = {
    GlobalRegistry.register(LeftNav.Style,
    LeftNavPage.Style,
    MuiButtonsDemo.Style,
    MuiPaperDemo.Style,
    MuiSwitchesDemo.Style,
    MuiMenuDemo.Style,
    MuiTabsDemo.Style)
    GlobalRegistry.onRegistration(_.addToDocument())
  }
}

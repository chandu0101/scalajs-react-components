package demo
package css

import chandu0101.scalajs.react.components.listviews.ReactListView
import chandu0101.scalajs.react.components.searchboxes.ReactSearchBox
import chandu0101.scalajs.react.components.tables.{Pager, ReactTable}
import demo.components.materialui._
import demo.components.reactinfinite.ReactInfiniteDemo
import demo.components.{InfoTemplate, LeftNav, LeftNavPage, ScalaCSSTutorial}
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
      MobileTearSheet.Style,
      ReactTable.DefaultStyle,
      ReactListView.DefaultStyle,
      ReactSearchBox.DefaultStyle,
      Pager.DefaultStyle,
      ScalaCSSTutorial.Style,
      InfoTemplate.Style,
      ReactInfiniteDemo.styles,
      MuiTabsDemo.Style)
    GlobalRegistry.addToDocumentOnRegistration()
  }
}

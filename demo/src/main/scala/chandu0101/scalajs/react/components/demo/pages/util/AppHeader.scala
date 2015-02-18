package chandu0101.scalajs.react.components.demo.pages.util

import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{BackendScope, ReactComponentB}


import chandu0101.scalajs.react.components.util.MTypes
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scala.scalajs.js
import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss._


/**
 * Created by chandrasekharkode .
 */
object AppHeader {

  object Style {

    val headerStyle = Seq(background := "#F2706D",
      fontSize := "1.5em",
      padding := 0,
      margin := 0,
      position := "fixed",
      width := "100%",
      zIndex := "5")

    val menuNav = Seq( MsFlexAlign := "center" ,
      WebkitAlignItems := "center" ,
      WebkitBoxAlign := "center" ,
      alignItems := "center" ,
      display := "-ms-flexbox" ,
      display := "-webkit-box" ,
      display := "-webkit-flex" ,
      display := "flex" ,
      height := "64px" ,
      lineHeight := "64px" ,
      margin := "0 3rem" )

    val logo = Seq(
      color := "rgb(244, 233, 233)",
      textDecoration := "none",
      width := "150px"
    )

    val menuItem = Seq(
      padding := "20px",
      color := "rgb(244, 233, 233)",
      textDecoration := "none")

    val menuItemHover = Seq(background := "#f1453e")

  }

  case class State(menuHover: String = "")

  class Backend(t: BackendScope[_, State]) {

    def onMouseEnter(menu : String) = t.modState(_.copy(menuHover = menu))

    def onMouseLeave = t.modState(_.copy(menuHover = ""))

  }


  val component = ReactComponentB[Unit]("AppHeader")
    .initialState(State())
    .backend(new Backend(_))
    .render((P,S,B) => {
    val docs: String = "Docs"
    val github: String = "Github"
    header(Style.headerStyle)(
        nav(Style.menuNav)(
          a(Style.logo, href := "#")("S J R C"),
          div(marginLeft := "auto")(
            a(target :="_blank",(S.menuHover == docs) ?= Style.menuItemHover, Style.menuItem, href := "docs" ,onMouseEnter --> B.onMouseEnter(docs) ,onMouseLeave --> B.onMouseLeave)(docs),
            a(target :="_blank" ,(S.menuHover == github) ?= Style.menuItemHover,Style.menuItem, href := "https://github.com/chandu0101/scalajs-react-components",onMouseEnter --> B.onMouseEnter(github) ,onMouseLeave --> B.onMouseLeave)(github)
          )
        ))
    })
    .buildU

  def apply() = component()

}

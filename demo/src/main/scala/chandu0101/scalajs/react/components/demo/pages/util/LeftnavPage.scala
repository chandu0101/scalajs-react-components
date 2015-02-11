package chandu0101.scalajs.react.components.demo.pages.util


import chandu0101.scalajs.react.components.all._
import chandu0101.scalajs.react.components.demo.pages.components.demo.DemoLeftNav
import chandu0101.scalajs.react.components.demo.routes.AppRouter.AppPage
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object LeftnavPage {

  object Style {

    val leftNavPage = Seq( display := "-ms-flexbox" ,
      display := "-webkit-box" ,
      display := "-webkit-flex" ,
      display := "flex" ,
      paddingTop := "64px")

    val pageMenu = Seq(width := "190px",paddingTop := "20px")

    val pageBody = Seq( borderLeft := "solid 1px #e0e0e0" ,
      minHeight := "800px" ,
      flex := 1,
      padding := "20px" )

    val pageBodyContent = Seq( borderRadius := "2px" ,
      boxShadow := "0 1px 4px rgba(39, 54, 54, 0.79)" ,
      maxWidth := "1024px" )

    val contentDemo = Seq(padding := "40px")

    val contentCode =Seq( borderTop := "solid 1px #e0e0e0" ,
      padding := "20px"
    )


  }

    case class State(menuItemHover : Boolean = false,menuItemSelected : Boolean = false)

      class Backend( t: BackendScope[Props,State]) {

        def getSelectedMenuItem = {
          t.props.menu.filter { menu => menu.route == AppPage.currentRoute}.head.text
        }
      }

      val component = ReactComponentB[Props]("LeftnavPage")
       .initialState(State(false))
       .backend(new Backend(_))
       .render((P,S,B) => {
           div(Style.leftNavPage)(
            div(Style.pageMenu)(
             DemoLeftNav(menu = P.menu,selectedItem = B.getSelectedMenuItem)
            ),
            div(Style.pageBody)(
             P.content
            )
           )
         })
      .build
   case class Props(menu : List[DemoLeftNav.Menu] , content : ReactNode)

     def apply(menu : List[DemoLeftNav.Menu],content :ReactNode , ref: js.UndefOr[String] = "", key: js.Any = {} ) = component.set(key,ref)(Props(menu,content))

}

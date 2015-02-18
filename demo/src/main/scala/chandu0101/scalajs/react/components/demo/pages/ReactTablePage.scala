package chandu0101.scalajs.react.components.demo.pages

import chandu0101.scalajs.react.components.demo.pages.components.demo.DemoLeftNav
import chandu0101.scalajs.react.components.demo.pages.util.LeftnavPage
import chandu0101.scalajs.react.components.demo.routes.AppRouter.AppPage._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactElement}

/**
 * Created by chandrasekharkode .
 */
object ReactTablePage {

  lazy val menus = List(
    DemoLeftNav.Menu(route = reacttable.path.value, text = "Info"),
    DemoLeftNav.Menu(route = reactbasic.path.value, text = "Basic(Search,Pagination)"),
    DemoLeftNav.Menu(route = reactsort.path.value, text = "Sorting"),
    DemoLeftNav.Menu(route = reactcustomcss.path.value, text = "CustomCss"),
    DemoLeftNav.Menu(route = reactcustomcell.path.value, text = "CustomCellFactory")
  )



  case class State(checked: Boolean)

  class Backend(t: BackendScope[Props, State]) {

  }

  val component = ReactComponentB[Props]("ReactTablePage")
    .initialState(State(checked = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
    LeftnavPage(menus,P.content)
  })
    .build

  case class Props(content: ReactElement)

  def apply(content: ReactElement ) = component(Props(content))
}
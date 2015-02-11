package chandu0101.scalajs.react.components.demo.pages

import chandu0101.scalajs.react.components.demo.pages.components.demo.DemoLeftNav
import chandu0101.scalajs.react.components.demo.pages.util.LeftnavPage
import chandu0101.scalajs.react.components.demo.routes.AppRouter.AppPage._
import chandu0101.scalajs.react.components.demo.util.Components
import chandu0101.scalajs.react.components.mixins.AsyncLoad
import japgolly.scalajs.react._

/**
 * Created by chandrasekharkode .
 */
object MaterialUIPage {

  lazy val menus = List(
    DemoLeftNav.Menu(route = minfo.path.value, text = "Info"),
    DemoLeftNav.Menu(route = mbuttons.path.value, text = "Buttons"),
    DemoLeftNav.Menu(route = mdatepicker.path.value, text = "Date Picker"),
    DemoLeftNav.Menu(route = mdialog.path.value, text = "Dialog"),
    DemoLeftNav.Menu(route = mdropdown.path.value, text = "Dropdown Menu"),
    DemoLeftNav.Menu(route = miconbuttons.path.value, text = "Icon Buttons"),
    DemoLeftNav.Menu(route = minputs.path.value, text = "Inputs"),
    DemoLeftNav.Menu(route = mleftnav.path.value, text = "Left-Nav"),
    DemoLeftNav.Menu(route = mmenus.path.value, text = "Menus"),
    DemoLeftNav.Menu(route = mpaper.path.value, text = "Paper"),
    DemoLeftNav.Menu(route = mswitches.path.value, text = "Switches"),
    DemoLeftNav.Menu(route = mtoolbar.path.value, text = "Toolbar")
  )

  case class State(checked: Boolean)

  class Backend(t: BackendScope[Props, State]) extends AsyncLoad {
    cssResources = List(Components.MATERIAL_UI.cssPath)

  }

  val component = ReactComponentB[Props]("MaterialUIPage")
    .initialState(State(checked = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
    LeftnavPage(menus, P.content)
  })
    .configure(AsyncLoad.mixin)
    .build

  case class Props(content: ReactElement)

  def apply(content: ReactElement) = component(Props(content))
}

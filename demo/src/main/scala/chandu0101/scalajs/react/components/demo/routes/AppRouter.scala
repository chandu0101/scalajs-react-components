package chandu0101.scalajs.react.components.demo.routes


import chandu0101.scalajs.react.components.demo.components.AppHeader
import chandu0101.scalajs.react.components.demo.pages._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router2.{Resolution, RouterConfigDsl, RouterCtl, _}
import japgolly.scalajs.react.vdom.prefix_<^._

/**
 * Created by chandrasekharkode .
 */
object AppRouter {


  sealed trait Page

  case object Home extends Page

  case object Contribute extends Page

  case class ReactListViewPages(p: LeftRoute) extends Page

  case class ReactTreeViewPages(p: LeftRoute) extends Page

  case class ReactPopoverPages(p: LeftRoute) extends Page

  case class ReactTablePages(p: LeftRoute) extends Page

  case class GoogleMapPages(p: LeftRoute) extends Page


  val config = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._
    val reactListViewRoutes: Rule = ReactListViewRouteModule.routes.prefixPath_/("#reactlistview").pmap[Page](ReactListViewPages) { case ReactListViewPages(p) => p}
    val reactTreeViewRoutes: Rule = ReactTreeViewRouteModule.routes.prefixPath_/("#reacttreeview").pmap[Page](ReactTreeViewPages) { case ReactTreeViewPages(p) => p}
    val reactPopoverRoutes: Rule = ReactPopoverRouteModule.routes.prefixPath_/("#reactpopover").pmap[Page](ReactPopoverPages) { case ReactPopoverPages(p) => p}
    val reactTableRoutes: Rule = ReactTableRouteModule.routes.prefixPath_/("#reacttable").pmap[Page](ReactTablePages) { case ReactTablePages(p) => p}
    val googleMapRoutes: Rule = GoogleMapRouteModule.routes.prefixPath_/("#googlemap").pmap[Page](GoogleMapPages) { case GoogleMapPages(p) => p}
    (trimSlashes
      | staticRoute(root, Home) ~> renderR(ctrl => HomePage(ctrl))
      | staticRoute("#contribute", Contribute) ~> render(ContributePage())
      | reactListViewRoutes
      | reactTreeViewRoutes
      | reactTableRoutes
      | reactPopoverRoutes
      | googleMapRoutes
      ).notFound(redirectToPage(Home)(Redirect.Replace))
      .renderWith(layout)
  }


  def layout(c: RouterCtl[Page], r: Resolution[Page]) = {
    <.div(
      AppHeader(),
      r.render(),
      <.div(^.textAlign := "center", ^.key := "footer")(
        <.hr(),
        <.p("Built using scalajs-react")
      )
    )
  }


  val homePageMenu = Vector(
    HomePage.ComponentInfo(name = "React ListView", imagePath = "images/reactListView.png", route = ReactListViewPages(ReactListViewRouteModule.Info), tags = Stream("list view", "search", "listview")),
    HomePage.ComponentInfo(name = "Google Map", imagePath = "images/googleMap.png", route = GoogleMapPages(GoogleMapRouteModule.Info), tags = Stream("google", "map", "googlemap")),
    HomePage.ComponentInfo(name = "React TreeView", imagePath = "images/reactTreeView.png", route = ReactTreeViewPages(ReactTreeViewRouteModule.Info), tags = Stream("tree view", "search", "treeview")),
    HomePage.ComponentInfo(name = "React Table", imagePath = "images/reactTable.png", route = ReactTablePages(ReactTableRouteModule.Info), tags = Stream("table", "search", "pagination", "sorting", "cutom cell")),
    HomePage.ComponentInfo(name = "React Popover", imagePath = "images/reactPopover.png", route = ReactPopoverPages(ReactPopoverRouteModule.Info), tags = Stream("modal", "popover"))
  )


  val baseUrl = BaseUrl.fromWindowOrigin / "scalajs-react-components/"

  val router = Router(baseUrl, config)

}

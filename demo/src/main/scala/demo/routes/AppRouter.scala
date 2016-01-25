package demo
package routes

import demo.components.{ AppHeader, ScalaCSSTutorial }
import demo.pages._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom
import scala.scalajs.js.Dynamic.{ global => g }

object AppRouter {

  sealed trait Page

  case object Home extends Page

  case class EuiPages(p: LeftRoute) extends Page
  case class GoogleMapPages(p: LeftRoute) extends Page
  case class MuiPages(p: LeftRoute) extends Page
  case class ReactDraggablePages(p: LeftRoute) extends Page
  case class ReactGeomIconPages(p: LeftRoute) extends Page
  case class ReactInfinitePages(p: LeftRoute) extends Page
  case class ReactListViewPages(p: LeftRoute) extends Page
  case class ReactPopoverPages(p: LeftRoute) extends Page
  case class ReactSelectPages(p: LeftRoute) extends Page
  case class ReactSlickPages(p: LeftRoute) extends Page
  case class ReactTablePages(p: LeftRoute) extends Page
  case class ReactTagsInputPages(p: LeftRoute) extends Page
  case class ReactTreeViewPages(p: LeftRoute) extends Page
  case class SpinnerPages(p: LeftRoute) extends Page
  case object ScalaCSSDoc extends Page

  val config = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._
    val reactListViewRoutes: Rule =
      ReactListViewRouteModule.routes.prefixPath_/("#reactlistview")
        .pmap[Page](ReactListViewPages) { case ReactListViewPages(p) => p }

    val reactTreeViewRoutes: Rule =
      ReactTreeViewRouteModule.routes.prefixPath_/("#reacttreeview")
        .pmap[Page](ReactTreeViewPages) { case ReactTreeViewPages(p) => p }

    val reactPopoverRoutes: Rule =
      ReactPopoverRouteModule.routes.prefixPath_/("#reactpopover")
        .pmap[Page](ReactPopoverPages) { case ReactPopoverPages(p) => p }

    val reactTableRoutes: Rule =
      ReactTableRouteModule.routes.prefixPath_/("#reacttable")
        .pmap[Page](ReactTablePages) { case ReactTablePages(p) => p }

    val reactTagsInputRoutes: Rule =
      ReactTagsInputRouteModule.routes.prefixPath_/("#reacttagsinput")
        .pmap[Page](ReactTagsInputPages) { case ReactTagsInputPages(p) => p }

    val reactSelectRoutes: Rule =
      ReactSelectRouteModule.routes.prefixPath_/("#reactselect")
        .pmap[Page](ReactSelectPages) { case ReactSelectPages(p) => p }

    val reactGeomIconRoutes: Rule =
      ReactGeomIcontRouteModule.routes.prefixPath_/("#reactgeomicon")
        .pmap[Page](ReactGeomIconPages) { case ReactGeomIconPages(p) => p }

    val reactInfiniteRoutes: Rule =
      ReactInfiniteRouteModule.routes.prefixPath_/("#reactinite")
        .pmap[Page](ReactInfinitePages) { case ReactInfinitePages(p) => p }

    val reactDraggableRoutes: Rule =
      ReactJSDraggableRouteModule.routes.prefixPath_/("#reactdraggable")
        .pmap[Page](ReactDraggablePages) { case ReactDraggablePages(p) => p }

    val reactSlickRoutes: Rule =
      ReactSlickRouteModule.routes.prefixPath_/("#reactslick")
        .pmap[Page](ReactSlickPages) { case ReactSlickPages(p) => p }

    val googleMapRoutes: Rule =
      GoogleMapRouteModule.routes.prefixPath_/("#googlemap")
        .pmap[Page](GoogleMapPages) { case GoogleMapPages(p) => p }

    val muiRoutes: Rule =
      MuiRouteModule.routes.prefixPath_/("#materialui")
        .pmap[Page](MuiPages) { case MuiPages(p) => p }

    val euiRoutes: Rule =
      EuiRouteModule.routes.prefixPath_/("#elementalui")
        .pmap[Page](EuiPages) { case EuiPages(p) => p }

    val spinnerRoutes: Rule =
      SpinnerRouteModule.routes.prefixPath_/("#spinner")
        .pmap[Page](SpinnerPages) { case SpinnerPages(p) => p }


    (trimSlashes
      | staticRoute(root, Home) ~> renderR(ctrl => HomePage(ctrl))
      | staticRoute("#scalacss", ScalaCSSDoc) ~> render(ScalaCSSTutorial())
      | euiRoutes
      | googleMapRoutes
      | muiRoutes
      | reactDraggableRoutes
      | reactGeomIconRoutes
      | reactInfiniteRoutes
      | reactListViewRoutes
      | reactPopoverRoutes
      | reactSelectRoutes
      | reactSlickRoutes
      | reactTableRoutes
      | reactTagsInputRoutes
      | reactTreeViewRoutes
      | spinnerRoutes
      ).notFound(redirectToPage(Home)(Redirect.Replace))
      .renderWith(layout)
  }

  def layout(c: RouterCtl[Page], r: Resolution[Page]) = {
    <.div(
      AppHeader(),
      r.render(),
      <.div(^.textAlign := "center", ^.key := "footer")(
        <.hr(),
        <.p("Built using scalajs-react")))
  }

  val homePageMenu = Vector(
    HomePage.ComponentInfo(
      name = "Material UI",
      imagePath = g.materialuiImage.toString,
      route = MuiPages(MuiRouteModule.Info),
      tags = Stream("materialui", "material", "framework")
    ),
    HomePage.ComponentInfo(
      name = "Elemental UI",
      imagePath = g.elementaluiImage.toString,
      route = EuiPages(EuiRouteModule.Info),
      tags = Stream("materialui", "material", "framework")
    ),
    HomePage.ComponentInfo(
      name = "React ListView",
      imagePath = g.reactListViewImage.toString,
      route = ReactListViewPages(ReactListViewRouteModule.Info),
      tags = Stream("list view", "search", "listview")
    ),
    HomePage.ComponentInfo(
      name = "Google Map",
      imagePath = g.googleMapImage.toString,
      route = GoogleMapPages(GoogleMapRouteModule.Info),
      tags = Stream("google", "map", "googlemap")
    ),
    HomePage.ComponentInfo(
      name = "React TreeView",
      imagePath = g.reactTreeViewImage.toString,
      route = ReactTreeViewPages(ReactTreeViewRouteModule.Info),
      tags = Stream("tree view", "search", "treeview")
    ),
    HomePage.ComponentInfo(
      name = "React Table",
      imagePath = g.reactTableImage.toString,
      route = ReactTablePages(ReactTableRouteModule.Info),
      tags = Stream("table", "search", "pagination", "sorting", "cutom cell")
    ),
    HomePage.ComponentInfo(
      name = "React Tags Input",
      imagePath = g.reactTagsInputImage.toString,
      route = ReactTagsInputPages(ReactTagsInputRouteModule.Info),
      tags = Stream("tags", "input")
    ),
    HomePage.ComponentInfo(
      name = "React Select",
      imagePath = g.reactSelectImage.toString,
      route = ReactSelectPages(ReactSelectRouteModule.Info),
      tags = Stream("select", "multi", "search", "filter", "multi select")
    ),
    HomePage.ComponentInfo(
      name = "React GeomIcons",
      imagePath = g.reactGeomIconImage.toString,
      route = ReactGeomIconPages(ReactGeomIcontRouteModule.Info),
      tags = Stream("icons", "svg")
    ),
    HomePage.ComponentInfo(
      name = "React Infinite",
      imagePath = g.reactInfiniteImage.toString,
      route = ReactInfinitePages(ReactInfiniteRouteModule.Info),
      tags = Stream("infinite scroll", "listview")
    ),
    HomePage.ComponentInfo(
      name = "React Slick",
      imagePath = g.reactInfiniteImage.toString,
      route = ReactSlickPages(ReactSlickRouteModule.Info),
      tags = Stream("slick", "slick")
    ),
    HomePage.ComponentInfo(
      name = "Spinner",
      imagePath = g.spinnerImage.toString,
      route = SpinnerPages(SpinnerRouteModule.Info),
      tags = Stream("spinner")
    ),
    HomePage.ComponentInfo(
      name = "React Popover",
      imagePath = g.reactPopoverImage.toString,
      route = ReactPopoverPages(ReactPopoverRouteModule.Info),
      tags = Stream("modal", "popover")
    ),
    HomePage.ComponentInfo(
      name = "React Draggable",
      imagePath = g.reactDraggableImage.toString,
      route = ReactDraggablePages(ReactJSDraggableRouteModule.Info),
      tags = Stream("modal", "popover")
    )
  )

  val baseUrl =
    if (dom.window.location.hostname == "localhost")
      BaseUrl.fromWindowOrigin_/
    else
      BaseUrl.fromWindowOrigin / "sjrc/"

  val router = Router(baseUrl, config)

}

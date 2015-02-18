package chandu0101.scalajs.react.components.demo.routes


import chandu0101.scalajs.react.components.demo.pages._
import chandu0101.scalajs.react.components.demo.pages.components.googlemap._
import chandu0101.scalajs.react.components.demo.pages.components.materialui._
import chandu0101.scalajs.react.components.demo.pages.components.reactdraggable.{ReactDraggableDemo, ReactDraggableInfo}
import chandu0101.scalajs.react.components.demo.pages.components.reactlistview.{ReactListViewDemo, ReactListViewInfo}
import chandu0101.scalajs.react.components.demo.pages.components.reactpopover.{ReactPopoverDemo, ReactPopoverInfo}
import chandu0101.scalajs.react.components.demo.pages.components.reacttable._
import chandu0101.scalajs.react.components.demo.pages.components.reacttreeview.{ReactTreeViewDemo, ReactTreeViewInfo}
import chandu0101.scalajs.react.components.demo.pages.components.socialshareicons.{SocialShareIconInfo, SocialShareIconsDemo}
import chandu0101.scalajs.react.components.demo.pages.util.AppHeader
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.{BaseUrl, Redirect, RoutingRules}
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom

/**
 * Created by chandrasekharkode .
 */
object AppRouter {


  object AppPage extends RoutingRules {
    val root = register(rootLocation(HomePage()))
    val minfo: Loc = register(location("#materialui/info", MaterialUIPage(MInfo())))
    val mbuttons: Loc = register(location("#materialui/buttons", MaterialUIPage(MuiButtonsDemo())))
    val mdialog: Loc = register(location("#materialui/dialog", MaterialUIPage(MuiDialogDemo())))
    val mdropdown: Loc = register(location("#materialui/dropdown", MaterialUIPage(MuiDropdownMenuDemo())))
    val miconbuttons: Loc = register(location("#materialui/iconbuttons", MaterialUIPage(MuiIconButtonsDemo())))
    val minputs: Loc = register(location("#materialui/inputs", MaterialUIPage(MInputs())))
    val mtextFields: Loc = register(location("#materialui/textfields", MaterialUIPage(MuiTextFieldDemo())))
    val mleftnav: Loc = register(location("#materialui/leftnav", MaterialUIPage(MuiLeftNavDemo())))
    val mmenus: Loc = register(location("#materialui/menus", MaterialUIPage(MuiMenuDemo())))
    val mpaper: Loc = register(location("#materialui/paper", MaterialUIPage(MuiPaperDemo())))
    val mswitches: Loc = register(location("#materialui/switches", MaterialUIPage(MuiSwitchesDemo())))
    val mtoast: Loc = register(location("#materialui/toast", MaterialUIPage(MToast())))
    val mtoolbar: Loc = register(location("#materialui/toolbar", MaterialUIPage(MuiToolbarDemo())))
    val mdatepicker: Loc = register(location("#materialui/datepicker", MaterialUIPage(MuiDatePickerDemo())))

    // react table routes
    val reacttable: Loc = register(location("#reacttable/info", ReactTablePage(ReactTableInfo())))
    val reactbasic: Loc = register(location("#reacttable/basic", ReactTablePage(BasicReactTable())))
    val reactsort: Loc = register(location("#reacttable/sort", ReactTablePage(SortingReactTable())))
    val reactcustomcell: Loc = register(location("#reacttable/customcell", ReactTablePage(CustomCellReactTable())))
    val reactcustomcss: Loc = register(location("#reacttable/customcss", ReactTablePage(CustomCssReactTable())))

    // google maps routes
    val googleMapInfo: Loc = register(location("#googlemap/info", GoogleMapPage(GoogleMapInfo())))
    val mapbasic: Loc = register(location("#googlemap/basic", GoogleMapPage(BasicMap())))
    val mapmarkers: Loc = register(location("#googlemap/marker", GoogleMapPage(MarkersMap())))
    val mapmarkersicon: Loc = register(location("#googlemap/markericon", GoogleMapPage(CustomMarkerIcon())))
    val mapmarkerinfowindow: Loc = register(location("#googlemap/markerinfowindow", GoogleMapPage(MarkerInfoWindow())))


    // scoial share icons

    val socialShareIconsInfo: Loc = register(location("#socialshare/info", SocialShareIconsPage(SocialShareIconInfo())))

    val socialShareIconsDemo: Loc = register(location("#socialshare/demo", SocialShareIconsPage(SocialShareIconsDemo())))

    // react popover

    val reactPopoverInfo: Loc = register(location("#reactpopover/info", ReactPopoverPage(ReactPopoverInfo())))

    val reactPopoverDemo: Loc = register(location("#reactpopover/demo", ReactPopoverPage(ReactPopoverDemo())))


    // react draggable

    val reactDraggableInfo: Loc = register(location("#reactdraggable/info", ReactDraggablePage(ReactDraggableInfo())))

    val reactDraggableDemo: Loc = register(location("#reactdraggable/demo", ReactDraggablePage(ReactDraggableDemo())))


    // react treeview

    val reactTreeViewInfo: Loc = register(location("#reacttreeview/info", ReactTreeViewPage(ReactTreeViewInfo())))

    val reactTreeViewDemo: Loc = register(location("#reacttreeview/demo", ReactTreeViewPage(ReactTreeViewDemo())))


    //react ListView

    val reactListViewInfo: Loc = register(location("#reactlistview/info", ReactListViewPage(ReactListViewInfo())))

    val reactListViewDemo: Loc = register(location("#reactlistview/demo", ReactListViewPage(ReactListViewDemo())))


    // contribute page

    val contribute: Loc = register(location("#contribute", ContributePage()))


    register(removeTrailingSlashes)

    def currentRoute = dom.window.location.href.substring(baseUrl.value.length)

    override protected val notFound = redirect(root, Redirect.Replace)


    override protected def interceptRender(i: InterceptionR): ReactElement = {
      div(
        AppHeader(),
        i.element,
        div(textAlign := "center", key := "footer")(
          hr(),
          p("Built using scalajs-react")
        )
      )
    }


    def getTitle(loc: String) = {
      if (loc.contains("materialui")) "Material-UI"
      else if (loc.contains("reacttable")) "React Table"
      else ""
    }


  }

  case class State(selectedIndex: Long)

  class Backend(t: BackendScope[_, _]) {


  }


//  val baseUrl = BaseUrl.fromWindowOrigin / "scalajs-react-components/demo/"
  val baseUrl = BaseUrl.fromWindowOrigin / "sjrc/"
  val C = AppPage.router(baseUrl)

}

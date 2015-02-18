package chandu0101.scalajs.react.components.demo.util

import chandu0101.scalajs.react.components.demo.routes.AppRouter.AppPage._

/**
 * Created by chandrasekharkode .
 */

case class ComponentInfo(name: String, imagePath: String, url: String, cssPath: String, tags: Stream[String])

object Components {


  val MATERIAL_UI = ComponentInfo(name = "Material UI", imagePath = "images/mui.png", url = minfo.path.value, cssPath = "styles/materialui.css",
    tags = Stream("buttons", "menu", "left nav", "dropdown menu", "toggle", "radio buttons", "checkbox", "menu bar", "app bar", "icon", "icon buttons", "date picker"))

  val REACT_TABLE = ComponentInfo(name = "React Table", imagePath = "images/reactTable.png", url = reacttable.path.value, cssPath = "styles/reactTable.css",
    tags = Stream("table", "sorting", "pagination", "search", "custom cell"))

  val GOOGLE_MAP = ComponentInfo(name = "Google Map", imagePath = "images/googleMap.png", url = googleMapInfo.path.value, cssPath = "",
    tags = Stream("google map","geolocation","lat lng"))

  val REACT_POPOVER = ComponentInfo(name = "React Popover", imagePath = "images/reactPopover.png", url = reactPopoverInfo.path.value, cssPath = "styles/reactPopover.css",
    tags = Stream("popover","left","right","top","bottom"))

  val SOCIAL_SHARE = ComponentInfo(name = "Social Share", imagePath = "images/socialShare.png", url = socialShareIconsInfo.path.value, cssPath = "styles/socialShare.css",
    tags = Stream("twitter","facebook","google plus","pinterest","linked in"))

  val REACT_TREE_VIEW = ComponentInfo(name = "React TreeView", imagePath = "images/reactTreeView.png", url = reactTreeViewInfo.path.value, cssPath = "styles/reactTreeView.css",
    tags = Stream("tree view","search"))

  val REACT_LIST_VIEW = ComponentInfo(name = "React ListView", imagePath = "images/reactListView.png", url = reactListViewInfo.path.value, cssPath = "styles/reactListView.css",
    tags = Stream("list view","search"))

  val REACT_DRAGGABLE = ComponentInfo(name = "React Draggable", imagePath = "images/reactTreeView.png", url = reactDraggableInfo.path.value, cssPath = "styles/reactDraggable.css",
    tags = Stream("draggable","drag drop"))



  val all: List[ComponentInfo] =
    List(MATERIAL_UI,GOOGLE_MAP,REACT_POPOVER,REACT_TREE_VIEW,REACT_LIST_VIEW)

}

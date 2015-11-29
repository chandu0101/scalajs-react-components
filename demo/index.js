var injectTapEventPlugin = require('react-tap-event-plugin');
injectTapEventPlugin();

window.ReactDOM = require('react-dom');
window.React = require('react');
window.mui = require("material-ui");
window.elemental = require("elemental");
window.hljs = require("highlight.js");

//css
require("./styles/default.css");
require("./styles/site.css");

//use new menus
window.mui.Menu = require('material-ui/lib/menus/menu');
window.mui.MenuItem = require('material-ui/lib/menus/menu-item');
window.mui.MenuDivider = require('material-ui/lib/menus/menu-divider');

//images
var googleMapImage = require("./images/googleMap.png");
   reactListViewImage = require("./images/reactListView.png"),
   reactTreeViewImage = require("./images/reactTreeView.png"),
   elementaluiImage = require("./images/elementalui.png"),
   materialuiImage = require("./images/mui.png"),
   reactTableImage = require("./images/reactTable.png"),
   bottomTearImage = require("./images/bottom-tear.svg"),
   reactTagsInputImage = require("./images/reactTagsInput.png"),
   reactSelectImage = require("./images/reactSelect.png"),
   reactInfiniteImage = require("./images/reactInfinite.png"),
   reactGeomIconImage = require("./images/reactGeomIcon.png"),
   spinnerImage = require("./images/spinner.png"),
   reactPopoverImage = require("./images/reactPopover.png"),
   reactDraggableImage = require("./images/reactDraggable.png");


window.googleMapImage = googleMapImage;
window.bottomTearImage = bottomTearImage;
window.reactInfiniteImage = reactInfiniteImage;
window.reactTagsInputImage = reactTagsInputImage;
window.reactListViewImage = reactListViewImage;
window.reactTableImage = reactTableImage;
window.spinnerImage = spinnerImage;
window.reactPopoverImage = reactPopoverImage;
window.reactGeomIconImage = reactGeomIconImage;
window.materialuiImage = materialuiImage;
window.elementaluiImage = elementaluiImage;
window.reactTreeViewImage = reactTreeViewImage;
window.reactSelectImage = reactSelectImage;
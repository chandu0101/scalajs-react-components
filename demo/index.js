var React = require('react');
var ReactDOM = require('react-dom');
var mui = require("material-ui");
var elemental = require("elemental");
var injectTapEventPlugin = require('react-tap-event-plugin');
var highlight = require("./js/highlight.pak.js");

injectTapEventPlugin();

window.ReactDOM = ReactDOM;
window.React = React;
window.mui = mui;
window.elemental = elemental;

//css

require("./styles/default.css");
require("./styles/site.css");

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
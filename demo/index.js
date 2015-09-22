var React = require('react/addons'),
    mui = require("material-ui"),
    injectTapEventPlugin = require('react-tap-event-plugin');

injectTapEventPlugin();

window.mui = mui;

require("./js/highlight.pak.js")



window.React = React;




//css

require("./styles/default.css")



//images
var googleMapImage = require("./images/googleMap.png");
   reactListViewImage = require("./images/reactListView.png"),
   reactTreeViewImage = require("./images/reactTreeView.png"),
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
window.reactTreeViewImage = reactTreeViewImage;
window.reactSelectImage = reactSelectImage;
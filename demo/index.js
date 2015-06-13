var React = require('react/addons'),
    hljs = require("highlight.js"),
    mui = require("material-ui"),
    injectTapEventPlugin = require('react-tap-event-plugin');



injectTapEventPlugin();


window.React = React;
window.hljs = hljs;
window.mui = mui;


//images
var googleMapImage = require("./images/googleMap.png");
   reactListViewImage = require("./images/reactListView.png"),
   reactTreeViewImage = require("./images/reactTreeView.png"),
   materialuiImage = require("./images/mui.png"),
   reactTableImage = require("./images/reactTable.png"),
   reactPopoverImage = require("./images/reactPopover.png");


window.googleMapImage = googleMapImage;
window.reactListViewImage = reactListViewImage;
window.reactTableImage = reactTableImage;
window.reactPopoverImage = reactPopoverImage;
window.materialuiImage = materialuiImage;
window.reactTreeViewImage = reactTreeViewImage;
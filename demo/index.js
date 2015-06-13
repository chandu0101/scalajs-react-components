var React = require('react/addons'),
    mui = require("material-ui"),
    injectTapEventPlugin = require('react-tap-event-plugin');

require("./js/highlight.pak.js")

injectTapEventPlugin();


window.React = React;
window.mui = mui;



//css

require("./styles/default.css")



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
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
   reactPopoverImage = require("./images/reactPopover.png");


window.googleMapImage = googleMapImage;
window.bottomTearImage = bottomTearImage;
window.reactTagsInputImage = reactTagsInputImage;
window.reactListViewImage = reactListViewImage;
window.reactTableImage = reactTableImage;
window.reactPopoverImage = reactPopoverImage;
window.materialuiImage = materialuiImage;
window.reactTreeViewImage = reactTreeViewImage;
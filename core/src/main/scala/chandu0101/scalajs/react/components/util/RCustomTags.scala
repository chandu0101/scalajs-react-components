package chandu0101.scalajs.react.components
package util

import japgolly.scalajs.react.vdom.Implicits._

/**
 *
 * Eventually these should be copied to scalajs-react core
 */
trait RCustomTags {

  /*  styles  */
  val webkitTransform = "webkitTransform".reactStyle

  val webkitTransition = "webkitTransition".reactStyle

  val msTransform = "msTransform".reactStyle

  val mozTransform = "mozTransform".reactStyle

  val webkitBackgroundClip = "webkitBackgroundClip".reactStyle

  val WebkitBoxShadow = "WebkitBoxShadow".reactStyle

  val webkitAppearance = "webkitAppearance".reactStyle

  val webkitOverflowScrolling = "webkitOverflowScrolling".reactStyle

  val MsFlexAlign = "MsFlexAlign".reactStyle
  val WebkitAlignItems = "WebkitAlignItems".reactStyle
  val WebkitBoxAlign = "WebkitBoxAlign".reactStyle
  val MsFlexDirection = "MsFlexDirection".reactStyle
  val MsFlexPack = "MsFlexPack".reactStyle
  val WebkitBoxDirection = "WebkitBoxDirection".reactStyle
  val WebkitBoxOrient = "WebkitBoxOrient".reactStyle
  val WebkitBoxPack = "WebkitBoxPack".reactStyle
  val WebkitFlexDirection = "WebkitFlexDirection".reactStyle
  val WebkitJustifyContent = "WebkitJustifyContent".reactStyle

  val MsFlexWrap = "MsFlexWrap".reactStyle
  val WebkitFlexWrap = "WebkitFlexWrap".reactStyle

  val MsFlex = "MsFlex".reactStyle
  val WebkitBoxFlex = "WebkitBoxFlex".reactStyle
  val WebkitFlex = "WebkitFlex".reactStyle
  val alignSelf = "alignSelf".reactStyle

  val lineHeight2 = "lineHeight".reactStyle

  val MsFlexItemAlign = "MsFlexItemAlign".reactStyle
  val WebkitAlignSelf = "WebkitAlignSelf".reactStyle

  /* Attributes */

  val ariaLabel = "aria-label".reactAttr

  val onMouseEnter = "onMouseEnter".reactAttr

  val onMouseLeave = "onMouseLeave".reactAttr

  val onTouchEnd = "onTouchEnd".reactAttr

  val onTouchStart = "onTouchStart".reactAttr

  val points = "points".reactAttr

  val dsvg = "d".reactAttr

  val defaultChecked = "defaultChecked".reactAttr


  /* Tags */

  val svgtag = "svg".reactTag

  val polygon = "polygon".reactTag

}

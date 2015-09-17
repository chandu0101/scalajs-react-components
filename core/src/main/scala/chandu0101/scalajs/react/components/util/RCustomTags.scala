package chandu0101.scalajs.react.components
package util

import japgolly.scalajs.react.vdom.prefix_<^._

object RCustomTags extends RCustomTags

/**
 * Eventually these should be copied to scalajs-react core
 */
trait RCustomTags {

  /*  styles  */
  val MsFlexAlign =          "MsFlexAlign".reactStyle
  val MsFlexDirection =      "MsFlexDirection".reactStyle
  val MsFlexWrap =           "MsFlexWrap".reactStyle
  val WebkitAlignItems =     "WebkitAlignItems".reactStyle
  val WebkitBoxAlign =       "WebkitBoxAlign".reactStyle
  val WebkitBoxDirection =   "WebkitBoxDirection".reactStyle
  val WebkitBoxOrient =      "WebkitBoxOrient".reactStyle
  val WebkitBoxShadow =      "WebkitBoxShadow".reactStyle
  val WebkitFlexDirection =  "WebkitFlexDirection".reactStyle
  val WebkitFlexWrap =       "WebkitFlexWrap".reactStyle
  val mozTransform =         "mozTransform".reactStyle
  val msTransform =          "msTransform".reactStyle

  //todo: should these also have upper case W?
  val webkitBackgroundClip = "webkitBackgroundClip".reactStyle
  val webkitTransform =      "webkitTransform".reactStyle

  /* Attributes */
  val onMouseEnter = "onMouseEnter".reactAttr
  val onMouseLeave = "onMouseLeave".reactAttr
}

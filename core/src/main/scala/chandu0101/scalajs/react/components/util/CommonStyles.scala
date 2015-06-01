package chandu0101.scalajs.react.components.util

import japgolly.scalajs.react.vdom.prefix_<^._

/**
 * Created by chandrasekharkode .
 */
trait CommonStyles extends RCustomTags{

  val cursorPointer = ^.cursor := "pointer"

  val cursorDefault =  ^.cursor := "default"

  val displayInlineBlock = ^.display := "inline-block"

  val displayBlock = ^.display := "block"

  val textAlignCenter = ^.textAlign := "center"

  val textAlignLeft = ^.textAlign := "left"

  val textAlignRight = ^.textAlign := "right"

  val positionAbsolute = ^.position := "absolute"

  val positionRelative = ^.position := "relative"

  val overFlowHidden = ^.overflow := "hidden"

  val outlineNone= ^.outline := "none"



  def backgroundClipPreFixer(value : String) = Seq(^.backgroundClip := value, webkitBackgroundClip := value)

  def boxShadowPreFixer(value : String) = Seq(^.boxShadow := value,WebkitBoxShadow := value)

  def styleSet1(st1 : TagMod , more : (TagMod,Boolean) * ) : TagMod = {
     st1.+(more.filter(_._2).map(_._1))
  }
  def styleSet(styles : (TagMod,Boolean) * ) : TagMod = {
    styles.filter(_._2).map(_._1)
  }


}

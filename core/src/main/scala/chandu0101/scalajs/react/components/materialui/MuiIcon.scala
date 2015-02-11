package chandu0101.scalajs.react.components.materialui

import chandu0101.scalajs.react.components.materialui.styles.MaterialUICss
import chandu0101.scalajs.react.components.util.CommonUtils
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object MuiIcon {


  val component = ReactComponentB[Props]("icon")
    .render(P => {
    val isMuiCustomIcon = P.icon.indexOf("mui-icon") > -1
    val mdfiClassName = "mdfi_" + P.icon.replaceAll("-", "_")
    val iconClassName = if (isMuiCustomIcon) P.icon else mdfiClassName
    span(classSetM(CommonUtils.cssMapM(P.classNames, MaterialUICss.mui_icon -> true, iconClassName -> true)))
  }).build

  case class Props(classNames: Map[String, Boolean], icon: String)

  def apply(classNames: Map[String, Boolean] = Map(), icon: String , key : js.Any = {}, ref : js.UndefOr[String] =  "") = component.set(key = key,ref = ref)(Props(classNames,icon))

}

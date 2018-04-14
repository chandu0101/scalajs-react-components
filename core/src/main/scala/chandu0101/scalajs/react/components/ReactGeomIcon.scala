package chandu0101.scalajs.react.components

import chandu0101.macros.tojs.JSMacro
import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("react-geomicons", JSImport.Default) @js.native
object ReactGeomIconRequire extends js.Any

case class ReactGeomIcon(
    name: IconName,
    height: js.UndefOr[String] = js.undefined,
    ref: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    fill: js.UndefOr[String] = js.undefined,
    width: js.UndefOr[String] = js.undefined
) {

  def apply() = {
    val props = JSMacro[ReactGeomIcon](this)
    val f     = JsComponent[js.Object, Children.None, Null](ReactGeomIconRequire)
    f(props)
  }
}

class IconName private (val value: String) extends AnyVal

object IconName {
  val BOOKMARK       = new IconName("bookmark")
  val CALENDAR       = new IconName("calendar")
  val CAMERA         = new IconName("camera")
  val CHAT           = new IconName("chat")
  val CHECK          = new IconName("check")
  val CHEVRONDOWN    = new IconName("chevronDown")
  val CHEVRONLEFT    = new IconName("chevronLeft")
  val CHEVRONRIGHT   = new IconName("chevronRight")
  val CHEVRONUP      = new IconName("chevronUp")
  val CLOCK          = new IconName("clock")
  val CLOSE          = new IconName("close")
  val CLOUD          = new IconName("cloud")
  val COG            = new IconName("cog")
  val COMPOSE        = new IconName("compose")
  val DRIBBBLE       = new IconName("dribbble")
  val EXPAND         = new IconName("expand")
  val EXTERNAL       = new IconName("external")
  val FACEBOOK       = new IconName("facebook")
  val FILE           = new IconName("file")
  val FOLDER         = new IconName("folder")
  val GEOLOCATION    = new IconName("geolocation")
  val GITHUB         = new IconName("github")
  val GRID           = new IconName("grid")
  val HEART          = new IconName("heart")
  val HOME           = new IconName("home")
  val INFO           = new IconName("info")
  val LINK           = new IconName("link")
  val LIST           = new IconName("list")
  val LOCK           = new IconName("lock")
  val MAIL           = new IconName("mail")
  val MUSIC_NOTE     = new IconName("musicNote")
  val NEXT           = new IconName("next")
  val NO             = new IconName("no")
  val PAUSE          = new IconName("pause")
  val PICTURE        = new IconName("picture")
  val PIN            = new IconName("pin")
  val PLAY           = new IconName("play")
  val PREVIOUS       = new IconName("previous")
  val REFRESH        = new IconName("refresh")
  val REPOST         = new IconName("repost")
  val SEARCH         = new IconName("search")
  val SHOPPING_CART  = new IconName("shoppingCart")
  val SKULL          = new IconName("skull")
  val SPEAKER        = new IconName("speaker")
  val SPEAKER_VOLUME = new IconName("speakerVolume")
  val STAR           = new IconName("star")
  val TAG            = new IconName("tag")
  val TRASH          = new IconName("trash")
  val TRIANGLE_DOWN  = new IconName("triangleDown")
  val TRIANGLE_LEFT  = new IconName("triangleLeft")
  val TRIANGLE_RIGHT = new IconName("triangleRight")
  val TRIANGLE_UP    = new IconName("triangleUp")
  val TWITTER        = new IconName("twitter")
  val USER           = new IconName("user")
  val VIDEO          = new IconName("video")
  val WARNING        = new IconName("warning")

  def newName(name: String) = new IconName(name)
}

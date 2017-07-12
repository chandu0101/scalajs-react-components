package chandu0101.scalajs.react.components
package fascades

import japgolly.scalajs.react.vdom.TopNode
import org.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scala.scalajs.js.annotation.JSName

@js.native @JSName("google.maps.LatLng")
class GLatLng(lat: Double, lng: Double) extends js.Object

@js.native @JSName("google.maps.Map")
class GMap(node: TopNode, options: js.Dynamic) extends js.Object {
  def setCenter(latLng: GLatLng): Unit = js.native
}

@js.native @JSName("google.maps.Point")
class GPoint(x: Int, y: Int) extends js.Object

@js.native @JSName("google.maps.Size")
class GSize(width: Int, height: Int) extends js.Object

@js.native @JSName("google.maps.Marker")
class GMarker(ops: js.Dynamic) extends js.Object {
  def setMap(map: GMap): Unit = js.native
}

@js.native @JSName("google.maps.InfoWindow")
class GInfoWindow extends js.Object {
  def setContent(content: String): Unit = js.native

  def open(map: GMap, marker: GMarker): Unit = js.native
}

@js.native @JSName("google.maps.event")
class GEvent extends js.Object {
  def addListener(marker: GMarker, tpe: String, callback: js.Function0[Unit]): Unit = js.native

  def addListener(marker: GMarker, tpe: String, callback: js.Function1[Event, Unit]): Unit = js.native
}

@js.native @JSName("google.maps.event.addListener")
class GAddListener(marker: GMarker, tpe: String, callback: js.Function) extends js.Object

@js.native @JSName("google.maps.event.clearInstanceListeners")
class GClearInstanceListeners(marker: GMarker) extends js.Object

@js.native @JSName("google.maps.event.clearListeners")
class GClearListeners(marker: GMarker, `type`: String) extends js.Object

case class Point(x: Int, y: Int) {
  def toGPoint = new GPoint(x, y)
}

case class Size(width: Int, height: Int) {
  def toGSize = new GSize(width, height)
}

/*
     url = image location
     size = This marker is 20 pixels wide by 32 pixels tall.
     origin = The origin for this image is 0,0.
     anchor = The anchor for this image is the base of the flagpole at 0,32.
   */

case class Icon(url: String, size: Size, origin: Point, anchor: Point) {
  def toGIcon = json(url = url, size = size.toGSize, origin = origin.toGPoint, anchor = anchor.toGPoint)
}

/*
    Shapes define the clickable region of the icon.
    The type defines an HTML &lt;area&gt; element 'poly' which
    traces out a polygon as a series of X,Y points. The final
    coordinate closes the poly by connecting to the first
    coordinate.
  */
case class Shape(coords: List[Int], tpe: String) {
  def toGShape = json("coords" -> coords.toJSArray, "type" -> tpe)
}

case class LatLng(lat: Double, lng: Double) {
  def toGlatlng = new GLatLng(lat, lng)
}

case class Marker(position: LatLng, title: String = "", icon: Icon = null, shape: Shape = null, zIndex: Int = 0, draggable: Boolean = false, content: String = "") {
  def toGMarker(map: GMap) = json(map = map, position = position.toGlatlng,
    title = title,
    icon = if (icon != null) icon.toGIcon else null,
    shape = if (shape != null) shape.toGShape else null,
    zIndex = zIndex,
    draggable = draggable)
}

case class MapOptions(center: LatLng, zoom: Int = 4) {
  def toGMapOptions = json(center = center.toGlatlng, zoom = zoom)
}
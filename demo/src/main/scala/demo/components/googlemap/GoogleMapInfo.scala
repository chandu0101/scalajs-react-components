package demo
package components
package googlemap

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object GoogleMapInfo {

  val component = ScalaComponent.builder[Unit]("googleMapInfo")
    .render(P => {
     InfoTemplate(componentFilePath = "maps/GoogleMap.scala")(
      <.h3("Google Map :"),
       <.p("Map component based on " ,<.a(^.href := "https://developers.google.com/maps/documentation/javascript/") ("google map javascript api"))
     )

  }).build

  def apply() = component()

}

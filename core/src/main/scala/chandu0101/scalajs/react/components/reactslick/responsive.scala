package chandu0101.scalajs.react.components.reactslick

import scala.scalajs.js
import scala.scalajs.js.`|`

@js.native
trait SlidesToShow extends js.Any {
  var slidesToShow: Int
}

object SlidesToShow {
  def apply(slidesToShow: Int): SlidesToShow =
    js.Dynamic
      .literal(
        slidesToShow = slidesToShow
      )
      .asInstanceOf[SlidesToShow]
}

@js.native
trait Unslick extends js.Any

@js.native
trait ResponsiveSetting extends js.Any {
  var breakpoint: Int
  var settings: SlidesToShow | Unslick
}

object ResponsiveSetting {
  def apply(breakpoint: Int, settings: SlidesToShow | Unslick): ResponsiveSetting = {
    val ret = js.Dynamic.literal().asInstanceOf[ResponsiveSetting]
    ret.breakpoint = breakpoint
    ret.settings = settings
    ret
  }
}

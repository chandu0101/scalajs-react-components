package chandu0101.scalajs.react.components.demo.util

import org.scalajs.dom

/**
 * Created by chandrasekharkode .
 */
object Navigate {
  def to(value : String) = dom.window.location.hash = value
}

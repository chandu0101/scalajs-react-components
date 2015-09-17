package chandu0101.scalajs.react.components
package models

import org.scalajs.dom.Element

case class RPoint(x: Double, y: Double)

case class RGrid(width: Double, height: Double)

case class RClientRect(top: Double = 0, left: Double = 0, right: Double = 0, bottom: Double = 0, height: Double = 0, width: Double = 0)

case class RPosition(top: Double = 0, left: Double = 0, right: Double = 0, bottom: Double = 0)

case class RElementPosition(element: Element, top: Double = 0, left: Double = 0, right: Double = 0, bottom: Double = 0)
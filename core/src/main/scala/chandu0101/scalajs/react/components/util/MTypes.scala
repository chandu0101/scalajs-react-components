package chandu0101.scalajs.react.components
package util

import chandu0101.scalajs.react.components.models.{RElementPosition, RPoint}
import japgolly.scalajs.react.{Callback, ReactEventH, ReactEventI}
import org.scalajs.dom.Event
import scala.scalajs.js.Date

trait MTypes {

  type REventIBooleanUnit = (ReactEventI, Boolean) => Callback

  type REventIUnit = (ReactEventI) => Callback

  type REventIIntUnit = (ReactEventI,Int) => Callback

  type DateUnit = (Date) => Callback

  type StringUnit = (String) => Callback

  type DateString = (Date) => String

  type EmptyFunc = () => Any

  type StringIntUnit = (String,Int) => Callback

  type StringStringIntAny = (String,String,Int) => Callback

  type REventIDateUnit = (ReactEventI, Date) => Callback

  type REventHUnit = (ReactEventH) => Callback

  type EventUnit = (Event) => Callback

  type EventRElementPositionAny = (Event, RElementPosition) => Callback

  type REventIDoubleUnit = (ReactEventI, Double) => Callback

  type REventIStringUnit = (ReactEventI, String) => Callback

  type REventIStringAny = (ReactEventI, String) => _

  type REventIIntStringUnit = (ReactEventI, Int, String) => Callback

  type OnDropdownTap = (ReactEventI, String, String) => Callback

  type REventIIntBooleanUnit = (ReactEventI, Int, Boolean) => Callback

  type CssClassType = Map[String, Boolean]

  type MapUnit = (Map[String,Any]) => Callback

  type MapMapUnit = (Map[String,Any],Map[String,Any]) => Callback

  type MapString = (Map[String,Any]) => String

  type StringRPointAny = (String,RPoint) => Any

}

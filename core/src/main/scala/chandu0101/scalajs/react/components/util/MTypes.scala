package chandu0101.scalajs.react.components.util

import chandu0101.scalajs.react.components.models.{RElementPosition, RPoint}
import japgolly.scalajs.react.{ReactEventH, ReactEventI}
import org.scalajs.dom.Event

import scala.scalajs.js.Date

/**
 * Created by chandrasekharkode .
 */
trait MTypes {

  type REventIBooleanUnit = (ReactEventI, Boolean) => Unit

  type REventIAny = (ReactEventI) => Any

  type REventIUnit = (ReactEventI) => Unit

  type REventIIntUnit = (ReactEventI,Int) => Unit

  type DateUnit = (Date) => Unit

  type StringUnit = (String) => Unit

  type DateString = (Date) => String

  type EmptyFunc = () => Any

  type StringIntUnit = (String,Int) => Unit

  type StringStringIntAny = (String,String,Int) => Any

  type REventIDateUnit = (ReactEventI, Date) => Unit

  type REventHUnit = (ReactEventH) => Unit

  type EventUnit = (Event) => Unit

  type EventRElementPositionAny = (Event,RElementPosition) => Any

  type REventIDoubleUnit = (ReactEventI, Double) => Unit

  type REventIStringUnit = (ReactEventI, String) => Unit

  type REventIStringAny = (ReactEventI, String) => _

  type REventIIntStringUnit = (ReactEventI, Int, String) => Unit

  type OnDropdownTap = (ReactEventI, String, String) => Unit

  type REventIIntBooleanUnit = (ReactEventI, Int, Boolean) => Unit

  type CssClassType = Map[String, Boolean]

  type MapUnit = (Map[String,Any]) => Unit

  type MapMapUnit = (Map[String,Any],Map[String,Any]) => Unit

  type MapString = (Map[String,Any]) => String

  type StringRPointAny = (String,RPoint) => Any

}

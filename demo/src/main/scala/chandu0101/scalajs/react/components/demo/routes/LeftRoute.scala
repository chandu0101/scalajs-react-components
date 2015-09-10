package chandu0101.scalajs.react.components
package demo.routes

import japgolly.scalajs.react.ReactElement

abstract class LeftRoute(val name : String,val route : String,val render : () => ReactElement)


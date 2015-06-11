package chandu0101.scalajs.react.components.demo.routes

import chandu0101.scalajs.react.components.demo.routes.AppRouter.Page
import japgolly.scalajs.react.ReactElement

abstract class LeftRoute(val name : String,val route : String,val render : () => ReactElement)


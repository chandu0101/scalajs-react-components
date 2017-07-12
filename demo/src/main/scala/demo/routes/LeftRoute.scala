package demo
package routes

import japgolly.scalajs.react.vdom.VdomElement

abstract class LeftRoute(val name: String,val route: String,val render: () => VdomElement)


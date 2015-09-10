package chandu0101.scalajs.react.components
package util

object KeyLine {

   object Desktop {
     val GUTTER = 24
     val GUTTER_LESS = 16
     val INCREMENT = 64
     val MENU_ITEM_HEIGHT = 32
   }

  def getIncrementalDim(dim : Double) = Math.ceil( dim / Desktop.INCREMENT) * Desktop.INCREMENT
}

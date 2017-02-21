package chandu0101.scalajs.react.components

import scala.scalajs.js

package object materialui {
  type RowId              = Int
  type ColumnId           = Int

  /* todo: need generate script to become more clever */
  private [materialui] implicit class A(m: Mui.type){
    def MuiThemeProvider = m.Styles.MuiThemeProvider
  }

  type TouchTapEvent   = raw.TouchTapEvent[org.scalajs.dom.Node]
  type TouchTapEventH  = raw.TouchTapEvent[org.scalajs.dom.html.Element]
  type TouchTapEventI  = raw.TouchTapEvent[org.scalajs.dom.html.Input]
  type TouchTapEventTA = raw.TouchTapEvent[org.scalajs.dom.html.TextArea]
}

package chandu0101.scalajs.react.components

import japgolly.scalajs.react._

import scala.scalajs.js

package object materialui {
  def installMuiContext[P, S, B, N <: TopNode](theme: js.UndefOr[MuiRawTheme]): ReactComponentSpec[P, S, B, N] => Callback =
    ThemeInstaller.installMuiContext(theme)
}

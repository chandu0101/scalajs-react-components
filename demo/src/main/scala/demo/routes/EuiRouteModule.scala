package demo.routes

import demo.components.elementalui._
import demo.pages.EuiPage
import japgolly.scalajs.react.extra.router.RouterConfigDsl
import demo.components.elementalui._

object EuiRouteModule {
  case object Info    extends LeftRoute("Info", "info", () => EuiInfo())
  case object Buttons extends LeftRoute("Buttons", "buttons", () => EuiButtonsDemo())
  case object Glyphs  extends LeftRoute("Glyphs", "glyphs", () => EuiGlyphsDemo())
  case object Forms   extends LeftRoute("Forms", "forms", () => EuiFormsDemo())
  case object Spinner extends LeftRoute("Spinner", "spinner", () => EuiSpinnerDemo())
  case object Modal   extends LeftRoute("Modal", "modal", () => EuiModalDemo())
  case object Misc    extends LeftRoute("Misc", "misc", () => EuiMiscDemo())
  val menu: List[LeftRoute] =
    List(Info, Buttons, Glyphs, Forms, Spinner, Modal, Misc)

  val routes = RouterConfigDsl[LeftRoute].buildRule { dsl =>
    import dsl._

    menu
      .map(i => staticRoute(i.route, i) ~> renderR(r => EuiPage(i, r)))
      .reduce(_ | _)

  }
}

package chandu0101.scalajs.react.components.pagers

import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, SyntheticEvent, _}
import org.scalajs.dom.html


/**
 * Created by chandrasekharkode .
 */
object Pager {


  class Backend(t: BackendScope[_, _]) {

  }

  val component = ReactComponentB[Props]("Pager")
    .stateless
    .backend(new Backend(_))
    .render((P,S,B) => {
    //    val prevClasses = Map(
    //                           P.css.pager -> (P.offset == 0) )
    //    val nextClasses = Map(P.css.pager -> (P.offset + P.itemsPerPage > P.totalItems))
    val prevClasses = Map("previous" -> (P.offset > 0),
      "disabled" -> (P.offset == 0))
    val nextClasses = Map("next" -> (P.offset + P.itemsPerPage < P.totalItems),
      "disabled" -> (P.offset + P.itemsPerPage >= P.totalItems))
    <.ul(^.cls := P.css.pager)(
      <.li(^.classSetM(prevClasses))(<.a(^.onClick ==> P.previousClick)("← Previous")),
      <.li(^.classSetM(nextClasses))(<.a(^.onClick ==> P.nextClick)("Next →"))
    )
  }).build

  case class Props(itemsPerPage: Int, totalItems: Int, offset: Int, nextClick: SyntheticEvent[html.Anchor] => Unit, previousClick: SyntheticEvent[html.Anchor] => Unit, css: CSS)

  case class CSS(pager: String = "pager")

  def apply(itemsPerPage: Int, totalItems: Int, offset: Int, nextClick: SyntheticEvent[html.Anchor] => Unit, previousClick: SyntheticEvent[html.Anchor] => Unit, css: CSS = CSS()) = {
    component(Props(itemsPerPage, totalItems, offset, nextClick, previousClick, css))
  }


}

package chandu0101.scalajs.react.components.reactbootstrap.materialui

import japgolly.scalajs.react.ReactComponentU_
import japgolly.scalajs.react.vdom._


import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}


/**
 * Created by chandrasekharkode on 12/1/14.
 */




  object material {

//    lazy val PaperButton :js.Dynamic = ???
    

    case class PaperButtonC(onClick: js.UndefOr[js.Any] = js.undefined, icon: js.UndefOr[String] = js.undefined, label: js.UndefOr[String] = js.undefined, className: js.UndefOr[String] = js.undefined, disabled: js.UndefOr[Boolean] = js.undefined, typeB: js.UndefOr[String] = js.undefined, href: js.UndefOr[String] = js.undefined, primary: js.UndefOr[Boolean] = js.undefined) {
      def toJs: js.Object = {
        val p = js.Dynamic.literal()
        icon.foreach(v => p.updateDynamic("icon")(v))
        label.foreach(v => p.updateDynamic("label")(v))
        onClick.foreach(v => p.updateDynamic("onClick")(v))
        className.foreach(v => p.updateDynamic("className")(v))
        disabled.foreach(v => p.updateDynamic("disabled")(v))
        href.foreach(v => p.updateDynamic("href")(v))
        typeB.foreach(v => p.updateDynamic("type")(v))
        primary.foreach(v => p.updateDynamic("primary")(v))
        p
      }

      def apply(children: TagMod*): ReactComponentU_ = {
        val f = g.PaperButton
        f(toJs, js.Array(children: _*)).asInstanceOf[ReactComponentU_]
      }
    }




}

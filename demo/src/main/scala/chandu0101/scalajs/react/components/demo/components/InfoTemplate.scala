package chandu0101.scalajs.react.components.demo.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js


/**
 * Created by chandrasekharkode .
 */
object InfoTemplate {


  val component = ReactComponentB[Props]("InfoTemplate")
    .render((P,C) => {
      <.div(^.cls := "info-template")(
        <.div(^.cls := "component-info")(C),
         P.cssPath.nonEmpty ?= <.div(^.marginTop := "10px")(
           <.h4("CSS :"),
           <.p(^.marginLeft := "30px")("Get it ",<.a(^.href := s"https://github.com/chandu0101/scalajs-react-components/tree/master/demo/${P.cssPath}" , ^.target := "_blank")("here"))
         ),
        P.browsersTested.nonEmpty ?= <.div(^.marginTop := "10px")(
           <.h4("Tested Browsers List :"),
           <.ul(^.marginLeft := "50px")(P.browsersTested.map(s => <.li(s)))
         ),
        <.div(^.marginTop := "10px")(
           ComponentCredits(filePath = s"core/src/main/scala/chandu0101/scalajs/react/components/${P.componentFilePath}")
         )
       )
    }).build


  case class Props(cssPath : String, browsersTested : List[String] ,componentFilePath : String)

  def apply( cssPath : String = "", browsersTested : List[String] = List() ,componentFilePath : String, ref: js.UndefOr[String] = "", key: js.Any = {})(children : ReactNode*) = component.set(key, ref)(Props(cssPath,browsersTested,componentFilePath),children)

}

package chandu0101.scalajs.react.components.demo.pages


import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


/**
 * Created by chandrasekharkode on 2/8/15.
 */
object ContributePage {

 object Style {

   val content : TagMod = Seq(padding := "80px")

   val rules = Seq(padding := "0 20px")


 }

  val component = ReactComponentB[Unit]("ContributePage")
    .render(P => {
      div(Style.content)(
       h3("Welcome Mama(friend,mate,amigo,dosth,...)"),
       div(Style.rules)(
        h4("Users : "),
        p("Go a head play with toys ,report issues and send PR(Pull Request)'s if possible :) ")
       ),
       div(Style.rules)(
        h4("Developers :"),
        ul(
         li("There are no global rules for this project ,follow what ever works for you."),
         li("If you're working on new component please create an issue in " ,a(href := "https://github.com/chandu0101/scalajs-react-components/issues" ,textDecoration := "none" ,target := "_blank")("Github") ," so that we can minimize duplicate works, and you may find other awesome contributors ." )
        )
       )
      )
    }).buildU

  def apply() = component()


}

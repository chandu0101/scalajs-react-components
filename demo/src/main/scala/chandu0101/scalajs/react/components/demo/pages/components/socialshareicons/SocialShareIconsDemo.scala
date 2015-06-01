package chandu0101.scalajs.react.components.demo.pages.components.socialshareicons

import chandu0101.scalajs.react.components.demo.pages.util.CodeExample
import chandu0101.scalajs.react.components.models._
import chandu0101.scalajs.react.components.social._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._



/**
 * Created by chandrasekharkode .
 */
object SocialShareIconsDemo {


  val code =
    """
      |
    """.stripMargin
  val component = ReactComponentB[Unit]("SocialShareIconsDemo")
    .render(P => {
   <.div(
     <.h2(^.cls := "mui-font-style-headline")("Demo"),
      CodeExample(code)(
      <.div(^.cls := "social-share-icons-demo")(
         SocialShareBasic(tweet = tweet,fbPost = fbPost,gplusPost = gplusPost,tumblrLink = tumblrLink ,linkedIn = linkedInPost , pintrest = pintrest),
         SocialShareBasic(css = "style2", tweet = tweet,fbPost = fbPost,gplusPost = gplusPost,tumblrLink = tumblrLink ,linkedIn = linkedInPost , pintrest = pintrest),
         SocialShareBasic(css = "style3", tweet = tweet,fbPost = fbPost,gplusPost = gplusPost,tumblrLink = tumblrLink ,linkedIn = linkedInPost , pintrest = pintrest),
         SocialShareBasic(css = "style4", tweet = tweet,fbPost = fbPost,gplusPost = gplusPost,tumblrLink = tumblrLink ,linkedIn = linkedInPost , pintrest = pintrest)
       )
      )
    )
  }).buildU

  private val title: String = "Reusable scalajs-react components"

  val tweet = Tweet(text = title,hashTags = List("scalajs","reactjs"), via = "chandu0101")

  val fbPost = FaceBookPost()

  val gplusPost = GooglePlusPost()

  val tumblrLink = TumblrLink(name = title,description = "use em now")

  val linkedInPost = LinkedIn(title =title )

  val pintrest = Pintrest(description = title)

  def apply() = component()
}

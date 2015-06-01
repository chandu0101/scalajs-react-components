package chandu0101.scalajs.react.components.social


import chandu0101.scalajs.react.components.models._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object SocialShareBasic {


  class Backend(t: BackendScope[Props, _]) {

    def parameterizeUrl(url: String, parameters: Map[String, Any]): String = {
      parameters.foldLeft(url)((base, kv) =>
        base ++ { if (base.contains("?")) "&" else "?" } ++ kv._1 ++ "=" + js.URIUtils.encodeURIComponent(kv._2.toString))
    }

    /*
      @see https://dev.twitter.com/web/tweet-button/web-intent
     */
    def tweetMe(message : Tweet) = {
      val host = "https://twitter.com/intent/tweet"
      val url = parameterizeUrl(host,Map("url" -> message.url,
       "text" -> message.text,
       "via" -> message.via,
       "hashtags" -> message.hashTags.mkString(",")
      ))
      openUrl(url)
    }

    def openUrl( url : String) = dom.window.open(url = url,target = "_blank",features = "width=600,height=400,left=100,top=100")

    def fbShare(message : FaceBookPost) = {
      val host = "https://www.facebook.com/sharer/sharer.php"
      val url = parameterizeUrl(host,Map("u" -> message.url))
      openUrl(url)
    }

    def googlePlusShare(message : GooglePlusPost) = {
     val host = "https://plus.google.com/share"
      val url = parameterizeUrl(host,Map("url" -> message.url))
      openUrl(url)
    }

    def tumblrLink(message : TumblrLink) = {
      val host = "http://www.tumblr.com/share/link"
      val url = parameterizeUrl(host,Map("url" -> message.url,
       "name" -> message.name,
       "description" -> message.description))
      openUrl(url)
    }

    def redditMe(message : Reddit) = {
      val host = "http://www.reddit.com/submit"
      val url = parameterizeUrl(host,Map("url" -> message.url,
       "title" -> message.title))
      openUrl(url)
    }

    def pinIt(message : Pintrest) = {
      val host = "http://www.pinterest.com/pin/create/button/"
      val url = parameterizeUrl(host,Map("url" -> message.url,
       "media" -> message.media,
        "description" -> message.description))
      openUrl(url)
    }

    def linkedInShare(message : LinkedIn) = {
      val host = "http://www.linkedin.com/shareArticle?mini=true"
      val url = parameterizeUrl(host,Map("url" -> message.url,
      "title" -> message.title))
      openUrl(url)
    }

  }

  val component = ReactComponentB[Props]("SocialShareBasic")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
     <.div(^.cls := "social-share")(
      <.div(^.cls := P.css)(
         P.fbPost!=null ?= <.i(^.cls := "icon-facebook")(^.onClick --> B.fbShare(P.fbPost)),
         P.tweet!=null ?=  <.i(^.cls := "icon-twitter")(^.onClick --> B.tweetMe(P.tweet)),
         P.gplusPost!=null ?= <.i(^.cls := "icon-googleplus")(^.onClick --> B.googlePlusShare(P.gplusPost)),
         P.tumblrLink!=null ?= <.i(^.cls := "icon-tumblr")(^.onClick --> B.tumblrLink(P.tumblrLink)),
         P.linkedIn!=null ?= <.i(^.cls := "icon-linkedin")(^.onClick --> B.linkedInShare(P.linkedIn)),
         P.pintrest!=null ?= <.i(^.cls := "icon-pinterest")(^.onClick --> B.pinIt(P.pintrest))
       )
      )
    })
    .build

  case class Props(tweet:Tweet,css: String,fbPost : FaceBookPost,gplusPost : GooglePlusPost,tumblrLink: TumblrLink,linkedIn: LinkedIn,pintrest: Pintrest)

  def apply(tweet:Tweet = null,
            fbPost: FaceBookPost = null,
            gplusPost : GooglePlusPost = null,
            tumblrLink : TumblrLink = null,
            linkedIn : LinkedIn = null,
            pintrest: Pintrest = null,
            css : String = "style1",ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(Props(tweet,css,fbPost,gplusPost,tumblrLink,linkedIn,pintrest))

}

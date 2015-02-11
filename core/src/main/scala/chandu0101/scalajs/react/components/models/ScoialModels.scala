package chandu0101.scalajs.react.components.models

import org.scalajs.dom

/**
 * Created by chandrasekharkode .
 */

case class Tweet(text :String = "",via : String = "", hashTags : List[String] = List(),url : String = dom.window.location.href ,related :String ="",inReplyTo :String = "")

case class FaceBookPost( url : String = dom.window.location.href)

case class GooglePlusPost( url : String = dom.window.location.href)

case class TumblrLink( url : String = dom.window.location.href,name : String = "",description : String = "")

case class Reddit(url : String = dom.window.location.href ,title : String = "")

case class LinkedIn( url : String = dom.window.location.href,title : String = "")

case class Pintrest(url : String = dom.window.location.href,media : String = "",description : String)

case class Github(login : String = "",html_url : String = "", avatar_url : String ="")

package demo
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.ext.Ajax

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.{Date, JSON}

object ComponentCredits {

  case class State(users: List[Github])

  class Backend(t: BackendScope[Props, State]) {
    def render(S: State) = {
      S.users match {
        case Nil => <.div("Loading Credits ...")
        case author :: contributors =>
          <.div(
            <.h4("Author: "),
            GithubUser(author),
            <.h4("Contributors: "),
            <.div(^.marginRight := "10px")(contributors.map(GithubUser(_)): _*)
          )
      }
    }
  }

  val component =
    ScalaComponent
      .builder[Props]("ComponentCredits")
      .initialState(State(List()))
      .renderBackend[Backend]
      .componentDidMount(
        $ =>
          Callback {
            val url =
              s"https://api.github.com/repos/chandu0101/scalajs-react-components/commits?path=${$.props.filePath}"
            Ajax.get(url).onSuccess {
              case xhr =>
                if (xhr.status == 200) {
                  val rawUsers = JSON.parse(xhr.responseText).asInstanceOf[js.Array[js.Dynamic]]
                  val users = rawUsers
                    .map(
                      u =>
                        Github(
                          login = u.author.login.toString,
                          html_url = u.author.html_url.toString,
                          avatar_url = u.author.avatar_url.toString,
                          time = new Date(u.commit.author.date.toString).getTime()
                      )
                    )
                    .toList
                    .groupBy(_.login)
                    .map {
                      case (id, objlist) => objlist.minBy(_.time)
                    }
                    .toSet
                    .toList

                  $.mountedPure
                    .modState(_.copy(users = users.sortBy(_.time)))
                    .runNow()
                }
            }
        }
      )
      .build

  case class Props(filePath: String)

  def apply(filePath: String) = component(Props(filePath))
}

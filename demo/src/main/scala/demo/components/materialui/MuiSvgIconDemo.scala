package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.{Px, Reusability}
import japgolly.scalajs.react.vdom.TagOf
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html.Div

import scala.scalajs.js

object MuiSvgIconDemo {

  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START
  case class Props(icons: js.Array[(String, MuiSvgIcon)])

  case class State(accepts: Accepts, hovered: js.UndefOr[String])

  case class Accepts(search: js.UndefOr[String]) {
    private val lower = search map (_.toLowerCase)
    def apply(name: String): Boolean =
      lower forall name.toLowerCase.contains
  }

  case class Backend($ : BackendScope[Props, State]) {
    implicit val r0 = Reusability.by_==[Props]
    implicit val r1 = Reusability.by_==[Accepts]

    def lookupIcon(name: String): MuiSvgIcon = {
      val lookup = Mui.SvgIcons.asInstanceOf[js.Dynamic]
      lookup.selectDynamic(name).asInstanceOf[MuiSvgIcon]
    }

    val select: String => ReactMouseEventFromHtml => Callback =
      name => e => $.modState(_.copy(hovered = name))

    val unselect: ReactMouseEventFromHtml => Callback =
      e => $.modState(_.copy(hovered = js.undefined))

    val onSearchChange: (ReactEventFromInput, String) => Callback =
      (e, str) => {
        e.persist()
        $.modState(_.copy(accepts = Accepts(e.target.value)))
      }

    /* rendering all icons turned out to be expensive, so
     *  we cache things based on search string */
    val renderedIconsPx: Px[VdomNode] =
      Px.callback($.props zip $.state.map(_.accepts)).withReuse.autoRefresh.map {
        case (p, accepts) =>
          p.icons.collect {
            case (name, icon) if accepts(name) =>
              icon.apply(
                key = name,
                style = js.Dynamic.literal(width = "30px", height = "30px"),
                hoverColor = Mui.Styles.colors.amber500,
                onMouseEnter = select(name),
                onMouseLeave = unselect,
                viewBox = "0 0 30 30"
              )()
          }.toVdomArray
      }

    def render(P: Props, S: State): TagOf[Div] =
      <.div(
        CodeExample(code, "MuiSvgIcons")(
          <.div(
            <.h4(s"Current icon: ${S.hovered.getOrElse("None")}"),
            <.label("Search: "),
            MuiTextField(name = "search",
                         value = S.accepts.search,
                         onChange = js.defined(onSearchChange))()
          ),
          <.div(
            ^.height := "300px",
            ^.overflowY := "scroll",
            renderedIconsPx.value()
          )
        )
      )
  }

  val component = ScalaComponent
    .builder[Props]("MuiSvgIconDemo")
    .initialState(State(Accepts(js.undefined), js.undefined))
    .renderBackend[Backend]
    .build

  val icons: js.Array[(String, MuiSvgIcon)] =
    js.Array(
      "PlacesRvHookup"              -> MuiSvgIcons.PlacesRvHookup,
      "PlacesSmokeFree"             -> MuiSvgIcons.PlacesSmokeFree,
      "PlacesSmokingRooms"          -> MuiSvgIcons.PlacesSmokingRooms,
      "PlacesSpa"                   -> MuiSvgIcons.PlacesSpa,
      "SocialCake"                  -> MuiSvgIcons.SocialCake,
      "SocialDomain"                -> MuiSvgIcons.SocialDomain,
      "SocialGroupAdd"              -> MuiSvgIcons.SocialGroupAdd,
      "SocialGroup"                 -> MuiSvgIcons.SocialGroup,
      "SocialLocationCity"          -> MuiSvgIcons.SocialLocationCity,
      "SocialMoodBad"               -> MuiSvgIcons.SocialMoodBad,
      "SocialMood"                  -> MuiSvgIcons.SocialMood,
      "SocialNotificationsActive"   -> MuiSvgIcons.SocialNotificationsActive,
      "SocialNotificationsNone"     -> MuiSvgIcons.SocialNotificationsNone,
      "SocialNotificationsOff"      -> MuiSvgIcons.SocialNotificationsOff,
      "SocialNotificationsPaused"   -> MuiSvgIcons.SocialNotificationsPaused,
      "SocialNotifications"         -> MuiSvgIcons.SocialNotifications,
      "SocialPages"                 -> MuiSvgIcons.SocialPages,
      "SocialPartyMode"             -> MuiSvgIcons.SocialPartyMode,
      "SocialPeopleOutline"         -> MuiSvgIcons.SocialPeopleOutline,
      "SocialPeople"                -> MuiSvgIcons.SocialPeople,
      "SocialPersonAdd"             -> MuiSvgIcons.SocialPersonAdd,
      "SocialPersonOutline"         -> MuiSvgIcons.SocialPersonOutline,
      "SocialPerson"                -> MuiSvgIcons.SocialPerson,
      "SocialPlusOne"               -> MuiSvgIcons.SocialPlusOne,
      "SocialPoll"                  -> MuiSvgIcons.SocialPoll,
      "SocialPublic"                -> MuiSvgIcons.SocialPublic,
      "SocialSchool"                -> MuiSvgIcons.SocialSchool,
      "SocialSentimentDissatisfied" -> MuiSvgIcons.SocialSentimentDissatisfied
    )

  // EXAMPLE:END

  def apply() = component(Props(icons))
}

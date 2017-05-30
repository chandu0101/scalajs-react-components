package demo.components.elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.TagOf
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html.Div

import scala.scalajs.js.`|`

object EuiModalDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(
      modalIsOpen: Boolean = false,
      sizeModalIsOpen: Boolean = false,
      modalSize: ModalSize | Double = 0.0
  )

  case class Backend($ : BackendScope[Unit, State]) {
    def toggleModal(event: ReactEventFromHtml): Callback =
      $.modState(state => state.copy(modalIsOpen = !state.modalIsOpen))

    def toggleSizeModal(size: ModalSize | Double)(event: ReactEventFromHtml): Callback =
      $.modState(state => state.copy(sizeModalIsOpen = !state.sizeModalIsOpen, modalSize = size))

    def renderLiveDemo(state: State): TagOf[Div] = {
      <.div(
        EuiButton(onClick = toggleModal _)("Show it"),
        EuiModal(
          isOpen = state.modalIsOpen,
          backdropClosesModal = true,
          onCancel = toggleModal _
        )(
          EuiModalHeader(text = "Modal Header")(),
          EuiModalBody()(
            EuiFormField(label = "Email")(
              EuiFormInput(
                `type` = "email",
                name = "email",
                required = true
              )()
            ),
            EuiFormField(label = "Password")(
              EuiFormInput(
                `type` = "password",
                name = "password",
                required = true
              )()
            ),
            <.p(
              "From the Wikipedia article",
              <.a(
                ^.href := "https://en.wikipedia.org/wiki/Elemental",
                ^.target := "_blank",
                "https://en.wikipedia.org/wiki/Elemental"
              )
            ),
            <.p(
              "An elemental is a mythic being described in occult and alchemical works from around the time of the European Renaissance and particularly elaborated in the 16th century works of Paracelsus."),
            <.p(
              "There are four elemental categories: gnomes, undines, sylphs, and salamanders. These correspond to the Classical elements of antiquity: earth, water, air and fire. Aether (quintessence) was not assigned an elemental."),
            <.p(
              "Terms employed for beings associated with alchemical elements vary by source and gloss."),
            <.h2("History"),
            <.p(
              "The Paracelsian concept of elementals draws from several much older traditions in mythology and religion. Common threads can be found in folklore, animism, and anthropomorphism. Examples of creatures such as the Pygmy were taken from Greek mythology."),
            <.p(
              "The elements of earth, water, air, and fire, were classed as the fundamental building blocks of nature. This system prevailed in the Classical world and was highly influential in medieval natural philosophy. Although Paracelsus uses these foundations and the popular preexisting names of elemental creatures, he is doing so to present new ideas which expand on his own philosophical system. The homunculus is another example of a Paracelsian idea with roots in earlier alchemical, scientific, and folklore traditions."),
            <.h3("Paracelsus"),
            <.p(
              "In his 16th-century alchemical work Liber de Nymphis, sylphis, pygmaeis et salamandris et de caeteris spiritibus, Paracelsus identified mythological beings as belonging to one of the four elements. Part of the Philosophia Magna, this book was first printed in 1566 after Paracelsus' death. He wrote the book to \"describe the creatures that are outside the cognizance of the light of nature, how they are to be understood, what marvellous works God has created\". He states that there is more bliss in describing these \"divine objects\" than in describing fencing, court etiquette, cavalry, and other worldly pursuits."),
            <.p("The concept of elementals seems to have been conceived by Paracelsus in the 16th century, though he did not in fact use the term \"elemental\" or a German equivalent.[5] He regarded them not so much as spirits but as beings between creatures and spirits, generally being invisible to mankind but having physical and commonly humanoid bodies, as well as eating, sleeping, and wearing clothes like humans. Paracelsus gave common names for the elemental types, as well as correct names, which he seems to have considered somewhat more proper, \"recht namen\". He also referred to them by purely German terms which are roughly equivalent to \"water people,\" \"mountain people,\" and so on, using all the different forms interchangeably.")
          ),
          EuiModalFooter()(
            EuiButton(onClick = toggleModal _, `type` = ButtonType.primary)("Submit"),
            EuiButton(onClick = toggleModal _, `type` = ButtonType.link_cancel)("Cancel")
          )
        )
      )
    }

    val renderStaticExample: TagOf[Div] =
      <.div(
        ^.className := "code-example",
        <.div(
          ^.className := "code-example__example",
          <.div(
            ^.className := "Modal-content",
            EuiModalHeader(text = "Modal Header")(),
            EuiModalBody()(
              EuiFormField(label = "Email")(
                EuiFormInput(
                  `type` = "email",
                  name = "email",
                  required = true
                )()
              ),
              EuiFormField(label = "Password")(
                EuiFormInput(
                  `type` = "password",
                  name = "password",
                  required = true
                )()
              )
            ),
            EuiModalFooter()(
              EuiButton()("Submit"),
              EuiButton()("Cancel")
            )
          )
        )
      )

    def renderSizes(state: State): TagOf[Div] = {
      <.div(
        EuiButton(onClick = toggleSizeModal(ModalSize.small) _)("small"),
        EuiButton(onClick = toggleSizeModal(ModalSize.large) _)("large"),
        EuiButton(onClick = toggleSizeModal(768) _)("768"),
        EuiModal(
          isOpen = state.sizeModalIsOpen,
          onCancel = toggleSizeModal(ModalSize.small) _,
          backdropClosesModal = true,
          width = state.modalSize
        )(
          EuiModalHeader(
            text = s"${state.modalSize.toString}",
            showCloseButton = true,
            onClose = toggleSizeModal(ModalSize.small) _
          )(),
          EuiModalBody()(<.p("&hellip;"))
        )
      )
    }

    def render(state: State): VdomElement =
      CodeExample(code, "EuiModal")(
        EuiContainer()(
          <.h1("Modal"),
          <.h2("Static Example"),
          renderStaticExample,
          <.h2("Live Demo"),
          renderLiveDemo(state),
          <.h2("Sizes"),
          renderSizes(state)
        )
      )
  }

  val component = ScalaComponent
    .builder[Unit]("EuiModalDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

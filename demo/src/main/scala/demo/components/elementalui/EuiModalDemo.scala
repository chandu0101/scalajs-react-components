package demo.components.elementalui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.elementalui._
import demo.components.CodeExample
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js.`|`

object EuiModalDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  case class State(modalIsOpen: Boolean = false,
                   sizeModalIsOpen: Boolean = false,
                   modalSize: String | Int = 0)

  case class Backend($: BackendScope[Unit, State]) {
    def toggleModal(event: ReactEventH) = 
      $.modState(state => state.copy(modalIsOpen = !state.modalIsOpen))

    def toggleSizeModal(size: String | Int)(event: ReactEventH) = 
      $.modState(state => state.copy(sizeModalIsOpen = !state.sizeModalIsOpen, modalSize = size))

    def renderLiveDemo(S: State) =
      <.div(
        Button(toggleModal _)("Show it"),
        Modal(
          isOpen = S.modalIsOpen,
          backdropClosesModal = true,
          onCancel = toggleModal _
        )(
          ModalHeader(text = "Modal Header")(),
          ModalBody()(
            FormField(label = "Email")(
              FormInput(
                label = "Email",
                `type` = "email",
                name = "email",
                placeholder = "name@example.com",
                required = true)()
            ),
            FormField(label = "Password")(
              FormInput(
                label = "Password",
                `type` = "password",
                name = "password",
                placeholder = "Min 8 chars",
                required = true)()
            ),
            <.p("From the Wikipedia article",
              <.a(^.href := "https://en.wikipedia.org/wiki/Elemental",
                ^.target := "_blank",
                "https://en.wikipedia.org/wiki/Elemental")),
            <.p("An elemental is a mythic being described in occult and alchemical works from around the time of the European Renaissance and particularly elaborated in the 16th century works of Paracelsus."),
            <.p("There are four elemental categories: gnomes, undines, sylphs, and salamanders. These correspond to the Classical elements of antiquity: earth, water, air and fire. Aether (quintessence) was not assigned an elemental."),
            <.p("Terms employed for beings associated with alchemical elements vary by source and gloss."),
            <.h2("History"),
            <.p("The Paracelsian concept of elementals draws from several much older traditions in mythology and religion. Common threads can be found in folklore, animism, and anthropomorphism. Examples of creatures such as the Pygmy were taken from Greek mythology."),
            <.p("The elements of earth, water, air, and fire, were classed as the fundamental building blocks of nature. This system prevailed in the Classical world and was highly influential in medieval natural philosophy. Although Paracelsus uses these foundations and the popular preexisting names of elemental creatures, he is doing so to present new ideas which expand on his own philosophical system. The homunculus is another example of a Paracelsian idea with roots in earlier alchemical, scientific, and folklore traditions."),
            <.h3("Paracelsus"),
            <.p("In his 16th-century alchemical work Liber de Nymphis, sylphis, pygmaeis et salamandris et de caeteris spiritibus, Paracelsus identified mythological beings as belonging to one of the four elements. Part of the Philosophia Magna, this book was first printed in 1566 after Paracelsus' death. He wrote the book to \"describe the creatures that are outside the cognizance of the light of nature, how they are to be understood, what marvellous works God has created\". He states that there is more bliss in describing these \"divine objects\" than in describing fencing, court etiquette, cavalry, and other worldly pursuits."),
            <.p("The concept of elementals seems to have been conceived by Paracelsus in the 16th century, though he did not in fact use the term \"elemental\" or a German equivalent.[5] He regarded them not so much as spirits but as beings between creatures and spirits, generally being invisible to mankind but having physical and commonly humanoid bodies, as well as eating, sleeping, and wearing clothes like humans. Paracelsus gave common names for the elemental types, as well as correct names, which he seems to have considered somewhat more proper, \"recht namen\". He also referred to them by purely German terms which are roughly equivalent to \"water people,\" \"mountain people,\" and so on, using all the different forms interchangeably.")),
          ModalFooter()(
            Button(onClick = toggleModal _, `type` = ButtonType.PRIMARY)("Submit"),
            Button(onClick = toggleModal _, `type` = ButtonType.LINK_CANCEL)("Cancel")
          )
        )
      )

    val renderStaticExample =
      <.div(^.className := "code-example",
        <.div(^.className := "code-example__example",
          <.div(^.className := "Modal-content",
            ModalHeader(text = "Modal Header")(),
            ModalBody()(
              FormField(label = "Email")(
                FormInput(
                  label = "Email",
                  `type` = "email",
                  name = "email",
                  placeholder = "name@example.com",
                  required = true)()
              ),
              FormField(label = "Password")(
                FormInput(
                  label = "Password",
                  `type` = "password",
                  name = "password",
                  placeholder = "Min 8 chars",
                  required = true
                )()
              )
            ),
            ModalFooter()(
              Button()("Submit"),
              Button()("Cancel")
            )
          )
        )
      )
    
    def renderSizes(S: State) =
      <.div(
        Button(onClick = toggleSizeModal("small") _)("small"),
        Button(onClick = toggleSizeModal("large") _)("large"),
        Button(onClick = toggleSizeModal(768) _)("768"),
        Modal(
          isOpen = S.sizeModalIsOpen,
          onCancel = toggleSizeModal("small") _,
          backdropClosesModal = true,
          width = S.modalSize)(
          ModalHeader(
            text = s"${S.modalSize}", 
            showCloseButton = true, 
            onClose = toggleSizeModal("small") _
          )(),
          ModalBody()(<.p("&hellip;"))))

    def render(S: State) =
      CodeExample(code, "EuiModal")(
        Container()(
          <.h1("Modal"),
          <.h2("Static Example"),
          renderStaticExample,
          <.h2("Live Demo"),
          renderLiveDemo(S),
          <.h2("Sizes"),
          renderSizes(S))
      )
  }

  val component = ReactComponentB[Unit]("EuiModalDemo")
    .initialState(State())
    .renderBackend[Backend]
    .build

  // EXAMPLE:END

  def apply() = component()
}

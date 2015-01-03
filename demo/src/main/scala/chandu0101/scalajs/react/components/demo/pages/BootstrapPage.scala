package chandu0101.scalajs.react.components.demo.pages

import chandu0101.scalajs.react.components.demo.codesamples.BootstrapSamples
import chandu0101.scalajs.react.components.demo.util.SingleSide
import chandu0101.scalajs.react.components.reactbootstrap.bootStrap
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactEventI}

/**
 * Created by chandrasekharkode on 12/1/14.
 */
object BootstrapPage {

  val buttonOptions = ReactComponentB[Unit]("buttonOptions")
    .render(P => {
    <.div(
      <.h3("Options"),
      bootStrap.ButtonToolbar()(
        bootStrap.Button()("Default"),
        bootStrap.Button(bsStyle = "primary")("Primary"),
        bootStrap.Button(bsStyle = "success")("Success"),
        bootStrap.Button(bsStyle = "info")("Info"),
        bootStrap.Button(bsStyle = "danger")("Danger"),
        bootStrap.Button(bsStyle = "link")("Link")
      )
    )
  }).buildU

  val buttonSizes = ReactComponentB[Unit]("buttonSizes")
    .render(P => {
    <.div(
      <.h3("Sizes"),
      <.div(
        bootStrap.ButtonToolbar()(
          bootStrap.Button(bsStyle = "primary", bsSize = "large")("Large Button"),
          bootStrap.Button(bsSize = "large")("Large Button")
        ),
        <.br(),
        bootStrap.ButtonToolbar()(
          bootStrap.Button(bsStyle = "primary")("Default Button"),
          bootStrap.Button()("Default Button")
        ),
        <.br(),
        bootStrap.ButtonToolbar()(
          bootStrap.Button(bsStyle = "primary", bsSize = "small")("Small Button"),
          bootStrap.Button(bsSize = "small")("Small Button")
        ),
        <.br(),
        bootStrap.ButtonToolbar()(
          bootStrap.Button(bsStyle = "primary", bsSize = "xsmall")("Extra small Button"),
          bootStrap.Button(bsSize = "xsmall")("Extra small Button")
        )
      )
    )
  }).buildU

  val buttonBlocks = ReactComponentB[Unit]("blocklevelbuttons")
    .render(P => {
    <.div(
      <.h3("Blocklevel Buttons"),
      <.p("Create block level buttons—those that span the full width of a parent— by adding the block prop."),
      <.div(^.cls := "well", ^.maxWidth := "400px")(
        bootStrap.Button(bsStyle = "primary", bsSize = "large", block = true)("Block level button"),
        bootStrap.Button(bsSize = "large", block = true)("Block level button")
      )
    )
  }).buildU

  val buttonState = ReactComponentB[Unit]("buttonstates")
    .render(P => {
    <.div(
      <.h3("Active state"),
      bootStrap.ButtonToolbar()(
        bootStrap.Button(bsStyle = "primary", bsSize = "large", active = true)("Primary button"),
        bootStrap.Button(bsSize = "large", active = true)("Button")
      ),
      <.h3("Disabled state"),
      bootStrap.ButtonToolbar()(
        bootStrap.Button(bsStyle = "primary", bsSize = "large", disabled = true)("Primary button"),
        bootStrap.Button(bsSize = "large", disabled = true)("Button")
      )
    )
  }).buildU


  val buttonTags = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3("Button tags"),
      <.p("The DOM element tag is choosen automaticly for you based on the props you supply. Passing ahref will result in the button using a <a /> element otherwise a<button /> element will be used."),
      bootStrap.ButtonToolbar()(
        bootStrap.Button(hrefB = "#")("Link"),
        bootStrap.Button()("Button")
      )
    )
  }).buildU

  case class State(isLoading: Boolean)

  class Backend(t: BackendScope[_, State]) {
    def handleClick(e: ReactEventI) = {
      e.preventDefault()
      t.modState(s => State(!s.isLoading))
    }
  }

  val loadingButton = ReactComponentB[Unit]("loadingButton")
    .initialState(State(false))
    .backend(new Backend(_))
    .render((P, S, B) => {
    <.div(
      //        bootStrap.Button(bsStyle = "primary",disabled = S.isLoading
      //        ,onClick = B.handleClick(null))("Button")
    )
  }).buildU

  val bGroupBasic = ReactComponentB[Unit]("bGroupBasic")
    .render(P => {
    <.div(
      <.h3("Basic example"),
      bootStrap.ButtonGroup()(
        bootStrap.Button()("Left"),
        bootStrap.Button()("Middle"),
        bootStrap.Button()("Right")
      )
    )
  }).buildU

  val buttonToolBar = ReactComponentB[Unit]("buttonToolBar")
    .render(P => {
    <.div(
      <.h3("Button toolbar"),
      bootStrap.ButtonToolbar()(
        bootStrap.ButtonGroup()(
          bootStrap.Button()("1"),
          bootStrap.Button()("2"),
          bootStrap.Button()("3"),
          bootStrap.Button()("4")
        ),
        bootStrap.ButtonGroup()(
          bootStrap.Button()("5"),
          bootStrap.Button()("6"),
          bootStrap.Button()("7")
        ),
        bootStrap.ButtonGroup()(
          bootStrap.Button()("8")
        )
      )
    )
  }).buildU

  val buttonNesting = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3("Nesting"),
      bootStrap.ButtonGroup()(
        bootStrap.Button()("1"),
        bootStrap.Button()("2"),
        bootStrap.DropdownButton(title = "Dropdown")(
          bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
          bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
        )
      )
    )
  }).buildU


  val buttonVerticalNesting = ReactComponentB[Unit]("verticalvaraition")
    .render(P => {
    <.div(
      <.h3("Vertical variation"),
      <.p("Make a set of buttons appear vertically stacked rather than horizontally.Split button dropdowns are not supported here.\n\nJust add vertical to the <ButtonGroup />."),
      bootStrap.ButtonGroup(vertical = true)(
        bootStrap.Button()("Button"),
        bootStrap.Button()("Button"),
        bootStrap.DropdownButton(title = "Dropdown")(
          bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
          bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
        ),
        bootStrap.Button()("Button"),
        bootStrap.Button()("Button"),
        bootStrap.DropdownButton(title = "Dropdown")(
          bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
          bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
        ),
        bootStrap.DropdownButton(title = "Dropdown")(
          bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
          bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
        )
      )
    )
  }).buildU


  //TODO alignment fucked up check this out
  val buttonJustified = ReactComponentB[Unit]("buttonsJustified")
    .render(P => {
    <.div(
      <.h3("Justified button groups"),
      <.p("Make a group of buttons stretch at equal sizes to span the entire width of its parent. Also works with button dropdowns within the button group."),
      bootStrap.ButtonGroup(justified = true)(
        bootStrap.Button()("Left"),
        bootStrap.Button()("Middle"),
        bootStrap.DropdownButton(title = "Dropdown")(
          bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
          bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
        )
      )
    )
  }).buildU


  val buttons = ReactComponentB[Unit]("buttons")
    .render(P => {
    <.div(
      <.h3("Buttons"),
      <.hr(),
      SingleSide.component(BootstrapSamples.buttonOptions, buttonOptions()),
      SingleSide.component(BootstrapSamples.buttonSizes, buttonSizes()),
      SingleSide.component(BootstrapSamples.buttonBlocks, buttonBlocks()),
      SingleSide.component(BootstrapSamples.buttonStates, buttonState()),
      SingleSide.component(BootstrapSamples.buttontags, buttonTags()),
      <.h3("Button groups"), <.span("ButtonGroup,ButtonToolbar"),
      <.hr(),
      SingleSide.component(BootstrapSamples.bGroupBasic, bGroupBasic()),
      SingleSide.component(BootstrapSamples.buttonToolBar, buttonToolBar()),
      SingleSide.component(BootstrapSamples.buttonNesting, buttonNesting()),
      SingleSide.component(BootstrapSamples.buttonVerticalNesting, buttonVerticalNesting())
      //      SingleSide.component(BootstrapSamples.buttonJustified, buttonJustified())


    )

  }).buildU


  val basicPanel = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3("Basic Example"),
      bootStrap.Panel()("Basic Panel Example")
    )
  }).buildU


  val panelWithHeading = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3(" Panel with heading"),
      bootStrap.Panel(header = "Panel Title")("Panel Content")
    )
  }).buildU

  val panelAlternatives = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3(" Contextual alternatives"),
      bootStrap.Panel(header = "Panel Title")("Panel Content"),
      bootStrap.Panel(header = "Panel Title", bsStyle = "primary")("Panel Content"),
      bootStrap.Panel(header = "Panel Title", bsStyle = "success")("Panel Content"),
      bootStrap.Panel(header = "Panel Title", bsStyle = "info")("Panel Content"),
      bootStrap.Panel(header = "Panel Title", bsStyle = "warning")("Panel Content"),
      bootStrap.Panel(header = "Panel Title", bsStyle = "danger")("Panel Content")
    )
  }).buildU


  val panels = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3("Panels"),
      <.h5("Panel, PanelGroup, Accordion"),
      <.hr(),
      SingleSide.component(BootstrapSamples.basicPanel, basicPanel()),
      SingleSide.component(BootstrapSamples.panelWithHeading, panelWithHeading()),
      SingleSide.component(BootstrapSamples.panelWithAlternatives, panelAlternatives())
    )
  }).buildU


  val progressBarBsic = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3("Basic example"),
      bootStrap.ProgressBar(now = 60.0)()
    )
  }).buildU

  val progressBarWithLabel = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3("With Label"),
      <.p("Add a label prop to show a visible percentage. For low percentages, consider adding a min-width to ensure the label's text is fully visible.\n\nThe following keys are interpolated with the current values: %(min)s, %(max)s, %(now)s, %(percent)s, %(bsStyle)s"),
      bootStrap.ProgressBar(now = 60.0, label = "%(percent)s%")()
    )
  }).buildU

  val progressBarAlternatives = ReactComponentB[Unit]("changeme")
      .render(P => {
      <.div(
        <.h3("Contextual alternatives"),
        bootStrap.ProgressBar(now = 60.0 ,bsStyle = "success" )(),
        bootStrap.ProgressBar(now = 20.0 ,bsStyle = "info" )(),
        bootStrap.ProgressBar(now = 70.0 ,bsStyle = "warning" )(),
        bootStrap.ProgressBar(now = 40.0 ,bsStyle = "danger" )()
      )
    }).buildU

  val progressBarAnimated = ReactComponentB[Unit]("changeme")
      .render(P => {
      <.div(
       <.h3("Animated"),
       bootStrap.ProgressBar(now = 35.0 ,active = true)()
      )
    }).buildU


  val progressBarStacked = ReactComponentB[Unit]("changeme")
      .render(P => {
      <.div(
       <.h3("Stacked"),
        bootStrap.ProgressBar()(
          bootStrap.ProgressBar(bsStyle = "success" , now = 35.0 ,key = 1)(),
          bootStrap.ProgressBar(bsStyle = "info" , now = 20.0 ,key = 2)(),
          bootStrap.ProgressBar(bsStyle = "danger" , now = 10.0 ,key = 2)()
        )
      )
    }).buildU

  val progressBars = ReactComponentB[Unit]("changeme")
    .render(P => {
    <.div(
      <.h3("Progress bars"),
      <.hr(),
      SingleSide.component(BootstrapSamples.progressBarBasic, progressBarBsic()),
      SingleSide.component(BootstrapSamples.progressBarWithLabel, progressBarWithLabel()),
      SingleSide.component(BootstrapSamples.progressBarAlternatives, progressBarAlternatives()),
      SingleSide.component(BootstrapSamples.progressBarAnimated, progressBarAnimated()),
      SingleSide.component(BootstrapSamples.progressBarStacked, progressBarStacked())

    )
  }).buildU




  val BootstrapDemos = ReactComponentB[Unit]("bootstrapdemo")
    .render(P => {
    <.div(
      buttons(),
      panels(),
      progressBars()
    )
  }).buildU


  def content = BootstrapDemos()

}

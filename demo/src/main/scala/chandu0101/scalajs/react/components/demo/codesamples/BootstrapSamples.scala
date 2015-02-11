package chandu0101.scalajs.react.components.demo.codesamples

/**
 * Created by chandrasekharkode .
 */
object BootstrapSamples {


  val buttonOptions = """ val buttonOptions = ReactComponentB[Unit]("buttons")
                        |    .render(P => {
                        |    div(
                        |      bootStrap.ButtonToolbar()(
                        |        bootStrap.Button()("Default"),
                        |        bootStrap.Button(bsStyle = "primary")("Primary"),
                        |        bootStrap.Button(bsStyle = "success")("Success"),
                        |        bootStrap.Button(bsStyle = "info")("Info"),
                        |        bootStrap.Button(bsStyle = "danger")("Danger"),
                        |        bootStrap.Button(bsStyle = "link")("Link")
                        |      )
                        |    )
                        |  }).buildU""".stripMargin


  val buttonSizes = """  val buttonSizes = ReactComponentB[Unit]("changeme")
                      |    .render(P => {
                      |      div(
                      |        bootStrap.ButtonToolbar()(
                      |          bootStrap.Button(bsStyle = "primary" ,bsSize = "large")("Large Button"),
                      |          bootStrap.Button(bsSize = "large")("Large Button")
                      |        ),
                      |        bootStrap.ButtonToolbar()(
                      |          bootStrap.Button(bsStyle = "primary")("Default Button"),
                      |          bootStrap.Button()("Default Button")
                      |        ),
                      |        bootStrap.ButtonToolbar()(
                      |          bootStrap.Button(bsStyle = "primary" ,bsSize = "small")("Small Button"),
                      |          bootStrap.Button(bsSize = "small")("Small Button")
                      |        ),
                      |        bootStrap.ButtonToolbar()(
                      |          bootStrap.Button(bsStyle = "primary" ,bsSize = "xsmall")("Extra small Button"),
                      |          bootStrap.Button(bsSize = "xsmall")("Extra small Button")
                      |        )
                      |      )
                      |  }).buildU""".stripMargin


  val buttonBlocks = """ val buttonBlocks = ReactComponentB[Unit]("blocklevelbuttons")
                       |      .render(P => {
                       |      div(cls:= "well", maxWidth := "400px",marginBottom := "10px" )(
                       |        bootStrap.Button(bsStyle = "primary" ,bsSize = "large", block = true)("Block level button"),
                       |        bootStrap.Button(bsSize = "large", block = true)("Block level button")
                       |      )
                       |    }).buildU""".stripMargin


  val buttonStates = """val buttonState = ReactComponentB[Unit]("buttonstates")
                       |      .render(P => {
                       |      div(
                       |        h3("Active state"),
                       |        bootStrap.ButtonToolbar()(
                       |          bootStrap.Button(bsStyle = "primary" ,bsSize = "large" ,active = true)("Primary button"),
                       |          bootStrap.Button(bsSize = "large" ,active = true)("Button")
                       |        ),
                       |        h3("Disabled state"),
                       |        bootStrap.ButtonToolbar()(
                       |          bootStrap.Button(bsStyle = "primary" ,bsSize = "large" ,disabled = true)("Primary button"),
                       |          bootStrap.Button(bsSize = "large" ,disabled = true)("Button")
                       |        )
                       |      )
                       |    }).buildU""".stripMargin


  val buttontags = """  val buttonTags = ReactComponentB[Unit]("changeme")
                     |      .render(P => {
                     |      div(
                     |        bootStrap.ButtonToolbar()(
                     |          bootStrap.Button(hrefB = "#")("Link"),
                     |          bootStrap.Button()("Button")
                     |        )
                     |      )
                     |    }).buildU
                     | """.stripMargin


  val bGroupBasic = """val bGroupBasic = ReactComponentB[Unit]("bGroupBasic")
                      |      .render(P => {
                      |      div(
                      |        bootStrap.ButtonGroup()(
                      |         bootStrap.Button("Left"),
                      |         bootStrap.Button("Middle"),
                      |         bootStrap.Button("Right")
                      |        )
                      |      )
                      |    }).buildU""".stripMargin


  val buttonToolBar = """ val buttonToolBar = ReactComponentB[Unit]("changeme")
                        |      .render(P => {
                        |      div(
                        |      bootStrap.ButtonToolbar()(
                        |        bootStrap.ButtonGroup()(
                        |          bootStrap.Button()("1"),
                        |          bootStrap.Button()("2"),
                        |          bootStrap.Button()("3"),
                        |          bootStrap.Button()("4")
                        |        ),
                        |        bootStrap.ButtonGroup()(
                        |          bootStrap.Button()("5"),
                        |          bootStrap.Button()("6"),
                        |          bootStrap.Button()("7")
                        |        ),
                        |        bootStrap.ButtonGroup()(
                        |          bootStrap.Button()("8")
                        |        )
                        |      )
                        |      )
                        |    }).buildU""".stripMargin


  val buttonNesting = """val buttonNesting = ReactComponentB[Unit]("changeme")
                        |      .render(P => {
                        |      div(
                        |       bootStrap.ButtonGroup()(
                        |         bootStrap.Button()("1"),
                        |         bootStrap.Button()("2"),
                        |        bootStrap.DropdownButton(title = "Dropdown")(
                        |         bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
                        |         bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
                        |        )
                        |       )
                        |      )
                        |    }).buildU""".stripMargin


  val buttonVerticalNesting = """val buttonVerticalNesting = ReactComponentB[Unit]("verticalvaraition")
                                |    .render(P => {
                                |    div(
                                |      bootStrap.ButtonGroup(vertical = true)(
                                |        bootStrap.Button()("Button"),
                                |        bootStrap.Button()("Button"),
                                |        bootStrap.DropdownButton(title = "Dropdown")(
                                |          bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
                                |          bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
                                |        ),
                                |        bootStrap.Button()("Button"),
                                |        bootStrap.Button()("Button"),
                                |        bootStrap.DropdownButton(title = "Dropdown")(
                                |          bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
                                |          bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
                                |        ),
                                |        bootStrap.DropdownButton(title = "Dropdown")(
                                |          bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
                                |          bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
                                |        )
                                |      )
                                |    )
                                |  }).buildU""".stripMargin


  val buttonJustified = """val buttonJustified = ReactComponentB[Unit]("buttonsJustified")
                          |      .render(P => {
                          |      div(
                          |        h3("Justified button groups"),
                          |        p("Make a group of buttons stretch at equal sizes to span the entire width of its parent. Also works with button dropdowns within the button group."),
                          |        bootStrap.ButtonGroup()(
                          |          bootStrap.Button()("Left"),
                          |          bootStrap.Button()("Middle"),
                          |          bootStrap.DropdownButton(title = "Dropdown")(
                          |            bootStrap.MenuItem(eventKey = "1")("Dropdown Link"),
                          |            bootStrap.MenuItem(eventKey = "2")("Dropdown Link")
                          |          )
                          |        )
                          |      )
                          |    }).buildU""".stripMargin


  val basicPanel = """val basicPanel = ReactComponentB[Unit]("changeme")
                     |      .render(P => {
                     |      div(
                     |        bootStrap.Panel()("Basic Panel Example")
                     |      )
                     |    }).buildU""".stripMargin


  val panelWithHeading =
    """
      |val panelWithHeading = ReactComponentB[Unit]("changeme")
      |    .render(P => {
      |    div(
      |      bootStrap.Panel(header = "Panel Title")("Panel Content")
      |    )
      |  }).buildU
    """.stripMargin

  val panelWithAlternatives =
    """
      |val panelAlternatives = ReactComponentB[Unit]("changeme")
      |    .render(P => {
      |    div(
      |      bootStrap.Panel(header = "Panel Title")("Panel Content"),
      |      bootStrap.Panel(header = "Panel Title" ,bsStyle = "primary")("Panel Content"),
      |      bootStrap.Panel(header = "Panel Title" ,bsStyle = "success")("Panel Content"),
      |      bootStrap.Panel(header = "Panel Title" ,bsStyle = "info")("Panel Content"),
      |      bootStrap.Panel(header = "Panel Title" ,bsStyle = "warning")("Panel Content"),
      |      bootStrap.Panel(header = "Panel Title" ,bsStyle = "danger")("Panel Content")
      |    )
      |  }).buildU
    """.stripMargin

  val progressBarBasic =
    """
      | val progressBarBsic = ReactComponentB[Unit]("changeme")
      |     .render(P => {
      |     div(
      |       bootStrap.ProgressBar(now = 60.0)()
      |     )
      |   }).buildU
    """.stripMargin

  val progressBarWithLabel =
   """
     |val progressBarWithLabel = ReactComponentB[Unit]("changeme")
     |  .render(P => {
     |  div(
     |    bootStrap.ProgressBar(now = 60.0 , label = "%(percent)s%" )()
     |  )
     |}).buildU
   """.stripMargin

  val progressBarAlternatives =
    """
      |val progressBarAlternatives = ReactComponentB[Unit]("changeme")
      |      .render(P => {
      |      div(
      |        bootStrap.ProgressBar(now = 60.0 ,bsStyle = "success" )(),
      |        bootStrap.ProgressBar(now = 20.0 ,bsStyle = "info" )(),
      |        bootStrap.ProgressBar(now = 70.0 ,bsStyle = "warning" )(),
      |        bootStrap.ProgressBar(now = 40.0 ,bsStyle = "danger" )()
      |      )
      |    }).buildU
    """.stripMargin


  val progressBarAnimated =
    """
      | val progressBarAnimated = ReactComponentB[Unit]("changeme")
      |      .render(P => {
      |      div(
      |       bootStrap.ProgressBar(now = 35.0 ,active = true)()
      |      )
      |    }).buildU
    """.stripMargin

  val progressBarStacked =
    """
      |val progressBarStacked = ReactComponentB[Unit]("changeme")
      |      .render(P => {
      |      div(
      |       h3("Stacked"),
      |        bootStrap.ProgressBar()(
      |          bootStrap.ProgressBar(bsStyle = "success" , now = 35.0 ,key = 1)(),
      |          bootStrap.ProgressBar(bsStyle = "info" , now = 20.0 ,key = 2)(),
      |          bootStrap.ProgressBar(bsStyle = "danger" , now = 10.0 ,key = 2)()
      |        )
      |      )
      |    }).buildU
    """.stripMargin


}

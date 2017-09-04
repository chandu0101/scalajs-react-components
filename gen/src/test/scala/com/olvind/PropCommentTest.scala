package com.olvind

class PropCommentTest extends org.scalatest.FunSuite with org.scalatest.Matchers {

  test("comment 0") {
    val inputs: Seq[String] =
      Seq(
        """//arne""",
        """/*arne*/""",
        """/**arne*/""",
        """ /** arne */""",
        """ /** arne **/"""
      )
    inputs map PropComment.clean map (_ should equal(PropComment(Some("arne"), Seq.empty)))
  }

  test("comment 1") {
    val input = """  /**
      |   * @ignore
      |   * The material-ui theme applied to this component.
      |   */
      |""".stripMargin

    PropComment.clean(input) should equal(
      PropComment(Some("The material-ui theme applied to this component."), Seq(Ignore)))
  }

  test("comment 2") {
    val input = """    /**
                  |     * Callback function that is fired when the header of step is touched.
                  |     *
                  |     * @param {number} stepIndex - The index of step is being touched.
                  |     * @param {node} Step component which is being touched
                  |     */
                  |""".stripMargin

    PropComment.clean(input) should equal(
      PropComment(
        Some("Callback function that is fired when the header of step is touched."),
        Seq(
          Param("{number} stepIndex - The index of step is being touched."),
          Param("{node} Step component which is being touched")
        )
      ))
  }

  test("comment 3") {
    val input =
      """    /**
                  |     * Fired when the `Snackbar` is requested to be closed by a click outside the `Snackbar`, or after the
                  |     * `autoHideDuration` timer expires.
                  |     *
                  |     * Typically `onRequestClose` is used to set state in the parent component, which is used to control the `Snackbar`
                  |     * `open` prop.
                  |     *
                  |     * The `reason` parameter can optionally be used to control the response to `onRequestClose`,
                  |     * for example ignoring `clickaway`.
                  |     *
                  |     * @param {string} reason Can be:`"timeout"` (`autoHideDuration` expired) or: `"clickaway"`
                  |     */""".stripMargin
    val expected = PropComment(
      Some(
        """Fired when the `Snackbar` is requested to be closed by a click outside the `Snackbar`, or after the
        |`autoHideDuration` timer expires.
        |Typically `onRequestClose` is used to set state in the parent component, which is used to control the `Snackbar`
        |`open` prop.
        |The `reason` parameter can optionally be used to control the response to `onRequestClose`,
        |for example ignoring `clickaway`.""".stripMargin),
      Seq(
        Param(
          """{string} reason Can be:`"timeout"` (`autoHideDuration` expired) or: `"clickaway"`"""))
    )

    val actual = PropComment.clean(input)

    expected.value should equal(actual.value)
    expected.anns should equal(actual.anns)
  }

  test("comment 4") {
    val input = """  /**
                  |   * @param 1
                  |   * 2
                  |   * @param 3
                  |   * 4
                  |   */
                  |""".stripMargin

    PropComment.clean(input).anns should equal(Seq(Param("1\n2"), Param("3\n4")))
  }

  test("comment 5") {
    val input = """  /**
                  |   * @ignore
                  |   */
                  |""".stripMargin

    PropComment.clean(input) should equal(PropComment(None, Seq(Ignore)))
  }

}

package demo.components
package materialui

import chandu0101.macros.tojs.GhPagesMacros
import chandu0101.scalajs.react.components.materialui._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js

object MuiAutoCompleteDemo {
  val code = GhPagesMacros.exampleSource

  // EXAMPLE:START

  val fruit = js.Array(
    "Apple",
    "Apricot",
    "Avocado",
    "Banana",
    "Bilberry",
    "Blackberry",
    "Blackcurrant",
    "Blueberry",
    "Boysenberry",
    "Blood Orange",
    "Cantaloupe",
    "Currant",
    "Cherry",
    "Cherimoya",
    "Cloudberry",
    "Coconut",
    "Cranberry",
    "Clementine",
    "Damson",
    "Date",
    "Dragonfruit",
    "Durian",
    "Elderberry",
    "Feijoa",
    "Fig",
    "Goji berry",
    "Gooseberry",
    "Grape",
    "Grapefruit",
    "Guava",
    "Honeydew",
    "Huckleberry",
    "Jabouticaba",
    "Jackfruit",
    "Jambul",
    "Jujube",
    "Juniper berry",
    "Kiwi fruit",
    "Kumquat",
    "Lemon",
    "Lime",
    "Loquat",
    "Lychee",
    "Nectarine",
    "Mango",
    "Marion berry",
    "Melon",
    "Miracle fruit",
    "Mulberry",
    "Mandarine",
    "Olive",
    "Orange",
    "Papaya",
    "Passionfruit",
    "Peach",
    "Pear",
    "Persimmon",
    "Physalis",
    "Plum",
    "Pineapple",
    "Pumpkin",
    "Pomegranate",
    "Pomelo",
    "Purple Mangosteen",
    "Quince",
    "Raspberry",
    "Raisin",
    "Rambutan",
    "Redcurrant",
    "Salal berry",
    "Satsuma",
    "Star fruit",
    "Strawberry",
    "Squash",
    "Salmonberry",
    "Tamarillo",
    "Tamarind",
    "Tomato",
    "Tangerine",
    "Ugli fruit",
    "Watermelon"
  )
  val colors = js.Array("Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Black", "White")

  val onNewRequest: (String, Int) => Callback =
    (chosen, idx) => Callback.info(s"onNewRequest: chosen: $chosen, idx: $idx")

  val onUpdateInput: (String, js.Array[String], js.Object) => Callback =
    (search, ds, params) => Callback.info(s"onUpdateInput: search $search")

  val component = ScalaComponent
    .builder[Unit]("MuiAutoCompleteDemo")
    .render(P =>
      CodeExample(code, "MuiAutoComplete")(
        <.div(
          MuiAutoComplete(
            floatingLabelText = "Type t, fuzzy search": VdomNode,
            filter = js.defined(MuiAutoCompleteFilters.fuzzyFilter),
            dataSource = fruit,
            anchorOrigin = Origin(Vertical.bottom, Horizontal.middle),
            onNewRequest = onNewRequest,
            onUpdateInput = onUpdateInput
          )()
        ),
        <.div(
          MuiAutoComplete(
            floatingLabelText = "Type r, case insensitive": VdomNode,
            filter = js.defined(MuiAutoCompleteFilters.caseInsensitiveFilter),
            dataSource = colors,
            onNewRequest = onNewRequest,
            onUpdateInput = onUpdateInput
          )()
        )
    ))
    .build

  // EXAMPLE:END

  def apply() = component()
}

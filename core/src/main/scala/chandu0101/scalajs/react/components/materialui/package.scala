package chandu0101.scalajs.react.components

import scala.scalajs.js

package object materialui {
  type RowId              = Int
  type ColumnId           = Int
  type SearchText         = String
  type Value              = String
  type AutoCompleteFilter = js.Function3[SearchText, Value, Value, Boolean]
}

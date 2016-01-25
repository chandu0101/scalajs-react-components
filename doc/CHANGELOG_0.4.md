# 0.4.0 (Unreleased)
* Material-ui bumped from 0.13 to 0.14.3
* Bumped Scala-js to 0.6.6 to avoid some implicit resolution issues
* Bumped scalacss dependency
* Rewrote React Select wrapper, added Async support
* Added React Slick wrapper
* Move inference driving implicits to `chandu0101.scalajs.react.components.Implicits`. See `README` for more info
* Moved `CssProperties` to `chandu0101.scalajs.react.components` as it isnt specific to material-ui

* Big changes in Material-ui 0.14
  * Removed old menus from default imports, so it's not necessary to override anymore
  * Changed names of derived enum classes from Component/prop to a name derived from its values.
    For example `labelPosition: js.UndefOr[MuiCheckboxLabelPosition]` => `labelPosition: js.UndefOr[LeftRight]`
  * Fixed a bug/common warning with one child wrapped in a js array

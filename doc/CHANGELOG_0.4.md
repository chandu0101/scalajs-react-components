# 0.4.0
* Bumped Scala-js to 0.6.6 to avoid some implicit resolution issues
* Rewrote React Select wrapper, added Async support
* Added React Slick wrapper
* Material-ui 0.14
  * Removed old menus from default imports, so it's not necessary to override anymore
  * Changed names of derived enum classes from Component/prop to a name derived from its values.
    For example `labelPosition: js.UndefOr[MuiCheckboxLabelPosition]` => `labelPosition: js.UndefOr[LeftRight]`
  * Fixed a bug/common warning with one child wrapped in a js array
* Bump scalacss dependency

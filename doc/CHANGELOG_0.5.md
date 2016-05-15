# 0.5.0
* Bumped to react 0.15.3
* Material-ui bumped from 0.14.4 to 0.15.2
* Bumped Scala-js to 0.6.11
* Bumped Elemental-ui to work with new react, not really tested

* Changes in Material-ui 0.15
  * There are many small changes in the library as they try to make the API more sane and more composable.
    It's recommended to read through the [Changelog](https://github.com/callemall/material-ui/blob/master/CHANGELOG.md)
  * Javascript imports changed (also described in changelog)
  * Now need to use `MuiThemeProvider` instead of `ThemeInstaller.installMuiContext()`
  * Added a demo for themes to showcase how to use and adjust current theme
  * Now some of the components are generic, for example `MuiDropDownMenu[T]`.
    This means that you can get back sane things in callbacks.
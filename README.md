scalajs-react-components
========================

[![Join the chat at https://gitter.im/chandu0101/scalajs-react-components](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/chandu0101/scalajs-react-components?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Reusable [scalajs-react](https://github.com/japgolly/scalajs-react) components.

We are trying to make the experience of using javascript components in scala.js
 as good as possible by adding typed wrappers.

Adding types to javascript is a lot of guesswork, and we're certain to have gotten them wrong
 some places. Bug reports and/or pull requests are very much welcome! :)

### Wrappers for javascript components:
These components require you to provide javascript yourself.

- Material-ui 0.18.1
- Elemental-ui 0.6.1
- Semantic-ui 0.68.5
- Google maps (downloads js directly from google)
- React GeomIcon (react-geomicons: 2.1.10)
- React Infinite (react-infinite, 0.11.0)
- Spinner (react-spinner, 0.2.7)
- React Select (react-select: 1.0.0-rc.5)
- React TagsInput (react-tagsinput, 3.16.1)
- React Slick (react-slick: 0.14.11)

### Components written in scala.js
- DefaultSelect
- Pager
- ReactDraggable
- ReactListView
- ReactPopOver
- ReactSearchBox
- ReactTable
- ReactTreeView

## Gotchas

#### You have to call `apply` even when components dont have children:
```scala
MuiRaisedButton(label = "label")()
```

## Setup

#### SBT
Add these dependencies to you sbt build file
```scala
libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "1.1.0",
  "com.github.japgolly.scalajs-react" %%% "extra" % "1.1.0",
  "com.olvind" %%% "scalajs-react-components" % "1.0.0-M1"
)
```

This repository includes an example project, by all means use it as a template for your own.


#### ScalaCSS
In order to use the scala.js components, you need to make sure you load their CSS:
```scala
GlobalRegistry.register(<component>.Style)
```
See [here](https://japgolly.github.io/scalacss/book/ext/react.html) for more details

## Full Demo With Code Examples

**Online :**

http://chandu0101.github.io/sjrc/

**Local :** This will start a web server on http://localhost/8080
```
sbt 
fastOptJS::webpack
demo/compile:fastOptJS::startWebpackDevServer

```

## Example project

We've included an example project to give you an idea how to use the components
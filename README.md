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

- Material-ui 0.17.0
- Elemental-ui 0.5.4
- Google maps (downloads js directly from google)
- React GeomIcon (react-geomicons: 2.0.4)
- React Infinite (react-infinite, 0.7.1)
- Spinner (react-spinner, 0.2.3)
- React Select (react-select: 1.0.0-beta)
- React TagsInput (react-tagsinput, 3.0.3)
- React Slick (react-slick: 0.9.3)

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

#### Bad implicit inference for js.UndefOr[T]

Scala will only run one implicit to convert a type to another,
 which means that in order to convert a `String` to `js.UndefOr[ReactNode]`
 it needs to be done in two steps:

(1) `String => ReactNode`

(2) `ReactNode` => `js.UndefOr[ReactNode]`

We provide special versions of a few such implicits in
`chandu0101.scalajs.react.components.Implicits`.
To use:
```scala
import chandu0101.scalajs.react.components.Implicits._
```
or to put them in scope for your whole application:
```scala
package object mypackage extends chandu0101.scalajs.react.components.Implicits
```

#### Uncaught TypeError: Cannot read property 'RaisedButton' of undefined
If you try to use a javascript wrapper like material-ui and
 you get an error like this, make sure the corresponding javascript library
 is loaded in the global namespace where the wrapper expects to find it.

Sbt does not by itself understand these module systems, so unless you're prepared
 to talk it into supporting it, please rather have a look at the
 [webpack configuration for the demo project](demo/webpack.config.js) to
 see an example of how this can be solved.

## Setup

#### SBT
Add these dependencies to you sbt build file
```scala
libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "0.11.3",
  "com.github.japgolly.scalajs-react" %%% "extra" % "0.11.3",
  "com.olvind" %%% "scalajs-react-components" % "0.6.0"
)
```

#### ScalaCSS
In order to use the scala.js components, you need to make sure you load their CSS:
```scala
GlobalRegistry.register(<component>.Style)
```
See [here](https://japgolly.github.io/scalacss/book/ext/react.html) for more details

#### Provide javascript
In the case of material-ui at least you generally need to use javascript tools to
 generate a bundle of the javascript dependencies, because `sbt` and the scala.js
 plugin do not understand `require()`.

See the [demo](demo) to see how it can be done.


## Demo With Code Examples

**Online :** 

http://chandu0101.github.io/sjrc/

**Local :** 
```
sbt demo/fastOptJS
cd demo
//open a new terminal tab/window
yarn install
npm start
//open in browser
http://localhost:8090/

```

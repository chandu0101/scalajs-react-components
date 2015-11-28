scalajs-react-components
========================

[![Join the chat at https://gitter.im/chandu0101/scalajs-react-components](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/chandu0101/scalajs-react-components?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Reusable [scalajs-react] (https://github.com/japgolly/scalajs-react) components.

We are trying to make the experience of using javascript components in scala.js
 as good as possible by adding typed wrappers.

Adding types to javascript is a lot of guesswork, and we're certain to have gotten them wrong
 some places. Bug reports and/or pull requests are very much welcome! :)


### Wrappers for javascript components:
These components require you to provide javascript yourself.

- material-ui 0.13.4
- elemental-ui 0.5.5
- Google maps (downloads js directly from google)
- ReactGeomIcon (react-geomicons: 2.0.4)
- ReactInfinite (react-infinite, 0.7.1)
- Spinner (react-spinner, 0.2.3)
- ReactSelect (react-select: 1.0.0-beta5) (BROKEN after upgrade)
- ReactTagsInput (react-tagsinput, 3.0.2)

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

#### Bad implicit inference for optional union types:
Some components have props with types like this:
```scala
case class MuiMenu(
  ...
  value: js.UndefOr[String | js.Array[String]] = js.undefined,
  ...
```
Unfortunately, if you supply a `String` here, scala will only run one implicit conversion,
 not two like would be needed. The result is that you need to provide a type casting hint for now:
```scala
MuiMenu(value = "value": String | js.Array[String])
```
We will try to find a better solution for this.

#### Material-ui has two incompatible menu implementations

old: `require('material-ui/menu/menu'')`
new: `require('material-ui/menus/menu'')`

The new menu is the one documented on [material-ui](http://www.material-ui.com), while
 if you `require('material-ui'')` you will get the old.

We changed to the new version for scalajs-react-components 0.2.
Check [index.js](demo/index.js) to see how to specify the new one.


## Setup

#### SBT
```scala
// add this line to your build.sbt
libraryDependencies += "com.github.chandu0101.scalajs-react-components" %%% "core" % "0.2.0"
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
npm install
npm start
//open in browser
http://localhost:8090/

```
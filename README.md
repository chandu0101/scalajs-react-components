scalajs-react-components
========================

[![Join the chat at https://gitter.im/chandu0101/scalajs-react-components](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/chandu0101/scalajs-react-components?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Reusable [scalajs-react] (https://github.com/japgolly/scalajs-react) components

#### Status

Its work in progress...


#### Demo With Code Examples 

http://chandu0101.github.io/sjrc/

#### Setup

Library is not published to maven central as its still work in progress

To publish Locally  : 

```
 // need this hack until this PR https://github.com/japgolly/scalajs-react/pull/144 published
git clone -b unsfasespec https://github.com/chandu0101/scalajs-react/

cd scalajs-react

sbt publishLocal

// once above PR published , i'll push this to maven central till then follow 
 git clone https://github.com/chandu0101/scalajs-react-components
 
 cd scalajs-react-components
 
 sbt publishLocal

```

Using in Projects : 

```scala

// add this line to your build.sbt
libraryDependencies += "com.chandu0101.scalajs-react-components" %%% "core" % "0.0.1-SNAPSHOT"

```

#### Docs 

http://chandu0101.github.io/sjrc/docs


#### Contribute 

http://chandu0101.github.io/sjrc/#contribute


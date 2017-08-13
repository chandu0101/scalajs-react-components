addSbtPlugin("org.scala-js"  % "sbt-scalajs"         % "0.6.19")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.7.0")

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.25" // Needed by sbt-git

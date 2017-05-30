addSbtPlugin("org.scala-js"  % "sbt-scalajs"         % "0.6.17")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.6.0")
//addSbtPlugin("com.olvind" % "mui-generator" % "+")

//lazy val plugins = project in file(".") dependsOn(file("../gen"))

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.25" // Needed by sbt-git

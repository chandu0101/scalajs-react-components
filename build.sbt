// *****************************************************************************
// Projects
// *****************************************************************************
lazy val macros =
  project
    .in(file("macros"))
    .enablePlugins(ScalaJSPlugin)
    .settings(commonSettings, publicationSettings)
    .settings(
      name := "scalajs-react-components-macros",
      libraryDependencies ++= Seq(
        "com.github.japgolly.scalajs-react" %%% "core"      % "1.1.1",
        "com.github.japgolly.scalajs-react" %%% "extra"     % "1.1.1",
        "org.scalatest"                     %%% "scalatest" % "3.0.4" % Test
      )
    )

lazy val gen =
  project
    .in(file("gen"))
    .enablePlugins(ScalaJSBundlerPlugin)
    .settings(commonSettings, preventPublication, npmGenSettings)
    .settings(
      organization := "com.olvind",
      name := "generator",
      version in webpack := "2.6.1",
      libraryDependencies ++= Seq(
        "com.lihaoyi"   %% "ammonite-ops" % "1.0.1",
        "org.scalatest" %% "scalatest"    % "3.0.4" % Test
      )
    )

lazy val generateMui = TaskKey[Seq[File]]("generateMui")
lazy val generateEui = TaskKey[Seq[File]]("generateEui")
lazy val generateSui = TaskKey[Seq[File]]("generateSui")

lazy val core =
  project
    .in(file("core"))
    .dependsOn(macros)
    .enablePlugins(ScalaJSPlugin)
    .settings(commonSettings, publicationSettings)
    .settings(
      generateEui := {
        val genDir = sourceManaged.value
        genDir.mkdirs()
        val res = runner.value.run(
          "com.olvind.eui.EuiRunner",
          (fullClasspath in (gen, Runtime)).value.files,
          List(
            (npmUpdate in (gen, Compile)).value / "node_modules" / "elemental",
            sourceManaged.value / "main"
          ) map (_.absolutePath),
          streams.value.log
        )

        val pathFinder: PathFinder = sourceManaged.value ** "*.scala"
        pathFinder.get.filter(_.getAbsolutePath.contains("elemental"))
      },
      generateMui := {
        val genDir = sourceManaged.value
        genDir.mkdirs()
        val res = runner.value.run(
          "com.olvind.mui.MuiRunner",
          (fullClasspath in (gen, Runtime)).value.files,
          List(
            (npmUpdate in (gen, Compile)).value / "node_modules" / "material-ui",
            sourceManaged.value / "main"
          ) map (_.absolutePath),
          streams.value.log
        )
        val pathFinder: PathFinder = sourceManaged.value ** "*.scala"
        pathFinder.get.filter(_.getAbsolutePath.contains("material"))
      },
      generateSui := {
        val genDir = sourceManaged.value
        genDir.mkdirs()
        val res = runner.value.run(
          "com.olvind.sui.SuiRunner",
          (fullClasspath in (gen, Runtime)).value.files,
          List(
            (npmUpdate in (gen, Compile)).value / "node_modules" / "semantic-ui-react" / "dist" / "commonjs",
            sourceManaged.value / "main"
          ) map (_.absolutePath),
          streams.value.log
        )
        val pathFinder: PathFinder = sourceManaged.value ** "*.scala"
        pathFinder.get.filter(_.getAbsolutePath.contains("semanticui"))
      }
    )
    .settings(
      sourceGenerators in Compile += generateMui,
      sourceGenerators in Compile += generateEui,
      sourceGenerators in Compile += generateSui,
      mappings in (Compile, packageSrc) ++= {
        val sourceDir = (sourceManaged.value / "main").toPath
        def rel(f: File) = sourceDir.relativize(f.toPath).toString

        (managedSources in Compile).value map (s ⇒ s → rel(s))
      },
      libraryDependencies ++= Seq(
        "com.github.japgolly.scalajs-react" %%% "core"        % "1.1.1" withSources (),
        "com.github.japgolly.scalajs-react" %%% "extra"       % "1.1.1" withSources (),
        "com.github.japgolly.scalacss"      %%% "core"        % "0.5.5" withSources (),
        "com.github.japgolly.scalacss"      %%% "ext-react"   % "0.5.5" withSources (),
        "org.scala-js"                      %%% "scalajs-dom" % "0.9.4" withSources (),
        "org.scalacheck"                    %%% "scalacheck"  % "1.13.5" % Test,
        "org.scalatest"                     %%% "scalatest"   % "3.0.4" % Test
      )
    )

lazy val preventPublication = Seq(
  publishArtifact := false,
  publish := {},
  packagedArtifacts := Map.empty) // doesn't work - https://github.com/sbt/sbt-pgp/issues/42

lazy val demo =
  project
    .in(file("demo"))
    .dependsOn(core)
    .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
    .settings(commonSettings, preventPublication, npmSettings, npmDevSettings)
    .settings(
      name := "scalajs-react-components-demo",
      version in webpack := "2.6.1",
//      version in installWebpackDevServer := "2.7.1",
      scalaJSUseMainModuleInitializer := true,
      scalaJSUseMainModuleInitializer.in(Test) := false,
      artifactPath.in(Compile, fastOptJS) := ((crossTarget in (Compile, fastOptJS)).value /
        ((moduleName in fastOptJS).value + "-opt.js")),
      webpackResources :=
        webpackResources.value +++
          PathFinder(Seq(baseDirectory.value / "images", baseDirectory.value / "index.html")) ** "*.*",
      webpackConfigFile in (Test) := Some(baseDirectory.value / "webpack.config.test.js"),
      webpackConfigFile in (Compile, fastOptJS) := Some(
        baseDirectory.value / "webpack.config.dev.js"),
      webpackConfigFile in (Compile, fullOptJS) := Some(
        baseDirectory.value / "webpack.config.prod.js"),
      jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv,
      webpackBundlingMode := BundlingMode.LibraryOnly()
    )

lazy val root =
  project
    .in(file("."))
    .aggregate(macros, core, demo)
    .settings(commonSettings, preventPublication)

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val commonSettings =
  Seq(
    scalaVersion := "2.12.4",
    version := "1.0.0-M2",
    name := "scalajs-react-components",
    organization := "com.olvind",
    homepage := Some(url("http://chandu0101.github.io/scalajs-react-components")),
    licenses += ("Apache 2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    mappings.in(Compile, packageBin) += baseDirectory.in(ThisBuild).value / "LICENSE" -> "LICENSE",
    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-unchecked", // Enable additional warnings where generated code depends on assumptions.
      "-language:implicitConversions", // Allow definition of implicit functions called views
      "-language:postfixOps",
      "-P:scalajs:sjsDefinedByDefault"
    ),
    unmanagedSourceDirectories.in(Compile) := Seq(scalaSource.in(Compile).value),
    unmanagedSourceDirectories.in(Test) := Seq(scalaSource.in(Test).value)
  )

lazy val publicationSettings = Seq(
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra :=
    <scm>
      <connection>scm:git:github.com:chandu0101/scalajs-react-components</connection>
      <developerConnection>scm:git:git@github.com:chandu0101/scalajs-react-components.git</developerConnection>
      <url>github.com:chandu0101/scalajs-react-components.git</url>
    </scm>
      <developers>
        <developer>
          <id>chandu0101</id>
          <name>Chandra Sekhar Kode</name>
        </developer>
        <developer>
          <id>oyvindberg</id>
          <name>Øyvind Raddum Berg</name>
        </developer>
        <developer>
          <id>fmcgough</id>
          <name>Frankie</name>
        </developer>
        <developer>
          <id>roberto@leibman.net</id>
          <name>Roberto Leibman</name>
        </developer>
      </developers>
)

lazy val SuiVersion   = "0.68.5"
lazy val EuiVersion   = "0.6.1"
lazy val MuiVersion   = "0.20.0"
lazy val reactVersion = "15.5.4"

lazy val npmGenSettings = Seq(
  useYarn := true,
  npmDependencies.in(Compile) := Seq(
    "elemental"         -> EuiVersion,
    "material-ui"       -> MuiVersion,
    "semantic-ui-react" -> SuiVersion
  )
)

lazy val npmSettings = Seq(
  useYarn := true,
  npmDependencies.in(Compile) := Seq(
    "elemental"                         -> EuiVersion,
    "highlight.js"                      -> "9.9.0",
    "material-ui"                       -> MuiVersion,
    "react"                             -> reactVersion,
    "react-dom"                         -> reactVersion,
    "react-addons-create-fragment"      -> "15.6.2",
    "react-addons-css-transition-group" -> "15.6.2",
    "react-addons-pure-render-mixin"    -> "15.6.2",
    "react-addons-transition-group"     -> "15.6.2",
    "react-addons-update"               -> "15.6.2",
    "react-geomicons"                   -> "2.1.0",
    "react-infinite"                    -> "0.12.1",
    "react-select"                      -> "1.2.1",
    "react-slick"                       -> "0.16.0",
    "react-spinner"                     -> "0.2.7",
    "react-split-pane"                  -> "0.1.74",
    "react-tagsinput"                   -> "3.16.1",
    "react-tap-event-plugin"            -> "2.0.1",
    "semantic-ui-react"                 -> SuiVersion,
    "svg-loader"                        -> "0.0.2"
  )
)

lazy val npmDevSettings = {
  val deps = Seq(
    "css-loader"           -> "0.28.9",
    "expose-loader"        -> "0.7.4",
    "file-loader"          -> "1.1.6",
    "gulp-decompress"      -> "2.0.1",
    "imagemin"             -> "5.3.1",
    "image-webpack-loader" -> "4.0.0",
    "less"                 -> "2.7.3",
    "less-loader"          -> "4.0.5",
    "lodash"               -> "4.17.4",
    "node-libs-browser"    -> "2.1.0",
    "react-hot-loader"     -> "3.1.3",
    "style-loader"         -> "0.19.0",
    "url-loader"           -> "0.6.2",
    "webpack"              -> "2.6.1",
    "webpack-dev-server"   -> "2.11.1"
  )

  Seq(
    npmDevDependencies in Test := deps,
    npmDevDependencies in Compile := deps
  )
}

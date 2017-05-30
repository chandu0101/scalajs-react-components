import java.io.FileReader

import org.scalajs.core.tools.json

import scala.util.Try
import scalajsbundler.NpmPackage
import scalajsbundler.util.JS

// *****************************************************************************
// Projects
// *****************************************************************************
lazy val macros =
  project
    .in(file("macros"))
    .enablePlugins(ScalaJSPlugin)
    .settings(commonSettings)
    .settings(
      name := "scalajs-react-components-macros",
      libraryDependencies ++= Seq(
        "com.github.japgolly.scalajs-react" %%% "core"      % "1.0.1" withSources (),
        "com.github.japgolly.scalajs-react" %%% "extra"     % "1.0.1" withSources (),
        "org.scalatest"                     %%% "scalatest" % "3.0.3" % Test
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
      version in installWebpackDevServer := "2.6.1",
      libraryDependencies ++= Seq(
        "com.lihaoyi"   %% "ammonite-ops" % "0.9.5",
        "org.scalatest" %% "scalatest"    % "3.0.3" % Test
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
    .settings(commonSettings)
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
      libraryDependencies ++= Seq(
        "com.github.japgolly.scalajs-react" %%% "core"        % "1.0.1" withSources (),
        "com.github.japgolly.scalajs-react" %%% "extra"       % "1.0.1" withSources (),
        "com.github.japgolly.scalacss"      %%% "core"        % "0.5.3" withSources (),
        "com.github.japgolly.scalacss"      %%% "ext-react"   % "0.5.3" withSources (),
        "org.scala-js"                      %%% "scalajs-dom" % "0.9.2" withSources (),
        "org.scalacheck"                    %%% "scalacheck"  % "1.13.5" % Test,
        "org.scalatest"                     %%% "scalatest"   % "3.0.3" % Test
      )
    )

val jsDir = "demo/assets"

lazy val preventPublication = Seq(
  publishArtifact := false,
  publish := (),
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
      version in installWebpackDevServer := "2.4.5",
      scalaJSUseMainModuleInitializer := true,
      scalaJSUseMainModuleInitializer.in(Test) := false,
      artifactPath.in(Compile, fastOptJS) := ((crossTarget in (Compile, fastOptJS)).value /
        ((moduleName in fastOptJS).value + "-opt.js")),
      webpackResources :=
        webpackResources.value +++
          PathFinder(
            Seq(
              baseDirectory.value / "images",
              baseDirectory.value / "bundles" / "index.js",
              baseDirectory.value / "index.html"
            )) ** "*.*",
      webpackEmitSourceMaps := false,
      webpackConfigFile := Some(baseDirectory.value / "bundles" / "custom.webpack.config.js")
//      enableReloadWorkflow := true
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
    scalaVersion := "2.12.2",
    version := "1.0.0",
    name := "scalajs-react-components",
    organization := "com.olvind",
    licenses += ("Apache 2.0",
    url("http://www.apache.org/licenses/LICENSE-2.0")),
    mappings.in(Compile, packageBin) += baseDirectory.in(ThisBuild).value / "LICENSE" -> "LICENSE",
    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-unchecked", // Enable additional warnings where generated code depends on assumptions.
      "-language:implicitConversions", // Allow definition of implicit functions called views
      "-language:postfixOps"
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
              <id>elacin</id>
              <name>Øyvind Raddum Berg</name>
            </developer>
          </developers>
)

lazy val SuiVersion   = "0.68.5"
lazy val EuiVersion   = "0.6.1"
lazy val MuiVersion   = "0.18.1"
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
    "react-addons-create-fragment"      -> reactVersion,
    "react-addons-css-transition-group" -> "15.0.2",
    "react-addons-pure-render-mixin"    -> "15.5.2",
    "react-addons-transition-group"     -> "15.0.0",
    "react-addons-update"               -> "15.5.2",
    "react-geomicons"                   -> "2.1.0",
    "react-infinite"                    -> "0.11.0",
    "react-select"                      -> "1.0.0-rc.5",
    "react-slick"                       -> "0.14.11",
    "react-spinner"                     -> "0.2.7",
    "react-tagsinput"                   -> "3.16.1",
    "react-tap-event-plugin"            -> "2.0.1",
    "semantic-ui-react"                 -> SuiVersion,
    "svg-loader"                        -> "0.0.2"
  )
)

lazy val npmDevSettings = Seq(
  npmDevDependencies.in(Compile) := Seq(
    "compression-webpack-plugin" -> "0.4.0",
    "css-loader"                 -> "0.28.3",
    "file-loader"                -> "0.11.1",
    "gulp-decompress"            -> "2.0.1",
    "image-webpack-loader"       -> "3.3.1",
    "imagemin"                   -> "5.3.1",
    "less"                       -> "2.7.2",
    "less-loader"                -> "4.0.3",
    "lodash"                     -> "4.17.4",
    "node-libs-browser"          -> "2.0.0",
    "react-hot-loader"           -> "1.3.1",
    "style-loader"               -> "0.18.1",
    "url-loader"                 -> "0.5.8",
    "expose-loader"              -> "0.7.3",
    "webpack"                    -> "2.6.1",
    "webpack-dev-server"         -> "2.4.5"
  )
)

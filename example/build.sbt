// *****************************************************************************
// Projects
// *****************************************************************************

lazy val example =
  project
    .in(file("."))
    .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        "com.github.japgolly.scalajs-react" %%% "core"                     % "1.0.1",
        "com.github.japgolly.scalajs-react" %%% "extra"                    % "1.0.1",
        "com.olvind"                        %%% "scalajs-react-components" % "1.0.+"
      )
    )

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings = commonSettings ++ bundlerSettings

lazy val commonSettings =
  Seq(
    scalaVersion := "2.12.2",
    organization := "net.leibman",
    mappings.in(Compile, packageBin) += baseDirectory.in(ThisBuild).value / "LICENSE" -> "LICENSE",
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding",
      "UTF-8"
    )
  )

lazy val SuiVersion   = "0.68.5"
lazy val EuiVersion   = "0.6.1"
lazy val MuiVersion   = "0.18.1"
lazy val reactVersion = "15.5.4"

lazy val bundlerSettings =
  Seq(
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
            baseDirectory.value / "index.html"
          )) ** "*.*",
    webpackEmitSourceMaps := false,
    enableReloadWorkflow := true,
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

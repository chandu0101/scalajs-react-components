import com.typesafe.sbt.pgp.PgpKeys._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object ScalajsReactComponents extends Build {

  val Scala211 = "2.11.6"

  val scalajsReactVersion = "0.9.1"
  val scalaCSSVersion = "0.3.0"

  type PE = Project => Project

  def commonSettings: PE =
    _.enablePlugins(ScalaJSPlugin)
      .settings(
        organization       := "com.github.chandu0101.scalajs-react-components",
        version            := "0.1.0",
        homepage           := Some(url("https://github.com/chandu0101/scalajs-react-components")),
        licenses           += ("Apache-2.0", url("http://opensource.org/licenses/Apache-2.0")),
        scalaVersion       := Scala211,
        scalacOptions     ++= Seq("-deprecation", "-unchecked", "-feature",
                                "-language:postfixOps", "-language:implicitConversions",
                                "-language:higherKinds", "-language:existentials"),
        updateOptions      := updateOptions.value.withConsolidatedResolution(true))

  def preventPublication: PE =
    _.settings(
      publishArtifact := false,
      publishLocalSigned := (),       // doesn't work
      publishSigned := (),            // doesn't work
      packagedArtifacts := Map.empty) // doesn't work - https://github.com/sbt/sbt-pgp/issues/42

  def publicationSettings: PE =
    _.settings(
      publishTo := {
        val nexus = "https://oss.sonatype.org/"
        if (isSnapshot.value)
          Some("snapshots" at nexus + "content/repositories/snapshots")
        else
          Some("releases"  at nexus + "service/local/staging/deploy/maven2")
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
        </developers>)
    .configure(sourceMapsToGithub)

  def sourceMapsToGithub: PE =
    p => p.settings(
      scalacOptions ++= (if (isSnapshot.value) Seq.empty else Seq({
        val a = p.base.toURI.toString.replaceFirst("[^/]+/?$", "")
        val g = "https://raw.githubusercontent.com/chandu0101/scalajs-react-components"
        s"-P:scalajs:mapSourceURI:$a->$g/v${version.value}/"
      }))
    )

  def utestSettings: PE =
      _.configure(useReact("test"))
      .settings(
      libraryDependencies  += "com.lihaoyi" %%% "utest" % "0.3.0",
      testFrameworks       += new TestFramework("utest.runner.Framework"),
      scalaJSStage in Test := FastOptStage,
      requiresDOM          := true,
      jsEnv in Test        := PhantomJSEnv().value)

  def useReact(scope: String = "compile"): PE =
    _.settings(
      libraryDependencies += "com.github.japgolly.scalajs-react" %%% "extra" % scalajsReactVersion
      )

    val jsDir = "demo/assets"

    def createLauncher(scope: String = "compile"): PE =
    _.settings(persistLauncher := true,
      persistLauncher in Test := false,
      crossTarget in (Compile, fullOptJS) := file(jsDir),
      crossTarget in (Compile, fastOptJS) := file(jsDir),
//      crossTarget in (Compile, packageLauncher) := file(jsDir),
      artifactPath in (Compile, fastOptJS) := ((crossTarget in (Compile, fastOptJS)).value /
        ((moduleName in fastOptJS).value + "-opt.js"))
    )

  def addCommandAliases(m: (String, String)*) = {
    val s = m.map(p => addCommandAlias(p._1, p._2)).reduce(_ ++ _)
    (_: Project).settings(s: _*)
  }

  // ==============================================================================================
  lazy val root = Project("root", file("."))
    .aggregate(core, demo)
    .configure(commonSettings, preventPublication, addCommandAliases(
      "t"  -> "; test:compile ; test/test",
      "tt" -> ";+test:compile ;+test/test",
      "T"  -> "; clean ;t",
      "TT" -> ";+clean ;tt"))

  // ==============================================================================================
  lazy val core = project
    .configure(commonSettings, publicationSettings)
    .settings(
      name := "core",
      libraryDependencies ++= Seq(
        "com.github.japgolly.scalajs-react" %%% "core" % scalajsReactVersion,
        "com.github.japgolly.scalacss" %%% "core" % scalaCSSVersion,
        "com.github.japgolly.scalacss" %%% "ext-react" % scalaCSSVersion),
      target in Compile in doc := baseDirectory.value / "docs"
    )


  // ==============================================================================================
  lazy val demo = project
    .dependsOn(core)
    .configure(commonSettings,createLauncher(), useReact(), preventPublication)

}

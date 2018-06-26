import Dependencies._

name := "Scala-nanoid project"

val sharedSettings = Seq(
  name := "scala-nanoid",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.12.3",
  organization := "com.github.ssnickolay",
  publishMavenStyle := true,
  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
  crossScalaVersions := Seq("2.11.12", "2.12.6", "2.13.0-M4"),
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomIncludeRepository := { _ => false },
  licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/ssnickolay"),
      "scm:git@github.com:ssnickolay/scala-nanoid.git"
    )
  ),
  developers := List(
    Developer(
      id    = "ssnickolay",
      name  = "Sverchkov Nikolay",
      email = "ssnickolay@gmail.com",
      url   = url("https://github.com/ssnickolay")
    )
  )
)

lazy val root = project.in(file(".")).
  aggregate(nanoidJS, nanoidJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val nanoid = crossProject.in(file(".")).
  settings(sharedSettings).
  jvmSettings(
    // Add JVM-specific settings here
    libraryDependencies += "org.scalactic" %%% "scalactic" % scalactic,
    libraryDependencies += "org.scalatest" %%% "scalatest" % scalatest % Test
  ).
  jsSettings(
    // Add JS-specific settings here
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    libraryDependencies += "org.scalactic" %%% "scalactic" % scalactic,
    libraryDependencies += "org.scalatest" %%% "scalatest" % scalatest % Test
  )

lazy val nanoidJVM = nanoid.jvm
lazy val nanoidJS = nanoid.js

import Dependencies._

name := "Scala-nanoid project"

val sharedSettings = Seq(
  name := "scala-nanoid",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.12.3",
)

lazy val root = project.in(file(".")).
  aggregate(nanoidJS, nanoidJVM).
  settings(
    publish := {},
    publishLocal := {},
  )

lazy val nanoid = crossProject.in(file(".")).
  settings(sharedSettings).
  jvmSettings(
    libraryDependencies += scalactic,
    libraryDependencies += scalaTest % Test
  ).
  jsSettings(
    // Add JS-specific settings here
  )

lazy val nanoidJVM = nanoid.jvm
lazy val nanoidJS = nanoid.js
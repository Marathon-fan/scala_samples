import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test,
    // libraryDependencies += "com.softwaremill.macwire" %% "macros" % "1.0.5",
    // libraryDependencies += "com.softwaremill.macwire" %% "runtime" % "1.0.5"
    libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided",
    libraryDependencies += "com.softwaremill.macwire" %% "macrosakka" % "2.3.0" % "provided",
    libraryDependencies += "com.softwaremill.macwire" %% "util" % "2.3.0",                  
    libraryDependencies += "com.softwaremill.macwire" %% "proxy" % "2.3.0"
  )

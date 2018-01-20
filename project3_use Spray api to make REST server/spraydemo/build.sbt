import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.2",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",

	resolvers ++= Seq(
	  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
	  "Spray repository"    at "http://repo.spray.io/",
	  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
	  "spray repo" at "http://repo.spray.io"
	),


     libraryDependencies ++= Seq(
     scalaTest % Test,

	  // akka
	  "com.typesafe.akka" %% "akka-actor" % "2.3.2",
	  // spray
	  "io.spray" %% "spray-routing" % "1.3.1",
	  "io.spray" %% "spray-client" % "1.3.1",
	  "io.spray" %% "spray-testkit" % "1.3.1" % "test",
	  // macwire
	  "com.softwaremill.macwire" %% "macros" % "0.7",
	  "com.softwaremill.macwire" %% "runtime" % "0.7",
	  // async
	  "org.scala-lang.modules" %% "scala-async" % "0.9.1",
	  // util
	  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
	  "ch.qos.logback" % "logback-classic" % "1.1.2",
	  "org.scalatest" %% "scalatest" % "2.1.3" % "test",

    )
  )


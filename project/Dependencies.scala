import sbt._

object Dependencies {
  lazy val libraryDependencies: Seq[ModuleID] = Seq(
    "ch.qos.logback" % "logback-classic" % "1.1.7",
    "org.scalatest" %% "scalatest" % Versions.scalatest % Test,
    "com.iheart" %% "ficus" % "1.4.1",
    "com.typesafe" % "config" % Versions.config,
    "com.typesafe.akka" %% "akka-http-core" % Versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http" % Versions.akkaHttp,
    "com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttp % Test,
    "com.typesafe.akka" %% "akka-http-spray-json" % Versions.akkaHttp,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"
  )
}


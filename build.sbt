import sbt.Keys.aggregate

Seq(Revolver.settings: _*)
lazy val stage: String = sys.env.getOrElse("ENVIRONMENT", "development")

// Settings
lazy val commonSettings: Seq[Setting[_]] = Seq(
  organization := "com.example",
  scalaVersion := Versions.scala,
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xmax-classfile-name", "242"),
  javaOptions ++= Seq(
    s"-Djava.util.Arrays.useLegacyMergeSort=true",
    s"-Dfile.encoding=UTF-8",
    "-Xms2G",
    "-Xmx4G"
  ),
  fork in Global := true,
  test in assembly := {},
  aggregate in assembly := false
)

// Projects
lazy val root: Project = (project in file("."))
  .settings(name := "hello-server")
  .aggregate(server)

lazy val core: Project = project
  .settings(
    commonSettings,
    name := "core",
    libraryDependencies ++= Dependencies.libraryDependencies
  )

lazy val server: Project = project
  .settings(
    commonSettings,
    name := "server",
    mainClass in (Compile, run) := Some("com.example.application.Application"),
    libraryDependencies ++= Dependencies.libraryDependencies,
    javaOptions in Global ++= Seq(
      s"-Dlogback.configurationFile=src/main/resources/logback/$stage.xml"
    ),
    javaOptions in Test ++= Seq(
      s"-Dlogback.configurationFile=src/main/resources/logback/test.xml"
    )
  )
  .dependsOn(core)

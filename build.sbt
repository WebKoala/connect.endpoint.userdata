name := "ConnectUserdataApi"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  ws
)


lazy val root = (project in file(".")).enablePlugins(PlayScala)
    
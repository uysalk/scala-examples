name := """scala-examples"""

version := "1.0"

scalaVersion := "2.11.7"


resolvers := Seq(Resolver.url("http://repo1.maven.org/maven2/"))



libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"

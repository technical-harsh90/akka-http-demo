
name := "testable"

version := "0.1"

scalaVersion := "2.13.3"

val AkkaVersion = "2.6.10"
val akkaHttpV   = "10.2.1"
val scalaTestV  = "3.2.3"

//libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion
// https://mvnrepository.com/artifact/org.scala-lang.modules/scala-xml
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.3.0"

// https://mvnrepository.com/artifact/com.lucidchart/xtract
libraryDependencies += "com.lucidchart" %% "xtract" % "2.2.1"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % AkkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % AkkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % AkkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-http" % akkaHttpV
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV
libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV
libraryDependencies += "org.scalatest"     %% "scalatest" % scalaTestV % "test"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.0.8"
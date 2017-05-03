name := "play01"

version := "1.0"

lazy val `play01` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.11"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0" % Test

libraryDependencies += "org.mockito" % "mockito-all" % "1.8.4" % Test

libraryDependencies += "com.sksamuel.elastic4s" %% "elastic4s-core" % "5.1.5"

libraryDependencies += "com.sksamuel.elastic4s" %% "elastic4s-testkit" % "5.1.5" % Test

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  
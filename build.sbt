import play.Project._

name := "Play2App"

version := "1.0"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "com.googlecode.htmlcompressor"         % "htmlcompressor"        % "1.5.2"
)

playJavaSettings

templatesImport ++= Seq(
  java.util.List
)
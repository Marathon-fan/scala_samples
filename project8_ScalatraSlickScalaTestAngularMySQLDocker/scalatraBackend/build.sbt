organization := "org.scalatra.slickexample"
name := "Scalatra Slick"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.4"

val ScalatraVersion = "2.6.+"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"  % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % "test",
  "org.scalactic"           %% "scalactic"         % "3.0.4",
  "org.scalatest"           %% "scalatest"         % "3.0.4" % "test",
  "com.typesafe.slick"      %% "slick"             % "3.2.1",
  "com.typesafe.slick"      %% "slick-hikaricp"    % "3.2.1",
  "com.typesafe.slick"      %% "slick-codegen"     % "3.2.1",
  "mysql"                   % "mysql-connector-java" % "5.1.12",
  "com.h2database"          %  "h2"                % "1.4.196",
  "com.mchange"             %  "c3p0"              % "0.9.5.2",
  "ch.qos.logback"          %  "logback-classic"   % "1.2.3"            % "provided",
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.2.15.v20160210" % "container;compile",
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % "provided",
  "com.typesafe.play"       %% "play-json"         % "2.6.7",
  "org.apache.httpcomponents" % "httpclient"       % "4.5.5",
  "org.apache.httpcomponents" % "httpcore"         % "4.0-alpha6" 
)


enablePlugins(ScalatraPlugin)
enablePlugins(JavaAppPackaging)


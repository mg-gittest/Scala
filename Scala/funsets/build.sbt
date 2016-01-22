submitProjectName := "funsets"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

// This setting defines the project to which a solution is submitted. When creating a
// handout, the 'createHandout' task will make sure that its value is correct.
submitProjectName := "recfun"

libraryDependencies ++= {
  val c = currentProject.value
  if (c.isEmpty || c == "quickcheck") Seq(
    "org.scalacheck" %% "scalacheck" % "1.12.1"
  )
  else Seq.empty
}

libraryDependencies ++= {
  val c = currentProject.value
  if (c.isEmpty || c == "nodescala" || c == "suggestions") Seq(
    "com.netflix.rxjava" % "rxjava-scala" % "0.15.0",
    "org.json4s" %% "json4s-native" % "3.2.11",
    "org.scala-lang.modules" %% "scala-swing" % "1.0.1",
    "net.databinder.dispatch" %% "dispatch-core" % "0.11.0",
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    "org.slf4j" % "slf4j-api" % "1.7.5",
    "org.slf4j" % "slf4j-simple" % "1.7.5",
    "com.squareup.retrofit" % "retrofit" % "1.0.0",
    "org.scala-lang.modules" %% "scala-async" % "0.9.2"
  )
  else Seq.empty
}

libraryDependencies ++= {
  val c = currentProject.value
  if (c.isEmpty || c == "actorbintree" || c == "kvstore") Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.3.9",
    "com.typesafe.akka" %% "akka-testkit" % "2.3.9"
  )
  else Seq.empty
}

libraryDependencies ++= {
  val c = currentProject.value
  if (c.isEmpty || parProgProjects(c)) Seq(
    "com.storm-enroute" %% "scalameter-core" % "0.6",
    "com.github.scala-blitz" %% "scala-blitz" % "1.1",
    "com.storm-enroute" %% "scalameter" % "0.6" % "test"
  )
  else Seq.empty
}

fork := {
  val c = currentProject.value
  if (parProgProjects(c)) true
  else false
}

// See documentation in ProgFunBuild.scala
projectDetailsMap := {
val currentCourseId = "progfun-006"
val depsQuickcheck = Seq(
    "org.scalacheck" %% "scalacheck" % "1.12.1"
  )
Map(
  "example" ->  ProjectDetails(
                  packageName = "example",
                  assignmentPartId = "gTzFogNk",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "recfun" ->     ProjectDetails(
                  packageName = "recfun",
                  assignmentPartId = "4Rarn9Ki",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "funsets" ->    ProjectDetails(
                  packageName = "funsets",
                  assignmentPartId = "gBXOL7Rd",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "objsets" ->    ProjectDetails(
                  packageName = "objsets",
                  assignmentPartId = "25dMMEz7",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "patmat" ->     ProjectDetails(
                  packageName = "patmat",
                  assignmentPartId = "6gPmpcif",
                  maxScore = 20d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "forcomp" ->    ProjectDetails(
                  packageName = "forcomp",
                  assignmentPartId = "gG3oZGIO",
                  maxScore = 10d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "streams" ->    ProjectDetails(
                  packageName = "streams",
                  assignmentPartId = "1WKgCFCi",
                  maxScore = 20d,
                  styleScoreRatio = 0.2,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "quickcheck" -> ProjectDetails(
                  packageName = "quickcheck",
                  assignmentPartId = "02Vi5q7m",
                  maxScore = 10d,
                  styleScoreRatio = 0.0,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId,
                  dependencies=depsQuickcheck),
  "constraints"  -> ProjectDetails(
                  packageName = "constraints",
                  assignmentPartId = "kL1K2FAj",
                  maxScore = 10d,
                  styleScoreRatio = 0.0,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId),
  "interpreter"  -> ProjectDetails(
                  packageName = "interpreter",
                  assignmentPartId = "1SZhe1Ua283r87a7rd",
                  maxScore = 10d,
                  styleScoreRatio = 0.0,
                  styleSheet = (baseDirectory.value / "project" / "scalastyle_config.xml").toString,
                  courseId=currentCourseId)
)}

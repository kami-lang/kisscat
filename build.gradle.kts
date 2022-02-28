publication.data {
  val baseVersion = "0.1.0"
  version = "$baseVersion-LOCAL"
  // Used to publish non-local versions of artifacts in CI environment
  versionInCI = "$baseVersion-SNAPSHOT"

  displayName = "Kisscat"
  artifactId = "kisscat"
  groupId = "com.meowool.kami"
  description = "A common toolkit (utils) built to help you further reduce Kotlin boilerplate code and improve development efficiency."
  url = "https://github.com/kami-lang/${rootProject.name}"
  vcs = "$url.git"
  developer {
    id = "rin"
    name = "Rin Orz"
    url = "https://github.com/RinOrz/"
  }
}

subprojects {
  configurations.all {
    // Clear the cache every hour
    resolutionStrategy.cacheChangingModulesFor(1, TimeUnit.HOURS)
  }
  optIn("com.meowool.kisscat.internal.InternalKisscatApi")
  dokka(DokkaFormat.Html) {
    outputDirectory.set(rootDir.resolve("docs/apis"))
  }
  afterEvaluate {
    if (project.path != Projects.Mio && configurations.names.contains("api")) {
      dependencies.apiProject(Projects.Mio)
    }
  }
  kotlinExplicitApi()
}

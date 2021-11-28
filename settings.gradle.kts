@file:Suppress("SpellCheckingInspection")

rootProject.name = "kisscat"

pluginManagement {
  repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

plugins {
  id("com.meowool.gradle.toolkit") version "0.1.0-SNAPSHOT"
}

dependencyMapper {
  libraries {
    map("dev.zacsweers.autoservice:auto-service-ksp" to "Auto.Service.Ksp")
    map("it.unimi.dsi:fastutil" to "FastUtil")
    map("net.sf.jopt-simple:jopt-simple" to "JoptSimple")
  }
}

gradleToolkitWithMeowoolSpec()

importProjects(rootDir)

// Only set in the CI environment, waiting the issue to be fixed:
// https://youtrack.jetbrains.com/issue/KT-48291
if (isCiEnvironment) extra["kotlin.mpp.enableGranularSourceSetsMetadata"] = true
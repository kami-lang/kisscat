@file:Suppress("SpellCheckingInspection")

rootProject.name = "madex"

pluginManagement {
  repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}

plugins {
  id("com.meowool.gradle.toolkit") version "0.1.1-SNAPSHOT"
}

gradleToolkitWithMeowoolSpec()

importProjects(rootDir)
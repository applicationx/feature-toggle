plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
//    id("org.springframework.boot") version "2.7.5" apply false
    id("io.spring.dependency-management") version "1.0.15.RELEASE" apply true
//    kotlin("plugin.spring") version "1.3.50" apply false
    `kotlin-dsl`
}

dependencies {
    implementation("io.spring.gradle:dependency-management-plugin:1.0.15.RELEASE")
}

repositories {
    gradlePluginPortal()
    maven(url = "https://repo.spring.io/plugins-snapshot")
    maven(url = "https://repo.spring.io/snapshot")
    maven(url = "https://repo.spring.io/milestone")
}

plugins {
    id("org.springframework.boot") version "2.7.5" apply false
    id("io.spring.dependency-management") version "1.0.15.RELEASE" apply true
    `kotlin-dsl`
}
val springBootVersion:String by project
dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.7.5")
    implementation("io.spring.gradle:dependency-management-plugin:1.0.15.RELEASE")
}

repositories {
    gradlePluginPortal()
    maven(url = "https://repo.spring.io/plugins-snapshot")
    maven(url = "https://repo.spring.io/snapshot")
    maven(url = "https://repo.spring.io/milestone")
}

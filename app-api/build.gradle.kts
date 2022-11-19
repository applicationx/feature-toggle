plugins {
    id("se.handlar.toggle.java-library-conventions")
    id("io.spring.dependency-management")
    id("maven-publish")
    id("com.google.cloud.artifactregistry.gradle-plugin") version "2.2.0"
}


dependencies {
    implementation("io.projectreactor:reactor-core")

}

publishing {
    repositories {
        maven {
            val snapshotURL ="artifactregistry://europe-north1-maven.pkg.dev/upbeat-arch-369008/appx-labs-maven-snapshot"
            val releaseURL = "artifactregistry://europe-north1-maven.pkg.dev/upbeat-arch-369008/appx-labs-maven-release"
            val version: String by project
            url = uri(if (version.endsWith("SNAPSHOT")) snapshotURL else releaseURL)
        }
    }


    publications {
        create<MavenPublication>("maven") {
            groupId = "nu.handlar.toggle"
            artifactId = "app-api"
            version = "1.0.0-SNAPSHOT"

            from(components["java"])
        }
    }
}
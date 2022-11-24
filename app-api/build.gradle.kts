plugins {
    id("se.handlar.toggle.java-library-conventions")
    id("io.spring.dependency-management")
    id("maven-publish")
    id("com.google.cloud.artifactregistry.gradle-plugin") version "2.2.0"
}


dependencies {
    implementation("io.projectreactor:reactor-core")
    implementation("jakarta.validation:jakarta.validation-api")
    testImplementation("com.github.blocoio:faker:1.2.9")
}
tasks.register<Jar>("testJar") {
    archiveBaseName.set("${project.name}-test")
    from(project.the<SourceSetContainer>()["test"].output)
}
tasks.getByName("jar").dependsOn("testJar")

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
            from(components["java"])
        }
        create<MavenPublication>("mavenTest") {
            artifactId = "${project.name}-test"
            artifact(tasks.getByName("testJar"))
        }
    }
}


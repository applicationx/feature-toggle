plugins {
    id("se.handlar.toggle.java-library-conventions")
    id("io.spring.dependency-management")
    id("maven-publish")
}


dependencies {
    implementation("io.projectreactor:reactor-core")
    implementation("jakarta.validation:jakarta.validation-api")
    // Test
    testImplementation("com.github.blocoio:faker:1.2.9")
}
tasks.getByName<Jar>("jar") {
    archiveBaseName.set("${parent?.name}")
}
tasks.register<Jar>("testJar") {
    archiveBaseName.set("${parent?.name}-test")
    from(project.the<SourceSetContainer>()["test"].output)
}
tasks.getByName("jar").dependsOn("testJar")

publishing {
    repositories {
        maven {
            val version: String by project
            when (version.endsWith("SNAPSHOT")) {
                true -> {
                    name = "nexus-snapshots"
                    url = uri(properties["nexusSnapshots"].toString())
                }
                false -> {
                    name = "nexus-releases"
                    url = uri(properties["nexusReleases"].toString())
                }
            }
            credentials {
                username = properties["nexusUsername"].toString()
                password = properties["nexusPassword"].toString()
            }
        }
    }


    publications {
        create<MavenPublication>("maven") {
            artifactId = "${parent?.name}"
            from(components["java"])
        }
        create<MavenPublication>("mavenTest") {
            artifactId = "${parent?.name}-test"
            artifact(tasks.getByName("testJar"))
        }
    }
}


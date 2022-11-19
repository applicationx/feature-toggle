plugins {
    id("se.handlar.toggle.java-application-conventions")
    id("org.springframework.boot")
    id("com.google.cloud.artifactregistry.gradle-plugin") version "2.2.0"

}

dependencies {
    implementation(project(":app-api"))
    implementation(project(":rest"))

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("com.github.blocoio:faker:1.2.9")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}


repositories {
    maven {
        url = uri("artifactregistry://europe-north1-maven.pkg.dev/upbeat-arch-369008/appx-labs-maven-snapshot")
    }
    maven {
        url = uri("artifactregistry://europe-north1-maven.pkg.dev/upbeat-arch-369008/appx-labs-maven-release")
    }
}

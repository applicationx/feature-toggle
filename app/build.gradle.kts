import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    id("se.handlar.toggle.java-application-conventions")
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":app-api"))

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("jakarta.validation:jakarta.validation-api")

    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.4.3")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:testcontainers:1.17.6")
    testImplementation("org.testcontainers:junit-jupiter:1.17.6")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.testcontainers:mongodb:1.17.6")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("com.github.blocoio:faker:1.2.9")
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    this.archiveFileName.set("${archiveBaseName.get()}.${archiveExtension.get()}")
}
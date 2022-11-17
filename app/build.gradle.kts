plugins {
    id("se.handlar.toggle.java-application-conventions")
    id("org.springframework.boot")
//    id("io.spring.dependency-management")
}
dependencyManagement {
    imports {
        val springCloudVersion:String by project
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}
/*
configurations {
    compileOnly {
        extendsFrom(annotationProcessor.get())
    }
}

 */

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
//    implementation("org.mapstruct:mapstruct:1.5.3.Final")
//    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    implementation("org.mapstruct:mapstruct")
    annotationProcessor("org.mapstruct:mapstruct-processor")

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

//application {
//    // Define the main class for the application.
//    mainClass.set("se.handlar.toggle.app.App")
//}
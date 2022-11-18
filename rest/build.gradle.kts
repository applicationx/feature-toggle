plugins {
    id("se.handlar.toggle.java-library-conventions")
    id("io.spring.dependency-management")
}

dependencies {
    api(project(":app-api"))
    implementation("io.projectreactor:reactor-core")
    implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-context")
    implementation("jakarta.validation:jakarta.validation-api")
}

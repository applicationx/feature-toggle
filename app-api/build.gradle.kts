plugins {
    id("se.handlar.toggle.java-library-conventions")
    id("io.spring.dependency-management")
}


dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}
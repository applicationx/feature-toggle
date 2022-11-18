plugins {
    java
    id("io.spring.dependency-management")
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven(url = "https://jitpack.io")
    maven(url = "https://repo.spring.io/snapshot")
    maven(url = "https://repo.spring.io/milestone")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencyManagement {
    imports {
        val springCloudVersion:String by project
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
    }
}

dependencies {

    constraints {
        val mapstructVersion:String by project
        implementation("org.mapstruct:mapstruct:1.5.3.Final")
        annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
        implementation("org.apache.commons:commons-text:1.9")
    }

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
//    implementation("org.mapstruct:mapstruct:1.5.3.Final")
//    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    implementation("org.mapstruct:mapstruct")
    annotationProcessor("org.mapstruct:mapstruct-processor")

}


configurations {
    compileOnly {
        extendsFrom(annotationProcessor.get())
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.8.2")
        }
    }
}

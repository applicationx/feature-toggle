settingsEvaluated {
    pluginManagement {
        plugins {
            id("org.springframework.boot") version "2.7.5"
            id("io.spring.dependency-management") version "1.0.15.RELEASE"
        }
        resolutionStrategy {

        }
        repositories {
            gradlePluginPortal()
            maven(url = "https://repo.spring.io/plugins-snapshot")
        }
    }
}
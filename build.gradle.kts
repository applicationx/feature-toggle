plugins {
    java
    id("org.springframework.boot") version "2.7.5" apply false
    //id("io.spring.dependency-management") version "1.0.15.RELEASE" apply true
}

//subprojects {
//    apply {
//        plugin("io.spring.dependency-management")
//    }
//}

/*
dependencies {
    constraints {
        val springCloudVersion:String by project
        implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"))

    }
}

 */

/*
dependencyManagement {
    imports {
        val springCloudVersion:String by project
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.5")
    }
}
*/
allprojects {
    group = "nu.handlar.toggle"
    version = "1.0.0"
}
/*
subprojects {
    apply {
        plugin("io.spring.dependency-management")
    }

}
 */
/*
    dependencyManagement {
        imports {
            val springCloudVersion:String by project
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
        }
    }


 */

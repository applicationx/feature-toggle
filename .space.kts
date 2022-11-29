/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Hello World!") {
    container(displayName = "Say Hello", image = "hello-world")
}
job("Build and run tests") {
   gradlew("amazoncorretto:17-alpine", "build")
}

job("Build and push Docker") {
    host("Build artifacts and a Docker image") {
        // generate artifacts required for the image
        shellScript {
            content = """
                ./gradlew build
            """
        }

        dockerBuildPush {
            // Docker context, by default, project root
            context = "docker"
            // path to Dockerfile relative to project root
            // if 'file' is not specified, Docker will look for it in 'context'/Dockerfile
            file = "app/Dockerfile"
            labels["vendor"] = "handlar"
            //args["HTTP_PROXY"] = "http://10.20.30.1:123"

            val spaceRepo = "handlar.registry.jetbrains.space/p/handlar/docker-release/$spaceRepo"
            // image tags for 'docker push'
            tags {
                +"$spaceRepo:1.0.${"$"}JB_SPACE_EXECUTION_NUMBER"
                +"$spaceRepo:latest"
            }
        }
    }
}
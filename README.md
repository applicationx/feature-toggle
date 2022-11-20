[![CI](https://github.com/applicationx/feature-toggle/actions/workflows/github-basic.yml/badge.svg)](https://github.com/applicationx/feature-toggle/actions/workflows/github-basic.yml)

# feature-toggle
Simple java 17/Spring Boot project that provides feature-toggles for backend and frontend to consume. This project is created to try on technologies that I don't usually work with such as gradle, reactive spring boot, ArgoCD and Kubernetes. 

Written with technologies:
* Java 17
* Gradle v7.5.1 (Multi module)
* Spring Boot
* Reactive Web
* Reactive Mongo
* Google Artifact Repository (Uploads library project files)
* Docker Hub (Uploads Spring Boot docker)
* feature-toggle-k8s will contain kubernetes files to use with [ArgoCD](https://github.com/argoproj/argo-cd) and GitOps
* GitHub actions workflow to build, test and deploy to maven repository and docker-hub

To run locally you need to start `docker/mongo.yml`by typing `docker-compose mongo.yml`. 
This will start mongo on port 27017. 

### Next step
* To call rest endpoints from other java Spring Boot projects im considering exposing RestApi interface and use [Reactive Feign client](https://github.com/PlaytikaOSS/feign-reactive) to make the calls and wrap it in Hysterix 
or creating a boot with client beans that can be imported to other projects.

* Move Spring Boot configuration over to either Git or Hashicorp Vault

* Setup Eureka

* Implement micro frontend (React) that also get pushed to Docker-Hub


package nu.handlar.toggle.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
// Spring boot application with basepackage from gradle.properties


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "feature-toggle", version = "1.0", description = "Feature-Toggle v1.0"))
public class AppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
}

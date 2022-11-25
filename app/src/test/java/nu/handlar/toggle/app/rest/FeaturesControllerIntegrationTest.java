package nu.handlar.toggle.app.rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.app.model.domain.FeatureService;
import nu.handlar.toggle.app.model.domain.FeatureTestBuilder;

@Testcontainers(disabledWithoutDocker = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class FeaturesControllerIntegrationTest {

	@Container
	public static final MongoDBContainer mongoDbContainer = new MongoDBContainer("mongo:4.2.3").withExposedPorts(27017);

	@BeforeAll
	public static void setUp() {
		mongoDbContainer.start();
	}

	@DynamicPropertySource
	public static void overrideProperties(org.springframework.test.context.DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDbContainer::getReplicaSetUrl);
	}

	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private FeatureService featureService;

	@Test
	void getFeature() {

		Feature expected = FeatureTestBuilder.random();
		featureService.save(expected).block();

		webTestClient.get().uri("/features/" + expected.getId())
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectAll(
						res -> res.expectStatus().isOk(),
						res -> res.expectBody()
								.jsonPath("$.id").isEqualTo(expected.getId())
								.jsonPath("$.description").isEqualTo(expected.getDescription())
								.jsonPath("$.enabled").isEqualTo(expected.getEnabled()));
	}
}

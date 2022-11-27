package nu.handlar.toggle.app.rest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.app.model.domain.FeatureService;
import nu.handlar.toggle.app.model.domain.FeatureTestBuilder;
import reactor.test.StepVerifier;

@Testcontainers(disabledWithoutDocker = true)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class FeaturesControllerIntegrationTest {

	@Container
	public static final MongoDBContainer mongoDbContainer = new MongoDBContainer("mongo:4.2.3").withExposedPorts(27017);

	@Container
	public static final KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest")).withExposedPorts(9092, 9093);

	@BeforeAll
	public static void setUp() {
		mongoDbContainer.start();
		kafkaContainer.start();
	}

	@DynamicPropertySource
	public static void overrideProperties(org.springframework.test.context.DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDbContainer::getReplicaSetUrl);
		registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
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

	// https://stackoverflow.com/questions/56360094/calling-methods-in-two-different-reactivemongorepositorys-in-a-transaction-usin/61676211#61676211 setup mongodb for transactions
	@Test
	void saveFeature() {
		Feature expected = FeatureTestBuilder.random();
		webTestClient.post().uri("/features")
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(expected)
				.exchange()
				.expectAll(
						res -> res.expectStatus().isCreated(),
						res -> res.expectBody()
								.jsonPath("$.id").isEqualTo(expected.getId())
								.jsonPath("$.description").isEqualTo(expected.getDescription())
								.jsonPath("$.enabled").isEqualTo(expected.getEnabled()));

		featureService.findById(expected.getId())
				.as(StepVerifier::create)
				.expectNext(expected)
				.verifyComplete();
	}
}

package nu.handlar.toggle.rest.api;

import io.bloco.faker.Faker;

public final class ApiFeatureTestBuilder {
	private ApiFeatureTestBuilder() {
	}

	public static ApiFeature.ApiFeatureBuilder randomBuilder() {
		Faker faker = new Faker();
		return ApiFeature.builder()
				.id(faker.app.name().toLowerCase().replace(" ", "-").toLowerCase())
				.description(faker.lorem.paragraph())
				.enabled(faker.bool.bool(0.3f));
	}

	public static ApiFeature random() {
		return randomBuilder().build();
	}

}
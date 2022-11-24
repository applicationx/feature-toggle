package nu.handlar.toggle.app.model.domain;

import io.bloco.faker.Faker;

public final class FeatureTestBuilder {

	public static Feature.FeatureBuilder randomBuilder() {
		Faker faker = new Faker();
		return Feature.builder()
				.id(faker.app.name().toLowerCase())
				.description(faker.lorem.paragraph(10))
				.enabled(faker.bool.bool(0.3f));
	}

	public static Feature random() {
		return randomBuilder().build();
	}

}
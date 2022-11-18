package nu.handlar.toggle.app.api.service;

import nu.handlar.toggle.app.api.model.Feature;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeatureService {
	Mono<Feature> save(Feature feature);

	Flux<Feature> findAll();

	Mono<Void> deleteById(String id);

	Mono<Feature> update(Feature feature);

	Mono<Feature> findById(String id);
}

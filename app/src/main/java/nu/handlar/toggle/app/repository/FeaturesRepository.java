package nu.handlar.toggle.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import nu.handlar.toggle.app.model.dao.FeatureDao;
import reactor.core.publisher.Flux;

public interface FeaturesRepository extends ReactiveMongoRepository<FeatureDao, String> {

	Flux<FeatureDao> findByIdLike(String description);
}

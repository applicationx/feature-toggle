package nu.handlar.toggle.app.service;

import java.util.Objects;

import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import nu.handlar.toggle.app.error.CantSendRecordException;
import nu.handlar.toggle.app.facade.KafkaSender;
import nu.handlar.toggle.app.model.domain.FeatureService;
import nu.handlar.toggle.app.config.DomainMappers;
import nu.handlar.toggle.app.error.FeatureAlreadyExistsException;
import nu.handlar.toggle.app.error.FeatureNotFoundException;
import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.app.repository.FeaturesRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class FeatureServiceImpl implements FeatureService {

	private final DomainMappers mappers;
	private final FeaturesRepository repository;

	private final KafkaSender kafkaSender;


	public FeatureServiceImpl(DomainMappers mappers, FeaturesRepository repository, KafkaSender kafkaSender) {
		this.mappers = Objects.requireNonNull(mappers, "mappers");
		this.repository = Objects.requireNonNull(repository, "repository");
		this.kafkaSender = Objects.requireNonNull(kafkaSender, "kafkaSender");
	}

//	@Transactional
	@Override
	public Mono<Feature> save(Feature feature) {
		return repository.findById(feature.getId())
				.doOnNext(dao -> {
					throw new FeatureAlreadyExistsException(String.format("Feature with ID=%s already exists", feature.getId()));
				})
				.switchIfEmpty(repository.save(mappers.toDao(feature)))
				.map(mappers::toDomain)
				.doOnNext(kafkaSender::create);
	}

	@Override
	public Flux<Feature> findAll() {
		return repository.findAll()
				.map(mappers::toDomain);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return repository.deleteById(id);
	}

	@Override
	public Mono<Feature> update(Feature feature) {
		return repository.findById(feature.getId())
				.switchIfEmpty(Mono.error(new FeatureNotFoundException("Unable to find feature {}".replace("{}", feature.getId().toString()))))
				.map(dao -> mappers.toDao(feature))
				.flatMap(repository::save)
				.map(mappers::toDomain);
	}

	@Override
	public Mono<Feature> findById(String id) {
		return repository.findById(id)
				.map(mappers::toDomain);
	}

	@Override
	public Flux<Feature> findByIdLike(String id) {
		return repository.findByIdLike(id)
				.map(mappers::toDomain);
	}
}

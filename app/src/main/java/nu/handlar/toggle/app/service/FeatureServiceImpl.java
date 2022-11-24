package nu.handlar.toggle.app.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import nu.handlar.toggle.app.model.domain.FeatureService;
import nu.handlar.toggle.app.config.DomainMappers;
import nu.handlar.toggle.app.error.FeatureAlreadyExistsException;
import nu.handlar.toggle.app.error.FeatureNotFoundException;
import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.app.repository.FeaturesRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FeatureServiceImpl implements FeatureService {

	private final DomainMappers mappers;
	private final FeaturesRepository repository;

	public FeatureServiceImpl(DomainMappers mappers, FeaturesRepository repository) {
		this.mappers = Objects.requireNonNull(mappers, "mappers");
		this.repository = Objects.requireNonNull(repository, "repository");
	}

	@Override
	public Mono<Feature> save(Feature feature) {
		return repository.findById(feature.getId())
				.map(dao -> {
					if (dao.getId().equals(feature.getId())) {
						throw new FeatureAlreadyExistsException(String.format("Feature toggle with id %s already exist", feature.getId()));
					}
					return mappers.toDomain(dao);
				})
				.switchIfEmpty(repository
						.save(mappers.toDao(feature))
						.map(mappers::toDomain));
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

package nu.handlar.toggle.app.rest;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nu.handlar.toggle.app.mapper.RestMappers;
import nu.handlar.toggle.rest.api.ApiCreateFeature;
import nu.handlar.toggle.rest.api.ApiFeature;
import nu.handlar.toggle.rest.api.ApiUpdateFeature;
import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.app.model.domain.FeatureService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/features")
public class FeaturesController {

	private final RestMappers mappers;
	private final FeatureService domain;

	public FeaturesController(RestMappers mappers, FeatureService domain) {
		this.mappers = Objects.requireNonNull(mappers, "mappers");
		this.domain = Objects.requireNonNull(domain, "domain");
	}

	@GetMapping
	public Flux<ApiFeature> getFeatures() {
		return domain.findAll()
				.map(mappers::toApi);
	}


	@GetMapping(path = "{id}")
	public Mono<ApiFeature> getFeature(@PathVariable("id") String id) {
		return domain.findById(id)
				.map(mappers::toApi);
	}

	@GetMapping(path = "{id}/enabled")
	public Mono<Boolean> isEnabled(@PathVariable("id") String id) {
		return domain.findById(id)
				.cache()
				.map(Feature::getEnabled);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Mono<ApiFeature> save(@RequestBody @Valid ApiCreateFeature apiCreateFeature) {
		return domain.save(mappers.toDomain(apiCreateFeature)).map(mappers::toApi);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/{id}")
	public Mono<Void> delete(@PathVariable("id") String id) {
		return domain.deleteById(id);
	}

	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PutMapping(path = "/{id}")
	public Mono<ApiFeature> update(@PathVariable("id") String id, @RequestBody ApiUpdateFeature apiUpdateFeature) {
		return domain.update(mappers.create(id, apiUpdateFeature))
				.map(mappers::toApi);
	}
}

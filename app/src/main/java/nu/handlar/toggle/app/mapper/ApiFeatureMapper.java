package nu.handlar.toggle.app.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.rest.api.ApiFeature;

@Mapper(componentModel = "spring")

public interface ApiFeatureMapper {

	@Mapping(source = "description", target = "description", qualifiedByName = "unwrap")
	Feature toDomain(ApiFeature api);

	@Named("unwrap")
	default <T> T optionalToObj(Optional<T> input) {
		return input.orElse(null);
	}
}

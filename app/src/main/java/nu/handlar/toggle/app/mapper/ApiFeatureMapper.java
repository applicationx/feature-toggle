package nu.handlar.toggle.app.mapper;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.rest.api.ApiFeature;

@Mapper(componentModel = "spring")

public interface ApiFeatureMapper {

	Feature toDomain(ApiFeature api);
}

package nu.handlar.toggle.app.mapper;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.model.api.ApiFeature;
import nu.handlar.toggle.app.api.model.Feature;

@Mapper(componentModel = "spring")

public interface ApiFeatureMapper {

	Feature toDomain(ApiFeature api);
}

package nu.handlar.toggle.app.mapper;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.rest.api.ApiCreateFeature;

@Mapper(componentModel = "spring")
public interface ApiCreateFeatureMapper {

	Feature toDomain(ApiCreateFeature api);
}

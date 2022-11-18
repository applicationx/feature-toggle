package nu.handlar.toggle.rest.mapper;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.api.model.Feature;
import nu.handlar.toggle.rest.model.ApiCreateFeature;

@Mapper(componentModel = "spring")
public interface ApiCreateFeatureMapper {

	Feature toDomain(ApiCreateFeature api);
}

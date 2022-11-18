package nu.handlar.toggle.app.mapper;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.model.api.ApiCreateFeature;
import nu.handlar.toggle.app.api.model.Feature;

@Mapper(componentModel = "spring")
public interface ApiCreateFeatureMapper {

	Feature toDomain(ApiCreateFeature api);
}

package nu.handlar.toggle.app.mapper.factory;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.model.api.ApiUpdateFeature;
import nu.handlar.toggle.app.model.domain.Feature;

@Mapper(componentModel = "spring")
public interface FeatureFactory {

	Feature create(String id, ApiUpdateFeature api);
}

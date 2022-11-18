package nu.handlar.toggle.rest.mapper.factory;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.api.model.Feature;
import nu.handlar.toggle.rest.model.ApiUpdateFeature;

@Mapper(componentModel = "spring")
public interface FeatureFactory {

	Feature create(String id, ApiUpdateFeature api);
}

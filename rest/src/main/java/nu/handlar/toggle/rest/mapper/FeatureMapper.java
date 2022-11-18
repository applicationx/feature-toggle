package nu.handlar.toggle.rest.mapper;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.api.model.Feature;
import nu.handlar.toggle.rest.model.ApiFeature;

@Mapper(componentModel = "spring")
public interface FeatureMapper {

	ApiFeature toApi(Feature domain);
}

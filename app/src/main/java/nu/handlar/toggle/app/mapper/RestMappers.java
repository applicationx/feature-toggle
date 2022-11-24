package nu.handlar.toggle.app.mapper;

import org.springframework.stereotype.Component;

import lombok.Data;
import nu.handlar.toggle.app.model.domain.Feature;
import nu.handlar.toggle.app.mapper.factory.FeatureFactory;
import nu.handlar.toggle.rest.api.ApiCreateFeature;
import nu.handlar.toggle.rest.api.ApiFeature;
import nu.handlar.toggle.rest.api.ApiUpdateFeature;

@Component
@Data
public class RestMappers {
	private final ApiFeatureMapper apiFeatureMapper;
	private final ApiCreateFeatureMapper apiCreateFeatureMapper;

	private final FeatureFactory featureFactory;

	private final FeatureMapper featureMapper;

	public Feature toDomain(ApiFeature api) {
		return apiFeatureMapper.toDomain(api);
	}

	public Feature toDomain(ApiCreateFeature api) {
		return apiCreateFeatureMapper.toDomain(api);
	}

	public ApiFeature toApi(Feature domain) {
		return featureMapper.toApi(domain);
	}

	public Feature create(String id, ApiUpdateFeature apiUpdateFeature) {
		return featureFactory.create(id, apiUpdateFeature);
	}

}

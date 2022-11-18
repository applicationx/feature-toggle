package nu.handlar.toggle.rest.config;

import org.springframework.stereotype.Component;

import lombok.Data;
import nu.handlar.toggle.app.api.model.Feature;
import nu.handlar.toggle.rest.mapper.ApiCreateFeatureMapper;
import nu.handlar.toggle.rest.mapper.ApiFeatureMapper;
import nu.handlar.toggle.rest.mapper.DomainFeatureMapper;
import nu.handlar.toggle.rest.mapper.factory.FeatureFactory;
import nu.handlar.toggle.rest.model.ApiCreateFeature;
import nu.handlar.toggle.rest.model.ApiFeature;
import nu.handlar.toggle.rest.model.ApiUpdateFeature;

@Component
@Data
public class RestMappers {
	private final ApiFeatureMapper apiFeatureMapper;
	private final ApiCreateFeatureMapper apiCreateFeatureMapper;

	private final FeatureFactory featureFactory;

	private final DomainFeatureMapper domainFeatureMapper;


	public Feature toDomain(ApiFeature api) {
		return apiFeatureMapper.toDomain(api);
	}

	public Feature toDomain(ApiCreateFeature api) {
		return apiCreateFeatureMapper.toDomain(api);
	}

	public ApiFeature toApi(Feature domain) {
		return domainFeatureMapper.toApi(domain);
	}

	public Feature create(String id, ApiUpdateFeature apiUpdateFeature) {
		return featureFactory.create(id, apiUpdateFeature);
	}

}

package nu.handlar.toggle.app.config;

import org.springframework.stereotype.Component;

import lombok.Data;
import nu.handlar.toggle.app.mapper.ApiCreateFeatureMapper;
import nu.handlar.toggle.app.mapper.ApiFeatureMapper;
import nu.handlar.toggle.app.mapper.FeatureDaoMapper;
import nu.handlar.toggle.app.mapper.FeatureMapper;
import nu.handlar.toggle.app.mapper.factory.FeatureFactory;
import nu.handlar.toggle.app.model.api.ApiCreateFeature;
import nu.handlar.toggle.app.model.api.ApiFeature;
import nu.handlar.toggle.app.model.api.ApiUpdateFeature;
import nu.handlar.toggle.app.model.dao.FeatureDao;
import nu.handlar.toggle.app.model.domain.Feature;

@Component
@Data
public class DomainMappers {
	private final ApiFeatureMapper apiFeatureMapper;
	private final ApiCreateFeatureMapper apiCreateFeatureMapper;
	private final FeatureDaoMapper featureDaoMapper;

	private final FeatureFactory featureFactory;

	private final FeatureMapper featureMapper;

	public FeatureDao toDao(Feature domain) {
		return featureMapper.toDao(domain);
	}

	public Feature toDomain(FeatureDao dao) {
		return featureDaoMapper.toDomain(dao);
	}

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

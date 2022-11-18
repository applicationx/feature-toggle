package nu.handlar.toggle.app.config;

import org.springframework.stereotype.Component;

import lombok.Data;
import nu.handlar.toggle.app.api.model.Feature;
import nu.handlar.toggle.app.mapper.FeatureDaoMapper;
import nu.handlar.toggle.app.mapper.FeatureMapper;
import nu.handlar.toggle.app.model.dao.FeatureDao;

@Component
@Data
public class DomainMappers {
	private final FeatureDaoMapper featureDaoMapper;

	private final FeatureMapper featureMapper;

	public FeatureDao toDao(Feature domain) {
		return featureMapper.toDao(domain);
	}

	public Feature toDomain(FeatureDao dao) {
		return featureDaoMapper.toDomain(dao);
	}
}

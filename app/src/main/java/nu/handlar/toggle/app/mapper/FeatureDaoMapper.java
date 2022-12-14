package nu.handlar.toggle.app.mapper;

import org.mapstruct.Mapper;

import nu.handlar.toggle.app.model.dao.FeatureDao;
import nu.handlar.toggle.app.model.domain.Feature;

@Mapper(componentModel = "spring")
public interface FeatureDaoMapper {

	Feature toDomain(FeatureDao dao);
}

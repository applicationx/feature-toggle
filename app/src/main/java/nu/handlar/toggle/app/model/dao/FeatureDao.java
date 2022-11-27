package nu.handlar.toggle.app.model.dao;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import nu.handlar.toggle.rest.api.HasIdType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
@Document
public class FeatureDao  implements HasIdType<String> {
	@MongoId
	private String id;
	private String description;
	private Boolean enabled;
}

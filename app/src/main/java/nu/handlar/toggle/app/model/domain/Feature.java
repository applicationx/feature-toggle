package nu.handlar.toggle.app.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(of = {"id"})
@Builder(toBuilder = true)
public class Feature {
	@NonNull
	private final String id;
	private final String description;
	private final Boolean enabled;
}

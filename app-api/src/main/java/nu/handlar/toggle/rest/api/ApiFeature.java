package nu.handlar.toggle.rest.api;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiFeature implements HasIdType<String> {
	@NonNull
	private String id;
	private String description;
	@NonNull
	private boolean enabled;

	public Optional<String> getDescription() {
		return Optional.ofNullable(description);
	}

}

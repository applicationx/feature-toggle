package nu.handlar.toggle.message.api;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class FeatureCreatedMessage {
	@NonNull
	private String id;
	private String description;
	private boolean enabled;

	public Optional<String> getDescription() {
		return Optional.ofNullable(description);
	}
}

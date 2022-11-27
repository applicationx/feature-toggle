package nu.handlar.toggle.message.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class FeatureToggledMessage {
	@NonNull
	private String id;
	private boolean enabled;
}

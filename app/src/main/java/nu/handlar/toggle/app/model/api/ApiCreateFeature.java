package nu.handlar.toggle.app.model.api;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiCreateFeature implements HasIdType<String> {
	@Pattern(regexp = "^[a-z0-9\\-]+$") // Should only accept small letters and dashes
	private String id;
	private String description;
	private Boolean enabled;
}

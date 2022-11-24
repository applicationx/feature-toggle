package nu.handlar.toggle.rest.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiFeature implements HasIdType<String>{
	private String id;
    private String description;
    private Boolean enabled;
}

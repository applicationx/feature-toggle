package nu.handlar.toggle.app.config;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JSONMapper {

	private final ObjectMapper mapper;

	public JSONMapper(ObjectMapper mapper) {
		this.mapper = Objects.requireNonNull(mapper, "mapper");
	}
	public String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public <T> T fromJson(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

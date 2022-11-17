package nu.handlar.toggle.app.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FeatureNotFoundException extends IllegalArgumentException {
	public FeatureNotFoundException() {
	}

	public FeatureNotFoundException(String s) {
		super(s);
	}

	public FeatureNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FeatureNotFoundException(Throwable cause) {
		super(cause);
	}
}

package nu.handlar.toggle.app.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FeatureAlreadyExistsException extends IllegalArgumentException {

	public FeatureAlreadyExistsException() {
	}

	public FeatureAlreadyExistsException(String s) {
		super(s);
	}

	public FeatureAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public FeatureAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}

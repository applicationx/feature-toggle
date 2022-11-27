package nu.handlar.toggle.app.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CantSendRecordException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CantSendRecordException(String message, Throwable cause) {
		super(message, cause);
	}

	public CantSendRecordException(Throwable cause) {
		super(cause);
	}
}

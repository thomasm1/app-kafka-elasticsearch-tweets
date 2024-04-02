package app.mapl.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public ApiException( String message) {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = message;
    }
    public ApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public ApiException(String message, HttpStatus status, String messageExtra) {
        super(message);
        this.status = status;
        this.message = messageExtra;
    }

    public HttpStatus getStatus() {
        return status;
    }
    @Override
    public String getMessage() {
        return message;
    }
}

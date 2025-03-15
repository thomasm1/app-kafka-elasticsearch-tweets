package net.ourdailytech.rest.exception;

import org.springframework.http.HttpStatus;

public class PostApiException extends RuntimeException {
    private HttpStatus status;
    private String message;
    public PostApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public PostApiException(String message, HttpStatus status, String messageExtra) {
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

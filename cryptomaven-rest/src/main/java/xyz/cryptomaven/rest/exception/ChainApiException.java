package xyz.cryptomaven.rest.exception;

import org.springframework.http.HttpStatus;

public class ChainApiException extends RuntimeException {
  private HttpStatus status;
  private String message;

  public ChainApiException(HttpStatus status, String message) {
    this.status = status;
    this.message = message;
  }

  public ChainApiException(String message, HttpStatus status, String messageExtra) {
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

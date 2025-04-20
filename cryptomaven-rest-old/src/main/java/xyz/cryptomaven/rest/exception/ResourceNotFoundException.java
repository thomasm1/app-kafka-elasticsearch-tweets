package xyz.cryptomaven.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
  private String resourceName;
  private String fieldName;
  private String fieldValue;
  private String message;

  public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
    super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // Post not found with id : 1
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }


  public ResourceNotFoundException(String message) {
    super(String.format(" not found : '%s'", message));
  }

  public ResourceNotFoundException(String message, Throwable cause) {
    super(String.format(" %s  not found with cause: '%s'", message, cause));
  }

  public ResourceNotFoundException(Throwable cause) {
    super(String.format(" cause found   : '%s'", cause));
  }

  public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(String.format("%s not %s found with %s : '%s'", message, cause, enableSuppression, writableStackTrace));
  }

}

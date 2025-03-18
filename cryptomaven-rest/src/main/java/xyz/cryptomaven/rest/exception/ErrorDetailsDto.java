package xyz.cryptomaven.rest.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class ErrorDetailsDto implements Serializable {
    static long serialVersionUID = 1L;
    private List<Map<String,String>> errors;
    private  Date timestamp;
    private  String message;
    private  String details;

    public ErrorDetailsDto(List<Map<String,String>> errors, Date timestamp, String message, String details) {
        this.errors = errors;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    public ErrorDetailsDto(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public List<Map<String,String>>  getErrors() {
        return errors;
    }
    public void setErrors(List<Map<String,String>>  errors) {
        this.errors = errors;
    }
}

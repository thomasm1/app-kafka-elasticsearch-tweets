package app.mapl.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Response;
import org.springframework.http.HttpStatus;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Map;

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


    public static void handleErrorResponse(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        if (exception instanceof AccessDeniedException) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }
        throw new RuntimeException(response.toString());
    }

}

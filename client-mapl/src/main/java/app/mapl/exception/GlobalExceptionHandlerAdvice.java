package app.mapl.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice  {  //extends ResponseEntityExceptionHandler
    @ExceptionHandler
    public ProblemDetail handleIllegalStateException(IllegalStateException e) {
        var pdh = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
        pdh.setDetail("IllegalStateException" + e.getMessage());
        return pdh;
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDto> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest){
        ErrorDetailsDto eErrorDetailsDto = new ErrorDetailsDto(new Date(), exception.getMessage(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(eErrorDetailsDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostApiException.class)
    public ResponseEntity<ErrorDetailsDto> handlePostApiException(PostApiException exception, WebRequest webRequest){
        ErrorDetailsDto eErrorDetailsDto = new ErrorDetailsDto(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(eErrorDetailsDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDto> handleGlobalException(Exception exception,
                                                               WebRequest webRequest){
        ErrorDetailsDto eErrorDetailsDto = new ErrorDetailsDto(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(eErrorDetailsDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetailsDto> handleAccessDeniedException(AccessDeniedException exception,
                                                                    WebRequest webRequest){
        ErrorDetailsDto eErrorDetailsDto = new ErrorDetailsDto(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(eErrorDetailsDto, HttpStatus.FORBIDDEN);
    }
// MethodArgumentNotValidException.
// MethodArgumentNotValidException.fieldErrors().getfields()
// MethodArgumentNotValidException.fieldErrors().getDefaultMessage()

     @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Object> maplHandleBindErrors(MethodArgumentNotValidException exception){
         String message = "Error: MethodArgumentNotValidException";
        // List of Mapped errors
        List<Map<String, String>> errorList = exception.getFieldErrors().stream()
                .map(fieldError -> {
                    Map<String, String > errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorList);
    }


}

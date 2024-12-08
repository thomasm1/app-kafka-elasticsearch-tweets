package com.friendsofgroot.app.exception;

import com.friendsofgroot.app.models.dto.ErrorDetailsDto;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //data

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    ResponseEntity<ErrorDetailsDto> handleJPAViolations(TransactionSystemException exception){
        return ResponseEntity.badRequest().build();
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDto> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                           WebRequest webRequest){
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetailsDto> handleAccessDeniedException(AccessDeniedException exception,
                                                                       WebRequest webRequest){
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    /// Method from ResponseEntityExceptionHandler
    @Override
    protected  ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException notValidException,
                                                                   HttpHeaders headers,
                                                                   HttpStatusCode statusCode,
                                                                   WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        notValidException.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldError = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldError, message);

        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
// CUSTOM MethodArgumentNotValidException
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    ResponseEntity<Object> maplHandleBindErrors(MethodArgumentNotValidException exception){
//        String message = "Error: MethodArgumentNotValidException";
//        // List of Mapped errors
//        List<Map<String, String>> errorList = exception.getFieldErrors().stream()
//                .map(fieldError -> {
//                    Map<String, String > errorMap = new HashMap<>();
//                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//                    return errorMap;
//                }).collect(Collectors.toList());
//
//        return ResponseEntity.badRequest().body(errorList);
//    }


    @ExceptionHandler(EmailAlreadyExistsException.class)
public ResponseEntity<ErrorDetailsDto> handleEmailAlreadyExists(EmailAlreadyExistsException e ) {
        ErrorDetailsDto errorDetailsDto = new ErrorDetailsDto(
              new Date(), e.getMessage(),
                "USER_NOT_REGISTERED"
        );
        return new ResponseEntity<>(errorDetailsDto, HttpStatus.NOT_FOUND);
}

    @ExceptionHandler(PostApiException.class)
    public ResponseEntity<ErrorDetailsDto> handlePostApiException(PostApiException exception, WebRequest webRequest){
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDto> handleGlobalException(Exception exception,
                                                                 WebRequest webRequest){
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

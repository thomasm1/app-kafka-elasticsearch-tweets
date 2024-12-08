package app.mapl.exception

import app.mapl.models.dto.ErrorDetailsDto
import org.apache.commons.logging.Log
import org.slf4j.Logger
import org.springframework.context.MessageSource
import org.springframework.http.ResponseEntity
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GlobalExceptionHandlerTest extends Specification {
    @Mock
    Logger log
    @Mock
    Log pageNotFoundLogger
    @Mock
    Log logger
    @Mock
    MessageSource messageSource
    @InjectMocks
    GlobalExceptionHandler globalExceptionHandler

    def setup() {
        MockitoAnnotations.openMocks(this)
    }

    def "test validation Error Handler"() {
        when:
        ResponseEntity<List> result = globalExceptionHandler.validationErrorHandler(null)

        then:
        result == null
    }

    def "test handle JPA Violations"() {
        when:
        ResponseEntity<ErrorDetailsDto> result = globalExceptionHandler.handleJPAViolations(null)

        then:
        result == null
    }

    def "test handle Resource Not Found Exception"() {
        when:
        ResponseEntity<ErrorDetailsDto> result = globalExceptionHandler.handleResourceNotFoundException(new ResourceNotFoundException("message", null, true, true), null)

        then:
        result == null
    }

    def "test handle Access Denied Exception"() {
        when:
        ResponseEntity<ErrorDetailsDto> result = globalExceptionHandler.handleAccessDeniedException(null, null)

        then:
        result == null
    }

    def "test handle Method Argument Not Valid"() {
        when:
        ResponseEntity<Object> result = globalExceptionHandler.handleMethodArgumentNotValid(null, null, null, null)

        then:
        result == null
    }

    def "test handle Email Already Exists"() {
        when:
        ResponseEntity<ErrorDetailsDto> result = globalExceptionHandler.handleEmailAlreadyExists(new EmailAlreadyExistsException("message"))

        then:
        result == null
    }

    def "test handle Post Api Exception"() {
        when:
        ResponseEntity<ErrorDetailsDto> result = globalExceptionHandler.handlePostApiException(new PostApiException("message", null, "messageExtra"), null)

        then:
        result == null
    }

    def "test handle Global Exception"() {
        when:
        ResponseEntity<ErrorDetailsDto> result = globalExceptionHandler.handleGlobalException(null, null)

        then:
        result == null
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme

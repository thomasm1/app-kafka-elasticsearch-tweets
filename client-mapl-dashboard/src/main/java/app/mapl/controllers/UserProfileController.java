package app.mapl.controllers;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.UserProfileDto;
import app.mapl.service.UserProfileService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

import static java.util.Collections.emptyMap;

@RestController
@RequestMapping("api/userProfiles")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserProfileController {

    private UserProfileService userProfileService;

    // Build Save Transaction REST APIfw
    @PostMapping
    public ResponseEntity<UserProfileDto> saveUserProfile(@RequestBody @Valid UserProfileDto userProfileDto, HttpServletRequest request){
        UserProfileDto savedUserProfile = userProfileService.saveUserProfile(userProfileDto);
        return ResponseEntity.created(getUri()).body((UserProfileDto) getResponse(request, emptyMap(), "AccountCreated"));
    }
/// TODO
    private Object getResponse(HttpServletRequest request, Map<Object, Object> emptyMap, String accountCreated) {
        return null;
    }

    private URI getUri() {
        return URI.create("http://localhost:8080/api/userProfiles");
    }

    // Build Get Transaction REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getUserProfile(@PathVariable("id") Long userProfileId){
        APIResponseDto apiResponseDto = userProfileService.getUserProfileById(userProfileId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}

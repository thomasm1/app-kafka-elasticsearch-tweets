package app.mapl.controllers;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.UserProfileDto;
import app.mapl.service.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/userProfiles")
@AllArgsConstructor
public class UserProfileController {

    private UserProfileService userProfileService;

    // Build Save Transaction REST API
    @PostMapping
    public ResponseEntity<UserProfileDto> saveUserProfile(@RequestBody UserProfileDto userProfileDto){
        UserProfileDto savedUserProfile = userProfileService.saveUserProfile(userProfileDto);
        return new ResponseEntity<>(savedUserProfile, HttpStatus.CREATED);
    }

    // Build Get Transaction REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getUserProfile(@PathVariable("id") Long userProfileId){
        APIResponseDto apiResponseDto = userProfileService.getUserProfileById(userProfileId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}

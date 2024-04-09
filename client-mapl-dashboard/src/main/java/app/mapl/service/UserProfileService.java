package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.UserProfileDto;

public interface UserProfileService {
    UserProfileDto saveUserProfile(UserProfileDto employeeDto);

    UserProfileDto createUserProfile(UserProfileDto userProfileDto);

    APIResponseDto getUserProfileById(Long employeeId);

    APIResponseDto verifyAccountKey(String key);
}

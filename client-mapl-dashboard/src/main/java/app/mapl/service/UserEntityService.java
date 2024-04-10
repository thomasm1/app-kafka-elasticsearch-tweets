package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.UserEntityDto;

public interface UserEntityService {
    UserEntityDto saveUserEntity(UserEntityDto employeeDto);

    UserEntityDto createUserEntity(UserEntityDto uerEntityDto);

    APIResponseDto getUserEntityById(Long employeeId);

    APIResponseDto verifyAccountKey(String key);
}

package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.models.RoleEntity;
import app.mapl.models.UserEntity;

public interface UserEntityService {
    UserEntity createUserEntityRole(String firstName, String lastName, String email);

    RoleEntity getRoleName(String name);

    UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role);

    UserEntity getUserEntityByEmail(String email);

    APIResponseDto getUserEntityById(Long employeeId);

    void verifyAccountKey(String key);
}

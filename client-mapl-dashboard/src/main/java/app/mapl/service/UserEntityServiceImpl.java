package app.mapl.service;

import app.mapl.dto.APIResponseDto;

import app.mapl.exception.ApiException;
import app.mapl.mapper.UserMapper;
import app.mapl.models.Authority;
import app.mapl.models.ConfirmationEntity;
import app.mapl.models.RoleEntity;
import app.mapl.models.UserEntity;
import app.mapl.repositories.ConfirmationRepository;
import app.mapl.repositories.RoleEntityRepository;
import app.mapl.repositories.UserEntityRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import static app.mapl.models.UserEntity.buildUserEntity;


@Service
@AllArgsConstructor
public class UserEntityServiceImpl implements  UserEntityService {

    private UserEntityRepository uerEntityRepository;
    private ConfirmationRepository confirmationRepository;
    private RoleEntityRepository roleRepository;
    private UserMapper userMapper;
//    private WebClient webClient;
//    private APIClient apiClient;


    @Override
    public UserEntity createUserEntityRole(String firstName, String lastName, String email) {
        var role = getRoleName(Authority.USER.name());
    return createUserEntity(firstName, lastName, email, role);
    }

    public static APIResponseDto getResponse(HttpServletRequest request, Map<?, ?> data, String message, HttpStatus status) {

        return new APIResponseDto(LocalDateTime.now().toString(), status.value(),  request.getRequestURI(), data);
    }
    /**
     * @param name
     * @return
     */
    @Override
    public RoleEntity getRoleName(String name) {
    return roleRepository.findByName(name).orElseThrow(() -> new ApiException("Role not found"));

    }


    private ConfirmationEntity getConfirmationEntity(String key) {
        return confirmationRepository.findByKey(key).orElseThrow(() -> new ApiException("Confirmation not found"));
    }

    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param role
     * @return UserEntity
     */
    @Override
    public UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role) {
        UserEntity  userEntity =  buildUserEntity(firstName, lastName, email, role);
        Optional<UserEntity> savedUserEntity = Optional.ofNullable(uerEntityRepository.save(userEntity));
          return  savedUserEntity.get();

    }

    /**
     * @param email
     * @return UserEntity
     */
    @Override
    public UserEntity  getUserEntityByEmail(String email) {
        var uerEntity = uerEntityRepository.findByEmailIgnoreCase(email);
//    var uerEntityDto = userMapper.toUserEntityDto(uerEntity.get());
        return uerEntity.orElseThrow(() ->  new ApiException("User not found"));
    }

    /**
     * @param key
     * @return
     */
    @Override
    public void verifyAccountKey(String key) {
        var confirmationEntity = getConfirmationEntity(key);
        var uerEntity = getUserEntityByEmail(confirmationEntity.getUserEntity().getEmail());
        uerEntity.setEnabled(true);
        uerEntityRepository.save(uerEntity);
        confirmationRepository.delete(confirmationEntity);
//        return new APIResponseDto("Account verified");
    }
    /**
     * @param uerEntityId
     * @return UserEntity
     */
    @Override
    public APIResponseDto getUserEntityById(Long uerEntityId) {

        Optional<app.mapl.models.UserEntity> uerEntity = uerEntityRepository.findById(uerEntityId) ;

//
//        ResponseEntity<DashboardDto> responseEntity = getForEntity("http://localhost:8080/api/dashboards/" + uerEntity.getDashboardCode(),
//                DashboardDto.class);
//
//        DashboardDto dashboardDto = responseEntity.getBody();
//
//        DashboardDto dashboardDto = webClient.get()
//                .uri("http://localhost:8080/api/dashboards/" + uerEntity.getDashboardCode())
//                .retrieve()
//                .bodyToMono(DashboardDto.class)
//                .block();

//        DashboardDto dashboardDto = apiClient.getDashboard(uerEntity.getDashboardCode()); // TODO:
//
//        UserEntityDto uerEntityDto = new UserEntityDto(
//                uerEntity.getId(),
//                uerEntity.getFirstName(),
//                uerEntity.getLastName(),
//                uerEntity.getEmail(),
//                uerEntity.getDashboardCode(),
//                uerEntity.getOrganizationCode()
//        );

        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setUserEntity(uerEntityDto);
//        apiResponseDto.setDashboard(dashboardDto);

        return apiResponseDto;
    }


}

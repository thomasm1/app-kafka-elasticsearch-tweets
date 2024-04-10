package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.DashboardDto;
import app.mapl.dto.UserEntityDto;

import app.mapl.mapper.UserMapper;
import app.mapl.models.UserEntity;
import app.mapl.repositories.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserEntityServiceImpl implements  UserEntityService {

    private UserEntityRepository uerEntityRepository;
    private UserMapper userMapper;
//    private WebClient webClient;
//    private APIClient apiClient;

    /**
     * @param employeeDto
     * @return
     */
    @Override
    public UserEntityDto saveUserEntity(UserEntityDto employeeDto) {
        return null;
    }

    @Override
    public UserEntityDto createUserEntity(UserEntityDto uerEntityDto) {

        uerEntityDto.setDashboardCode("DASHBOARD_CODE");
        uerEntityDto.setOrganizationCode("ORGANIZATION_CODE");
        UserEntity savedUserEntity = uerEntityRepository.save(userMapper.toUserEntity(uerEntityDto));

        UserEntityDto savedUserEntityDto = new UserEntityDto(
                savedUserEntity.getId(),
                savedUserEntity.getFirstName(),
                savedUserEntity.getLastName(),
                savedUserEntity.getEmail(),
                savedUserEntity.getDashboardCode(),
                savedUserEntity.getOrganizationCode()
        );

        return savedUserEntityDto;
    }

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

    /**
     * @param key
     * @return
     */
    @Override
    public APIResponseDto verifyAccountKey(String key) {
        return null;
        //TODO: implement
    }
}

package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.DashboardDto;
import app.mapl.dto.UserProfileDto;

import app.mapl.mapper.UserMapper;
import app.mapl.models.UserProfile;
import app.mapl.repositories.UserProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements  UserProfileService {

    private UserProfileRepository userProfileRepository;
    private UserMapper userMapper;
//    private WebClient webClient;
//    private APIClient apiClient;

    /**
     * @param employeeDto
     * @return
     */
    @Override
    public UserProfileDto saveUserProfile(UserProfileDto employeeDto) {
        return null;
    }

    @Override
    public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {

        userProfileDto.setDashboardCode("DASHBOARD_CODE");
        userProfileDto.setOrganizationCode("ORGANIZATION_CODE");
        UserProfile savedUserProfile = userProfileRepository.save(userMapper.toUserProfile(userProfileDto));

        UserProfileDto savedUserProfileDto = new UserProfileDto(
                savedUserProfile.getId(),
                savedUserProfile.getFirstName(),
                savedUserProfile.getLastName(),
                savedUserProfile.getEmail(),
                savedUserProfile.getDashboardCode(),
                savedUserProfile.getOrganizationCode()
        );

        return savedUserProfileDto;
    }

    @Override
    public APIResponseDto getUserProfileById(Long userProfileId) {

        Optional<app.mapl.models.UserProfile> userProfile = userProfileRepository.findById(userProfileId) ;

//
//        ResponseEntity<DashboardDto> responseEntity = getForEntity("http://localhost:8080/api/dashboards/" + userProfile.getDashboardCode(),
//                DashboardDto.class);
//
//        DashboardDto dashboardDto = responseEntity.getBody();
//
//        DashboardDto dashboardDto = webClient.get()
//                .uri("http://localhost:8080/api/dashboards/" + userProfile.getDashboardCode())
//                .retrieve()
//                .bodyToMono(DashboardDto.class)
//                .block();

//        DashboardDto dashboardDto = apiClient.getDashboard(userProfile.getDashboardCode()); // TODO:
//
//        UserProfileDto userProfileDto = new UserProfileDto(
//                userProfile.getId(),
//                userProfile.getFirstName(),
//                userProfile.getLastName(),
//                userProfile.getEmail(),
//                userProfile.getDashboardCode(),
//                userProfile.getOrganizationCode()
//        );

        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setUserProfile(userProfileDto);
//        apiResponseDto.setDashboard(dashboardDto);

        return apiResponseDto;
    }
}

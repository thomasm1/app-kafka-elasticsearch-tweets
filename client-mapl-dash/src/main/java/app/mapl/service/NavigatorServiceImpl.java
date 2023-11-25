package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.DashboardDto;
import app.mapl.dto.NavigatorDto;
import app.mapl.models.Navigator;
import app.mapl.repositories.NavigatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class NavigatorServiceImpl implements  NavigatorService {

    private NavigatorRepository navigatorRepository;

    // private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiClient;

    /**
     * @param employeeDto
     * @return
     */
    @Override
    public NavigatorDto saveNavigator(NavigatorDto employeeDto) {
        return null;
    }

    @Override
    public NavigatorDto createNavigator(NavigatorDto navigatorDto) {

        Navigator navigator = new Navigator(
                navigatorDto.getId(),
                navigatorDto.getFirstName(),
                navigatorDto.getLastName(),
                navigatorDto.getEmail(),
                navigatorDto.getDashboardCode(),
                navigatorDto.getOrganizationCode()
        );

        Navigator saveDNavigator = navigatorRepository.save(navigator);

        NavigatorDto savedNavigatorDto = new NavigatorDto(
                saveDNavigator.getId(),
                saveDNavigator.getFirstName(),
                saveDNavigator.getLastName(),
                saveDNavigator.getEmail(),
                saveDNavigator.getDashboardCode(),
                saveDNavigator.getDashboardCode()
        );

        return savedNavigatorDto;
    }

    @Override
    public APIResponseDto getNavigatorById(Long navigatorId) {

        Navigator navigator = navigatorRepository.findById(navigatorId).get();


//        ResponseEntity<DashboardDto> responseEntity = getForEntity("http://localhost:8080/api/dashboards/" + navigator.getDashboardCode(),
//                DashboardDto.class);
//
//        DashboardDto dashboardDto = responseEntity.getBody();

//        DashboardDto dashboardDto = webClient.get()
//                .uri("http://localhost:8080/api/dashboards/" + navigator.getDashboardCode())
//                .retrieve()
//                .bodyToMono(DashboardDto.class)
//                .block();
//
        DashboardDto dashboardDto = apiClient.getDashboard(navigator.getDashboardCode()); // TODO:

        NavigatorDto navigatorDto = new NavigatorDto(
                navigator.getId(),
                navigator.getFirstName(),
                navigator.getLastName(),
                navigator.getEmail(),
                navigator.getDashboardCode(),
                navigator.getOrganizationCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setNavigator(navigatorDto);
        apiResponseDto.setDashboard(dashboardDto);

        return apiResponseDto;
    }
}

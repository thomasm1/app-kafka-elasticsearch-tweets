package app.mapl.service;

import app.mapl.dto.DashboardDto;
import app.mapl.dto.NavigatorDto;
import app.mapl.dto.NavigatorDto;
import app.mapl.mapper.NavigatorMapper;
import app.mapl.mapper.NavigatorMapper;
import app.mapl.models.Navigator;
import app.mapl.models.Navigator;
import app.mapl.repositories.NavigatorRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import app.mapl.dto.APIResponseDto;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@AllArgsConstructor
public class NavigatorServiceImpl implements  NavigatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NavigatorServiceImpl.class);

    private NavigatorRepository navigatorRepository;

    // private RestTemplate restTemplate;
    private WebClient webClient;
//    private APIClient apiClient;

    /**
     * @param navigatorDto
     * @return
     */
    @Override
    public NavigatorDto saveNavigator(NavigatorDto navigatorDto) {

        Navigator navigator = NavigatorMapper.mapToNavigator(navigatorDto);

        Navigator saveDNavigator = navigatorRepository.save(navigator);

        NavigatorDto savedNavigatorDto = NavigatorMapper.mapToNavigatorDto(saveDNavigator);

        return savedNavigatorDto;
    }

    @Override
    public NavigatorDto createNavigator(NavigatorDto navigatorDto) {

        Navigator navigator = NavigatorMapper.mapToNavigator(navigatorDto);

        Navigator saveDNavigator = navigatorRepository.save(navigator);

        NavigatorDto savedNavigatorDto = NavigatorMapper.mapToNavigatorDto(saveDNavigator);

        return savedNavigatorDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDashboard")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDashboard")
    @Override
    public APIResponseDto getNavigatorById(Long navigatorId) {

        LOGGER.info("inside getNavigatorById() method");
        Navigator navigator = navigatorRepository.findById(navigatorId).get();
//        ResponseEntity<DashboardDto> responseEntity = getForEntity("http://localhost:8080/api/dashboards/" + navigator.getDashboardCode(),
//                DashboardDto.class);
//
//        DashboardDto dashboardDto = responseEntity.getBody();

        DashboardDto dashboardDto = webClient.get()
                .uri("http://localhost:${}/api/dashboards/" + navigator.getDashboardCode())
                .retrieve()
                .bodyToMono(DashboardDto.class)
                .block();
//
//        DashboardDto dashboardDto = apiClient.getDashboard(navigator.getDashboardCode()); // TODO:

        NavigatorDto navigatorDto = NavigatorMapper.mapToNavigatorDto(navigator);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setNavigator(navigatorDto);
        apiResponseDto.setDashboard(dashboardDto);

        return apiResponseDto;
    }
}

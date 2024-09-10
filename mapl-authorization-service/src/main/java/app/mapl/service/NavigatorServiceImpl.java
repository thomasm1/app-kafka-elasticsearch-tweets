package app.mapl.service;

import app.mapl.dto.DashboardDto;
import app.mapl.dto.NavigatorDto;
import app.mapl.dto.NavigatorDto;
import app.mapl.mapper.NavigatorMapper;
import app.mapl.mapper.NavigatorMapper;
import app.mapl.models.Navigator;
import app.mapl.models.Navigator;
import app.mapl.repositories.NavigatorReactiveRepository;
import app.mapl.repositories.NavigatorRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import app.mapl.dto.APIResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class NavigatorServiceImpl implements  NavigatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NavigatorServiceImpl.class);

    private NavigatorRepository navigatorRepository;

    private NavigatorReactiveRepository navigatorReactiveRepository;

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
    ///////////////////////// REACTIVE //////////////////////////
    @Override
    public Mono<NavigatorDto> saveReactiveNavigator(NavigatorDto navigatorDto) {
        // convert NavigatorDTO into Navigator Entity
        Navigator navigator = NavigatorMapper.mapToNavigator(navigatorDto);
        Mono<Navigator> savedNavigator = navigatorReactiveRepository.save(navigator);
        return savedNavigator
                .map((navigatorEntity) -> NavigatorMapper.mapToNavigatorDto(navigatorEntity));
    }

    @Override
    public Mono<NavigatorDto> getReactiveNavigator(String navigatorId) {
        Mono<Navigator> savedNavigator = navigatorReactiveRepository.findById(Long.valueOf(navigatorId));
        return savedNavigator
                .map((navigator) -> NavigatorMapper.mapToNavigatorDto(navigator));
    }

    @Override
    public Flux<NavigatorDto> getAllReactiveNavigators() {

        Flux<Navigator> navigatorFlux = navigatorReactiveRepository.findAll();

        return navigatorFlux
                .map(NavigatorMapper::mapToNavigatorDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<NavigatorDto> updateReactiveNavigator(NavigatorDto navigatorDto, String navigatorId) {

        Mono<Navigator> navigatorMono = navigatorReactiveRepository.findById(Long.valueOf(navigatorId));

        Mono<Navigator> updatedNavigator = navigatorMono.flatMap((existingNavigator) -> {
            existingNavigator.setFirstName(navigatorDto.getFirstName());
            existingNavigator.setLastName(navigatorDto.getLastName());
            existingNavigator.setEmail(navigatorDto.getEmail());

            return navigatorReactiveRepository.save(existingNavigator);
        });
        return updatedNavigator
                .map((navigator) -> NavigatorMapper.mapToNavigatorDto(navigator));
    }

    @Override
    public Mono<Void> deleteReactiveNavigator(String navigatorId) {
        return navigatorReactiveRepository.deleteById(Long.valueOf(navigatorId));
    }
}

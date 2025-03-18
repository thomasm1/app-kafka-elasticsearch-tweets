package app.mapl.services;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.NavigatorDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NavigatorService {
    NavigatorDto saveNavigator(NavigatorDto navigatorDto);

    NavigatorDto createNavigator(NavigatorDto navigatorDto);

    APIResponseDto getNavigatorById(Long navigatorId);

/////////// REACTIVE ////////////////
Mono<NavigatorDto> saveReactiveNavigator(NavigatorDto navigatorDto);

    Mono<NavigatorDto> getReactiveNavigator(String navigatorId);

    Flux<NavigatorDto> getAllReactiveNavigators();

    Mono<NavigatorDto> updateReactiveNavigator(NavigatorDto navigatorDto, String navigatorId);

    Mono<Void> deleteReactiveNavigator(String navigatorId);
}

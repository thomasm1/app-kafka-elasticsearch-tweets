package app.mapl.mapper;

import app.mapl.dto.NavigatorDto;
import app.mapl.models.Navigator;

public class NavigatorMapper {

    public static NavigatorDto mapToNavigatorDto(Navigator navigator){
        NavigatorDto navigatorDto = new NavigatorDto(
                navigator.getId(),
                navigator.getFirstName(),
                navigator.getLastName(),
                navigator.getEmail(),
                navigator.getDashboardCode(),
                navigator.getOrganizationCode()
        );
        return navigatorDto;
    }

    public static Navigator mapToNavigator(NavigatorDto navigatorDto){
        Navigator navigator = new Navigator(
                navigatorDto.getId(),
                navigatorDto.getFirstName(),
                navigatorDto.getLastName(),
                navigatorDto.getEmail(),
                navigatorDto.getDashboardCode(),
                navigatorDto.getOrganizationCode()
        );
        return navigator;
    }
}

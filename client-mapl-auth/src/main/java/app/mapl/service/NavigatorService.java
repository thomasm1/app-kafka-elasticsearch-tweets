package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.NavigatorDto;

public interface NavigatorService {
    NavigatorDto saveNavigator(NavigatorDto employeeDto);

    NavigatorDto createNavigator(NavigatorDto navigatorDto);

    APIResponseDto getNavigatorById(Long employeeId);
}

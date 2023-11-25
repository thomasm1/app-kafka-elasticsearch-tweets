package app.mapl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private NavigatorDto navigatorDto;
    private DashboardDto dashboard;

    public void setNavigator(NavigatorDto navigatorDto) {
    }
}

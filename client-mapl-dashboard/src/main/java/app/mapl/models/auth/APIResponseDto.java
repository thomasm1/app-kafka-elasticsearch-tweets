package app.mapl.models.auth;

import app.mapl.models.auth.User;
import app.mapl.models.dto.DashboardDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private User userEntity;
    private DashboardDto dashboard;
    private String accountVerified;

    public APIResponseDto(String toString, int value, String requestURI, Map<?,?> data) {
    }

}

package app.mapl.dto;

import app.mapl.models.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private UserEntity userEntity;
    private DashboardDto dashboard;
    private String accountVerified;

    public APIResponseDto(String toString, int value, String requestURI, Map<?,?> data) {
    }

    public void setUserEntity(UserEntity uerEntity ) {
    }
}

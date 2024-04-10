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
    private UserEntityDto uerEntityDto;
    private DashboardDto dashboard;

    public void setUserEntity(UserEntityDto uerEntityDto) {
    }
}

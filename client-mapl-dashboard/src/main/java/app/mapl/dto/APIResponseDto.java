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
    private UserProfileDto userProfileDto;
    private DashboardDto dashboard;

    public void setUserProfile(UserProfileDto userProfileDto) {
    }
}

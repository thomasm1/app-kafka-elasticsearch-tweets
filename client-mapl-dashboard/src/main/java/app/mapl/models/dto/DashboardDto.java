package app.mapl.models.dto;

import app.mapl.models.dto.DashboardDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link DashboardDto}
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDto {
    private Long id;
    private String dashboardName;
    private String dashboardDescription;
    private String dashboardCode;
}

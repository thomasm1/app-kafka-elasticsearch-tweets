package app.mapl.dto;

import app.mapl.dto.DashboardDto;
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

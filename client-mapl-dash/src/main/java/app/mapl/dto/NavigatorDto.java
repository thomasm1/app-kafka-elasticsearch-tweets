package app.mapl.dto;

import app.mapl.models.Navigator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Navigator}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NavigatorDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String dashboardCode;
}

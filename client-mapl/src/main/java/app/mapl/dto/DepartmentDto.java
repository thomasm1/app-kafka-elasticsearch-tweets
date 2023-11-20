package app.mapl.dto;

import app.mapl.models.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Department}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentDto implements Serializable {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}

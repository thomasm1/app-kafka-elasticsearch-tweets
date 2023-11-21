package com.doggywood.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link com.doggywood.entities.Employee}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDto implements Serializable {
    private int id;
    private int eType;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String dashboardCode;

}

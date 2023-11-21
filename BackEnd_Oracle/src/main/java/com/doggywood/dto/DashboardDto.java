package com.doggywood.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

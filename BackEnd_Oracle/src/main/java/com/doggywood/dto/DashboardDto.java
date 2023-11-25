package com.doggywood.dto;


public class DashboardDto {
    private Long id;
    private String dashboardName;
    private String dashboardDescription;
    private String dashboardCode;

    public DashboardDto(Long id, String dashboardName, String dashboardDescription, String dashboardCode) {
        this.id = id;
        this.dashboardName = dashboardName;
        this.dashboardDescription = dashboardDescription;
        this.dashboardCode = dashboardCode;
    }
}

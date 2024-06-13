package app.mapl.service;


import app.mapl.models.dto.DashboardDto;

public interface DashboardService {
    DashboardDto saveDashboard(DashboardDto dashboardDto);

    DashboardDto getDashboardByCode(String code);
}

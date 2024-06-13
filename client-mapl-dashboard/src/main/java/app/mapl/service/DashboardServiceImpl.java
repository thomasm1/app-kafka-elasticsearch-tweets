package app.mapl.service;

import app.mapl.models.dto.DashboardDto;
import app.mapl.models.Dashboard;
import app.mapl.repositories.DashboardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private DashboardRepository dashboardRepository;

    @Override
    public DashboardDto saveDashboard(DashboardDto dashboardDto) {

        Dashboard dashboard = new Dashboard(
                dashboardDto.getId(),
                dashboardDto.getDashboardName(),
                dashboardDto.getDashboardDescription(),
                dashboardDto.getDashboardCode()
        );

        Dashboard savedDashboard = dashboardRepository.save(dashboard);

        DashboardDto savedDashboardDto = new DashboardDto(
                savedDashboard.getId(),
                savedDashboard.getDashboardName(),
                savedDashboard.getDashboardDescription(),
                savedDashboard.getDashboardCode()
        );

        return savedDashboardDto;
    }

    @Override
    public DashboardDto getDashboardByCode(String dashboardCode) {

        Dashboard dashboard = dashboardRepository.findByDashboardCode(dashboardCode);

        DashboardDto dashboardDto = new DashboardDto(
                dashboard.getId(),
                dashboard.getDashboardName(),
                dashboard.getDashboardDescription(),
                dashboard.getDashboardCode()
        );
        return dashboardDto;
    }
}

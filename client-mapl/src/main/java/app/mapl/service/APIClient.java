package app.mapl.service;
import app.mapl.dto.DashboardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    // Build get dashboard rest api
    @GetMapping("api/dashboards/{dashboard-code}")
    DashboardDto getDashboard(@PathVariable("dashboard-code") String dashboardCode);
}

package app.mapl.service;
 
import app.mapl.dto.DashboardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DASHBOARD-SERVICE")
//@FeignClient(url = "http://localhost:8080", value = "DASHBOARD-SERVICE")
public interface APIClient {
    // Build   dashboard for USER-AUTH rest api
    @GetMapping("api/dashboards/{dashboard-code}")
    DashboardDto getDashboard(@PathVariable("dashboard-code") String dashboardCode);
}

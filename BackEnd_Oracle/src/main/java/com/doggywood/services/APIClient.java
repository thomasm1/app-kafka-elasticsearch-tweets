package com.doggywood.services;

//import org.springframework.cloud.openfeign.FeignClient;
import com.doggywood.dto.DashboardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/dashboards/{dashboard-code}")
    DashboardDto getDashboard(@PathVariable("dashboard-code") String dashboardCode);
}

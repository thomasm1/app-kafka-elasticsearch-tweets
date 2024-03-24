package app.mapl.controllers;

import app.mapl.dto.DashboardDto;
import app.mapl.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/dashboards")
@AllArgsConstructor
public class DashboardController {

    private DashboardService dashboardService;

    // Build save dashboard REST API
    @PostMapping
    public ResponseEntity<DashboardDto> saveDashboard(@RequestBody DashboardDto dashboardDto){
        DashboardDto savedDashboard = dashboardService.saveDashboard(dashboardDto);
        return new ResponseEntity<>(savedDashboard, HttpStatus.CREATED);
    }

    // Build get dashboard rest api
    @GetMapping("{dashboard-code}")
    public ResponseEntity<DashboardDto> getDashboard(@PathVariable("dashboard-code") String dashboardCode){
        DashboardDto dashboardDto = dashboardService.getDashboardByCode(dashboardCode);
        return new ResponseEntity<>(dashboardDto, HttpStatus.OK);
    }


}

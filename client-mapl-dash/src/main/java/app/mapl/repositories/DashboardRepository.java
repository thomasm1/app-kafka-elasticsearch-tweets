package app.mapl.repositories;

import app.mapl.models.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    Dashboard findByDashboardCode(String dashboardCode);

}

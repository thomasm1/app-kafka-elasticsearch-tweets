package app.mapl.repositories;

import app.mapl.models.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChainsRepository extends JpaRepository<Chain, Integer> {
    Chain findByName(String name);
}
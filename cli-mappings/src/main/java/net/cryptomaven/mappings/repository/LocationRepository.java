package net.cryptomaven.mappings.repository;

import net.cryptomaven.mappings.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

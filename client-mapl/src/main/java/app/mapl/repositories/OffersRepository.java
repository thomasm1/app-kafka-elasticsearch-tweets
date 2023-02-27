package app.mapl.repositories;

import app.mapl.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersRepository extends JpaRepository<Offer, Integer> {
}

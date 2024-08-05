package app.mapl.repositories;

import app.mapl.models.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinsRepository extends JpaRepository<Coin, Integer> {
//    Object findByUsername(String username); // logic needed
}
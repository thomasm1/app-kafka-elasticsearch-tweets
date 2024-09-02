package app.mapl.repositories;

import app.mapl.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Address, Integer> {
}

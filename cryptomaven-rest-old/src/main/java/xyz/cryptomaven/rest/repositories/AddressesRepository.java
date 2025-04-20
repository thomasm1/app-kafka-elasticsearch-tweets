package xyz.cryptomaven.rest.repositories;

import xyz.cryptomaven.rest.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressesRepository extends JpaRepository<Address, Long> {
}

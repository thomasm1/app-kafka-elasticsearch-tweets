package com.revature.repositories;

        import com.revature.beans.Address;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

/**
 * AddressRepository which extends the JpaRepository.
 * This repository handles location queries.
 *
 * @author Thomas Maestas
 *
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}

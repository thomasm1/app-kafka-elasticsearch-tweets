package app.mapl.repositories;

import app.mapl.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel="address", path = "address")
public interface AddressesRepository extends JpaRepository<Address, Integer> {

    List<Address> getAddressesByEmail(@Param("email") String email);



//    //// JPQL ///////////////////////////////////
//    // JOINS
//    @Query(nativeQuery = true, value="SELECT  address.email, users.firstName,users.lastName, address.address, address.chain, address.chainId, address.iconUrl FROM users JOIN address ON users.email = address.email  ORDER BY email DESC")
//    List<AddressResponse> getAddressesByUser(String email);
//
//    @Query(nativeQuery = true, value="SELECT a.email,u.firstName,  u.lastName, a.ADDRESS, a.CHAIN, a.iconUrl from ADDRESS a, USER u where a.email = u.email and a.email = ?1")
//    AddressResponse getAddressByUser(String email); //ChartData is a custom class
////    public AddressResponse getAddressByUser(String email); //ChartData is a custom class
//    // SEARCH BY EMAIL
//    @Query(nativeQuery = true, value = "SELECT * FROM ADDRESS WHERE EMAIL LIKE '%?1'")
//    List<Address> getAddressesByEmailStartsWith(String email);
//
//
//    @Query(value = "SELECT * FROM ADDRESS a WHERE a.chain LIKE '%?1%' OR a.symbol", nativeQuery = true)
//    List<Address> search(String keyword);
//
//
//    @Query(value = "FROM ADDRESS WHERE address LIKE '%?1'", nativeQuery = true)
//    List<Address> getAddressStartsBy(String keyword);
//
//
//    @Query(value = "SELECT * FROM ADDRESS a WHERE a.address LIKE '?1%'", nativeQuery = true)
//    List<Address> getAddressEndsBy(String keyword);

}

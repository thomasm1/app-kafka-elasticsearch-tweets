package xyz.cryptomaven.rest.repositoryTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import xyz.cryptomaven.rest.models.Address;
import xyz.cryptomaven.rest.repositories.AddressesRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddressRepositoryTest {

    public static final long ID = 22L;
    @Autowired
    private AddressesRepository addressesRepository;


    @Test
    public void testFindAll() {
        List<Address> addresses = addressesRepository.findAll();
        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());
    }

    @Test
    public void testFindById() {
        Address address = addressesRepository.findById(ID).orElse(null);
        assertNotNull(address);
    }
    @Test
    public void testFindByAddress() {
        // Test the findByAddress method
        List<Address> address = addressesRepository.findByAddress("0x1234567890abcdef1234567890abcdef12345678");
        assertNotNull(address);
    }

    @Test
    public void testUpdate() {
        // Test the update method
        Address address = addressesRepository.findById(ID).orElse(null);
        if (address != null) {
            address.setEmail("thomas@gmail.com");
            addressesRepository.saveAndFlush(address);
        }
        Address addressUpdated = addressesRepository.findById(ID).orElse(null);
        assertNotNull(addressUpdated);
        assertEquals("thomas@gmail.com", addressUpdated.getEmail());
    }

    @Test
    public void testSave() {
        // Test the save method
        Address address = new Address();
        address.setAddress("0x1234567890abcdef1234567890abcdef12345678");
        Address savedAddress = addressesRepository.saveAndFlush(address);
        assertNotNull(savedAddress);
    }
// TODO Fix constraint of sssaaaaaaaaa
//    @Test
//    public void testDelete() {
//        // Test the delete method
//        Address address = addressesRepository.findById(ID).orElse(null);
//        if (address != null) {
//            addressesRepository.delete(address);
//        }
//    }
}

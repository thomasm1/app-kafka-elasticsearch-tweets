package xyz.cryptomaven.rest.util.dataLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import xyz.cryptomaven.rest.mapper.RoleMapper;
import xyz.cryptomaven.rest.mapper.UserMapper;
import xyz.cryptomaven.rest.models.Address;
import xyz.cryptomaven.rest.models.Chain;
import xyz.cryptomaven.rest.models.Role;
import xyz.cryptomaven.rest.models.User;
import xyz.cryptomaven.rest.models.dto.RegisterDto;
import xyz.cryptomaven.rest.repositories.AddressesRepository;
import xyz.cryptomaven.rest.repositories.ChainsRepository;
import xyz.cryptomaven.rest.repositories.RoleRepository;
import xyz.cryptomaven.rest.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
@Profile("test")
@RequiredArgsConstructor
public class BootstrapData {

  private static final Logger log = LoggerFactory.getLogger(BootstrapData.class);
  @Autowired
  private final AddressesRepository addressesRepository;
  @Autowired
  private final ChainsRepository chainRepository;

  private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
  @Autowired
  private final RoleRepository rolesRepository;
  @Autowired
  private final UsersRepository usersRepository;
  @Autowired
  private final UserMapper userMapper;
  @Autowired
  private final RoleMapper roleMapper;

  Set<Role> roles = new HashSet<>();
  List<RegisterDto> registerDtos;
  private List<User> users = new ArrayList<>();
  private List<Chain> chains = new ArrayList<>();
  private List<Address> addresses = new ArrayList<>();

//  @Transactional
  @Bean
  public ApplicationRunner runner() {
    return args -> {
//      if (rolesRepository.count() == 0)
//        loadRoleData();
      if (usersRepository.count() ==0)
        loadUserData();

      if (addressesRepository.count() == 0) {
        loadAddressData();
      }
      if (chainRepository.count()  == 0 ) {
        loadChainData();
      }
    };
  }

  private void loadRoleData() {
    if (rolesRepository.count() == 0) {
      Role role1 = Role.builder()
        .id(1L)
        .name("ROLE_USER")
        .build();

      Role role2 = Role.builder()
        .id(2L)
        .name("ROLE_ADMIN")
        .build();
      roles.add(role1);
      roles.add(role2);
      rolesRepository.saveAll(roles);
      rolesRepository.flush();
    }
  }

  private void loadChainData() {
    if (chainRepository.count() == 0) {
      Chain chain1 = Chain.builder()
        .name("PulseChain")
        .symbol("PLS")
        .build();

      Chain chain2 = Chain.builder()
        .name("Ethereum")
        .symbol("ETH")
        .addressChain(null)
        .build();

      Chain chain3 = Chain.builder()
        .name("Solana")
        .symbol("SOL")
        .addressChain(null)
        .build();

      Chain chain4 = Chain.builder()
        .name("Avalanche")
        .symbol("AVAX")
        .addressChain(null)
        .build();

      Chain chain5 = Chain.builder()
        .name("Polygon")
        .symbol("MATIC")
        .addressChain(null)
        .build();

      Chain chain6 = Chain.builder()
        .name("Fantom")
        .symbol("FTM")
        .addressChain(null)
        .build();

      chains.addAll(Arrays.asList(chain1, chain2, chain3, chain4, chain5, chain6));
      for (Chain chain : chains) {
        chain.setChainId((int) (Math.random() * 1000));
        chain.setDateCreated(Date.valueOf(LocalDate.now()));
        chain.setLastUpdated(LocalDateTime.now());
      }
      chainRepository.saveAll(chains);
      chainRepository.flush();
    }
  }

  private void loadAddressData() {
    if (addressesRepository.count() == 0) {
      Address address1 = Address.builder()
        .address("0x399EEc3B8e889a2E0853dd254f09C4535061693A")
        .nftAddress("")
        .owner("")
//        .chains(chains)
        .description("")
        .blockExplorerUrl("")
        .build();

      Address address2 = Address.builder()
        .address("0x399EEc3B8e889a2E0853dd254f09C4535061693C")
        .nftAddress("")
        .owner("")
//        .chains(chains)
        .description("")
        .blockExplorerUrl("")
        .build();

      Address address3 = Address.builder()
        .address("0x399EEc3B8e889a2E0853dd254f09C4535061693B")
        .nftAddress("")
        .owner("")
//        .chains(chains)
        .description("")
        .blockExplorerUrl("")
        .build();

      addresses.addAll(Arrays.asList(address1, address2, address3));
      for (Address address : addresses) {
        address.setDateCreated(Date.valueOf(LocalDate.now()));
        address.setLastUpdated(LocalDateTime.now());
      }
      addressesRepository.saveAll(addresses);
      addressesRepository.flush();
    }
  }



private void loadUserData() {
  if (usersRepository.count() == 0) {
    User user1 = User.builder()
      .username("user1")
      .password("password")
      .firstName("Tom")
      .lastName("Smith")
      .email("email@gmail.com")
      .isActive(1)
      .contactType(1)
      .build();

    User user2 = User.builder()
      .username("user2")
      .password("password")
      .firstName("Tom")
      .lastName("Smith")
      .email("user2")
      .isActive(1)
      .contactType(1)
      .build();

    User user3 = User.builder()
      .username("user3")
      .password("password")
      .firstName("Tom")
      .lastName("Smith")
      .email("user3")
      .isActive(1)
      .contactType(1)
      .build();

//   Role roleUser = rolesRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role not found"));
//    for (User user : users) {
//      user.setRoles(Set.of(roleUser));
//    }
    users.addAll(Arrays.asList(user3, user2, user1));
    usersRepository.saveAll(users);
usersRepository.flush();
  }
}
}

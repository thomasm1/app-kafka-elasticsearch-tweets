package xyz.cryptomaven.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address extends AbstractDomainClass {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  private String description;
  private String owner;

  @Column(name = "email")
  private String email;

  private String address;

  @Column(name = "icon_url")
  private String iconUrl;

  @Column(name = "block_explorer_url")
  private String blockExplorerUrl;

  private String nftAddress;

  @OneToMany(mappedBy = "addressChain", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude  // ✅ Prevents infinite recursion
  @EqualsAndHashCode.Exclude // ✅ Avoids issues with hashCode()
  private Set<Chain> chains = new HashSet<>();

  @OneToMany(mappedBy = "addressCoin", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude  // ✅ Prevents infinite recursion
  @EqualsAndHashCode.Exclude // ✅ Avoids issues with hashCode()
  private Set<Coin> coins = new HashSet<>();


  @JsonIgnore  // ✅ Prevents infinite recursion
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_userid")  // ✅ Fixed JoinColumn
  @ToString.Exclude  // ✅ Prevents infinite loop in logs
  @EqualsAndHashCode.Exclude  // ✅ Fixes ConcurrentModificationException
  private User user;

}

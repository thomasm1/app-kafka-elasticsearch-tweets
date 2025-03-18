package xyz.cryptomaven.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder // ✅ Use @SuperBuilder instead of @Builder for JPA
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nft")
public class NftCoin extends AbstractDomainClass {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private double amount;

  @OneToOne
  @JsonIgnore
  @JoinColumn(name = "metadata_id") // ✅ Fixed foreign key name
  private Metadata metadata;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "coin_id") // ✅ Fixed foreign key name
  @ToString.Exclude
  @JsonIgnore
  private Coin coin;
}

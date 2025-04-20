package xyz.cryptomaven.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

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

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "coin_id") // ✅ Fixed foreign key name
  @ToString.Exclude
  @JsonIgnore
  private Coin coin;

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    NftCoin nftCoin = (NftCoin) o;
    return getId() != null && Objects.equals(getId(), nftCoin.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
  }
}

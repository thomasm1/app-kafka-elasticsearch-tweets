package xyz.cryptomaven.rest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Data
@Entity
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "metadata")
public class Metadata extends AbstractDomainClass {

  private static final long serialVersionUID = 1L;

  @Id
  private Long id;
  private String name;
  private String description;
  private String image;
  private String external_url;

  @OneToMany(mappedBy = "metadata", cascade = CascadeType.ALL, orphanRemoval = true)
  private  List<Attribute> attributes;

  @OneToOne(mappedBy = "metadata")
  NftCoin nftCoin;


  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    Metadata metadata = (Metadata) o;
    return getId() != null && Objects.equals(getId(), metadata.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
  }
}

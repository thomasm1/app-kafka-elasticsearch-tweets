package xyz.cryptomaven.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "chain")
public class Chain extends AbstractDomainClass {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  @Column(name = "id", nullable = false)
  private Long id;
  private String name;
  private String symbol;
  private String description;
  private String longDescription;
  private String iconUrl;
  private String category;
  private String chainListIcon;
  private String rpcUrl;
  private Integer chainId;
  private String blockExplorerUrl;

  @JsonIgnore
  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn(name = "chain_address_id" )
  @ToString.Exclude
  private Address addressChain;
//
//  public Chain() {
//    this.name = null;
//    this.symbol = null;
//    this.description = null;
//    this.longDescription = null;
//    this.iconUrl = null;
//    this.category = null;
//    this.chainListIcon = null;
//    this.rpcUrl = null;
//    this.chainId = null;
//    this.blockExplorerUrl = null;
//  }
}

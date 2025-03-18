package xyz.cryptomaven.rest.models.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import xyz.cryptomaven.rest.models.Metadata;
import xyz.cryptomaven.rest.models.Coin;
import xyz.cryptomaven.rest.models.NftCoin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link NftCoin} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NftCoinDto implements Serializable {
  private Long id;
  private String name;
  private double amount;


}

package xyz.cryptomaven.rest.models.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import xyz.cryptomaven.rest.models.Metadata;
import xyz.cryptomaven.rest.models.Coin;
import xyz.cryptomaven.rest.models.NftCoin;

import java.io.Serializable;

/**
 * A DTO for the {@link NftCoin} entity
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class NftCoinDto implements Serializable {
  private Long id;
  private String name;
  private double amount;
  private MetadataDto metadata;
//  private CoinDto coin;


    public void setMetadata(MetadataDto createdMetadataDto) {
      this.metadata = createdMetadataDto;

    }
}

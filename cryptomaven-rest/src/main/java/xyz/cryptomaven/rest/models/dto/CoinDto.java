package xyz.cryptomaven.rest.models.dto;

import lombok.*;
import xyz.cryptomaven.rest.models.Coin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link Coin}
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CoinDto implements Serializable {
  Integer version;
  Date dateCreated;
  Timestamp timeCreated;
  LocalDateTime lastUpdated;
  Timestamp timeUpdated;
  Long id;
  Double nativeToken;
 List<RawTokenDto> tokens;
  List<NftCoinDto> nfts;

    public void setId(long l) {
    }

  public void setName(String bitcoin) {
  }
}

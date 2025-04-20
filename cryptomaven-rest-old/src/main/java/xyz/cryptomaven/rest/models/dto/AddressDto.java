package xyz.cryptomaven.rest.models.dto;

import lombok.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Value
public class AddressDto implements Serializable {

  private static final long serialVersionUID = 1L;


  private Long id;

  private String description;

  private String email;
  private String owner;

  private String address;
  private String iconUrl;

  private String blockExplorerUrl;
  private String nftAddress;

  private Set<ChainDto> chains;

  private Set<CoinDto> coins;
  private UserDto user;


}

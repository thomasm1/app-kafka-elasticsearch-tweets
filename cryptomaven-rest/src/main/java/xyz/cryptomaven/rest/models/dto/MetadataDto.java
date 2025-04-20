package xyz.cryptomaven.rest.models.dto;


import lombok.*;
import xyz.cryptomaven.rest.models.Metadata;
import xyz.cryptomaven.rest.models.NftCoin;

import java.io.Serializable;
import java.util.List;

/**
 * A Dto for the {@link Metadata} entity
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class MetadataDto implements Serializable {
  private Long metadataId;
  private String name;
  private String description;
  private String image;
  private String external_url;
  private List<AttributeDto> attributes;
  private NftCoin nftCoin;

}

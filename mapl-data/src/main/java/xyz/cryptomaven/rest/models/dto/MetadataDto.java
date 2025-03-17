package xyz.cryptomaven.rest.models.dto;


import lombok.*;
import xyz.cryptomaven.rest.models.Metadata;

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
@Value
public class MetadataDto implements Serializable {
  private final int metadataId;
  private final String name;
  private final String description;
  private final String image;
  private String external_url;
  private final List<AttributeDto> attributes;
}

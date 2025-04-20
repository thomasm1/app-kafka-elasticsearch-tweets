package xyz.cryptomaven.rest.models.dto;

import lombok.*;
import xyz.cryptomaven.rest.models.Attribute;

import java.io.Serializable;

/**
 * A Dto for the {@link Attribute} entity
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class AttributeDto implements Serializable {
    private Long attrid;
    private String attribute_value;
    private String trait_type;

}

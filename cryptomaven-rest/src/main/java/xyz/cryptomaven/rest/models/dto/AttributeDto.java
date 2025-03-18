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
@Value
public class AttributeDto implements Serializable {
    private final int attrid;
    private final String attribute_value;
    private final String trait_type;

}

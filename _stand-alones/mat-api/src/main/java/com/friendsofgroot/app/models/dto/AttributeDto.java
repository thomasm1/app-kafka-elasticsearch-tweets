package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.Attribute;
import lombok.Data;

import java.io.Serializable;

/**
 * A Dto for the {@link Attribute} entity
 */
@Data
public class AttributeDto implements Serializable {
    private final int attrid;
    private final String valu;
    private final String trait_type;
    private final MetadataDto metadata;
}

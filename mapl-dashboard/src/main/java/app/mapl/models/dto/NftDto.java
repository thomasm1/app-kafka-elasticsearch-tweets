package app.mapl.models.dto;

import app.mapl.models.Metadata;
import app.mapl.models.Nft;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Nft} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NftDto implements Serializable {
    private int id;
    private String name;
    private int amount;
    private Metadata metadata;
    private int nft_address_id;
}
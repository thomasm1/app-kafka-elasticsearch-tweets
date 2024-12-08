package app.mapl.models.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A Dto for the {@link app.mapl.models.Nft} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NftDto implements Serializable {
    private static long serialVersionUID = 1L;
    private int id;
    private String name;
    private int amount;
    private MetadataDto metadataDto;
    private int NFTADDRESS_id;
}

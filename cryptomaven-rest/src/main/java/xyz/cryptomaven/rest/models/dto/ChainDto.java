package xyz.cryptomaven.rest.models.dto;

import lombok.*;
import xyz.cryptomaven.rest.models.Address;
import xyz.cryptomaven.rest.models.Chain;

import java.io.Serializable;

/**
 * A DTO for the {@link Chain} entity
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ChainDto implements Serializable {
    private Long id;
    private String name;
    private String symbol;
    private String description;
    private String longDescription;
    private String iconUrl;
    private String category;
    private String chainListIcon;
    private String rpcUrl;
    private Integer chainId;
    private String blockExplorerUrl;

    public void setId(long l) {
    }

    public void setName(String ethereumChain) {
    }
}

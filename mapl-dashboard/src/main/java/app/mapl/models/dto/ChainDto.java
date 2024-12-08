package app.mapl.models.dto;

import app.mapl.models.Chain;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Chain} entity
 */
@Builder
@Data
public class ChainDto implements Serializable {
    private Integer id;
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

    public String getChainToken() {
        return symbol;
    }
}
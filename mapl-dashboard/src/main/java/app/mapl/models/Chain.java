package app.mapl.models;

import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
@Data
@Entity
@Table(name = "CHAIN")
public class Chain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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

    public Chain(String name, String symbol, String description, String longDescription, String iconUrl, String category, String chainListIcon, String rpcUrl, Integer chainId, String blockExplorerUrl) {
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.longDescription = longDescription;
        this.iconUrl = iconUrl;
        this.category = category;
        this.chainListIcon = chainListIcon;
        this.rpcUrl = rpcUrl;
        this.chainId = chainId;
        this.blockExplorerUrl = blockExplorerUrl;
    }

    public Chain() {

    }
}
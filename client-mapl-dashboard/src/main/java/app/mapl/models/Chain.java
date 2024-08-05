package app.mapl.models;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "chain")
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
}
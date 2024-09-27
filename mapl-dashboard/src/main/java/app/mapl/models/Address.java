package app.mapl.models;

import lombok.*;

import jakarta.persistence.*;

@Data
@Entity
@Builder
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String description;

    private String owner;

    private String address;

    private String chain;


    @Column(name="icon_url")
    private String iconUrl;

    @Column(name="block_explorer_url")
    private String blockExplorerUrl;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name ="userid",foreignKey = @ForeignKey(name = "userid"))
    private User user;

    @Column(name="chain_id")
    private int chainId;

    @OneToOne( fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name ="nft_address")//,foreignKey = @ForeignKey(name = "nft_address_id"))
    private NftAddress nftAddress;
}

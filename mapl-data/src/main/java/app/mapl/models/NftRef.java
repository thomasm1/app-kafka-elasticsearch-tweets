package app.mapl.models;

import lombok.*;

import jakarta.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NFT_REF")
public class NftRef    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String owner;
    private String email;
    private String address;
    private String chain;

//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    private Nft nft;

}

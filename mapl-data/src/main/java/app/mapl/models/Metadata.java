package app.mapl.models;

import lombok.AllArgsConstructor;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "METADATA")
public class Metadata  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "metadata_id", nullable = false)
    private int metadataId;
    private String name;
    private String description;
    private String image;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Nft nft;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metadata", orphanRemoval = true)
    private List<Attribute> attributes;


}

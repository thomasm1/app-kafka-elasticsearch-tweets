package app.mapl.models;

import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "METADATA")
public class Metadata {

    @Id
    int metaid;
    String name;
    String description;
    String image;
    @OneToOne(mappedBy = "metadata")
    @JoinColumn(name = "nft_id")
    Nft nft;

    public Metadata() {

    }


}

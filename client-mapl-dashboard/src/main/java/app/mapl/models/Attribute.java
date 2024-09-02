package app.mapl.models;


import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Builder
@Table(name = "ATTRIBUTE")
public class Attribute {
    @Id
    int attrid;
    String value;
    String trait_type;
//    @ManyToOne
//    @JoinColumn(name = "metadata_metaid")
//    private int metadata_id;

}
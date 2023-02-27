package app.mapl.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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